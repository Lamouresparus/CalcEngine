package com.lamouresparus.calcengine;

public class Division extends CalculateBase{
    public Division(){}
    public Division(double leftValue, double rightValue){
        super(leftValue,rightValue);
    }
    @Override
    public void calculate() {
        double result = getRightValue() != 0? getLeftValue()/getRightValue() : 0.0;
        setResult(result);
}
}
