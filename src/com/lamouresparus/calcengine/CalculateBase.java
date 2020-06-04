package com.lamouresparus.calcengine;

public abstract class CalculateBase {
    private double leftValue;
    private double rightValue;
    private double result;

    public CalculateBase(){

    }
    public CalculateBase(double leftValue, double rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public abstract void calculate();

    public double getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(double leftValue) {
        this.leftValue = leftValue;
    }

    public double getRightValue() {
        return rightValue;
    }

    public void setRightValue(double rightValue) {
        this.rightValue = rightValue;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
