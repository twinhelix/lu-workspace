# Makefile for the Change lab
 
# Using the -O (optimize) option generates warnings about gregorian_calendar   
CXXFLAGS = -g   -Wall  -Woverloaded-virtual -Wextra -Weffc++
CXX=g++

# Get the names of the CPP and possible .o files in this 
# directory 
CPPFILES = $(wildcard *.cpp)
OFILES = $(CPPFILES:.cpp=.o)
HEADERS = $(wildcard *.hpp)


all: rules charge

# This uses the compiler to work out which  .hpp
# file each .cpp  depends on and the result saved in rules, included below
rules : $(CPPFILES)
	$(CXX) -MM $(CPPFILES) > rules 

# remove all object files  
clean : 
	rm -f *.o  charge

  
# make the main program
charge : $(OFILES) 
	$(CXX)   $(OFILES) -o charge  -lboost_date_time -lboost_program_options -lboost_regex -o charge

# the rules saying which .hpp files each .cpp uses   
include rules  