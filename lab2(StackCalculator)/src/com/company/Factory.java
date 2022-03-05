package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class Factory {
    public static void getInstance(String file) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        new Factory(file);
    }

    private Map<String, Operation> getConfiguration() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, Operation> configuration = new HashMap<>();
        InputStream in = Factory.class.getResourceAsStream("operations.properties");
        Properties properties = new Properties();
        properties.load(in);
        for (String key : properties.stringPropertyNames()) {
            String className = properties.getProperty(key);
            Operation operation = (Operation)Class.forName(className).getDeclaredConstructor().newInstance();
            configuration.put(key, operation);
        }
        return configuration;
    }

    private Factory(String file) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {
        Map<String, Operation> configuration = getConfiguration();

        List<String> listOfLines = new FileParser(file).parse();
        ExecutionContext executionContext = new ExecutionContext();
        for (String line : listOfLines) {
            if (line.charAt(0) == '#') {
                continue;
            }
            String[] args = line.split(" ");
            Operation operation = configuration.get(args[0]);
            operation.execute(args, executionContext);
        }
    }
}
