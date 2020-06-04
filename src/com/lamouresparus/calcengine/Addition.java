package com.lamouresparus.calcengine;

public class Addition extends CalculateBase implements MathInterface {
    public Addition(){
    }
    public Addition(double leftValue, double rightValue){
        super(leftValue, rightValue);
            }

    @Override
    public void calculate() {
        double result = getLeftValue()+getRightValue();
        setResult(result);

    }

    @Override
    public String getKeyword() {
        return "add";
    }

    @Override
    public char getSymbol() {
        return '+';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftValue(leftVal);
        setRightValue(rightVal);
        calculate();
        return getResult();
    }
}
