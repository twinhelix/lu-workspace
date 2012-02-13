// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g 2010-01-27 21:31:55

package pico ;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PicoLexer extends Lexer {
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

    public PicoLexer() {;} 
    public PicoLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PicoLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g"; }

    // $ANTLR start "ADDR"
    public final void mADDR() throws RecognitionException {
        try {
            int _type = ADDR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:11:6: ( 'addr' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:11:8: 'addr'
            {
            match("addr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ADDR"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:12:8: ( 'assign' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:12:10: 'assign'
            {
            match("assign"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "BREAK"
    public final void mBREAK() throws RecognitionException {
        try {
            int _type = BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:13:7: ( 'break' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:13:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BREAK"

    // $ANTLR start "BLOCK"
    public final void mBLOCK() throws RecognitionException {
        try {
            int _type = BLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:14:7: ( 'block' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:14:9: 'block'
            {
            match("block"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BLOCK"

    // $ANTLR start "DECL"
    public final void mDECL() throws RecognitionException {
        try {
            int _type = DECL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:15:6: ( 'decl' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:15:8: 'decl'
            {
            match("decl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECL"

    // $ANTLR start "DECLBLOCK"
    public final void mDECLBLOCK() throws RecognitionException {
        try {
            int _type = DECLBLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:16:11: ( 'declblock' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:16:13: 'declblock'
            {
            match("declblock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECLBLOCK"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:17:6: ( 'else' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:17:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "GETD"
    public final void mGETD() throws RecognitionException {
        try {
            int _type = GETD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:18:6: ( 'getd' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:18:8: 'getd'
            {
            match("getd"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GETD"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:19:4: ( 'if' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:19:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "IFELSE"
    public final void mIFELSE() throws RecognitionException {
        try {
            int _type = IFELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:20:8: ( 'ifelse' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:20:10: 'ifelse'
            {
            match("ifelse"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IFELSE"

    // $ANTLR start "INIT"
    public final void mINIT() throws RecognitionException {
        try {
            int _type = INIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:21:6: ( 'init' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:21:8: 'init'
            {
            match("init"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INIT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:22:5: ( 'int' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:22:7: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "MAIN"
    public final void mMAIN() throws RecognitionException {
        try {
            int _type = MAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:23:6: ( 'main' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:23:8: 'main'
            {
            match("main"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAIN"

    // $ANTLR start "PRINTD"
    public final void mPRINTD() throws RecognitionException {
        try {
            int _type = PRINTD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:24:8: ( 'printd' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:24:10: 'printd'
            {
            match("printd"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRINTD"

    // $ANTLR start "PRINTS"
    public final void mPRINTS() throws RecognitionException {
        try {
            int _type = PRINTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:25:8: ( 'prints' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:25:10: 'prints'
            {
            match("prints"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRINTS"

    // $ANTLR start "PRINTF"
    public final void mPRINTF() throws RecognitionException {
        try {
            int _type = PRINTF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:26:8: ( 'printf' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:26:10: 'printf'
            {
            match("printf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRINTF"

    // $ANTLR start "SCANF"
    public final void mSCANF() throws RecognitionException {
        try {
            int _type = SCANF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:27:7: ( 'scanf' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:27:9: 'scanf'
            {
            match("scanf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SCANF"

    // $ANTLR start "UMINUS"
    public final void mUMINUS() throws RecognitionException {
        try {
            int _type = UMINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:28:8: ( 'uminus' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:28:10: 'uminus'
            {
            match("uminus"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UMINUS"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:29:7: ( 'while' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:29:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:30:7: ( '=' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:30:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "AMP"
    public final void mAMP() throws RecognitionException {
        try {
            int _type = AMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:61:16: ( '&' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:61:18: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMP"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:62:16: ( '&&' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:62:18: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "BITNOT"
    public final void mBITNOT() throws RecognitionException {
        try {
            int _type = BITNOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:63:16: ( '~' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:63:19: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BITNOT"

    // $ANTLR start "BITOR"
    public final void mBITOR() throws RecognitionException {
        try {
            int _type = BITOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:64:16: ( '|' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:64:19: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BITOR"

    // $ANTLR start "BITXOR"
    public final void mBITXOR() throws RecognitionException {
        try {
            int _type = BITXOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:65:16: ( '^' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:65:19: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BITXOR"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:66:16: ( ',' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:66:19: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:67:16: ( '/' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:67:18: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:68:16: ( '==' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:68:19: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "GREATER"
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:69:16: ( '>' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:69:18: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER"

    // $ANTLR start "GREATER_EQUAL"
    public final void mGREATER_EQUAL() throws RecognitionException {
        try {
            int _type = GREATER_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:70:16: ( '>=' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:70:18: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER_EQUAL"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:71:16: ( '<' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:71:18: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "LESS_EQUAL"
    public final void mLESS_EQUAL() throws RecognitionException {
        try {
            int _type = LESS_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:72:16: ( '<=' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:72:19: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS_EQUAL"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:73:16: ( '(' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:73:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:74:16: ( '{' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:74:18: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:75:16: ( '-' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:75:18: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:76:16: ( '%' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:76:19: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "NOT_EQUAL"
    public final void mNOT_EQUAL() throws RecognitionException {
        try {
            int _type = NOT_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:77:16: ( '!=' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:77:19: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT_EQUAL"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:78:16: ( '!' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:78:18: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:79:16: ( '||' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:79:18: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:80:16: ( '+' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:80:19: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:81:16: ( '}' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:81:18: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:82:16: ( ')' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:82:19: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:83:16: ( ';' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:83:18: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "SHIFT_LEFT"
    public final void mSHIFT_LEFT() throws RecognitionException {
        try {
            int _type = SHIFT_LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:84:16: ( '<<' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:84:18: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHIFT_LEFT"

    // $ANTLR start "SHIFT_RIGHT"
    public final void mSHIFT_RIGHT() throws RecognitionException {
        try {
            int _type = SHIFT_RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:85:16: ( '>>' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:85:18: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHIFT_RIGHT"

    // $ANTLR start "TIMES"
    public final void mTIMES() throws RecognitionException {
        try {
            int _type = TIMES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:86:16: ( '*' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:86:19: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TIMES"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:90:4: ( ( '\\r' | '\\n' ) )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:90:6: ( '\\r' | '\\n' )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:94:4: ( ( ' ' | '\\t' | NL )+ )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:94:6: ( ' ' | '\\t' | NL )+
            {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:94:6: ( ' ' | '\\t' | NL )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT_1"
    public final void mCOMMENT_1() throws RecognitionException {
        try {
            int _type = COMMENT_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:100:11: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:100:13: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:100:18: ( options {greedy=false; } : . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:100:46: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT_1"

    // $ANTLR start "COMMENT_2"
    public final void mCOMMENT_2() throws RecognitionException {
        try {
            int _type = COMMENT_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:102:11: ( '//' (~ ( '\\n' | '\\r' ) )* NL )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:102:13: '//' (~ ( '\\n' | '\\r' ) )* NL
            {
            match("//"); 

            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:102:18: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:102:19: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            mNL(); 
             _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT_2"

    // $ANTLR start "COMMENT_3"
    public final void mCOMMENT_3() throws RecognitionException {
        try {
            int _type = COMMENT_3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:109:11: ( '#include' (~ ( '\\n' | '\\r' ) )* NL )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:109:13: '#include' (~ ( '\\n' | '\\r' ) )* NL
            {
            match("#include"); 

            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:109:24: (~ ( '\\n' | '\\r' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:109:25: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            mNL(); 
              _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT_3"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:112:17: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:112:19: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:113:17: ( '0' .. '9' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:113:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:116:10: ( LETTER ( LETTER | DIGIT )* )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:116:13: LETTER ( LETTER | DIGIT )*
            {
            mLETTER(); 
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:116:20: ( LETTER | DIGIT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:118:10: ( ( DIGIT )+ )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:118:15: ( DIGIT )+
            {
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:118:15: ( DIGIT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:118:17: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:119:10: ( '\"' (~ ( '\"' ) )* '\"' )
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:119:13: '\"' (~ ( '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:119:17: (~ ( '\"' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:119:18: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:8: ( ADDR | ASSIGN | BREAK | BLOCK | DECL | DECLBLOCK | ELSE | GETD | IF | IFELSE | INIT | INT | MAIN | PRINTD | PRINTS | PRINTF | SCANF | UMINUS | WHILE | T__59 | AMP | AND | BITNOT | BITOR | BITXOR | COMMA | DIVIDE | EQUAL | GREATER | GREATER_EQUAL | LESS | LESS_EQUAL | LPAREN | LBRACKET | MINUS | MOD | NOT_EQUAL | NOT | OR | PLUS | RBRACKET | RPAREN | SEMICOLON | SHIFT_LEFT | SHIFT_RIGHT | TIMES | WS | COMMENT_1 | COMMENT_2 | COMMENT_3 | IDENT | NUMBER | STRING )
        int alt8=53;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:10: ADDR
                {
                mADDR(); 

                }
                break;
            case 2 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:15: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 3 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:22: BREAK
                {
                mBREAK(); 

                }
                break;
            case 4 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:28: BLOCK
                {
                mBLOCK(); 

                }
                break;
            case 5 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:34: DECL
                {
                mDECL(); 

                }
                break;
            case 6 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:39: DECLBLOCK
                {
                mDECLBLOCK(); 

                }
                break;
            case 7 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:49: ELSE
                {
                mELSE(); 

                }
                break;
            case 8 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:54: GETD
                {
                mGETD(); 

                }
                break;
            case 9 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:59: IF
                {
                mIF(); 

                }
                break;
            case 10 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:62: IFELSE
                {
                mIFELSE(); 

                }
                break;
            case 11 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:69: INIT
                {
                mINIT(); 

                }
                break;
            case 12 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:74: INT
                {
                mINT(); 

                }
                break;
            case 13 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:78: MAIN
                {
                mMAIN(); 

                }
                break;
            case 14 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:83: PRINTD
                {
                mPRINTD(); 

                }
                break;
            case 15 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:90: PRINTS
                {
                mPRINTS(); 

                }
                break;
            case 16 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:97: PRINTF
                {
                mPRINTF(); 

                }
                break;
            case 17 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:104: SCANF
                {
                mSCANF(); 

                }
                break;
            case 18 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:110: UMINUS
                {
                mUMINUS(); 

                }
                break;
            case 19 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:117: WHILE
                {
                mWHILE(); 

                }
                break;
            case 20 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:123: T__59
                {
                mT__59(); 

                }
                break;
            case 21 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:129: AMP
                {
                mAMP(); 

                }
                break;
            case 22 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:133: AND
                {
                mAND(); 

                }
                break;
            case 23 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:137: BITNOT
                {
                mBITNOT(); 

                }
                break;
            case 24 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:144: BITOR
                {
                mBITOR(); 

                }
                break;
            case 25 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:150: BITXOR
                {
                mBITXOR(); 

                }
                break;
            case 26 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:157: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 27 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:163: DIVIDE
                {
                mDIVIDE(); 

                }
                break;
            case 28 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:170: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 29 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:176: GREATER
                {
                mGREATER(); 

                }
                break;
            case 30 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:184: GREATER_EQUAL
                {
                mGREATER_EQUAL(); 

                }
                break;
            case 31 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:198: LESS
                {
                mLESS(); 

                }
                break;
            case 32 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:203: LESS_EQUAL
                {
                mLESS_EQUAL(); 

                }
                break;
            case 33 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:214: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 34 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:221: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 35 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:230: MINUS
                {
                mMINUS(); 

                }
                break;
            case 36 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:236: MOD
                {
                mMOD(); 

                }
                break;
            case 37 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:240: NOT_EQUAL
                {
                mNOT_EQUAL(); 

                }
                break;
            case 38 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:250: NOT
                {
                mNOT(); 

                }
                break;
            case 39 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:254: OR
                {
                mOR(); 

                }
                break;
            case 40 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:257: PLUS
                {
                mPLUS(); 

                }
                break;
            case 41 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:262: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 42 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:271: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 43 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:278: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 44 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:288: SHIFT_LEFT
                {
                mSHIFT_LEFT(); 

                }
                break;
            case 45 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:299: SHIFT_RIGHT
                {
                mSHIFT_RIGHT(); 

                }
                break;
            case 46 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:311: TIMES
                {
                mTIMES(); 

                }
                break;
            case 47 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:317: WS
                {
                mWS(); 

                }
                break;
            case 48 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:320: COMMENT_1
                {
                mCOMMENT_1(); 

                }
                break;
            case 49 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:330: COMMENT_2
                {
                mCOMMENT_2(); 

                }
                break;
            case 50 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:340: COMMENT_3
                {
                mCOMMENT_3(); 

                }
                break;
            case 51 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:350: IDENT
                {
                mIDENT(); 

                }
                break;
            case 52 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:356: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 53 :
                // /Users/HassassiN/Desktop/Work/workspace/CompilersLab/src/pico/Pico.g:1:363: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\13\41\1\63\1\65\1\uffff\1\67\2\uffff\1\72\1\75\1\100\4"+
        "\uffff\1\102\12\uffff\7\41\1\113\6\41\21\uffff\10\41\1\uffff\1\41"+
        "\1\134\5\41\1\142\3\41\1\147\1\150\1\151\1\41\1\153\1\uffff\1\154"+
        "\4\41\1\uffff\1\41\1\162\1\163\1\41\3\uffff\1\41\2\uffff\1\41\1"+
        "\171\1\41\1\173\1\174\2\uffff\1\41\1\176\1\177\1\u0080\1\u0081\1"+
        "\uffff\1\u0082\2\uffff\1\41\5\uffff\1\41\1\u0085\1\uffff";
    static final String DFA8_eofS =
        "\u0086\uffff";
    static final String DFA8_minS =
        "\1\11\1\144\1\154\1\145\1\154\1\145\1\146\1\141\1\162\1\143\1\155"+
        "\1\150\1\75\1\46\1\uffff\1\174\2\uffff\1\52\1\75\1\74\4\uffff\1"+
        "\75\12\uffff\1\144\1\163\1\145\1\157\1\143\1\163\1\164\1\60\3\151"+
        "\1\141\2\151\21\uffff\1\162\1\151\1\141\1\143\1\154\1\145\1\144"+
        "\1\154\1\uffff\1\164\1\60\4\156\1\154\1\60\1\147\2\153\3\60\1\163"+
        "\1\60\1\uffff\1\60\1\164\1\146\1\165\1\145\1\uffff\1\156\2\60\1"+
        "\154\3\uffff\1\145\2\uffff\1\144\1\60\1\163\2\60\2\uffff\1\157\4"+
        "\60\1\uffff\1\60\2\uffff\1\143\5\uffff\1\153\1\60\1\uffff";
    static final String DFA8_maxS =
        "\1\176\1\163\1\162\1\145\1\154\1\145\1\156\1\141\1\162\1\143\1\155"+
        "\1\150\1\75\1\46\1\uffff\1\174\2\uffff\1\57\1\76\1\75\4\uffff\1"+
        "\75\12\uffff\1\144\1\163\1\145\1\157\1\143\1\163\1\164\1\172\1\164"+
        "\2\151\1\141\2\151\21\uffff\1\162\1\151\1\141\1\143\1\154\1\145"+
        "\1\144\1\154\1\uffff\1\164\1\172\4\156\1\154\1\172\1\147\2\153\3"+
        "\172\1\163\1\172\1\uffff\1\172\1\164\1\146\1\165\1\145\1\uffff\1"+
        "\156\2\172\1\154\3\uffff\1\145\2\uffff\1\163\1\172\1\163\2\172\2"+
        "\uffff\1\157\4\172\1\uffff\1\172\2\uffff\1\143\5\uffff\1\153\1\172"+
        "\1\uffff";
    static final String DFA8_acceptS =
        "\16\uffff\1\27\1\uffff\1\31\1\32\3\uffff\1\41\1\42\1\43\1\44\1\uffff"+
        "\1\50\1\51\1\52\1\53\1\56\1\57\1\62\1\63\1\64\1\65\16\uffff\1\34"+
        "\1\24\1\26\1\25\1\47\1\30\1\60\1\61\1\33\1\36\1\55\1\35\1\40\1\54"+
        "\1\37\1\45\1\46\10\uffff\1\11\20\uffff\1\14\5\uffff\1\1\4\uffff"+
        "\1\5\1\7\1\10\1\uffff\1\13\1\15\5\uffff\1\3\1\4\5\uffff\1\21\1\uffff"+
        "\1\23\1\2\1\uffff\1\12\1\16\1\17\1\20\1\22\2\uffff\1\6";
    static final String DFA8_specialS =
        "\u0086\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\37\2\uffff\1\37\22\uffff\1\37\1\31\1\43\1\40\1\uffff\1\30"+
            "\1\15\1\uffff\1\25\1\34\1\36\1\32\1\21\1\27\1\uffff\1\22\12"+
            "\42\1\uffff\1\35\1\24\1\14\1\23\2\uffff\32\41\3\uffff\1\20\1"+
            "\41\1\uffff\1\1\1\2\1\41\1\3\1\4\1\41\1\5\1\41\1\6\3\41\1\7"+
            "\2\41\1\10\2\41\1\11\1\41\1\12\1\41\1\13\3\41\1\26\1\17\1\33"+
            "\1\16",
            "\1\44\16\uffff\1\45",
            "\1\47\5\uffff\1\46",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53\7\uffff\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\64",
            "",
            "\1\66",
            "",
            "",
            "\1\70\4\uffff\1\71",
            "\1\73\1\74",
            "\1\77\1\76",
            "",
            "",
            "",
            "",
            "\1\101",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\112\25\41",
            "\1\114\12\uffff\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "",
            "\1\133",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\143",
            "\1\144",
            "\1\145",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\1\41\1\146\30\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\152",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "",
            "\1\161",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\164",
            "",
            "",
            "",
            "\1\165",
            "",
            "",
            "\1\166\1\uffff\1\170\14\uffff\1\167",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\172",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "\1\175",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "\1\u0083",
            "",
            "",
            "",
            "",
            "",
            "\1\u0084",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ADDR | ASSIGN | BREAK | BLOCK | DECL | DECLBLOCK | ELSE | GETD | IF | IFELSE | INIT | INT | MAIN | PRINTD | PRINTS | PRINTF | SCANF | UMINUS | WHILE | T__59 | AMP | AND | BITNOT | BITOR | BITXOR | COMMA | DIVIDE | EQUAL | GREATER | GREATER_EQUAL | LESS | LESS_EQUAL | LPAREN | LBRACKET | MINUS | MOD | NOT_EQUAL | NOT | OR | PLUS | RBRACKET | RPAREN | SEMICOLON | SHIFT_LEFT | SHIFT_RIGHT | TIMES | WS | COMMENT_1 | COMMENT_2 | COMMENT_3 | IDENT | NUMBER | STRING );";
        }
    }
 

}