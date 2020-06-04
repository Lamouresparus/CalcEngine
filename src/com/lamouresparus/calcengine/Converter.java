package com.lamouresparus.calcengine;

public class Converter {
    public static final char ADD_SYMBOL = '+';
    public static final char SUBTRACT_SYMBOL = '-';
    public static final char MULTIPLY_SYMBOL = '*';
    public static final char DIVIDE_SYMBOL = '/';
    MathOperation command;
    double leftValue;
    double rightValue;
    double result;

    public void process(String statement) throws InvalidStatementException {
        String[] splitedStatements = statement.split(" ");
        if (splitedStatements.length!=3) throw  new InvalidStatementException("Invalid statement", statement);
        String stringCommand = splitedStatements[0];
        try{
            leftValue = Double.parseDouble(splitedStatements[1]);
            rightValue = Double.parseDouble(splitedStatements[2]);
        }
        catch (NumberFormatException e){
            throw new InvalidStatementException("Wrong number Format", statement, e);
        }
        convertCommand(stringCommand);
        if(command == null){
            throw new InvalidStatementException("Invalid Command", statement);
        }
        calculate(command);
    }
    private void convertCommand(String stringCommand){
        if(stringCommand.equalsIgnoreCase(MathOperation.Add.toString())) command = MathOperation.Add;
        else if (stringCommand.equalsIgnoreCase(MathOperation.Subtract.toString())) command = MathOperation.Subtract;
        else if (stringCommand.equalsIgnoreCase(MathOperation.Multiply.toString())) command = MathOperation.Multiply;
        else if(stringCommand.equalsIgnoreCase(MathOperation.Divide.toString())) command = MathOperation.Divide;
        else command = null;
    }
    private void calculate(MathOperation command){
        CalculateBase calculator = null;
        switch (command){
            case Add:
                calculator = new Addition(leftValue,rightValue);
                break;
            case Divide:
                calculator = new Division(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplication(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtraction(leftValue,rightValue);
                break;
        }
        calculator.calculate();
        result = calculator.getResult();
    }

    @Override
    public String toString() {
        char symbol = ' ';
        switch (command){
            case Subtract -> symbol = SUBTRACT_SYMBOL;
            case Multiply -> symbol = MULTIPLY_SYMBOL;
            case Divide ->  symbol = DIVIDE_SYMBOL;
            case Add -> symbol = ADD_SYMBOL;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(leftValue + " ");
        sb.append(symbol+" ");
        sb.append(rightValue + " ");
        sb.append("=" +" ");
        sb.append(result);
        return sb.toString();
    }
}
