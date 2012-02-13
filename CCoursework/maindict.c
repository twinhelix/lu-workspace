/*
 * SUPPLIED CODE: C_Dictionary.
 *
 * "maindict.c":
 * Main program test harness, calling the various dictionary functions.
 */

#define LINELENGTH 256

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <ctype.h>
#include "dict.h"


static void showmenu() {
    printf("=============================================================\n");
    printf("Welcome to the dictionary program! Commands available:\n\n");
    printf("add    <word>     Add <word> to the dictionary\n");
    printf("print             Display the dictionary contents in order\n");
    printf("lookup <word>     Is <word> in the dictionary?\n");
    printf("count             Show the number of words in the dictionary\n");
    printf("find   <number>   Show word <number> in dictionary\n");
    printf("delete <word>     Delete <word> from the dictionary\n");
    printf("deletedict        Delete the entire dictionary\n\n");
    printf("help              Print this menu again\n");
    printf("quit              Exit this program\n");
    printf("=============================================================\n\n");
}

static char * commands [] = /* expected commands */
  { "add","print","lookup","count","find","delete","deletedict","help","quit" };

/* representing the commands */
enum cmds { cmd_add, cmd_print, cmd_lookup, cmd_count, cmd_find,
            cmd_delete, cmd_deletedict, cmd_help, cmd_quit, cmd_DUMMY };


static int getargument(char value[], enum cmds it) {
    /* the command requires an argument, get the next token */
    char * argument = strtok(NULL," \n");
    if (argument == NULL)    {
        fprintf(stderr,"%s must have an argument\n",commands[it]);
        return 0;
    }
    strcpy(value,argument);
    return 1;
}


static int docommand(char * line) {
    /*
     * check that the line contains a command and an argument if required.
     * call the appropriate function and report the result.
     * returns 1 to quit, 0 to continue
     */
    int quit = 0;
    enum cmds todo;

    char *c ;
    char command[LINELENGTH];
    char argument[LINELENGTH];
    int count = 0;
    int i;

    /* the working dictionary - static to keep the result between commands */
    static dict thedictionary = NULL;

    word aword ;

    /* skip leading blanks in the line */
    while (*line == ' ')
        line++ ;

    /* get the first word on the line */
    c = strtok(line," \n");
    if ( c == NULL ) /* no words on the line */
        return 0;
    /* copy the command and convert it to lowercase */
    strcpy(command,c);
    for (i=0;command[i] != '\0';i++)
        command[i]=tolower((unsigned char)command[i]);

    /* search the list of commands for the word
         look for the first item in commands starting with command
    */
    for (todo = cmd_add; todo < cmd_DUMMY; todo++ ) {
        if (strstr(commands[todo],command) == commands[todo]) {
            /* the input matches a command */
            break;
        }
    }

    /* select the operation on the tree */
    switch (todo) {

    case cmd_add:
        if (getargument(argument,todo)==0) {
            break;
        }
        thedictionary = addword(argument,thedictionary);
        break;

    case cmd_print:
        printdict(thedictionary);
        break;

    case cmd_lookup:
        if (getargument(argument,todo) == 0)
            break;
        if (lookup(argument,thedictionary) !=0) {
            printf("The word '%s' is in the dictionary\n",argument);
        } else {
            printf("The word '%s' is not in the dictionary\n",argument);
        }
        break;

    case cmd_count:
        printf("No. of words in the dictionary: %d\n", countwords(thedictionary));
        break;

    case cmd_find:
        if (getargument(argument,todo)==0) {
            break;
        }
        /* convert the argument to a number */
        if (sscanf(argument," %d",&count) == 1) {
            if ( findword(thedictionary,count,aword)) {
                printf("Word number %d in the dictionary is '%s'\n",count,aword);
            } else {
                printf("***No word number %d in the dictionary!***\n",count);
            }
        } else {
            fprintf(stderr,"find must have a number as an argument\n");
        }
        break;

    case cmd_delete:
        if (getargument(argument,todo)==0) {
            break;
        }
        thedictionary = deleteword(argument,thedictionary);
        break;

    case cmd_deletedict:
        thedictionary = deletedict(thedictionary);
        break;

    case cmd_help:
        showmenu();
        break;

    case cmd_quit:
        quit = 1;
        break;

    default:
        fprintf(stderr,"Unrecognised command %s\n",command);
        break;
    }

    return quit;
}


/*
 * main program
 */
int main (void) {
    char line [ LINELENGTH ] ;

    showmenu();
    do {
        (void)fputs("Command? ",stdout);
        (void)fflush(stdout);
        /* ends when no more input or a quit command */
    } while ((fgets(line,LINELENGTH,stdin) != NULL) && docommand(line)==0);
    return EXIT_SUCCESS;
}
