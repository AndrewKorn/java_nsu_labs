package com.company.Exceptions;

public class UnrecognizedOperation extends CalculatorException {
    public UnrecognizedOperation(String name) {
        super("Unrecognized operation: " + name);
    }
}
