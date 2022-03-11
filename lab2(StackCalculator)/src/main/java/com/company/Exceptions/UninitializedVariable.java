package com.company.Exceptions;

public class UninitializedVariable extends CalculatorException {
    public UninitializedVariable(String varible) {
        super("Uninitialized variable: " + varible);
    }
}
