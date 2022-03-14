package com.company;

import com.company.Exceptions.CalculatorException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
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

    public void calculate(String file) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, CalculatorException {
        List<String> listOfLines = new FileParser(file).parse();
        for (String line : listOfLines) {
            if (line.charAt(0) == '#') {
                continue;
            }
            OperationExecutor.executeOperation(line, config, executionContext, logger);
        }
    }

    public void calculate() throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, CalculatorException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (line.length() != 0) {
            if (line.charAt(0) == '#') {
                continue;
            }
            OperationExecutor.executeOperation(line, config, executionContext, logger);
            line = scanner.nextLine();
        }
    }
}