package com.lamouresparus.myapp;

import com.lamouresparus.calcengine.*;

public class Main {

    public static void main(String[] args) {
        DynamicHelper helper = new DynamicHelper(new MathInterface[]{
                new Addition(), new PowerOf()
        });
        String[] statements = {"add 1.0 7.0",
        "power 4.0 4.0"};
        for(String  statement : statements){
            String output = helper.process(statement);
            System.out.println(output);
        }
    }

    public static void usingConverterHelper(){
        String[] statements = {"add 1.0",
                "Add xxx 34.0",
                "addingsvghjk 38.0 40.0",
                "add 4.0 2.0",
                "divide 80.2 20.05",
                "subtract 30.0 40.0",
                "multiply 59.0 40.3"};
        Converter helper = new Converter();
        for (String statement : statements){
            try {
                helper.process(statement);
                System.out.println(helper);
            }
            catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("Original Cause: "+ e.getCause().getMessage());
                }
            }

        }
    }
    public static void usingMethodOveride (){
        MathCalc[] calculations = new MathCalc[4];
        calculations[0] = new MathCalc('a',20.0d,10.0d);
        calculations[1] = new MathCalc('s',50.0d,5.0d);
        calculations[2] = new MathCalc('d',40.0d,20.0d);
        calculations[3] = new MathCalc('m',10.0d, 2.0d);

        for (MathCalc calculation : calculations){
            calculation.execute();
            System.out.println("result is " + calculation.getResult());
        }

        System.out.println("----------------------------------------------");
        System.out.println("Method Override");
        System.out.println("-----------------------------------------------");

        MathCalc mathCalc = new MathCalc('d');
        mathCalc.execute(5.0d, 2.0d);
        System.out.println("first double val = "+ mathCalc.getResult());
        mathCalc.execute(5,2);
        System.out.println("second int val = "+ mathCalc.getResult());
        mathCalc.execute(5.0d,2);
        System.out.println("third double and int val = "+ mathCalc.getResult());
    }
    public static void usingCalculateBase(){
        System.out.println("---------------------------------------------------------");
        System.out.println("");
        System.out.println("Using Inheriance");
        System.out.println("---------------------------------------------------------------");

        CalculateBase[] calculateBases = {new Addition(200d,300d),
                new Multiplication(500d, 10d),
                new Subtraction(300d,150d),
                new Division(600d, 60d)};

        for ( CalculateBase calculation :calculateBases){
            calculation.calculate();
            System.out.println("Result = "+calculation.getResult());
        }
    }
}