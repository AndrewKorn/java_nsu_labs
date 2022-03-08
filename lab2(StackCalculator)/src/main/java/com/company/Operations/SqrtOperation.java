package com.company.Operations;

import com.company.CalculatorException;
import com.company.ExecutionContext;
import com.company.Operation;

public class SqrtOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new CalculatorException("Incorrect number of arguments for SQRT. Need 0, has " + (args.length - 1));
        }
        if (executionContext.getStack().isEmpty()) {
            throw new CalculatorException("Cant SQRT, stack is empty");
        }
        Double a = executionContext.getStack().pop();
        executionContext.getStack().push(Math.sqrt(a));
    }
}