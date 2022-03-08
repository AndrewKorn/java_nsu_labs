package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class Factory {
    public static void getInstance(String file, Map<String, Operation> config) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        new Factory(file, config);
    }

    public static void getInstance(Map<String, Operation> config) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        new Factory(config);
    }

    private Factory(String file, Map<String, Operation> config) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {
        ExecutionContext executionContext = new ExecutionContext();
        List<String> listOfLines = new FileParser(file).parse();

        for (String line : listOfLines) {
            if (line.charAt(0) == '#') {
                continue;
            }
            String[] args = line.split(" ");
            Operation operation = config.get(args[0]);
            operation.execute(args, executionContext);
        }

    }

    Factory(Map<String, Operation> config) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {
        ExecutionContext executionContext = new ExecutionContext();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (line.length() != 0) {
            if (line.charAt(0) == '#') {
                continue;
            }
            String[] args = line.split(" ");
            Operation operation = config.get(args[0]);
            operation.execute(args, executionContext);
            line = scanner.nextLine();
        }
    }
}
