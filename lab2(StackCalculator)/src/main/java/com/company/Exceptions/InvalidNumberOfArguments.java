package com.company.Exceptions;

public class InvalidNumberOfArguments extends CalculatorException {
    public InvalidNumberOfArguments(String name, int wrongArgc, int correctArgc) {
        super("Invalid number of arguments in " + name + ", have - " + wrongArgc + ", need - " + correctArgc);
    }
}
