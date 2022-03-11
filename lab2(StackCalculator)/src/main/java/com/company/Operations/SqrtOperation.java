package com.company.Operations;

import com.company.Exceptions.CalculatorException;
import com.company.Exceptions.InvalidNumberOfArguments;
import com.company.Exceptions.StackIsEmpty;
import com.company.ExecutionContext;
import com.company.Operation;

public class SqrtOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new InvalidNumberOfArguments("SQRT", args.length - 1, 0);
        }
        if (executionContext.getStack().isEmpty()) {
            throw new StackIsEmpty();
        }
        Double a = executionContext.getStack().pop();
        executionContext.getStack().push(Math.sqrt(a));
    }
}