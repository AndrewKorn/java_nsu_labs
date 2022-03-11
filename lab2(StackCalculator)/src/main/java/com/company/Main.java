package com.company;
import com.company.Exceptions.CalculatorException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException, NoSuchMethodException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        Logger logger = Logger.getLogger(Logger.class.getName());
        ExecutionContext executionContext = new ExecutionContext();
        Factory factory = new Factory(configuration, executionContext, logger);

        try {
            if (args.length == 0) {
                factory.calculate();
            }
            else {
                factory.calculate(args[0]);
            }
        }
        catch (CalculatorException calculatorException) {
            logger.log(Level.WARNING, calculatorException.getMessage());
        }
    }
}