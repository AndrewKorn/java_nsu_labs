package com.company.Operations;

import com.company.CalculatorException;
import com.company.ExecutionContext;
import com.company.Operation;

public class MulOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new CalculatorException("Incorrect number of arguments for *. Need 0, has " + (args.length - 1));
        }
        if (executionContext.getStack().size() < 2) {
            throw new CalculatorException("Not enough element in stack");
        }
        Double first = executionContext.getStack().pop();
        Double second = executionContext.getStack().pop();
        executionContext.getStack().push(first * second);
    }
}