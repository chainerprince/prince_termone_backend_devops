package com.restcalculator.services;

import com.restcalculator.Exceptions.InvalidOperationException;

public class MathOperatorImpl implements  MathOperator{
    @Override
    public  double doMath(double operand1,double operand2,String operation) throws InvalidOperationException {
        if("/".equals(operation)){
            if(operand2==0){
                throw new InvalidOperationException("Cannot divide by zero");
            }            
        }
        switch(operation){
            case "+":
                return operand1+operand2;
            case "-":
                return operand1-operand2;
            case "*":
                return operand1*operand2;
            case "/":
                return operand1/operand2;
            case "**":
                return Math.pow(operand1,operand2);
            case "log":
                return operand1 * Math.log10(operand2);
            case "ln":
                return operand1 * Math.log(operand2);
            default:
                throw new InvalidOperationException("Unknown operation");
        }
    }
}
