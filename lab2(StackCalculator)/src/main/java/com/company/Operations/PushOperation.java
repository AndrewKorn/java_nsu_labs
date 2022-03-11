package com.company.Operations;

import com.company.Exceptions.CalculatorException;
import com.company.Exceptions.InvalidNumberOfArguments;
import com.company.Exceptions.UninitializedVariable;
import com.company.ExecutionContext;
import com.company.Operation;

public class PushOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 2) {
            throw new InvalidNumberOfArguments("PUSH", args.length - 1, 1);
        }
        if (executionContext.getVariables().get(args[1]) == null) {
            throw new UninitializedVariable(args[1]);
        }
        executionContext.getStack().push(executionContext.getVariables().get(args[1]));
    }
}