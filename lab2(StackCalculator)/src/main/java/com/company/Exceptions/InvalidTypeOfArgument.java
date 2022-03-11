package com.company.Exceptions;

public class InvalidTypeOfArgument extends CalculatorException  {

    public InvalidTypeOfArgument(String argument, String type) {
        super("Invalid type of argument: " + argument + ", need " + type);
    }
}
