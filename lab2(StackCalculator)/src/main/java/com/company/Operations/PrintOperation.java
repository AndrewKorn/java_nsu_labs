package com.company.Operations;

import com.company.Exceptions.CalculatorException;
import com.company.Exceptions.InvalidNumberOfArguments;
import com.company.Exceptions.StackIsEmpty;
import com.company.ExecutionContext;
import com.company.Operation;

public class PrintOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new InvalidNumberOfArguments("PRINT", args.length - 1, 0);
        }
        if (executionContext.getStack().isEmpty()) {
            throw new StackIsEmpty();
        }
        System.out.println(executionContext.getStack().peek());
    }
}