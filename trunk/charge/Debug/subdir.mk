################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../ChargeMain.cpp \
../Point.cpp \
../ReadScript.cpp \
../Tokenize.cpp 

OBJS += \
./ChargeMain.o \
./Point.o \
./ReadScript.o \
./Tokenize.o 

CPP_DEPS += \
./ChargeMain.d \
./Point.d \
./ReadScript.d \
./Tokenize.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


