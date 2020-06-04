package com.lamouresparus.calcengine;

public class MathCalc {
    private double leftValue;
    private double rightValue;
    private double result;
    private char opCode;

    public MathCalc(){
    }

    public MathCalc(char opCode){
        this.opCode = opCode;
    }

    public MathCalc(char opCode, double leftValue, double rightValue) {
        this(opCode);
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public double getLeftValue() {
        return leftValue;
    }

    public double getRightValue() {
        return rightValue;
    }

    public double getResult() {
        return result;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setLeftValue(double leftValue) {
        this.leftValue = leftValue;
    }

    public void setRightValue(double rightValue) {
        this.rightValue = rightValue;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public void execute(){
        switch (opCode) {
            case 'a':
                result = leftValue + rightValue;
                break;
            case 's':
                result = leftValue - rightValue;
                break;
            case 'd':
                result = rightValue != 0 ? leftValue / rightValue : 0.0d;
                break;
            case 'm':
                result = leftValue * rightValue;
                break;
            default:
                System.out.println("Opps something went wrong");
        }

    }

    public  void  execute(int leftValue, int rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        execute();
        result = (int) result;
    }

    public  void  execute(double leftValue, double rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        execute();
    }
}
