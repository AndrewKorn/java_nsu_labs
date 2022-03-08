package com.company.Operations;

import com.company.CalculatorException;
import com.company.ExecutionContext;
import com.company.Operation;

public class PushOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 2) {
            throw new CalculatorException("Incorrect number of arguments for PUSH. Need 1, has " + (args.length - 1));
        }
        if (executionContext.getVariables().get(args[1]) == null) {
            throw new CalculatorException("Cant PUSH, this variable is not initialized");
        }
        executionContext.getStack().push(executionContext.getVariables().get(args[1]));
    }
}