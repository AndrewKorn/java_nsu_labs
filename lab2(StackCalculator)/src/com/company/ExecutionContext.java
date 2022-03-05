package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext {
    private Stack<Double> stack;
    private Map<String, Double> variables;

    public ExecutionContext() {
        stack = new Stack<>();
        variables = new HashMap<>();
    }

    public Stack<Double> getStack() {
        return stack;
    }

    public Map<String, Double> getVariables() {
        return variables;
    }
}
