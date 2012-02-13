// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\workspace\\CompilerLab\\src\\pico\\Pico.g 2010-01-23 02:49:55
package pico ;
import org.antlr.runtime.tree.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class PicoParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADDR", "ASSIGN", "BREAK", "BLOCK", "DECL", "DECLBLOCK", "ELSE", "GETD", "IF", "IFELSE", "INIT", "INT", "MAIN", "PRINTD", "PRINTS", "PRINTF", "SCANF", "UMINUS", "WHILE", "AMP", "AND", "BITNOT", "BITOR", "BITXOR", "COMMA", "DIVIDE", "EQUAL", "GREATER", "GREATER_EQUAL", "LESS", "LESS_EQUAL", "LPAREN", "LBRACKET", "MINUS", "MOD", "NOT_EQUAL", "NOT", "OR", "PLUS", "RBRACKET", "RPAREN", "SEMICOLON", "SHIFT_LEFT", "SHIFT_RIGHT", "TIMES", "NL", "WS", "COMMENT_1", "COMMENT_2", "COMMENT_3", "LETTER", "DIGIT", "IDENT", "NUMBER", "STRING", "'='"
    };
    public static final int MAIN=16;
    public static final int BITNOT=25;
    public static final int WHILE=22;
    public static final int LETTER=54;
    public static final int IFELSE=13;
    public static final int AMP=23;
    public static final int MOD=38;
    public static final int DECLBLOCK=9;
    public static final int NOT=40;
    public static final int AND=24;
    public static final int EOF=-1;
    public static final int BREAK=6;
    public static final int ADDR=4;
    public static final int LPAREN=35;
    public static final int IF=12;
    public static final int LBRACKET=36;
    public static final int RPAREN=44;
    public static final int COMMENT_2=52;
    public static final int SCANF=20;
    public static final int GREATER=31;
    public static final int COMMENT_3=53;
    public static final int COMMENT_1=51;
    public static final int COMMA=28;
    public static final int NOT_EQUAL=39;
    public static final int T__59=59;
    public static final int EQUAL=30;
    public static final int BITXOR=27;
    public static final int LESS=33;
    public static final int IDENT=56;
    public static final int PLUS=42;
    public static final int DIGIT=55;
    public static final int NL=49;
    public static final int RBRACKET=43;
    public static final int DIVIDE=29;
    public static final int ELSE=10;
    public static final int NUMBER=57;
    public static final int UMINUS=21;
    public static final int SEMICOLON=45;
    public static final int INT=15;
    public static final int PRINTD=17;
    public static final int MINUS=37;
    public static final int PRINTF=19;
    public static final int SHIFT_LEFT=46;
    public static final int WS=50;
    public static final int SHIFT_RIGHT=47;
    public static final int PRINTS=18;
    public static final int BITOR=26;
    public static final int GETD=11;
    public static final int DECL=8;
    public static final int BLOCK=7;
    public static final int OR=41;
    public static final int ASSIGN=5;
    public static final int LESS_EQUAL=34;
    public static final int TIMES=48;
    public static final int INIT=14;
    public static final int GREATER_EQUAL=32;
    public static final int STRING=58;

    // delegates
    // delegators


        public PicoParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PicoParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PicoParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\workspace\\CompilerLab\\src\\pico\\Pico.g"; }


      Symbols table =  new Symbols();
     private int declareErrors=0;

     private void reportError(Token id, String message ) {
      System.err.println("Error at line "+id.getLine()+" " +message);
      declareErrors++;
      }
     public int getDeclareErrorCount(){
      return declareErrors;
     }
     


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:144:1: program : ( decl )* main_def EOF ;
    public final PicoParser.program_return program() throws RecognitionException {
        PicoParser.program_return retval = new PicoParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF3=null;
        PicoParser.decl_return decl1 = null;

        PicoParser.main_def_return main_def2 = null;


        CommonTree EOF3_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:144:9: ( ( decl )* main_def EOF )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:144:11: ( decl )* main_def EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:144:11: ( decl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==INT) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==IDENT) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:144:12: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_program1015);
            	    decl1=decl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, decl1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            pushFollow(FOLLOW_main_def_in_program1020);
            main_def2=main_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, main_def2.getTree());
            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_program1022); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF3_tree = (CommonTree)adaptor.create(EOF3);
            adaptor.addChild(root_0, EOF3_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class main_def_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "main_def"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:147:1: main_def : INT MAIN LPAREN RPAREN block -> ^( MAIN block ) ;
    public final PicoParser.main_def_return main_def() throws RecognitionException {
        PicoParser.main_def_return retval = new PicoParser.main_def_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT4=null;
        Token MAIN5=null;
        Token LPAREN6=null;
        Token RPAREN7=null;
        PicoParser.block_return block8 = null;


        CommonTree INT4_tree=null;
        CommonTree MAIN5_tree=null;
        CommonTree LPAREN6_tree=null;
        CommonTree RPAREN7_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_MAIN=new RewriteRuleTokenStream(adaptor,"token MAIN");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:147:10: ( INT MAIN LPAREN RPAREN block -> ^( MAIN block ) )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:147:13: INT MAIN LPAREN RPAREN block
            {
            INT4=(Token)match(input,INT,FOLLOW_INT_in_main_def1039); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT4);

            MAIN5=(Token)match(input,MAIN,FOLLOW_MAIN_in_main_def1041); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_MAIN.add(MAIN5);

            LPAREN6=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_main_def1043); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN6);

            RPAREN7=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_main_def1045); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN7);

            pushFollow(FOLLOW_block_in_main_def1049);
            block8=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block8.getTree());


            // AST REWRITE
            // elements: MAIN, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 147:44: -> ^( MAIN block )
            {
                // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:147:47: ^( MAIN block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_MAIN.nextNode(), root_1);

                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "main_def"

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:151:2: statement : ( SEMICOLON | block | assignment | if_stmt | while_loop | break_stmt | call );
    public final PicoParser.statement_return statement() throws RecognitionException {
        PicoParser.statement_return retval = new PicoParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMICOLON9=null;
        PicoParser.block_return block10 = null;

        PicoParser.assignment_return assignment11 = null;

        PicoParser.if_stmt_return if_stmt12 = null;

        PicoParser.while_loop_return while_loop13 = null;

        PicoParser.break_stmt_return break_stmt14 = null;

        PicoParser.call_return call15 = null;


        CommonTree SEMICOLON9_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:151:12: ( SEMICOLON | block | assignment | if_stmt | while_loop | break_stmt | call )
            int alt2=7;
            switch ( input.LA(1) ) {
            case SEMICOLON:
                {
                alt2=1;
                }
                break;
            case LBRACKET:
                {
                alt2=2;
                }
                break;
            case IDENT:
                {
                alt2=3;
                }
                break;
            case IF:
                {
                alt2=4;
                }
                break;
            case WHILE:
                {
                alt2=5;
                }
                break;
            case BREAK:
                {
                alt2=6;
                }
                break;
            case PRINTF:
            case SCANF:
                {
                alt2=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:152:6: SEMICOLON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SEMICOLON9=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement1077); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:153:8: block
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_block_in_statement1090);
                    block10=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block10.getTree());

                    }
                    break;
                case 3 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:154:8: assignment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignment_in_statement1100);
                    assignment11=assignment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment11.getTree());

                    }
                    break;
                case 4 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:155:8: if_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_stmt_in_statement1110);
                    if_stmt12=if_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, if_stmt12.getTree());

                    }
                    break;
                case 5 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:156:8: while_loop
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_while_loop_in_statement1119);
                    while_loop13=while_loop();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_loop13.getTree());

                    }
                    break;
                case 6 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:157:8: break_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_break_stmt_in_statement1128);
                    break_stmt14=break_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, break_stmt14.getTree());

                    }
                    break;
                case 7 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:158:8: call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_call_in_statement1137);
                    call15=call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, call15.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:160:3: call : ( printf | scanf );
    public final PicoParser.call_return call() throws RecognitionException {
        PicoParser.call_return retval = new PicoParser.call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PicoParser.printf_return printf16 = null;

        PicoParser.scanf_return scanf17 = null;



        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:160:7: ( printf | scanf )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PRINTF) ) {
                alt3=1;
            }
            else if ( (LA3_0==SCANF) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:160:9: printf
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_printf_in_call1151);
                    printf16=printf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, printf16.getTree());

                    }
                    break;
                case 2 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:161:9: scanf
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_scanf_in_call1163);
                    scanf17=scanf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, scanf17.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "call"

    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:164:1: block : ( ( LBRACKET INT )=> LBRACKET ( decl )+ ( statement )* RBRACKET -> ^( DECLBLOCK ( decl )* ( statement )* ) | LBRACKET ( statement )* RBRACKET -> ^( BLOCK ( statement )* ) );
    public final PicoParser.block_return block() throws RecognitionException {
        PicoParser.block_return retval = new PicoParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET18=null;
        Token RBRACKET21=null;
        Token LBRACKET22=null;
        Token RBRACKET24=null;
        PicoParser.decl_return decl19 = null;

        PicoParser.statement_return statement20 = null;

        PicoParser.statement_return statement23 = null;


        CommonTree LBRACKET18_tree=null;
        CommonTree RBRACKET21_tree=null;
        CommonTree LBRACKET22_tree=null;
        CommonTree RBRACKET24_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_decl=new RewriteRuleSubtreeStream(adaptor,"rule decl");
        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:164:7: ( ( LBRACKET INT )=> LBRACKET ( decl )+ ( statement )* RBRACKET -> ^( DECLBLOCK ( decl )* ( statement )* ) | LBRACKET ( statement )* RBRACKET -> ^( BLOCK ( statement )* ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LBRACKET) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==INT) && (synpred1_Pico())) {
                    alt7=1;
                }
                else if ( (LA7_1==BREAK||LA7_1==IF||(LA7_1>=PRINTF && LA7_1<=SCANF)||LA7_1==WHILE||LA7_1==LBRACKET||LA7_1==RBRACKET||LA7_1==SEMICOLON||LA7_1==IDENT) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:165:10: ( LBRACKET INT )=> LBRACKET ( decl )+ ( statement )* RBRACKET
                    {
                    LBRACKET18=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_block1203); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET18);

                    if ( state.backtracking==0 ) {
                       table.pushScope(); 
                    }
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:167:14: ( decl )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==INT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:167:16: decl
                    	    {
                    	    pushFollow(FOLLOW_decl_in_block1222);
                    	    decl19=decl();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_decl.add(decl19.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:167:23: ( statement )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==BREAK||LA5_0==IF||(LA5_0>=PRINTF && LA5_0<=SCANF)||LA5_0==WHILE||LA5_0==LBRACKET||LA5_0==SEMICOLON||LA5_0==IDENT) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:167:25: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_block1228);
                    	    statement20=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement20.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       table.popScope(); 
                    }
                    RBRACKET21=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_block1261); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET21);



                    // AST REWRITE
                    // elements: statement, decl
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 168:36: -> ^( DECLBLOCK ( decl )* ( statement )* )
                    {
                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:168:39: ^( DECLBLOCK ( decl )* ( statement )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECLBLOCK, "DECLBLOCK"), root_1);

                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:168:51: ( decl )*
                        while ( stream_decl.hasNext() ) {
                            adaptor.addChild(root_1, stream_decl.nextTree());

                        }
                        stream_decl.reset();
                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:168:57: ( statement )*
                        while ( stream_statement.hasNext() ) {
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_statement.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:169:10: LBRACKET ( statement )* RBRACKET
                    {
                    LBRACKET22=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_block1285); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET22);

                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:169:19: ( statement )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==BREAK||LA6_0==IF||(LA6_0>=PRINTF && LA6_0<=SCANF)||LA6_0==WHILE||LA6_0==LBRACKET||LA6_0==SEMICOLON||LA6_0==IDENT) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:169:20: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_block1288);
                    	    statement23=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement23.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    RBRACKET24=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_block1292); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET24);



                    // AST REWRITE
                    // elements: statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 169:41: -> ^( BLOCK ( statement )* )
                    {
                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:169:44: ^( BLOCK ( statement )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:169:53: ( statement )*
                        while ( stream_statement.hasNext() ) {
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_statement.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "decl"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:173:1: decl : INT init ( COMMA init )* SEMICOLON -> ^( INT ( init )+ ) ;
    public final PicoParser.decl_return decl() throws RecognitionException {
        PicoParser.decl_return retval = new PicoParser.decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT25=null;
        Token COMMA27=null;
        Token SEMICOLON29=null;
        PicoParser.init_return init26 = null;

        PicoParser.init_return init28 = null;


        CommonTree INT25_tree=null;
        CommonTree COMMA27_tree=null;
        CommonTree SEMICOLON29_tree=null;
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init");
        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:173:13: ( INT init ( COMMA init )* SEMICOLON -> ^( INT ( init )+ ) )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:173:15: INT init ( COMMA init )* SEMICOLON
            {
            INT25=(Token)match(input,INT,FOLLOW_INT_in_decl1328); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT25);

            pushFollow(FOLLOW_init_in_decl1330);
            init26=init();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_init.add(init26.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:173:24: ( COMMA init )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:173:26: COMMA init
            	    {
            	    COMMA27=(Token)match(input,COMMA,FOLLOW_COMMA_in_decl1334); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA27);

            	    pushFollow(FOLLOW_init_in_decl1336);
            	    init28=init();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_init.add(init28.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            SEMICOLON29=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_decl1341); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON29);



            // AST REWRITE
            // elements: init, INT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 173:50: -> ^( INT ( init )+ )
            {
                // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:173:53: ^( INT ( init )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_INT.nextNode(), root_1);

                if ( !(stream_init.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_init.hasNext() ) {
                    adaptor.addChild(root_1, stream_init.nextTree());

                }
                stream_init.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decl"

    public static class init_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "init"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:178:1: init : (id= IDENT '=' val= expr -> ^( INIT $id $val) | id1= IDENT -> $id1);
    public final PicoParser.init_return init() throws RecognitionException {
        PicoParser.init_return retval = new PicoParser.init_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id=null;
        Token id1=null;
        Token char_literal30=null;
        PicoParser.expr_return val = null;


        CommonTree id_tree=null;
        CommonTree id1_tree=null;
        CommonTree char_literal30_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:178:13: (id= IDENT '=' val= expr -> ^( INIT $id $val) | id1= IDENT -> $id1)
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENT) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==59) ) {
                    alt9=1;
                }
                else if ( (LA9_1==COMMA||LA9_1==SEMICOLON) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:178:15: id= IDENT '=' val= expr
                    {
                    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_init1371); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(id);

                    char_literal30=(Token)match(input,59,FOLLOW_59_in_init1373); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_59.add(char_literal30);

                    pushFollow(FOLLOW_expr_in_init1377);
                    val=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(val.getTree());
                    if ( state.backtracking==0 ) {

                                      if(! table.declare(id.getText())) {
                                 	      reportError(id,"has already been declared in this scope");
                                       } 
                                      id.setText(table.getFullName(id.getText()));
                                     
                    }


                    // AST REWRITE
                    // elements: val, id
                    // token labels: id
                    // rule labels: val, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
                    RewriteRuleSubtreeStream stream_val=new RewriteRuleSubtreeStream(adaptor,"rule val",val!=null?val.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 185:17: -> ^( INIT $id $val)
                    {
                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:185:20: ^( INIT $id $val)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INIT, "INIT"), root_1);

                        adaptor.addChild(root_1, stream_id.nextNode());
                        adaptor.addChild(root_1, stream_val.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:187:15: id1= IDENT
                    {
                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_init1443); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(id1);

                    if ( state.backtracking==0 ) {

                                 if(! table.declare(id1.getText())) {
                                 	reportError(id1,"has already been declared in this scope");
                                 }
                                 id1.setText( table.getFullName(id1.getText()));
                      	 
                                 
                    }


                    // AST REWRITE
                    // elements: id1
                    // token labels: id1
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_id1=new RewriteRuleTokenStream(adaptor,"token id1",id1);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 194:13: -> $id1
                    {
                        adaptor.addChild(root_0, stream_id1.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "init"

    public static class if_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_stmt"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:197:1: if_stmt : IF LPAREN cond= expr RPAREN stmt= statement ( ( ELSE )=> ELSE elsestmt= statement -> ^( IFELSE $cond $stmt $elsestmt) | -> ^( IF $cond $stmt) ) ;
    public final PicoParser.if_stmt_return if_stmt() throws RecognitionException {
        PicoParser.if_stmt_return retval = new PicoParser.if_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF31=null;
        Token LPAREN32=null;
        Token RPAREN33=null;
        Token ELSE34=null;
        PicoParser.expr_return cond = null;

        PicoParser.statement_return stmt = null;

        PicoParser.statement_return elsestmt = null;


        CommonTree IF31_tree=null;
        CommonTree LPAREN32_tree=null;
        CommonTree RPAREN33_tree=null;
        CommonTree ELSE34_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:197:12: ( IF LPAREN cond= expr RPAREN stmt= statement ( ( ELSE )=> ELSE elsestmt= statement -> ^( IFELSE $cond $stmt $elsestmt) | -> ^( IF $cond $stmt) ) )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:197:15: IF LPAREN cond= expr RPAREN stmt= statement ( ( ELSE )=> ELSE elsestmt= statement -> ^( IFELSE $cond $stmt $elsestmt) | -> ^( IF $cond $stmt) )
            {
            IF31=(Token)match(input,IF,FOLLOW_IF_in_if_stmt1498); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IF.add(IF31);

            LPAREN32=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_if_stmt1500); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN32);

            pushFollow(FOLLOW_expr_in_if_stmt1504);
            cond=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(cond.getTree());
            RPAREN33=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_if_stmt1506); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN33);

            pushFollow(FOLLOW_statement_in_if_stmt1510);
            stmt=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(stmt.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:198:17: ( ( ELSE )=> ELSE elsestmt= statement -> ^( IFELSE $cond $stmt $elsestmt) | -> ^( IF $cond $stmt) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ELSE) ) {
                int LA10_1 = input.LA(2);

                if ( (synpred2_Pico()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0==BREAK||LA10_0==IF||(LA10_0>=PRINTF && LA10_0<=SCANF)||LA10_0==WHILE||LA10_0==LBRACKET||LA10_0==RBRACKET||LA10_0==SEMICOLON||LA10_0==IDENT) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:198:19: ( ELSE )=> ELSE elsestmt= statement
                    {
                    ELSE34=(Token)match(input,ELSE,FOLLOW_ELSE_in_if_stmt1539); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ELSE.add(ELSE34);

                    pushFollow(FOLLOW_statement_in_if_stmt1545);
                    elsestmt=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(elsestmt.getTree());


                    // AST REWRITE
                    // elements: elsestmt, stmt, cond
                    // token labels: 
                    // rule labels: retval, elsestmt, stmt, cond
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_elsestmt=new RewriteRuleSubtreeStream(adaptor,"rule elsestmt",elsestmt!=null?elsestmt.tree:null);
                    RewriteRuleSubtreeStream stream_stmt=new RewriteRuleSubtreeStream(adaptor,"rule stmt",stmt!=null?stmt.tree:null);
                    RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond",cond!=null?cond.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 198:58: -> ^( IFELSE $cond $stmt $elsestmt)
                    {
                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:199:20: ^( IFELSE $cond $stmt $elsestmt)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IFELSE, "IFELSE"), root_1);

                        adaptor.addChild(root_1, stream_cond.nextTree());
                        adaptor.addChild(root_1, stream_stmt.nextTree());
                        adaptor.addChild(root_1, stream_elsestmt.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:200:19: 
                    {

                    // AST REWRITE
                    // elements: IF, stmt, cond
                    // token labels: 
                    // rule labels: retval, stmt, cond
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_stmt=new RewriteRuleSubtreeStream(adaptor,"rule stmt",stmt!=null?stmt.tree:null);
                    RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond",cond!=null?cond.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 200:19: -> ^( IF $cond $stmt)
                    {
                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:200:24: ^( IF $cond $stmt)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_cond.nextTree());
                        adaptor.addChild(root_1, stream_stmt.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_stmt"

    public static class while_loop_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "while_loop"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:205:1: while_loop : WHILE LPAREN expr RPAREN statement ;
    public final PicoParser.while_loop_return while_loop() throws RecognitionException {
        PicoParser.while_loop_return retval = new PicoParser.while_loop_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHILE35=null;
        Token LPAREN36=null;
        Token RPAREN38=null;
        PicoParser.expr_return expr37 = null;

        PicoParser.statement_return statement39 = null;


        CommonTree WHILE35_tree=null;
        CommonTree LPAREN36_tree=null;
        CommonTree RPAREN38_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:205:12: ( WHILE LPAREN expr RPAREN statement )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:205:14: WHILE LPAREN expr RPAREN statement
            {
            root_0 = (CommonTree)adaptor.nil();

            WHILE35=(Token)match(input,WHILE,FOLLOW_WHILE_in_while_loop1684); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHILE35_tree = (CommonTree)adaptor.create(WHILE35);
            root_0 = (CommonTree)adaptor.becomeRoot(WHILE35_tree, root_0);
            }
            LPAREN36=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_while_loop1688); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_while_loop1691);
            expr37=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr37.getTree());
            RPAREN38=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_while_loop1693); if (state.failed) return retval;
            pushFollow(FOLLOW_statement_in_while_loop1696);
            statement39=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement39.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "while_loop"

    public static class break_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "break_stmt"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:207:1: break_stmt : BREAK SEMICOLON ;
    public final PicoParser.break_stmt_return break_stmt() throws RecognitionException {
        PicoParser.break_stmt_return retval = new PicoParser.break_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BREAK40=null;
        Token SEMICOLON41=null;

        CommonTree BREAK40_tree=null;
        CommonTree SEMICOLON41_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:207:12: ( BREAK SEMICOLON )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:207:14: BREAK SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            BREAK40=(Token)match(input,BREAK,FOLLOW_BREAK_in_break_stmt1705); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BREAK40_tree = (CommonTree)adaptor.create(BREAK40);
            adaptor.addChild(root_0, BREAK40_tree);
            }
            SEMICOLON41=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_break_stmt1707); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "break_stmt"

    public static class printf_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "printf"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:211:1: printf : pf= PRINTF LPAREN s= STRING ( RPAREN -> ^( PRINTS $s) | ( COMMA expr )+ RPAREN ) ;
    public final PicoParser.printf_return printf() throws RecognitionException {
        PicoParser.printf_return retval = new PicoParser.printf_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token pf=null;
        Token s=null;
        Token LPAREN42=null;
        Token RPAREN43=null;
        Token COMMA44=null;
        Token RPAREN46=null;
        PicoParser.expr_return expr45 = null;


        CommonTree pf_tree=null;
        CommonTree s_tree=null;
        CommonTree LPAREN42_tree=null;
        CommonTree RPAREN43_tree=null;
        CommonTree COMMA44_tree=null;
        CommonTree RPAREN46_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_PRINTF=new RewriteRuleTokenStream(adaptor,"token PRINTF");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
         CommonTree printlist = (CommonTree)adaptor.nil(); 
                String[] formatitems = new String[]{};
                int formatcount=0;
                int formatitem=0;
                CommonTree print = null;
            
        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:218:2: (pf= PRINTF LPAREN s= STRING ( RPAREN -> ^( PRINTS $s) | ( COMMA expr )+ RPAREN ) )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:220:4: pf= PRINTF LPAREN s= STRING ( RPAREN -> ^( PRINTS $s) | ( COMMA expr )+ RPAREN )
            {
            pf=(Token)match(input,PRINTF,FOLLOW_PRINTF_in_printf1738); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PRINTF.add(pf);

            LPAREN42=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_printf1740); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN42);

            s=(Token)match(input,STRING,FOLLOW_STRING_in_printf1744); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(s);

            if ( state.backtracking==0 ) {

                   String str = s.getText();
                   String form = str.substring(1,str.length()-1); // without " at the ends
                   formatitems = form.split("\045d",-1); // can't write percent here 
                   formatcount=formatitems.length;

                
            }
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:228:15: ( RPAREN -> ^( PRINTS $s) | ( COMMA expr )+ RPAREN )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RPAREN) ) {
                alt12=1;
            }
            else if ( (LA12_0==COMMA) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:228:17: RPAREN
                    {
                    RPAREN43=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_printf1766); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN43);

                    if ( state.backtracking==0 ) {
                       if (formatcount > 1 ) {
                                                   reportError(pf,"extra argument(s) for printf");
                                                };
                                              
                    }


                    // AST REWRITE
                    // elements: s
                    // token labels: s
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 232:19: -> ^( PRINTS $s)
                    {
                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:232:23: ^( PRINTS $s)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PRINTS, "PRINTS"), root_1);

                        adaptor.addChild(root_1, stream_s.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:235:17: ( COMMA expr )+ RPAREN
                    {
                    if ( state.backtracking==0 ) {
                       
                                       if (formatcount == 1 ) {
                                       reportError(pf,"missing argument(s) for printf");
                                        }
                                      
                    }
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:240:19: ( COMMA expr )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==COMMA) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:240:20: COMMA expr
                    	    {
                    	    COMMA44=(Token)match(input,COMMA,FOLLOW_COMMA_in_printf1855); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA44);

                    	    pushFollow(FOLLOW_expr_in_printf1857);
                    	    expr45=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr45.getTree());
                    	    if ( state.backtracking==0 ) {

                    	                        if (formatitems[formatitem].length()>0){
                    	                            print = (CommonTree)adaptor.create(PRINTS,"prints");
                    	                            print.addChild((CommonTree)adaptor.create(STRING,"\""+
                    	                              formatitems[formatitem]+"\""));
                    	                            printlist.addChild(print);
                    	                          }
                    	                           print = (CommonTree)adaptor.create(PRINTD,"printd");
                    	                           print.addChild((expr45!=null?((CommonTree)expr45.tree):null));
                    	                           printlist.addChild(print);
                    	                           formatitem++;
                    	                          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    RPAREN46=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_printf1904); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN46);

                    if ( state.backtracking==0 ) {
                       
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

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "printf"

    public static class scanf_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scanf"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:276:1: scanf : SCANF LPAREN STRING ( COMMA address )+ RPAREN SEMICOLON -> ( ^( GETD address ) )+ ;
    public final PicoParser.scanf_return scanf() throws RecognitionException {
        PicoParser.scanf_return retval = new PicoParser.scanf_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SCANF47=null;
        Token LPAREN48=null;
        Token STRING49=null;
        Token COMMA50=null;
        Token RPAREN52=null;
        Token SEMICOLON53=null;
        PicoParser.address_return address51 = null;


        CommonTree SCANF47_tree=null;
        CommonTree LPAREN48_tree=null;
        CommonTree STRING49_tree=null;
        CommonTree COMMA50_tree=null;
        CommonTree RPAREN52_tree=null;
        CommonTree SEMICOLON53_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_SCANF=new RewriteRuleTokenStream(adaptor,"token SCANF");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_address=new RewriteRuleSubtreeStream(adaptor,"rule address");
        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:276:12: ( SCANF LPAREN STRING ( COMMA address )+ RPAREN SEMICOLON -> ( ^( GETD address ) )+ )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:276:14: SCANF LPAREN STRING ( COMMA address )+ RPAREN SEMICOLON
            {
            SCANF47=(Token)match(input,SCANF,FOLLOW_SCANF_in_scanf1988); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SCANF.add(SCANF47);

            LPAREN48=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_scanf1990); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN48);

            STRING49=(Token)match(input,STRING,FOLLOW_STRING_in_scanf1992); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING49);

            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:276:34: ( COMMA address )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMMA) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:276:35: COMMA address
            	    {
            	    COMMA50=(Token)match(input,COMMA,FOLLOW_COMMA_in_scanf1995); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA50);

            	    pushFollow(FOLLOW_address_in_scanf1997);
            	    address51=address();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_address.add(address51.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            RPAREN52=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_scanf2001); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN52);

            SEMICOLON53=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_scanf2003); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON53);



            // AST REWRITE
            // elements: address
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 277:14: -> ( ^( GETD address ) )+
            {
                if ( !(stream_address.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_address.hasNext() ) {
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:277:17: ^( GETD address )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GETD, "GETD"), root_1);

                    adaptor.addChild(root_1, stream_address.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_address.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "scanf"

    public static class assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:279:1: assignment : id= IDENT '=' expr SEMICOLON -> ^( ASSIGN $id expr ) ;
    public final PicoParser.assignment_return assignment() throws RecognitionException {
        PicoParser.assignment_return retval = new PicoParser.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id=null;
        Token char_literal54=null;
        Token SEMICOLON56=null;
        PicoParser.expr_return expr55 = null;


        CommonTree id_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree SEMICOLON56_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:279:12: (id= IDENT '=' expr SEMICOLON -> ^( ASSIGN $id expr ) )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:279:14: id= IDENT '=' expr SEMICOLON
            {
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment2062); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(id);

            char_literal54=(Token)match(input,59,FOLLOW_59_in_assignment2064); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_59.add(char_literal54);

            pushFollow(FOLLOW_expr_in_assignment2067);
            expr55=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr55.getTree());
            SEMICOLON56=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment2069); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON56);

            if ( state.backtracking==0 ) {
               if (!table.isVisible(id.getText())) {
                                reportError(id, " is not declared ");
                              }
                             id.setText(table.getFullName(id.getText()));
                         
            }


            // AST REWRITE
            // elements: expr, id
            // token labels: id
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 285:12: -> ^( ASSIGN $id expr )
            {
                // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:285:15: ^( ASSIGN $id expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);

                adaptor.addChild(root_1, stream_id.nextNode());
                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:290:1: expr : and_expr ( OR and_expr )* ;
    public final PicoParser.expr_return expr() throws RecognitionException {
        PicoParser.expr_return retval = new PicoParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR58=null;
        PicoParser.and_expr_return and_expr57 = null;

        PicoParser.and_expr_return and_expr59 = null;


        CommonTree OR58_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:290:12: ( and_expr ( OR and_expr )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:290:14: and_expr ( OR and_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_and_expr_in_expr2122);
            and_expr57=and_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, and_expr57.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:290:23: ( OR and_expr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==OR) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:290:24: OR and_expr
            	    {
            	    OR58=(Token)match(input,OR,FOLLOW_OR_in_expr2125); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR58_tree = (CommonTree)adaptor.create(OR58);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR58_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_and_expr_in_expr2128);
            	    and_expr59=and_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, and_expr59.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class and_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "and_expr"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:292:1: and_expr : bit_or ( AND bit_or )* ;
    public final PicoParser.and_expr_return and_expr() throws RecognitionException {
        PicoParser.and_expr_return retval = new PicoParser.and_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND61=null;
        PicoParser.bit_or_return bit_or60 = null;

        PicoParser.bit_or_return bit_or62 = null;


        CommonTree AND61_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:292:12: ( bit_or ( AND bit_or )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:292:14: bit_or ( AND bit_or )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_bit_or_in_and_expr2141);
            bit_or60=bit_or();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_or60.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:292:21: ( AND bit_or )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==AND) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:292:23: AND bit_or
            	    {
            	    AND61=(Token)match(input,AND,FOLLOW_AND_in_and_expr2145); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND61_tree = (CommonTree)adaptor.create(AND61);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND61_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_bit_or_in_and_expr2148);
            	    bit_or62=bit_or();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_or62.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "and_expr"

    public static class bit_or_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bit_or"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:295:1: bit_or : bit_xor ( BITOR bit_xor )* ;
    public final PicoParser.bit_or_return bit_or() throws RecognitionException {
        PicoParser.bit_or_return retval = new PicoParser.bit_or_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BITOR64=null;
        PicoParser.bit_xor_return bit_xor63 = null;

        PicoParser.bit_xor_return bit_xor65 = null;


        CommonTree BITOR64_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:295:12: ( bit_xor ( BITOR bit_xor )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:295:14: bit_xor ( BITOR bit_xor )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_bit_xor_in_bit_or2165);
            bit_xor63=bit_xor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_xor63.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:295:22: ( BITOR bit_xor )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==BITOR) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:295:24: BITOR bit_xor
            	    {
            	    BITOR64=(Token)match(input,BITOR,FOLLOW_BITOR_in_bit_or2169); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    BITOR64_tree = (CommonTree)adaptor.create(BITOR64);
            	    root_0 = (CommonTree)adaptor.becomeRoot(BITOR64_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_bit_xor_in_bit_or2172);
            	    bit_xor65=bit_xor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_xor65.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bit_or"

    public static class bit_xor_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bit_xor"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:297:1: bit_xor : bit_and ( BITXOR bit_and )* ;
    public final PicoParser.bit_xor_return bit_xor() throws RecognitionException {
        PicoParser.bit_xor_return retval = new PicoParser.bit_xor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BITXOR67=null;
        PicoParser.bit_and_return bit_and66 = null;

        PicoParser.bit_and_return bit_and68 = null;


        CommonTree BITXOR67_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:297:12: ( bit_and ( BITXOR bit_and )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:297:14: bit_and ( BITXOR bit_and )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_bit_and_in_bit_xor2188);
            bit_and66=bit_and();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_and66.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:297:22: ( BITXOR bit_and )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==BITXOR) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:297:24: BITXOR bit_and
            	    {
            	    BITXOR67=(Token)match(input,BITXOR,FOLLOW_BITXOR_in_bit_xor2192); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    BITXOR67_tree = (CommonTree)adaptor.create(BITXOR67);
            	    root_0 = (CommonTree)adaptor.becomeRoot(BITXOR67_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_bit_and_in_bit_xor2195);
            	    bit_and68=bit_and();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bit_and68.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bit_xor"

    public static class bit_and_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bit_and"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:299:1: bit_and : equal_expr ( AMP equal_expr )* ;
    public final PicoParser.bit_and_return bit_and() throws RecognitionException {
        PicoParser.bit_and_return retval = new PicoParser.bit_and_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AMP70=null;
        PicoParser.equal_expr_return equal_expr69 = null;

        PicoParser.equal_expr_return equal_expr71 = null;


        CommonTree AMP70_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:299:12: ( equal_expr ( AMP equal_expr )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:299:14: equal_expr ( AMP equal_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_equal_expr_in_bit_and2210);
            equal_expr69=equal_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, equal_expr69.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:299:25: ( AMP equal_expr )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==AMP) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:299:27: AMP equal_expr
            	    {
            	    AMP70=(Token)match(input,AMP,FOLLOW_AMP_in_bit_and2214); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AMP70_tree = (CommonTree)adaptor.create(AMP70);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AMP70_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_equal_expr_in_bit_and2217);
            	    equal_expr71=equal_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, equal_expr71.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bit_and"

    public static class equal_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equal_expr"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:301:1: equal_expr : comp_expr ( ( EQUAL | NOT_EQUAL ) comp_expr )* ;
    public final PicoParser.equal_expr_return equal_expr() throws RecognitionException {
        PicoParser.equal_expr_return retval = new PicoParser.equal_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUAL73=null;
        Token NOT_EQUAL74=null;
        PicoParser.comp_expr_return comp_expr72 = null;

        PicoParser.comp_expr_return comp_expr75 = null;


        CommonTree EQUAL73_tree=null;
        CommonTree NOT_EQUAL74_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:301:12: ( comp_expr ( ( EQUAL | NOT_EQUAL ) comp_expr )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:301:14: comp_expr ( ( EQUAL | NOT_EQUAL ) comp_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_comp_expr_in_equal_expr2228);
            comp_expr72=comp_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_expr72.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:301:24: ( ( EQUAL | NOT_EQUAL ) comp_expr )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==EQUAL||LA20_0==NOT_EQUAL) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:301:25: ( EQUAL | NOT_EQUAL ) comp_expr
            	    {
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:301:25: ( EQUAL | NOT_EQUAL )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==EQUAL) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==NOT_EQUAL) ) {
            	        alt19=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:301:27: EQUAL
            	            {
            	            EQUAL73=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_equal_expr2233); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            EQUAL73_tree = (CommonTree)adaptor.create(EQUAL73);
            	            root_0 = (CommonTree)adaptor.becomeRoot(EQUAL73_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:301:36: NOT_EQUAL
            	            {
            	            NOT_EQUAL74=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_equal_expr2238); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            NOT_EQUAL74_tree = (CommonTree)adaptor.create(NOT_EQUAL74);
            	            root_0 = (CommonTree)adaptor.becomeRoot(NOT_EQUAL74_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_comp_expr_in_equal_expr2243);
            	    comp_expr75=comp_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, comp_expr75.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equal_expr"

    public static class comp_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comp_expr"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:1: comp_expr : shift_expr ( ( LESS | GREATER | GREATER_EQUAL | LESS_EQUAL ) shift_expr )* ;
    public final PicoParser.comp_expr_return comp_expr() throws RecognitionException {
        PicoParser.comp_expr_return retval = new PicoParser.comp_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LESS77=null;
        Token GREATER78=null;
        Token GREATER_EQUAL79=null;
        Token LESS_EQUAL80=null;
        PicoParser.shift_expr_return shift_expr76 = null;

        PicoParser.shift_expr_return shift_expr81 = null;


        CommonTree LESS77_tree=null;
        CommonTree GREATER78_tree=null;
        CommonTree GREATER_EQUAL79_tree=null;
        CommonTree LESS_EQUAL80_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:12: ( shift_expr ( ( LESS | GREATER | GREATER_EQUAL | LESS_EQUAL ) shift_expr )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:14: shift_expr ( ( LESS | GREATER | GREATER_EQUAL | LESS_EQUAL ) shift_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_shift_expr_in_comp_expr2255);
            shift_expr76=shift_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, shift_expr76.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:25: ( ( LESS | GREATER | GREATER_EQUAL | LESS_EQUAL ) shift_expr )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=GREATER && LA22_0<=LESS_EQUAL)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:26: ( LESS | GREATER | GREATER_EQUAL | LESS_EQUAL ) shift_expr
            	    {
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:26: ( LESS | GREATER | GREATER_EQUAL | LESS_EQUAL )
            	    int alt21=4;
            	    switch ( input.LA(1) ) {
            	    case LESS:
            	        {
            	        alt21=1;
            	        }
            	        break;
            	    case GREATER:
            	        {
            	        alt21=2;
            	        }
            	        break;
            	    case GREATER_EQUAL:
            	        {
            	        alt21=3;
            	        }
            	        break;
            	    case LESS_EQUAL:
            	        {
            	        alt21=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 21, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt21) {
            	        case 1 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:28: LESS
            	            {
            	            LESS77=(Token)match(input,LESS,FOLLOW_LESS_in_comp_expr2260); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            LESS77_tree = (CommonTree)adaptor.create(LESS77);
            	            root_0 = (CommonTree)adaptor.becomeRoot(LESS77_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:36: GREATER
            	            {
            	            GREATER78=(Token)match(input,GREATER,FOLLOW_GREATER_in_comp_expr2265); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            GREATER78_tree = (CommonTree)adaptor.create(GREATER78);
            	            root_0 = (CommonTree)adaptor.becomeRoot(GREATER78_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:47: GREATER_EQUAL
            	            {
            	            GREATER_EQUAL79=(Token)match(input,GREATER_EQUAL,FOLLOW_GREATER_EQUAL_in_comp_expr2270); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            GREATER_EQUAL79_tree = (CommonTree)adaptor.create(GREATER_EQUAL79);
            	            root_0 = (CommonTree)adaptor.becomeRoot(GREATER_EQUAL79_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:303:64: LESS_EQUAL
            	            {
            	            LESS_EQUAL80=(Token)match(input,LESS_EQUAL,FOLLOW_LESS_EQUAL_in_comp_expr2275); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            LESS_EQUAL80_tree = (CommonTree)adaptor.create(LESS_EQUAL80);
            	            root_0 = (CommonTree)adaptor.becomeRoot(LESS_EQUAL80_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_shift_expr_in_comp_expr2305);
            	    shift_expr81=shift_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, shift_expr81.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comp_expr"

    public static class shift_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shift_expr"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:306:1: shift_expr : add_expr ( ( SHIFT_LEFT | SHIFT_RIGHT ) add_expr )* ;
    public final PicoParser.shift_expr_return shift_expr() throws RecognitionException {
        PicoParser.shift_expr_return retval = new PicoParser.shift_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHIFT_LEFT83=null;
        Token SHIFT_RIGHT84=null;
        PicoParser.add_expr_return add_expr82 = null;

        PicoParser.add_expr_return add_expr85 = null;


        CommonTree SHIFT_LEFT83_tree=null;
        CommonTree SHIFT_RIGHT84_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:306:12: ( add_expr ( ( SHIFT_LEFT | SHIFT_RIGHT ) add_expr )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:306:14: add_expr ( ( SHIFT_LEFT | SHIFT_RIGHT ) add_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_add_expr_in_shift_expr2316);
            add_expr82=add_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, add_expr82.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:306:23: ( ( SHIFT_LEFT | SHIFT_RIGHT ) add_expr )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=SHIFT_LEFT && LA24_0<=SHIFT_RIGHT)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:306:24: ( SHIFT_LEFT | SHIFT_RIGHT ) add_expr
            	    {
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:306:24: ( SHIFT_LEFT | SHIFT_RIGHT )
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==SHIFT_LEFT) ) {
            	        alt23=1;
            	    }
            	    else if ( (LA23_0==SHIFT_RIGHT) ) {
            	        alt23=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 23, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:306:26: SHIFT_LEFT
            	            {
            	            SHIFT_LEFT83=(Token)match(input,SHIFT_LEFT,FOLLOW_SHIFT_LEFT_in_shift_expr2321); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SHIFT_LEFT83_tree = (CommonTree)adaptor.create(SHIFT_LEFT83);
            	            root_0 = (CommonTree)adaptor.becomeRoot(SHIFT_LEFT83_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:306:40: SHIFT_RIGHT
            	            {
            	            SHIFT_RIGHT84=(Token)match(input,SHIFT_RIGHT,FOLLOW_SHIFT_RIGHT_in_shift_expr2326); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SHIFT_RIGHT84_tree = (CommonTree)adaptor.create(SHIFT_RIGHT84);
            	            root_0 = (CommonTree)adaptor.becomeRoot(SHIFT_RIGHT84_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_add_expr_in_shift_expr2332);
            	    add_expr85=add_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, add_expr85.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shift_expr"

    public static class add_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "add_expr"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:308:1: add_expr : mul_expr ( ( PLUS | MINUS ) mul_expr )* ;
    public final PicoParser.add_expr_return add_expr() throws RecognitionException {
        PicoParser.add_expr_return retval = new PicoParser.add_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS87=null;
        Token MINUS88=null;
        PicoParser.mul_expr_return mul_expr86 = null;

        PicoParser.mul_expr_return mul_expr89 = null;


        CommonTree PLUS87_tree=null;
        CommonTree MINUS88_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:308:12: ( mul_expr ( ( PLUS | MINUS ) mul_expr )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:308:14: mul_expr ( ( PLUS | MINUS ) mul_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_mul_expr_in_add_expr2347);
            mul_expr86=mul_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mul_expr86.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:308:23: ( ( PLUS | MINUS ) mul_expr )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==MINUS||LA26_0==PLUS) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:308:25: ( PLUS | MINUS ) mul_expr
            	    {
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:308:25: ( PLUS | MINUS )
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==PLUS) ) {
            	        alt25=1;
            	    }
            	    else if ( (LA25_0==MINUS) ) {
            	        alt25=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 25, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:308:27: PLUS
            	            {
            	            PLUS87=(Token)match(input,PLUS,FOLLOW_PLUS_in_add_expr2353); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS87_tree = (CommonTree)adaptor.create(PLUS87);
            	            root_0 = (CommonTree)adaptor.becomeRoot(PLUS87_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:308:35: MINUS
            	            {
            	            MINUS88=(Token)match(input,MINUS,FOLLOW_MINUS_in_add_expr2358); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS88_tree = (CommonTree)adaptor.create(MINUS88);
            	            root_0 = (CommonTree)adaptor.becomeRoot(MINUS88_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mul_expr_in_add_expr2363);
            	    mul_expr89=mul_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mul_expr89.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "add_expr"

    public static class mul_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mul_expr"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:310:1: mul_expr : sign_expr ( ( TIMES | DIVIDE | MOD ) sign_expr )* ;
    public final PicoParser.mul_expr_return mul_expr() throws RecognitionException {
        PicoParser.mul_expr_return retval = new PicoParser.mul_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TIMES91=null;
        Token DIVIDE92=null;
        Token MOD93=null;
        PicoParser.sign_expr_return sign_expr90 = null;

        PicoParser.sign_expr_return sign_expr94 = null;


        CommonTree TIMES91_tree=null;
        CommonTree DIVIDE92_tree=null;
        CommonTree MOD93_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:310:12: ( sign_expr ( ( TIMES | DIVIDE | MOD ) sign_expr )* )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:310:14: sign_expr ( ( TIMES | DIVIDE | MOD ) sign_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_sign_expr_in_mul_expr2377);
            sign_expr90=sign_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, sign_expr90.getTree());
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:310:24: ( ( TIMES | DIVIDE | MOD ) sign_expr )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==DIVIDE||LA28_0==MOD||LA28_0==TIMES) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:310:25: ( TIMES | DIVIDE | MOD ) sign_expr
            	    {
            	    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:310:25: ( TIMES | DIVIDE | MOD )
            	    int alt27=3;
            	    switch ( input.LA(1) ) {
            	    case TIMES:
            	        {
            	        alt27=1;
            	        }
            	        break;
            	    case DIVIDE:
            	        {
            	        alt27=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt27=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt27) {
            	        case 1 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:310:27: TIMES
            	            {
            	            TIMES91=(Token)match(input,TIMES,FOLLOW_TIMES_in_mul_expr2382); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            TIMES91_tree = (CommonTree)adaptor.create(TIMES91);
            	            root_0 = (CommonTree)adaptor.becomeRoot(TIMES91_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:310:36: DIVIDE
            	            {
            	            DIVIDE92=(Token)match(input,DIVIDE,FOLLOW_DIVIDE_in_mul_expr2387); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DIVIDE92_tree = (CommonTree)adaptor.create(DIVIDE92);
            	            root_0 = (CommonTree)adaptor.becomeRoot(DIVIDE92_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:310:46: MOD
            	            {
            	            MOD93=(Token)match(input,MOD,FOLLOW_MOD_in_mul_expr2392); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MOD93_tree = (CommonTree)adaptor.create(MOD93);
            	            root_0 = (CommonTree)adaptor.becomeRoot(MOD93_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_sign_expr_in_mul_expr2397);
            	    sign_expr94=sign_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, sign_expr94.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mul_expr"

    public static class sign_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sign_expr"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:312:1: sign_expr : ( NOT primary_expr | MINUS bexp= primary_expr -> ^( UMINUS $bexp) | BITNOT primary_expr | primary_expr );
    public final PicoParser.sign_expr_return sign_expr() throws RecognitionException {
        PicoParser.sign_expr_return retval = new PicoParser.sign_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NOT95=null;
        Token MINUS97=null;
        Token BITNOT98=null;
        PicoParser.primary_expr_return bexp = null;

        PicoParser.primary_expr_return primary_expr96 = null;

        PicoParser.primary_expr_return primary_expr99 = null;

        PicoParser.primary_expr_return primary_expr100 = null;


        CommonTree NOT95_tree=null;
        CommonTree MINUS97_tree=null;
        CommonTree BITNOT98_tree=null;
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_primary_expr=new RewriteRuleSubtreeStream(adaptor,"rule primary_expr");
        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:312:12: ( NOT primary_expr | MINUS bexp= primary_expr -> ^( UMINUS $bexp) | BITNOT primary_expr | primary_expr )
            int alt29=4;
            switch ( input.LA(1) ) {
            case NOT:
                {
                alt29=1;
                }
                break;
            case MINUS:
                {
                alt29=2;
                }
                break;
            case BITNOT:
                {
                alt29=3;
                }
                break;
            case LPAREN:
            case IDENT:
            case NUMBER:
                {
                alt29=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:313:16: NOT primary_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NOT95=(Token)match(input,NOT,FOLLOW_NOT_in_sign_expr2424); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT95_tree = (CommonTree)adaptor.create(NOT95);
                    root_0 = (CommonTree)adaptor.becomeRoot(NOT95_tree, root_0);
                    }
                    pushFollow(FOLLOW_primary_expr_in_sign_expr2429);
                    primary_expr96=primary_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primary_expr96.getTree());

                    }
                    break;
                case 2 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:314:16: MINUS bexp= primary_expr
                    {
                    MINUS97=(Token)match(input,MINUS,FOLLOW_MINUS_in_sign_expr2446); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS97);

                    pushFollow(FOLLOW_primary_expr_in_sign_expr2450);
                    bexp=primary_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_primary_expr.add(bexp.getTree());


                    // AST REWRITE
                    // elements: bexp
                    // token labels: 
                    // rule labels: retval, bexp
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_bexp=new RewriteRuleSubtreeStream(adaptor,"rule bexp",bexp!=null?bexp.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 314:41: -> ^( UMINUS $bexp)
                    {
                        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:314:44: ^( UMINUS $bexp)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UMINUS, "UMINUS"), root_1);

                        adaptor.addChild(root_1, stream_bexp.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:315:16: BITNOT primary_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    BITNOT98=(Token)match(input,BITNOT,FOLLOW_BITNOT_in_sign_expr2478); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BITNOT98_tree = (CommonTree)adaptor.create(BITNOT98);
                    root_0 = (CommonTree)adaptor.becomeRoot(BITNOT98_tree, root_0);
                    }
                    pushFollow(FOLLOW_primary_expr_in_sign_expr2482);
                    primary_expr99=primary_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primary_expr99.getTree());

                    }
                    break;
                case 4 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:316:16: primary_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_primary_expr_in_sign_expr2500);
                    primary_expr100=primary_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primary_expr100.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sign_expr"

    public static class address_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "address"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:318:1: address : AMP id= IDENT -> ^( ADDR $id) ;
    public final PicoParser.address_return address() throws RecognitionException {
        PicoParser.address_return retval = new PicoParser.address_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id=null;
        Token AMP101=null;

        CommonTree id_tree=null;
        CommonTree AMP101_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_AMP=new RewriteRuleTokenStream(adaptor,"token AMP");

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:318:9: ( AMP id= IDENT -> ^( ADDR $id) )
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:318:14: AMP id= IDENT
            {
            AMP101=(Token)match(input,AMP,FOLLOW_AMP_in_address2512); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AMP.add(AMP101);

            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_address2516); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(id);

            if ( state.backtracking==0 ) {
               if (!table.isVisible(id.getText())) {
                              reportError(id, "is not declared");
                              }
                             id.setText(table.getFullName(id.getText()));
                            
            }


            // AST REWRITE
            // elements: id
            // token labels: id
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 323:16: -> ^( ADDR $id)
            {
                // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:323:19: ^( ADDR $id)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ADDR, "ADDR"), root_1);

                adaptor.addChild(root_1, stream_id.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "address"

    public static class primary_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primary_expr"
    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:325:1: primary_expr : (id= IDENT | NUMBER | LPAREN expr RPAREN );
    public final PicoParser.primary_expr_return primary_expr() throws RecognitionException {
        PicoParser.primary_expr_return retval = new PicoParser.primary_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id=null;
        Token NUMBER102=null;
        Token LPAREN103=null;
        Token RPAREN105=null;
        PicoParser.expr_return expr104 = null;


        CommonTree id_tree=null;
        CommonTree NUMBER102_tree=null;
        CommonTree LPAREN103_tree=null;
        CommonTree RPAREN105_tree=null;

        try {
            // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:325:15: (id= IDENT | NUMBER | LPAREN expr RPAREN )
            int alt30=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt30=1;
                }
                break;
            case NUMBER:
                {
                alt30=2;
                }
                break;
            case LPAREN:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:326:5: id= IDENT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary_expr2562); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    id_tree = (CommonTree)adaptor.create(id);
                    adaptor.addChild(root_0, id_tree);
                    }
                    if ( state.backtracking==0 ) {
                       if (!table.isVisible(id.getText())) {
                                    reportError(id," is not declared");
                                       };
                                    id.setText(table.getFullName(id.getText()));
                                       
                                 
                    }

                    }
                    break;
                case 2 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:332:5: NUMBER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NUMBER102=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_primary_expr2570); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER102_tree = (CommonTree)adaptor.create(NUMBER102);
                    adaptor.addChild(root_0, NUMBER102_tree);
                    }

                    }
                    break;
                case 3 :
                    // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:333:5: LPAREN expr RPAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LPAREN103=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_primary_expr2576); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_primary_expr2579);
                    expr104=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr104.getTree());
                    RPAREN105=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_primary_expr2581); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primary_expr"

    // $ANTLR start synpred1_Pico
    public final void synpred1_Pico_fragment() throws RecognitionException {   
        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:165:10: ( LBRACKET INT )
        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:165:11: LBRACKET INT
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred1_Pico1184); if (state.failed) return ;
        match(input,INT,FOLLOW_INT_in_synpred1_Pico1186); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Pico

    // $ANTLR start synpred2_Pico
    public final void synpred2_Pico_fragment() throws RecognitionException {   
        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:198:19: ( ELSE )
        // D:\\workspace\\CompilerLab\\src\\pico\\Pico.g:198:20: ELSE
        {
        match(input,ELSE,FOLLOW_ELSE_in_synpred2_Pico1533); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Pico

    // Delegated rules

    public final boolean synpred2_Pico() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Pico_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Pico() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Pico_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_decl_in_program1015 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_main_def_in_program1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_main_def1039 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_MAIN_in_main_def1041 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_LPAREN_in_main_def1043 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_main_def1045 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_block_in_main_def1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_stmt_in_statement1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_loop_in_statement1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_stmt_in_statement1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_in_statement1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_printf_in_call1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scanf_in_call1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_block1203 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_decl_in_block1222 = new BitSet(new long[]{0x0100281000589040L});
    public static final BitSet FOLLOW_statement_in_block1228 = new BitSet(new long[]{0x0100281000581040L});
    public static final BitSet FOLLOW_RBRACKET_in_block1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_block1285 = new BitSet(new long[]{0x0100281000581040L});
    public static final BitSet FOLLOW_statement_in_block1288 = new BitSet(new long[]{0x0100281000581040L});
    public static final BitSet FOLLOW_RBRACKET_in_block1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_decl1328 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_init_in_decl1330 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_COMMA_in_decl1334 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_init_in_decl1336 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_decl1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_init1371 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_init1373 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_expr_in_init1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_init1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_stmt1498 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_LPAREN_in_if_stmt1500 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_expr_in_if_stmt1504 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_if_stmt1506 = new BitSet(new long[]{0x0100201000581040L});
    public static final BitSet FOLLOW_statement_in_if_stmt1510 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ELSE_in_if_stmt1539 = new BitSet(new long[]{0x0100201000581040L});
    public static final BitSet FOLLOW_statement_in_if_stmt1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_while_loop1684 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_LPAREN_in_while_loop1688 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_expr_in_while_loop1691 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_while_loop1693 = new BitSet(new long[]{0x0100201000581040L});
    public static final BitSet FOLLOW_statement_in_while_loop1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_break_stmt1705 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_break_stmt1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINTF_in_printf1738 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_LPAREN_in_printf1740 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_STRING_in_printf1744 = new BitSet(new long[]{0x0000100010000000L});
    public static final BitSet FOLLOW_RPAREN_in_printf1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_printf1855 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_expr_in_printf1857 = new BitSet(new long[]{0x0000100010000000L});
    public static final BitSet FOLLOW_RPAREN_in_printf1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SCANF_in_scanf1988 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_LPAREN_in_scanf1990 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_STRING_in_scanf1992 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_COMMA_in_scanf1995 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_address_in_scanf1997 = new BitSet(new long[]{0x0000100010000000L});
    public static final BitSet FOLLOW_RPAREN_in_scanf2001 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_scanf2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assignment2062 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_assignment2064 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_expr_in_assignment2067 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_expr_in_expr2122 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_OR_in_expr2125 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_and_expr_in_expr2128 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_bit_or_in_and_expr2141 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_AND_in_and_expr2145 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_bit_or_in_and_expr2148 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_bit_xor_in_bit_or2165 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_BITOR_in_bit_or2169 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_bit_xor_in_bit_or2172 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_bit_and_in_bit_xor2188 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_BITXOR_in_bit_xor2192 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_bit_and_in_bit_xor2195 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_equal_expr_in_bit_and2210 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_AMP_in_bit_and2214 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_equal_expr_in_bit_and2217 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_comp_expr_in_equal_expr2228 = new BitSet(new long[]{0x0000008040000002L});
    public static final BitSet FOLLOW_EQUAL_in_equal_expr2233 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_equal_expr2238 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_comp_expr_in_equal_expr2243 = new BitSet(new long[]{0x0000008040000002L});
    public static final BitSet FOLLOW_shift_expr_in_comp_expr2255 = new BitSet(new long[]{0x0000000780000002L});
    public static final BitSet FOLLOW_LESS_in_comp_expr2260 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_GREATER_in_comp_expr2265 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_GREATER_EQUAL_in_comp_expr2270 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_LESS_EQUAL_in_comp_expr2275 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_shift_expr_in_comp_expr2305 = new BitSet(new long[]{0x0000000780000002L});
    public static final BitSet FOLLOW_add_expr_in_shift_expr2316 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_SHIFT_LEFT_in_shift_expr2321 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_SHIFT_RIGHT_in_shift_expr2326 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_add_expr_in_shift_expr2332 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_mul_expr_in_add_expr2347 = new BitSet(new long[]{0x0000042000000002L});
    public static final BitSet FOLLOW_PLUS_in_add_expr2353 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_MINUS_in_add_expr2358 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_mul_expr_in_add_expr2363 = new BitSet(new long[]{0x0000042000000002L});
    public static final BitSet FOLLOW_sign_expr_in_mul_expr2377 = new BitSet(new long[]{0x0001004020000002L});
    public static final BitSet FOLLOW_TIMES_in_mul_expr2382 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_DIVIDE_in_mul_expr2387 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_MOD_in_mul_expr2392 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_sign_expr_in_mul_expr2397 = new BitSet(new long[]{0x0001004020000002L});
    public static final BitSet FOLLOW_NOT_in_sign_expr2424 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_primary_expr_in_sign_expr2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_sign_expr2446 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_primary_expr_in_sign_expr2450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BITNOT_in_sign_expr2478 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_primary_expr_in_sign_expr2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expr_in_sign_expr2500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AMP_in_address2512 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENT_in_address2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary_expr2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_primary_expr2570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_expr2576 = new BitSet(new long[]{0x0300012802000000L});
    public static final BitSet FOLLOW_expr_in_primary_expr2579 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_expr2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred1_Pico1184 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INT_in_synpred1_Pico1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_synpred2_Pico1533 = new BitSet(new long[]{0x0000000000000002L});

}