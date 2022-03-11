package com.company.Operations;

import com.company.Exceptions.CalculatorException;
import com.company.Exceptions.InvalidNumberOfArguments;
import com.company.Exceptions.InvalidTypeOfArgument;
import com.company.ExecutionContext;
import com.company.Operation;

public class DefineOperation implements Operation {

    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 3) {
            throw new InvalidNumberOfArguments("DEFINE", args.length - 1, 2);
        }
        try {
            Double.parseDouble(args[2]);
        }
        catch (NumberFormatException e) {
            throw new InvalidTypeOfArgument(args[2], "Double");
        }
        executionContext.getVariables().put(args[1], Double.parseDouble(args[2]));
    }
}