package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuration {
    private final String configFile;
    private final Map<String, Operation> config;

    public Configuration(String configFile) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.configFile = configFile;
        this.config = new HashMap<>();
    }

    public Map<String, Operation> getConfig() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InputStream in = Configuration.class.getClassLoader().getResourceAsStream(configFile);
        Properties properties = new Properties();
        properties.load(in);
        for (String key : properties.stringPropertyNames()) {
            String className = properties.getProperty(key);
            Operation operation = (Operation)Class.forName(className).getDeclaredConstructor().newInstance();
            config.put(key, operation);
        }
        return config;
    }
}