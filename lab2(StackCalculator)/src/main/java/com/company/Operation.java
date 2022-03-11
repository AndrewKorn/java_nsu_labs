package com.company;

import com.company.Exceptions.CalculatorException;

public interface Operation {
    void  execute(String[] args, ExecutionContext executionContext) throws CalculatorException;
}