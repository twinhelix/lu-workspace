/*
 Source for a scanner and parser for a small subset of C
 Use antlr v3 to generate java files containing code for the
 scanner and parser, and run from a java main program.
 
 Because there is only a small number of functions (from stdio)
 they are fixed in the grammar  
*/
grammar Pico;
options {
 language=Java;
 ASTLabelType=CommonTree;
 output=AST;
 }

tokens {
// names of keywords, some are  only used in the generated ast
ADDR = 'addr' ;
ASSIGN = 'assign' ;
BREAK = 'break' ;
BLOCK = 'block' ;
DECL = 'decl' ;            // declaration
DECLBLOCK = 'declblock';   // block containing declarations
ELSE = 'else';
GETD   = 'getd' ;          // read an integer
IF = 'if';  
IFELSE = 'ifelse'  ;
INIT = 'init' ;            // declaration with a value  eg int count=0; 
INT = 'int';
MAIN  = 'main' ;
PRINTD = 'printd';         // print an integer in decimal
PRINTS = 'prints';         // print a string
PRINTF = 'printf';
SCANF = 'scanf';
UMINUS = 'uminus';         // unary minus
WHILE = 'while';
}

@lexer::header {
package pico ;
}
@header{package pico ;
import org.antlr.runtime.tree.*;
}

@members {
  Symbols table =  new Symbols();
 private int declareErrors=0;

 private void reportError(Token id, String message ) {
  System.err.println("Error at line "+id.getLine()+" " +message);
  declareErrors++;
  }
 public int getDeclareErrorCount(){
  return declareErrors;
 }
 
}

// Names for special characters
AMP            : '&';
AND            : '&&' ;
BITNOT         :  '~' ;
BITOR          :  '|' ;
BITXOR         :  '^' ;
COMMA          :  ',';
DIVIDE         : '/';
EQUAL          :  '==';
GREATER        : '>';
GREATER_EQUAL  : '>=';
LESS           : '<';
LESS_EQUAL     :  '<=';
LPAREN         :  '('  ;
LBRACKET       : '{';
MINUS          : '-';
MOD            :  '%';
NOT_EQUAL      :  '!=';
NOT            : '!' ;
OR             : '||' ;
PLUS           :  '+';
RBRACKET       : '}';
RPAREN         :  ')';
SEMICOLON      : ';';
SHIFT_LEFT     : '<<';
SHIFT_RIGHT    : '>>';
TIMES          :  '*';


fragment  // newline  the token is not sent to the parser
NL : (    '\r' 
        |  '\n')  ;

// Whitespace 
WS : (' '
   | '\t'
   | NL )+
     { $channel=HIDDEN; } ;
        
        
 COMMENT_1 : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};
 
 COMMENT_2 : '//' (~('\n' | '\r'))* NL
               { $channel=HIDDEN;} ;
 
 // There is no preprocess instead #include is treated as a comment
 // so programs which include stdio.h  can be compiled and run
 // both on this compiler and  gcc  
 // Other preprocessing statements are not recognised 
 COMMENT_3 : '#include' (~('\n' | '\r'))* NL
               {  $channel=HIDDEN;} ;             

fragment LETTER : ('a'..'z' | 'A'..'Z' | '_' ) ;
fragment DIGIT  : '0'..'9' ;
// identifiers                
IDENT // The tokens listed above are not treated as identifiers
         :  LETTER (LETTER | DIGIT )*;

NUMBER   :    ( DIGIT) +  ;
STRING   :  '"' (~('"'))* '"' ;



/*
*  antlr v3 grammar 
*  A|B is A or B, ( A )* zero or more A , (A)+ at least one A  
*  uppercase words are tokens (terminals)
*  lowercase words are names of grammar rules
*  a token followed by a '!' is not put in the ast
*  a token followed by a '^' is the root of the AST  for the rule
*  EOF no more input is expected  
*  (A B) => a, input enough tokens to match A B and if found  apply rule a
*   A -> ^(X1 X2 X2)  when an A is recognised return the tree (X1 X2 X3)
*  { action ;}  the java statements are included in the rule at that point
*  In an action $x is a reference to the ast for x 
*  @members{...} contains variables and methods put into the parse
*  @init{...} code run when a rule starts, but before the branches are tested
*  @after{...} code run after any rule branch is chosen
*  returns [ ... ] list of variable declarations, the values of the variables
    are passed back from the rule
*  [...] after rule name - a list of arguments to pass to the chosen branch
*/

// The top level definition
program : (decl)*  main_def EOF    ;   

//  definition of main
main_def :  INT MAIN LPAREN RPAREN   block -> ^(MAIN block) ;


  
 statement : 
     SEMICOLON!   // empty statement
     | block 
     | assignment 
     | if_stmt
     | while_loop
     | break_stmt
     | call;
     
  call: printf  
      | scanf ;

// a bracketed block
block : // look ahead one token to see if there are any declarations 
         (LBRACKET INT ) => 
          LBRACKET { table.pushScope(); }
             ( decl)+ ( statement)*  { table.popScope(); }
                          RBRACKET -> ^(DECLBLOCK decl* statement* )
       | LBRACKET (statement)* RBRACKET -> ^(BLOCK  statement*);
         

// variable declaration list
decl        : INT init ( COMMA init )* SEMICOLON -> ^(INT init+);

