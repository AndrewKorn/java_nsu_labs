package com.company;

public interface Operation {
    void  execute(String[] args, ExecutionContext executionContext) throws CalculatorException;
}