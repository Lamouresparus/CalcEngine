package com.lamouresparus.calcengine;

public class Subtraction extends CalculateBase {
    public Subtraction(){}
    public Subtraction(double leftValue, double rightValue){
        super(leftValue, rightValue);
    }

    @Override
    public void calculate() {
        double result = getLeftValue() - getRightValue();
        setResult(result);
    }
}
