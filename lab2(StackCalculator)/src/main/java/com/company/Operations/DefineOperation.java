package com.company.Operations;

import com.company.CalculatorException;
import com.company.ExecutionContext;
import com.company.Operation;

public class DefineOperation implements Operation {

    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 3) {
            throw new CalculatorException("Incorrect number of arguments for DEFINE. Need 2, has " + (args.length - 1));
        }
        executionContext.getVariables().put(args[1], Double.parseDouble(args[2]));
    }
}