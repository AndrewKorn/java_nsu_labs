package com.company.Operations;

import com.company.Exceptions.CalculatorException;
import com.company.Exceptions.DivisionByZero;
import com.company.Exceptions.InvalidNumberOfArguments;
import com.company.Exceptions.NotEnoughElementInStack;
import com.company.ExecutionContext;
import com.company.Operation;

public class DivOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new InvalidNumberOfArguments("/", args.length - 1, 0);
        }
        if (executionContext.getStack().size() < 2) {
            throw new NotEnoughElementInStack();
        }
        Double first = executionContext.getStack().pop();
        Double second = executionContext.getStack().pop();
        if (second == 0) {
            throw new DivisionByZero();
        }
        executionContext.getStack().push(first / second);
    }
}