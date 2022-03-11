package com.company;

import com.company.Exceptions.CalculatorException;
import com.company.Exceptions.UnrecognizedOperation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Factory {
    private final Map<String, Operation> config;
    private final ExecutionContext executionContext;
    private final Logger logger;

    public Factory(Configuration configuration, ExecutionContext executionContext, Logger logger) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.config = configuration.getConfig();
        this.executionContext = executionContext;
        this.logger = logger;
    }

    void executeOperation(String line) {
        String[] args = line.split(" ");
        try {
            if (!config.containsKey(args[0])) {
                throw new UnrecognizedOperation(args[0]);
            }
            Operation operation = config.get(args[0]);
            try {
                operation.execute(args, executionContext);
                logger.log(Level.INFO, "operation " + args[0] + " was successful");
            } catch (CalculatorException calculatorException) {
                logger.log(Level.WARNING, calculatorException.getMessage());
            }
        }
        catch (CalculatorException calculatorException) {
            calculatorException.printStackTrace();
            logger.log(Level.WARNING, calculatorException.getMessage());
        }
    }

    public void calculate(String file) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, CalculatorException {
        List<String> listOfLines = new FileParser(file).parse();

        for (String line : listOfLines) {
            if (line.charAt(0) == '#') {
                continue;
            }
            executeOperation(line);
        }

    }

    public void calculate() throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, CalculatorException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (line.length() != 0) {
            if (line.charAt(0) == '#') {
                continue;
            }
            executeOperation(line);
            line = scanner.nextLine();
        }
    }
}