/*
 * Translates a c subset into mips assembler
 * the main program which calls the scanner,parser, check
 * and code generator 
 * to print out the tree generated from parser set PRINTTREE(below)
 * to stop calling the code generator unset WRITECODE 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import pico.PicoLexer;
import pico.PicoParser;
import pico.Gen;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
public class Compiler {

  enum Error {
    // Error messages and output (see Sun's enum notes/examples)
    complete("The compiler finished"),
    notC("The source file '%1$s' should be  C\n"), 
    noSourceName("There should be one source file\n"),
    missing("The source file '%1$s' does not exist\n"),
    unReadable("The source file '%1$s' is not readable\n"),
    recognise("Syntax error: %1$s\n"),
    reading("Error reading source: %1$s\n"),
    parseErrors("The parser found %1$d syntax error%2$s\n"),
    declareErrors("The parser found %1$d  error%2$s\n"),
    emptyTree("The generated tree was empty\n"),
    checkError("Error checking the tree:"),
    errors(" %1$d error%2$s found\n"),
    cantCreate("Can't create the assembler file\n"),
    treeError("Error walking over modified tree\n")
    ;

    private final String errorMessage;

    private Error(String message) {
      errorMessage = message;
    }

    public void error() {
      System.err.println(errorMessage);
      System.exit(ordinal());
    }

    public void error(final String str) {
      System.err.format(errorMessage, str);
      System.exit(ordinal());
    }
    public void error(final int count) {
      System.err.format(errorMessage, count,(count != 1 ? "s" :""));
      System.exit(ordinal());
    }

    public void exception(final Exception thrown) {
      System.err.println(errorMessage+thrown.toString());
      System.exit(ordinal());
    }
  }


  /**
   * @param args
   * One source file only 
   */
  public static void main(final String[] args) {
    // output control
    final boolean WRITECODE = true;
    final boolean PRINTTREE = true;
    // files
    final String sourceSuffix = ".c";
    final String codeSuffix = ".s";
    System.setProperty("TESTDIRECTORY", "D:\\workspace\\CompilersLab\\compilertests\\");
    // The directory containing files that can be used for testing
    final String testDirectory = System.getProperty("TESTDIRECTORY");//+"/";

    int errorCount = 0;
    
    if (args.length == 0) {
      Error.noSourceName.error();
    }
    String sourceName= "";
    String outputDir = "";
    int arg=0;
    if (args[arg].charAt(0) == '-') {
      if (args[arg].equals("-outputdir")){
          if (args.length > arg+2){
           outputDir = args[arg+1];
           sourceName = args[2];
          }
      }
        
    }
    else {
      sourceName=args[arg];
    }
    sourceName += sourceSuffix;
    
    final int suff = sourceName.lastIndexOf(sourceSuffix);
    if ((suff < 0) && (sourceName.lastIndexOf(".") >= 0)) {
      Error.notC.error(sourceName);
    }
    
    File sourceFile = new File(sourceName);
    CharStream source = null;
    if (!sourceFile.exists()) {
      if (sourceFile.getParent()== null) {
        /*
         * If there is no directory in the filename
         * try the test directory
         */
        sourceName = testDirectory+sourceName;
        sourceFile = new File(sourceName);
        if (!sourceFile.exists()) {
          Error.missing.error(sourceName);
        }
      } else {
        Error.missing.error(sourceName);
      }
    }
    try {
      source = new ANTLRFileStream(sourceName);
    } catch (FileNotFoundException expn) {
      Error.unReadable.error(sourceName);
    }
    catch  (java.io.IOException expn2 ) {
      Error.unReadable.error(sourceName);
    }
	final String shortSourceName = sourceFile.getName();
    final PicoLexer scanner = new PicoLexer(source);
    final CommonTokenStream stream = new CommonTokenStream(scanner);
    final PicoParser parser = new PicoParser(stream);
    // Call the Parser (which calls the lexer)
     PicoParser.program_return result = null;
    try {
      result  =  parser.program();
    } catch (RecognitionException expn) {
      Error.recognise.exception(expn);
    }
    errorCount = parser.getNumberOfSyntaxErrors();
    if (errorCount > 0 ) {
      Error.parseErrors.error(errorCount) ;
    }
    errorCount = parser.getDeclareErrorCount();
    if (errorCount > 0 ) {
      Error.declareErrors.error(errorCount) ;
    }

    // Get the generated tree if there are no syntax errors
    final CommonTree tree = (CommonTree)result.getTree();
    if (tree == null) {
      Error.emptyTree.error();
    }
    if (PRINTTREE) {
      System.out.println(tree.toStringTree());
    }
    if (WRITECODE) {
      String codeName = shortSourceName;
      // generate the code file name
      if (suff < 0) {
        codeName = codeName + codeSuffix;
      } else {
        int last = codeName.lastIndexOf(".");
        if (last >= 0) {  
         codeName = codeName.substring(0, last) + codeSuffix;
        }
      }
      PrintStream code = null;
      try {
        code = new PrintStream(outputDir+codeName);
      } catch (FileNotFoundException expn) {
        Error.cantCreate.exception(expn);
      }
      CommonTreeNodeStream treestream = new CommonTreeNodeStream(tree);
      // call the code 
      Gen gen = new Gen(treestream);
      gen.setCode(code);
      gen.setSourceName(sourceName);
      try {
        gen.program();
      } catch (RecognitionException expn) {
        Error.treeError.exception(expn);
      }
      finally {
        code.close();
      }
    }
    Error.complete.error();
  }
}

