package com.lamouresparus.calcengine;

public class DynamicHelper {
    private MathInterface[] handlers;
    public DynamicHelper(MathInterface[] handlers){
        this.handlers = handlers;
    }
    public  String process(String statement){
        String[] parts = statement.split(MathInterface.SEPERATOR);
        String keyword = parts[0];
        MathInterface theHandler = null;
        for( MathInterface handler:handlers){
            if(handler.getKeyword().equalsIgnoreCase(keyword)){
                theHandler = handler;
                break;
            }
        }
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        double result = theHandler.doCalculation(leftVal,rightVal);
        StringBuilder sb = new StringBuilder();
        sb.append(leftVal + " ");
        sb.append(theHandler.getSymbol());
        sb.append(" "+ rightVal);
        sb.append(" "+"=" +" ");
        sb.append(result);
        return sb.toString();
    }
}
