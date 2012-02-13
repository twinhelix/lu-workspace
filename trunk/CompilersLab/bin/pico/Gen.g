tree grammar Gen;
// skeleton
options {
    tokenVocab=Pico;
    ASTLabelType=CommonTree;
    language=Java;
}

@header {
    package pico;
    import java.io.PrintStream;
    // add other imports needed
    import java.util.Vector;
    import java.util.Hashtable; 
}

@members{
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
}

/*
The tree grammar for the tree produced by Pico
*/
program
@init{
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
}
@after{
    endCode(code);
    printData();
}
: (decl )* // declarations before main
{ codeStart(); }
main_def // main program
{
		print("li \$v0, 10");
		print("syscall");
};

decl: ^(INT ( init )* ) ;

init
@init { String name; }
: // initialised declaration eg int errors = 0;
^(INIT var=IDENT e=expr) {
			name = var.getText();
			code.println(".data");
			if (table.isGlobal()) {
				code.println(".globl " + name);
			}
			code.print(name + ":\t");

			if ($e.result.isImmediate()) {
				code.println(".word\t" + $e.result.getValue());
				code.println(".text");
			} else {
				code.println(".space 4");
				code.println(".text");
				print("sw " + $e.result + ", " + name);
			}
			
			/*


			if ($e.result.immediate) {
				print(".word " + $e.result.value);
				print(".text");
			} else {
				print(".space 4");
				print(".text");
				print("sw " + $e.result.reg + ", " + l);
			}
			regs.free($e.result);*/
}
|  id=IDENT { declareVar($id); } // just a variable declaration
;

main_def :
^('main'  block);
block 
:
// block -{} starting with declarations
^(DECLBLOCK
  (decl*)
  (statement*))
|
^(BLOCK (statement )* )
;
/*
There are two labels given which  the condition should jump to
*/
bool_expr [ String trueLabel,String falseLabel]
@init { String nlabel=newLabel(); }

:
^(AND bool_expr[nlabel,falseLabel] 
     bool_expr[trueLabel,falseLabel] )
| ^(OR bool_expr[trueLabel,nlabel] 
    bool_expr[trueLabel, falseLabel])
| ^(NOT bool_expr[falseLabel,trueLabel] )
|  compare[trueLabel,falseLabel];


compare  [ String trueLabel,String falseLabel]
   // maybe generate a conditional branch
:
^(LESS  expr expr ) 
 | ^(GREATER      expr expr )
 | ^(EQUAL        expr expr ) 
| ^(NOT_EQUAL     expr expr )
| ^(GREATER_EQUAL expr expr ) 
| ^(LESS_EQUAL    expr expr )
;

expr returns [ Register result ]
     :  binaryexpr  { result=$binaryexpr.result; }
     |  unaryexpr   { result=$unaryexpr.result; }
		 ;

binaryexpr returns [ Register result ]
			@after {
				regs.free(right);
			}
      : ^(PLUS left=expr right=expr ) {
      		if ($left.result.isImmediate() && $right.result.isImmediate()) {
						int total = Integer.valueOf($left.result.getValue()) + Integer.valueOf($right.result.getValue());
						$left.result.setValue(Integer.toString(total));
						result = $left.result;
					} else {
						result = binaryOpComm($left.result, $right.result, "add");
					}
      }
      | ^(MINUS  expr expr ) 
      | ^(TIMES  expr expr ) 
      | ^(DIVIDE expr expr ) 
      | ^(MOD    expr expr ) 
      | ^(SHIFT_LEFT  expr expr )
      | ^(SHIFT_RIGHT expr expr ) 
      | ^(AMP    expr expr)  
      | ^(BITOR  expr expr)   
      | ^(BITXOR expr expr)   
        ;

unaryexpr returns [ Register result ] 
      : ^(UMINUS  expr)  // pass a register to use : expr[use]   
      | ^(BITNOT  expr)
      | IDENT  { //result = loadMem($IDENT.getText()); 
      		result = regs.getFreeReg();
					print ("lw " + result + ", " + $IDENT.getText());
       }
      | NUMBER { //result = regNum($NUMBER.getText());
      		result = regs.getFreeReg();
					result.setValue($NUMBER.getText());
					result.setImmediate(true);
       }
      ;

cond
   // scope is only used for while
   scope {
     String endLabel;
   }
@init{
    // allocate labels for true and false branches
    String trueLabel;
    String falseLabel;
    String thirdLabel;
    $cond::endLabel = falseLabel;   // where to goto in break
}
:
^(IFELSE bool_expr[trueLabel,falseLabel] { defineLabel(trueLabel);}
  statement 
  statement) 

| ^(IF bool_expr[trueLabel,falseLabel]
  statement ) 
 {   defineLabel(falseLabel);}

| ^(WHILE {
        defineLabel(topLabel);
    }
    bool_expr[trueLabel,falseLabel]
    statement ) {defineLabel(falseLabel);}
;

statement
 :
^(PRINTS s=STRING ) {
		print(".data");
		String str = defineLabel("Str");
		print(str + ":");
		print(".asciiz " + s);
		print(".text");
		print("la \$a0, " + str);
		print("li \$v0, 4");
		print("syscall");
}
| ^(PRINTD e=expr ) {
		if ($e.result.isImmediate()) {
			print("li \$a0, " + $e.result.getValue());
		} else {
			print("move \$a0, " + $e.result);
		}
		print("li \$v0, 1");
		print("syscall");
		regs.free($e.result);
}
| ^(GETD ^(ADDR a=IDENT )) {
		print("li \$v0, 5");
		print("syscall");
		print("sw \$v0, " + getLabel($a.getText()));
}
| ^(ASSIGN dest=IDENT result=expr) {
		if ($result.result.isImmediate()) {
			print("li " + $result.result + ", " + $result.result.getValue());
		}
		print("sw " + $result.result + ", " + getLabel($dest.getText()));
		regs.free($result.result);
	}
|  BREAK {
		print("b " + getLabel("Exit"));
 	}
| cond 
| block;
