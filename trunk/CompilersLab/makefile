# The makefile	of the compiler lab
# This makefile should be in the directory above pico
# All source files except Compiler should be in the subdirectory pico
# Type "make" to build the compiler 
ANTLRVERSION=3.2
LOCATION=/vol/lab
ANTLRJAR=$(LOCATION)/lib/antlr-${ANTLRVERSION}.jar
ANTLRBIN=$(LOCATION)/bin/antlr32
PARSER=pico/PicoParser.class
CODEGEN=pico/Gen.class

# default rule
compiler.jar :   $(PARSER) $(CODEGEN) Compiler.class
	jar cf	compiler.jar  pico/*.class *.class

Compiler.class : Compiler.java 
	javac -g -classpath ./pico:$(ANTLRJAR):. Compiler.java 


  
$(PARSER) : pico/Pico.g
	$(ANTLRBIN)  pico/Pico.g
	javac -g -classpath $(ANTLRJAR) pico/*.java  


$(CODEGEN) : pico/Gen.g
	$(ANTLRBIN) -lib ./pico pico/Gen.g
	javac -g -classpath $(ANTLRJAR)  pico/*.java  

clean :
	rm -rf pico/*.class Compiler.class compiler.jar pico/Gen.java

