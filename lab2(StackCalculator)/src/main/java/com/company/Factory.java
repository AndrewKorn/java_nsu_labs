package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class Factory {
    private final Map<String, Operation> config;

    public Factory(Configuration configuration) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.config = configuration.getConfig();
    }

    public void getInstance(String file, Configuration configuration) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, CalculatorException {
        ExecutionContext executionContext = new ExecutionContext();
        List<String> listOfLines = new FileParser(file).parse();

        for (String line : listOfLines) {
            if (line.charAt(0) == '#') {
                continue;
            }
            String[] args = line.split(" ");
            try {
                if (!config.containsKey(args[0])) {
                    throw new CalculatorException("Unrecognized operation '" + args[0] + "'");
                }
                Operation operation = config.get(args[0]);
                try {
                    operation.execute(args, executionContext);
                } catch (CalculatorException calculatorException) {
                    calculatorException.printStackTrace();
                }
            }
            catch (CalculatorException calculatorException) {
                calculatorException.printStackTrace();
            }
        }

    }

    public void getInstance(Configuration configuration) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, CalculatorException {
        ExecutionContext executionContext = new ExecutionContext();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (line.length() != 0) {
            if (line.charAt(0) == '#') {
                continue;
            }
            String[] args = line.split(" ");
            try {
                if (!config.containsKey(args[0])) {
                    throw new CalculatorException("Unrecognized operation '" + args[0] + "'");
                }
                Operation operation = config.get(args[0]);
                try {
                    operation.execute(args, executionContext);
                } catch (CalculatorException calculatorException) {
                    calculatorException.printStackTrace();
                }
                line = scanner.nextLine();
            }
            catch (CalculatorException calculatorException) {
                calculatorException.printStackTrace();
            }
        }
    }
}