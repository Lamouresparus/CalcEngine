package com.lamouresparus.calcengine;

public class Multiplication extends CalculateBase {
    public Multiplication(){}
    public Multiplication(double leftValue, double rightValue){
        super(leftValue, rightValue);
    }
    @Override
    public void calculate() {
        double result = getLeftValue() * getRightValue();
        setResult(result);
    }
}
