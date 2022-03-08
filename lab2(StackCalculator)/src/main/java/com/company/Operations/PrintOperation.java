package com.company.Operations;

import com.company.CalculatorException;
import com.company.ExecutionContext;
import com.company.Operation;

public class PrintOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new CalculatorException("Incorrect number of arguments for PRINT. Need 0, has " + (args.length - 1));
        }
        if (executionContext.getStack().isEmpty()) {
            throw new CalculatorException("Cant PRINT, stack is empty");
        }
        System.out.println(executionContext.getStack().peek());
    }
}