package com.company;

import com.company.Exceptions.CalculatorException;
import com.company.Exceptions.UnrecognizedOperation;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationExecutor {
    static void executeOperation(String[] args, Map<String, Operation> config, ExecutionContext executionContext, Logger logger) {
        try {
            if (!config.containsKey(args[0])) {
                throw new UnrecognizedOperation(args[0]);
            }
            Operation operation = config.get(args[0]);
            try {
                operation.execute(args, executionContext);
                logger.log(Level.INFO, "operation " + args[0] + " was successful");
            }
            catch (CalculatorException calculatorException) {
                logger.log(Level.WARNING, calculatorException.getMessage());
            }
        }
        catch (CalculatorException calculatorException) {
            calculatorException.printStackTrace();
            logger.log(Level.WARNING, calculatorException.getMessage());
        }
    }
}
