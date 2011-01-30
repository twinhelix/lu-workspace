// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g 2010-01-27 21:31:56

    package pico;
    import java.io.PrintStream;
    // add other imports needed
    import java.util.Vector;
    import java.util.Hashtable; 


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Gen extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADDR", "ASSIGN", "BREAK", "BLOCK", "DECL", "DECLBLOCK", "ELSE", "GETD", "IF", "IFELSE", "INIT", "INT", "MAIN", "PRINTD", "PRINTS", "PRINTF", "SCANF", "UMINUS", "WHILE", "AMP", "AND", "BITNOT", "BITOR", "BITXOR", "COMMA", "DIVIDE", "EQUAL", "GREATER", "GREATER_EQUAL", "LESS", "LESS_EQUAL", "LPAREN", "LBRACKET", "MINUS", "MOD", "NOT_EQUAL", "NOT", "OR", "PLUS", "RBRACKET", "RPAREN", "SEMICOLON", "SHIFT_LEFT", "SHIFT_RIGHT", "TIMES", "NL", "WS", "COMMENT_1", "COMMENT_2", "COMMENT_3", "LETTER", "DIGIT", "IDENT", "NUMBER", "STRING", "'='"
    };
    public static final int MAIN=16;
    public static final int BITNOT=25;
    public static final int WHILE=22;
    public static final int MOD=38;
    public static final int AMP=23;
    public static final int IFELSE=13;
    public static final int LETTER=54;
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
    public static final int SHIFT_RIGHT=47;
    public static final int WS=50;
    public static final int BITOR=26;
    public static final int PRINTS=18;
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


        public Gen(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public Gen(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return Gen.tokenNames; }
    public String getGrammarFileName() { return "/Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g"; }


        final static private boolean DEBUG = false;
        final static private boolean SHOWCODE = false; 
        // PrintStream created and opened by the main program
        // write assembler to it using print, println etc
        // System.out used if SHOWCODE is true or the setCode methos is not called
        // from the main program
        private PrintStream code = System.out; 
        private int labelNum = 0;
        private String sourceName = "hellow.c";

        private Symbols table;
        private Registers regs;
        private Vector<String> strings, vars;
        private Hashtable<String,Integer> initVars;
    	
        // This file can contain Java code to be called by the actions
        // Actions can call methods from other class in the classpath
        // IMPORTANT dont put percent or dollar signs in comments in members
        // actions etc
        public void setCode(PrintStream out) {
            code = out;
        }

        public void setSourceName(String name) {
            sourceName = name;
        }

        boolean isGlobal(String varName) {
         // looks at  the variable name to see if declared at the top (global) level
         // a global var does not start with _0
          return varName.charAt(1)!='0';
         }
        
         // Code that should be done first
        void codeStart() {
            code.println("# compiling "+ sourceName);
            code.println("\t.text");
            code.println("\t.globl\tmain");
            code.println("main:");
        }

    		private String defineLabel(String base) {
    			int i;
    			for(i = 0; !table.declare(base + i); i++);
    			return table.getFullName(base + i);
    		}
    		
    		private void printData() {
    			//code.println("printData");
    		}
    		
    		private void endCode(PrintStream code) {
    			//code.ln("endCode");
    		}

    		// Gets the appropriate label in the scope
    		private String getLabel(String base) {
    			int i;
    			for(i = 0; !table.isVisible(base + i); i++);
    			return table.getFullName(base + i);
    		}

    		public void print(String s) {
    			if (s.charAt(s.length()-1) != ':') {
    				code.print("\t");
    			}
    			code.println(s);
    		}
    		
    		private void declareVar(CommonTree id) {
    		
    		}
    		
    		private Register loadMem(String ident) {
    			return regs.getFreeReg();
    		}

    		private Register regNum(String number) {
    			return regs.getFreeReg();
    		}
    		
    		private Register binaryOpComm(Register left, Register right, String op) {
    			if (left.isImmediate()) {
    				print(op + " " + left + ", " + right + ", " + left);
    			} else {
    				print(op + " " + left + ", " + left + ", " + right.getValue());
    			}
    		left.setImmediate(false);
    		
    		return left;
    	}



    // $ANTLR start "program"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:114:1: program : ( decl )* main_def ;
    public final void program() throws RecognitionException {

            regs = new Registers();
            strings= new Vector<String>(0);
            vars = new Vector<String>(0);
            initVars = new Hashtable<String,Integer>(0);
            table = new Symbols();
            // To print to the screen
            if (code == null || SHOWCODE || DEBUG) {
              code = System.out;
            }
            code.println("# compiler last changed - Jan 2010");
            code.println("# author ~lwy08 / ~lx108 / ~vdm108 ");

        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:132:1: ( ( decl )* main_def )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:132:3: ( decl )* main_def
            {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:132:3: ( decl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==INT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:132:4: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_program66);
            	    decl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             codeStart(); 
            pushFollow(FOLLOW_main_def_in_program74);
            main_def();

            state._fsp--;


            		print("li $v0, 10");
            		print("syscall");


            }


                endCode(code);
                printData();

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "program"


    // $ANTLR start "decl"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:140:1: decl : ^( INT ( init )* ) ;
    public final void decl() throws RecognitionException {
        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:140:5: ( ^( INT ( init )* ) )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:140:7: ^( INT ( init )* )
            {
            match(input,INT,FOLLOW_INT_in_decl85); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:140:13: ( init )*
                loop2:
                do {
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==INIT||LA2_0==IDENT) ) {
                        alt2=1;
                    }


                    switch (alt2) {
                	case 1 :
                	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:140:15: init
                	    {
                	    pushFollow(FOLLOW_init_in_decl89);
                	    init();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop2;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "decl"


    // $ANTLR start "init"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:142:1: init : ( ^( INIT var= IDENT e= expr ) | id= IDENT );
    public final void init() throws RecognitionException {
        CommonTree var=null;
        CommonTree id=null;
        Register e = null;


         String name; 
        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:144:1: ( ^( INIT var= IDENT e= expr ) | id= IDENT )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==INIT) ) {
                alt3=1;
            }
            else if ( (LA3_0==IDENT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:145:1: ^( INIT var= IDENT e= expr )
                    {
                    match(input,INIT,FOLLOW_INIT_in_init110); 

                    match(input, Token.DOWN, null); 
                    var=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_init114); 
                    pushFollow(FOLLOW_expr_in_init118);
                    e=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    			name = var.getText();
                    			code.println(".data");
                    			if (table.isGlobal()) {
                    				code.println(".globl " + name);
                    			}
                    			code.print(name + ":\t");

                    			if (e.isImmediate()) {
                    				code.println(".word\t" + e.getValue());
                    				code.println(".text");
                    			} else {
                    				code.println(".space 4");
                    				code.println(".text");
                    				print("sw " + e + ", " + name);
                    			}
                    			
                    			/*


                    			if (e.immediate) {
                    				print(".word " + e.value);
                    				print(".text");
                    			} else {
                    				print(".space 4");
                    				print(".text");
                    				print("sw " + e.reg + ", " + l);
                    			}
                    			regs.free(e);*/


                    }
                    break;
                case 2 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:175:4: id= IDENT
                    {
                    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_init128); 
                     declareVar(id); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "init"


    // $ANTLR start "main_def"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:178:1: main_def : ^( 'main' block ) ;
    public final void main_def() throws RecognitionException {
        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:178:10: ( ^( 'main' block ) )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:179:1: ^( 'main' block )
            {
            match(input,MAIN,FOLLOW_MAIN_in_main_def141); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_main_def144);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "main_def"


    // $ANTLR start "block"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:180:1: block : ( ^( DECLBLOCK ( ( decl )* ) ( ( statement )* ) ) | ^( BLOCK ( statement )* ) );
    public final void block() throws RecognitionException {
        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:181:1: ( ^( DECLBLOCK ( ( decl )* ) ( ( statement )* ) ) | ^( BLOCK ( statement )* ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==DECLBLOCK) ) {
                alt7=1;
            }
            else if ( (LA7_0==BLOCK) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:183:1: ^( DECLBLOCK ( ( decl )* ) ( ( statement )* ) )
                    {
                    match(input,DECLBLOCK,FOLLOW_DECLBLOCK_in_block155); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:184:3: ( ( decl )* )
                        // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:184:4: ( decl )*
                        {
                        // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:184:4: ( decl )*
                        loop4:
                        do {
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( (LA4_0==INT) ) {
                                alt4=1;
                            }


                            switch (alt4) {
                        	case 1 :
                        	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:184:4: decl
                        	    {
                        	    pushFollow(FOLLOW_decl_in_block160);
                        	    decl();

                        	    state._fsp--;


                        	    }
                        	    break;

                        	default :
                        	    break loop4;
                            }
                        } while (true);


                        }

                        // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:185:3: ( ( statement )* )
                        // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:185:4: ( statement )*
                        {
                        // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:185:4: ( statement )*
                        loop5:
                        do {
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( ((LA5_0>=ASSIGN && LA5_0<=BLOCK)||LA5_0==DECLBLOCK||(LA5_0>=GETD && LA5_0<=IFELSE)||(LA5_0>=PRINTD && LA5_0<=PRINTS)||LA5_0==WHILE) ) {
                                alt5=1;
                            }


                            switch (alt5) {
                        	case 1 :
                        	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:185:4: statement
                        	    {
                        	    pushFollow(FOLLOW_statement_in_block167);
                        	    statement();

                        	    state._fsp--;


                        	    }
                        	    break;

                        	default :
                        	    break loop5;
                            }
                        } while (true);


                        }


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:187:1: ^( BLOCK ( statement )* )
                    {
                    match(input,BLOCK,FOLLOW_BLOCK_in_block175); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:187:9: ( statement )*
                        loop6:
                        do {
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( ((LA6_0>=ASSIGN && LA6_0<=BLOCK)||LA6_0==DECLBLOCK||(LA6_0>=GETD && LA6_0<=IFELSE)||(LA6_0>=PRINTD && LA6_0<=PRINTS)||LA6_0==WHILE) ) {
                                alt6=1;
                            }


                            switch (alt6) {
                        	case 1 :
                        	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:187:10: statement
                        	    {
                        	    pushFollow(FOLLOW_statement_in_block178);
                        	    statement();

                        	    state._fsp--;


                        	    }
                        	    break;

                        	default :
                        	    break loop6;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "block"


    // $ANTLR start "bool_expr"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:192:1: bool_expr[ String trueLabel,String falseLabel] : ( ^( AND bool_expr[nlabel,falseLabel] bool_expr[trueLabel,falseLabel] ) | ^( OR bool_expr[trueLabel,nlabel] bool_expr[trueLabel, falseLabel] ) | ^( NOT bool_expr[falseLabel,trueLabel] ) | compare[trueLabel,falseLabel] );
    public final void bool_expr(String trueLabel, String falseLabel) throws RecognitionException {
         String nlabel=newLabel(); 
        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:195:1: ( ^( AND bool_expr[nlabel,falseLabel] bool_expr[trueLabel,falseLabel] ) | ^( OR bool_expr[trueLabel,nlabel] bool_expr[trueLabel, falseLabel] ) | ^( NOT bool_expr[falseLabel,trueLabel] ) | compare[trueLabel,falseLabel] )
            int alt8=4;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt8=1;
                }
                break;
            case OR:
                {
                alt8=2;
                }
                break;
            case NOT:
                {
                alt8=3;
                }
                break;
            case EQUAL:
            case GREATER:
            case GREATER_EQUAL:
            case LESS:
            case LESS_EQUAL:
            case NOT_EQUAL:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:196:1: ^( AND bool_expr[nlabel,falseLabel] bool_expr[trueLabel,falseLabel] )
                    {
                    match(input,AND,FOLLOW_AND_in_bool_expr202); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_bool_expr_in_bool_expr204);
                    bool_expr(nlabel, falseLabel);

                    state._fsp--;

                    pushFollow(FOLLOW_bool_expr_in_bool_expr213);
                    bool_expr(trueLabel, falseLabel);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:198:3: ^( OR bool_expr[trueLabel,nlabel] bool_expr[trueLabel, falseLabel] )
                    {
                    match(input,OR,FOLLOW_OR_in_bool_expr221); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_bool_expr_in_bool_expr223);
                    bool_expr(trueLabel, nlabel);

                    state._fsp--;

                    pushFollow(FOLLOW_bool_expr_in_bool_expr231);
                    bool_expr(trueLabel, falseLabel);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:200:3: ^( NOT bool_expr[falseLabel,trueLabel] )
                    {
                    match(input,NOT,FOLLOW_NOT_in_bool_expr238); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_bool_expr_in_bool_expr240);
                    bool_expr(falseLabel, trueLabel);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:201:4: compare[trueLabel,falseLabel]
                    {
                    pushFollow(FOLLOW_compare_in_bool_expr248);
                    compare(trueLabel, falseLabel);

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bool_expr"


    // $ANTLR start "compare"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:204:1: compare[ String trueLabel,String falseLabel] : ( ^( LESS expr expr ) | ^( GREATER expr expr ) | ^( EQUAL expr expr ) | ^( NOT_EQUAL expr expr ) | ^( GREATER_EQUAL expr expr ) | ^( LESS_EQUAL expr expr ) );
    public final void compare(String trueLabel, String falseLabel) throws RecognitionException {
        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:206:1: ( ^( LESS expr expr ) | ^( GREATER expr expr ) | ^( EQUAL expr expr ) | ^( NOT_EQUAL expr expr ) | ^( GREATER_EQUAL expr expr ) | ^( LESS_EQUAL expr expr ) )
            int alt9=6;
            switch ( input.LA(1) ) {
            case LESS:
                {
                alt9=1;
                }
                break;
            case GREATER:
                {
                alt9=2;
                }
                break;
            case EQUAL:
                {
                alt9=3;
                }
                break;
            case NOT_EQUAL:
                {
                alt9=4;
                }
                break;
            case GREATER_EQUAL:
                {
                alt9=5;
                }
                break;
            case LESS_EQUAL:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:207:1: ^( LESS expr expr )
                    {
                    match(input,LESS,FOLLOW_LESS_in_compare266); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_compare269);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_compare271);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:208:4: ^( GREATER expr expr )
                    {
                    match(input,GREATER,FOLLOW_GREATER_in_compare280); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_compare287);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_compare289);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:209:4: ^( EQUAL expr expr )
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_compare297); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_compare306);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_compare308);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:210:3: ^( NOT_EQUAL expr expr )
                    {
                    match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_compare316); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_compare322);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_compare324);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:211:3: ^( GREATER_EQUAL expr expr )
                    {
                    match(input,GREATER_EQUAL,FOLLOW_GREATER_EQUAL_in_compare331); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_compare333);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_compare335);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:212:3: ^( LESS_EQUAL expr expr )
                    {
                    match(input,LESS_EQUAL,FOLLOW_LESS_EQUAL_in_compare343); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_compare348);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_compare350);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "compare"


    // $ANTLR start "expr"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:215:1: expr returns [ Register result ] : ( binaryexpr | unaryexpr );
    public final Register expr() throws RecognitionException {
        Register result = null;

        Register binaryexpr1 = null;

        Register unaryexpr2 = null;


        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:216:6: ( binaryexpr | unaryexpr )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==AMP||(LA10_0>=BITOR && LA10_0<=BITXOR)||LA10_0==DIVIDE||(LA10_0>=MINUS && LA10_0<=MOD)||LA10_0==PLUS||(LA10_0>=SHIFT_LEFT && LA10_0<=TIMES)) ) {
                alt10=1;
            }
            else if ( (LA10_0==UMINUS||LA10_0==BITNOT||(LA10_0>=IDENT && LA10_0<=NUMBER)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:216:9: binaryexpr
                    {
                    pushFollow(FOLLOW_binaryexpr_in_expr371);
                    binaryexpr1=binaryexpr();

                    state._fsp--;

                     result=binaryexpr1; 

                    }
                    break;
                case 2 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:217:9: unaryexpr
                    {
                    pushFollow(FOLLOW_unaryexpr_in_expr384);
                    unaryexpr2=unaryexpr();

                    state._fsp--;

                     result=unaryexpr2; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "expr"


    // $ANTLR start "binaryexpr"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:220:1: binaryexpr returns [ Register result ] : ( ^( PLUS left= expr right= expr ) | ^( MINUS expr expr ) | ^( TIMES expr expr ) | ^( DIVIDE expr expr ) | ^( MOD expr expr ) | ^( SHIFT_LEFT expr expr ) | ^( SHIFT_RIGHT expr expr ) | ^( AMP expr expr ) | ^( BITOR expr expr ) | ^( BITXOR expr expr ) );
    public final Register binaryexpr() throws RecognitionException {
        Register result = null;

        Register left = null;

        Register right = null;


        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:224:7: ( ^( PLUS left= expr right= expr ) | ^( MINUS expr expr ) | ^( TIMES expr expr ) | ^( DIVIDE expr expr ) | ^( MOD expr expr ) | ^( SHIFT_LEFT expr expr ) | ^( SHIFT_RIGHT expr expr ) | ^( AMP expr expr ) | ^( BITOR expr expr ) | ^( BITXOR expr expr ) )
            int alt11=10;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt11=1;
                }
                break;
            case MINUS:
                {
                alt11=2;
                }
                break;
            case TIMES:
                {
                alt11=3;
                }
                break;
            case DIVIDE:
                {
                alt11=4;
                }
                break;
            case MOD:
                {
                alt11=5;
                }
                break;
            case SHIFT_LEFT:
                {
                alt11=6;
                }
                break;
            case SHIFT_RIGHT:
                {
                alt11=7;
                }
                break;
            case AMP:
                {
                alt11=8;
                }
                break;
            case BITOR:
                {
                alt11=9;
                }
                break;
            case BITXOR:
                {
                alt11=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:224:9: ^( PLUS left= expr right= expr )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_binaryexpr419); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr423);
                    left=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr427);
                    right=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                          		if (left.isImmediate() && right.isImmediate()) {
                    						int total = Integer.valueOf(left.getValue()) + Integer.valueOf(right.getValue());
                    						left.setValue(Integer.toString(total));
                    						result = left;
                    					} else {
                    						result = binaryOpComm(left, right, "add");
                    					}
                          

                    }
                    break;
                case 2 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:233:9: ^( MINUS expr expr )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_binaryexpr442); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr445);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr447);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:234:9: ^( TIMES expr expr )
                    {
                    match(input,TIMES,FOLLOW_TIMES_in_binaryexpr461); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr464);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr466);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:235:9: ^( DIVIDE expr expr )
                    {
                    match(input,DIVIDE,FOLLOW_DIVIDE_in_binaryexpr480); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr482);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr484);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:236:9: ^( MOD expr expr )
                    {
                    match(input,MOD,FOLLOW_MOD_in_binaryexpr498); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr503);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr505);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:237:9: ^( SHIFT_LEFT expr expr )
                    {
                    match(input,SHIFT_LEFT,FOLLOW_SHIFT_LEFT_in_binaryexpr519); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr522);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr524);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:238:9: ^( SHIFT_RIGHT expr expr )
                    {
                    match(input,SHIFT_RIGHT,FOLLOW_SHIFT_RIGHT_in_binaryexpr537); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr539);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr541);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:239:9: ^( AMP expr expr )
                    {
                    match(input,AMP,FOLLOW_AMP_in_binaryexpr555); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr560);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr562);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:240:9: ^( BITOR expr expr )
                    {
                    match(input,BITOR,FOLLOW_BITOR_in_binaryexpr576); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr579);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr581);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:241:9: ^( BITXOR expr expr )
                    {
                    match(input,BITXOR,FOLLOW_BITXOR_in_binaryexpr596); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_binaryexpr598);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_binaryexpr600);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

            }

            				regs.free(right);
            			
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "binaryexpr"


    // $ANTLR start "unaryexpr"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:244:1: unaryexpr returns [ Register result ] : ( ^( UMINUS expr ) | ^( BITNOT expr ) | IDENT | NUMBER );
    public final Register unaryexpr() throws RecognitionException {
        Register result = null;

        CommonTree IDENT3=null;
        CommonTree NUMBER4=null;

        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:245:7: ( ^( UMINUS expr ) | ^( BITNOT expr ) | IDENT | NUMBER )
            int alt12=4;
            switch ( input.LA(1) ) {
            case UMINUS:
                {
                alt12=1;
                }
                break;
            case BITNOT:
                {
                alt12=2;
                }
                break;
            case IDENT:
                {
                alt12=3;
                }
                break;
            case NUMBER:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:245:9: ^( UMINUS expr )
                    {
                    match(input,UMINUS,FOLLOW_UMINUS_in_unaryexpr633); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_unaryexpr636);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:246:9: ^( BITNOT expr )
                    {
                    match(input,BITNOT,FOLLOW_BITNOT_in_unaryexpr650); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_unaryexpr653);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:247:9: IDENT
                    {
                    IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_unaryexpr664); 
                     //result = loadMem(IDENT3.getText()); 
                          		result = regs.getFreeReg();
                    					print ("lw " + result + ", " + IDENT3.getText());
                           

                    }
                    break;
                case 4 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:251:9: NUMBER
                    {
                    NUMBER4=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_unaryexpr677); 
                     //result = regNum(NUMBER4.getText());
                          		result = regs.getFreeReg();
                    					result.setValue(NUMBER4.getText());
                    					result.setImmediate(true);
                           

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "unaryexpr"

    protected static class cond_scope {
        String endLabel;
    }
    protected Stack cond_stack = new Stack();


    // $ANTLR start "cond"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:258:1: cond : ( ^( IFELSE bool_expr[trueLabel,falseLabel] statement statement ) | ^( IF bool_expr[trueLabel,falseLabel] statement ) | ^( WHILE bool_expr[trueLabel,falseLabel] statement ) );
    public final void cond() throws RecognitionException {
        cond_stack.push(new cond_scope());

            // allocate labels for true and false branches
            String trueLabel;
            String falseLabel;
            String thirdLabel;
            ((cond_scope)cond_stack.peek()).endLabel = falseLabel;   // where to goto in break

        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:270:1: ( ^( IFELSE bool_expr[trueLabel,falseLabel] statement statement ) | ^( IF bool_expr[trueLabel,falseLabel] statement ) | ^( WHILE bool_expr[trueLabel,falseLabel] statement ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case IFELSE:
                {
                alt13=1;
                }
                break;
            case IF:
                {
                alt13=2;
                }
                break;
            case WHILE:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:271:1: ^( IFELSE bool_expr[trueLabel,falseLabel] statement statement )
                    {
                    match(input,IFELSE,FOLLOW_IFELSE_in_cond710); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_bool_expr_in_cond712);
                    bool_expr(trueLabel, falseLabel);

                    state._fsp--;

                     defineLabel(trueLabel);
                    pushFollow(FOLLOW_statement_in_cond719);
                    statement();

                    state._fsp--;

                    pushFollow(FOLLOW_statement_in_cond724);
                    statement();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:275:3: ^( IF bool_expr[trueLabel,falseLabel] statement )
                    {
                    match(input,IF,FOLLOW_IF_in_cond732); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_bool_expr_in_cond734);
                    bool_expr(trueLabel, falseLabel);

                    state._fsp--;

                    pushFollow(FOLLOW_statement_in_cond739);
                    statement();

                    state._fsp--;


                    match(input, Token.UP, null); 
                       defineLabel(falseLabel);

                    }
                    break;
                case 3 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:279:3: ^( WHILE bool_expr[trueLabel,falseLabel] statement )
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_cond751); 


                            defineLabel(topLabel);
                        

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_bool_expr_in_cond759);
                    bool_expr(trueLabel, falseLabel);

                    state._fsp--;

                    pushFollow(FOLLOW_statement_in_cond766);
                    statement();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    defineLabel(falseLabel);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            cond_stack.pop();
        }
        return ;
    }
    // $ANTLR end "cond"


    // $ANTLR start "statement"
    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:286:1: statement : ( ^( PRINTS s= STRING ) | ^( PRINTD e= expr ) | ^( GETD ^( ADDR a= IDENT ) ) | ^( ASSIGN dest= IDENT result= expr ) | BREAK | cond | block );
    public final void statement() throws RecognitionException {
        CommonTree s=null;
        CommonTree a=null;
        CommonTree dest=null;
        Register e = null;

        Register result = null;


        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:287:2: ( ^( PRINTS s= STRING ) | ^( PRINTD e= expr ) | ^( GETD ^( ADDR a= IDENT ) ) | ^( ASSIGN dest= IDENT result= expr ) | BREAK | cond | block )
            int alt14=7;
            switch ( input.LA(1) ) {
            case PRINTS:
                {
                alt14=1;
                }
                break;
            case PRINTD:
                {
                alt14=2;
                }
                break;
            case GETD:
                {
                alt14=3;
                }
                break;
            case ASSIGN:
                {
                alt14=4;
                }
                break;
            case BREAK:
                {
                alt14=5;
                }
                break;
            case IF:
            case IFELSE:
            case WHILE:
                {
                alt14=6;
                }
                break;
            case BLOCK:
            case DECLBLOCK:
                {
                alt14=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:288:1: ^( PRINTS s= STRING )
                    {
                    match(input,PRINTS,FOLLOW_PRINTS_in_statement781); 

                    match(input, Token.DOWN, null); 
                    s=(CommonTree)match(input,STRING,FOLLOW_STRING_in_statement785); 

                    match(input, Token.UP, null); 

                    		print(".data");
                    		String str = defineLabel("Str");
                    		print(str + ":");
                    		print(".asciiz " + s);
                    		print(".text");
                    		print("la $a0, " + str);
                    		print("li $v0, 4");
                    		print("syscall");


                    }
                    break;
                case 2 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:298:3: ^( PRINTD e= expr )
                    {
                    match(input,PRINTD,FOLLOW_PRINTD_in_statement794); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_statement798);
                    e=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		if (e.isImmediate()) {
                    			print("li $a0, " + e.getValue());
                    		} else {
                    			print("move $a0, " + e);
                    		}
                    		print("li $v0, 1");
                    		print("syscall");
                    		regs.free(e);


                    }
                    break;
                case 3 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:308:3: ^( GETD ^( ADDR a= IDENT ) )
                    {
                    match(input,GETD,FOLLOW_GETD_in_statement807); 

                    match(input, Token.DOWN, null); 
                    match(input,ADDR,FOLLOW_ADDR_in_statement810); 

                    match(input, Token.DOWN, null); 
                    a=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement814); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 

                    		print("li $v0, 5");
                    		print("syscall");
                    		print("sw $v0, " + getLabel(a.getText()));


                    }
                    break;
                case 4 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:313:3: ^( ASSIGN dest= IDENT result= expr )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_statement824); 

                    match(input, Token.DOWN, null); 
                    dest=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement828); 
                    pushFollow(FOLLOW_expr_in_statement832);
                    result=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		if (result.isImmediate()) {
                    			print("li " + result + ", " + result.getValue());
                    		}
                    		print("sw " + result + ", " + getLabel(dest.getText()));
                    		regs.free(result);
                    	

                    }
                    break;
                case 5 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:320:4: BREAK
                    {
                    match(input,BREAK,FOLLOW_BREAK_in_statement840); 

                    		print("b " + getLabel("Exit"));
                     	

                    }
                    break;
                case 6 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:323:3: cond
                    {
                    pushFollow(FOLLOW_cond_in_statement846);
                    cond();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Gen.g:324:3: block
                    {
                    pushFollow(FOLLOW_block_in_statement851);
                    block();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "statement"

    // Delegated rules


 

    public static final BitSet FOLLOW_decl_in_program66 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_main_def_in_program74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_decl85 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_init_in_decl89 = new BitSet(new long[]{0x0100000000004008L});
    public static final BitSet FOLLOW_INIT_in_init110 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_init114 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_init118 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_init128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAIN_in_main_def141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_main_def144 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLBLOCK_in_block155 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_decl_in_block160 = new BitSet(new long[]{0x000000000047BAE8L});
    public static final BitSet FOLLOW_statement_in_block167 = new BitSet(new long[]{0x0000000000463AE8L});
    public static final BitSet FOLLOW_BLOCK_in_block175 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block178 = new BitSet(new long[]{0x0000000000463AE8L});
    public static final BitSet FOLLOW_AND_in_bool_expr202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_bool_expr204 = new BitSet(new long[]{0x00000387C1000000L});
    public static final BitSet FOLLOW_bool_expr_in_bool_expr213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_bool_expr221 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_bool_expr223 = new BitSet(new long[]{0x00000387C1000000L});
    public static final BitSet FOLLOW_bool_expr_in_bool_expr231 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_bool_expr238 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_bool_expr240 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_compare_in_bool_expr248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_compare266 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_compare269 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_compare271 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_in_compare280 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_compare287 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_compare289 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUAL_in_compare297 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_compare306 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_compare308 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_compare316 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_compare322 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_compare324 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_EQUAL_in_compare331 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_compare333 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_compare335 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESS_EQUAL_in_compare343 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_compare348 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_compare350 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binaryexpr_in_expr371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryexpr_in_expr384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_binaryexpr419 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr423 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr427 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_binaryexpr442 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr445 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMES_in_binaryexpr461 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr464 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr466 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVIDE_in_binaryexpr480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr482 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr484 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_binaryexpr498 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr503 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr505 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHIFT_LEFT_in_binaryexpr519 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr522 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr524 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHIFT_RIGHT_in_binaryexpr537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr539 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AMP_in_binaryexpr555 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr560 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr562 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITOR_in_binaryexpr576 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr579 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr581 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITXOR_in_binaryexpr596 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_binaryexpr598 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_binaryexpr600 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UMINUS_in_unaryexpr633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryexpr636 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITNOT_in_unaryexpr650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryexpr653 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_unaryexpr664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_unaryexpr677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IFELSE_in_cond710 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_cond712 = new BitSet(new long[]{0x0000000000463AE0L});
    public static final BitSet FOLLOW_statement_in_cond719 = new BitSet(new long[]{0x0000000000463AE0L});
    public static final BitSet FOLLOW_statement_in_cond724 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_cond732 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_cond734 = new BitSet(new long[]{0x0000000000463AE0L});
    public static final BitSet FOLLOW_statement_in_cond739 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_cond751 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_cond759 = new BitSet(new long[]{0x0000000000463AE0L});
    public static final BitSet FOLLOW_statement_in_cond766 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRINTS_in_statement781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_statement785 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRINTD_in_statement794 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_statement798 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GETD_in_statement807 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ADDR_in_statement810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_statement814 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_statement824 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_statement828 = new BitSet(new long[]{0x0301C4602EA00000L});
    public static final BitSet FOLLOW_expr_in_statement832 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BREAK_in_statement840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cond_in_statement846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement851 = new BitSet(new long[]{0x0000000000000002L});

}