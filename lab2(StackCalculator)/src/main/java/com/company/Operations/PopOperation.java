package com.company.Operations;

import com.company.CalculatorException;
import com.company.ExecutionContext;
import com.company.Operation;

public class PopOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (executionContext.getStack().isEmpty()) {
            throw new CalculatorException("Cant POP, stack is empty");
        }
        if (args.length != 2) {
            throw new CalculatorException("Incorrect number of arguments for POP. Need 1, has " + (args.length - 1));
        }
        executionContext.getStack().pop();
    }
}