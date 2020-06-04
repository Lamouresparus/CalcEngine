package com.lamouresparus.calcengine;

public interface MathInterface {
    String SEPERATOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculation(double leftVal, double rightVal);
}
