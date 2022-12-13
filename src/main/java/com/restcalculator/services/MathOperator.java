package com.restcalculator.services;

import com.restcalculator.Exceptions.InvalidOperationException;

public interface MathOperator {
    // write a method that perform arithmetic operations
    double doMath(double operand1,double operand2,String operation) throws InvalidOperationException;
    

}
