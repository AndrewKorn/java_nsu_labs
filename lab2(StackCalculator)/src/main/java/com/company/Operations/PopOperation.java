package com.company.Operations;

import com.company.Exceptions.CalculatorException;
import com.company.Exceptions.InvalidNumberOfArguments;
import com.company.Exceptions.StackIsEmpty;
import com.company.ExecutionContext;
import com.company.Operation;

public class PopOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (executionContext.getStack().isEmpty()) {
            throw new StackIsEmpty();
        }
        if (args.length != 2) {
            throw new InvalidNumberOfArguments("POP", args.length - 1, 1);
        }
        executionContext.getStack().pop();
    }
}