// a declaration with an initialisation might not
// be the same as an assignment eg in global
 
init        : id=IDENT '=' val=expr 
              {
                if(! table.declare($id.getText())) {
           	      reportError($id,"has already been declared in this scope");
                 } 
                $id.setText(table.getFullName($id.getText()));
               }
                -> ^(INIT $id $val)

            | id1 = IDENT
                      {
           if(! table.declare($id1.getText())) {
           	reportError($id1,"has already been declared in this scope");
           }
           $id1.setText( table.getFullName($id1.getText()));
	 
           }-> $id1
 
            ; 
if_stmt    :  IF LPAREN cond=expr RPAREN stmt=statement  
                ( (ELSE) =>  ELSE elsestmt = statement   ->
                   ^( IFELSE  $cond   $stmt $elsestmt ) 
                | ->   ^(IF $cond $stmt)    
                )
                   
;
              
while_loop : WHILE ^ LPAREN! expr RPAREN! statement ;

break_stmt : BREAK SEMICOLON! ;

// parse printf and generate a tree with node (prints, string)
// from the strings in the format or (printd, int) for the %d in the format
printf     
 @init{ CommonTree printlist = (CommonTree)adaptor.nil(); 
        String[] formatitems = new String[]{};
        int formatcount=0;
        int formatitem=0;
        CommonTree print = null;
    }
 :
  
   pf=PRINTF LPAREN s=STRING  {
     String str = $s.getText();
     String form = str.substring(1,str.length()-1); // without " at the ends
     formatitems = form.split("\045d",-1); // can't write percent here 
     formatcount=formatitems.length;

  }
// first   case  ends with a  ): just the string to print, 
              ( RPAREN { if (formatcount > 1 ) {
                             reportError($pf,"extra argument(s) for printf");
                          };
                        }
                  ->  ^( PRINTS  $s )
// otherwise at least one  expression 
              |
                { 
                 if (formatcount == 1 ) {
                 reportError($pf,"missing argument(s) for printf");
                  }
                }
                  (COMMA expr 
                  {
                  if (formatitems[formatitem].length()>0){
                      print = (CommonTree)adaptor.create(PRINTS,"prints");
                      print.addChild((CommonTree)adaptor.create(STRING,"\""+
                        formatitems[formatitem]+"\""));
                      printlist.addChild(print);
                    }
                     print = (CommonTree)adaptor.create(PRINTD,"printd");
                     print.addChild($expr.tree);
                     printlist.addChild(print);
                     formatitem++;
                    }
                    )+  RPAREN  
                  { 
                   if (formatitem < formatcount && formatitems[formatitem].length()> 0) {
                      print = (CommonTree)adaptor.create(PRINTS,"prints");
                      print.addChild((CommonTree)adaptor.create(STRING,"\""+formatitems[formatitem]+"\""));
                      printlist.addChild(print);
                     }
                     retval.tree = root_0;
       
                     root_0 = (CommonTree)adaptor.nil();
                     printlist = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK,"block"),printlist);

                             
                     adaptor.addChild(root_0,printlist);
                     retval.tree = root_0; 
   
                   }
                 )
              ;
            
// requires a string and at least one & variable  
// assumes that there is a %d 
// does not check input if there are strings between the %d
scanf      : SCANF LPAREN STRING (COMMA address)+ RPAREN SEMICOLON  
             -> ^(GETD  address )+;   
                    
assignment : id=IDENT '='  expr SEMICOLON
             { if (!table.isVisible($id.getText())) {
                  reportError($id, " is not declared ");
                }
               $id.setText(table.getFullName($id.getText()));
           }
           -> ^(ASSIGN $id expr) ;
/*
 The priority of arithmetic operators are implemented 
 by the order in which the tree is built
*/
expr       : and_expr (OR^ and_expr)* ;

and_expr   : bit_or ( AND^ bit_or )* ;


bit_or     : bit_xor ( BITOR^ bit_xor )* ; 

bit_xor    : bit_and ( BITXOR^ bit_and)* ; 

bit_and    : equal_expr ( AMP^ equal_expr)* ;

equal_expr : comp_expr (( EQUAL^ | NOT_EQUAL^ ) comp_expr)* ;

comp_expr  : shift_expr (( LESS^ | GREATER^ | GREATER_EQUAL^ | LESS_EQUAL^ ) 
                        shift_expr)* ;

shift_expr : add_expr (( SHIFT_LEFT^ | SHIFT_RIGHT^ )  add_expr )*  ;

add_expr   : mul_expr ( ( PLUS^ | MINUS^ ) mul_expr )* ;

mul_expr   : sign_expr (( TIMES^ | DIVIDE^ | MOD^ ) sign_expr)* ;

sign_expr  :
               NOT ^  primary_expr
             | MINUS bexp=primary_expr  -> ^(UMINUS $bexp) 
             | BITNOT ^ primary_expr 
             | primary_expr ;

address :    AMP id=IDENT   
             { if (!table.isVisible($id.getText())) {
                reportError($id, "is not declared");
                }
               $id.setText(table.getFullName($id.getText()));
              }-> ^( ADDR $id)   ;

primary_expr  : 
    id=IDENT { if (!table.isVisible($id.getText())) {
              reportError($id," is not declared");
                 };
              $id.setText(table.getFullName($id.getText()));
                 
           }
  | NUMBER
  | LPAREN! expr RPAREN! ;

