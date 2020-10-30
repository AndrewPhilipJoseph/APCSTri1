package util;
import java.util.ArrayList;


import view_control.CalculatorUI;
import view_control.GraphingCalculatorUI;





public class Seperator {


    public ArrayList<Math.OPERATOR> holder = new ArrayList<Math.OPERATOR>();

    String stringNumber = "";

    public double [] numbersList = new double[1000];
    public int totalAmountNumbers;


    public Seperator(String input, double x) {
        stringNumber = "";
        numbersList = new double[totalOperatorsfn(GraphingCalculatorUI.input)+1];
        totalAmountNumbers = 0;
       // String xIn = String.valueOf(x);
       // String input = GraphingCalculatorUI.input.replace("x", xIn); //replaces x in the function with iteration
        //value from in the UI

        for (int length = 0; length < input.length(); length++) {
            char iterator = input.charAt(length);
            //iterates through input to find numbers and operators
            String itS = String.valueOf(iterator); //sets the number to be a string

            if (itS.equals("x")) {
                itS = String.valueOf(x);
            }

            if (!operatorTest(itS)) {
                setNumber(itS);


            }
            else {


                operatorTest(itS);

                numbersList[totalAmountNumbers] = Double.valueOf(stringNumber);
                stringNumber = "";
                totalAmountNumbers++;
            }
            if (totalAmountNumbers == 0) {
                numbersList[totalAmountNumbers] = Double.valueOf(stringNumber);
                holder.add(Math.OPERATOR.NOOP);
            }
            }

        }




    public Seperator(String input) { //the same as above but for basic calculator functions
        stringNumber = "";
        numbersList = new double[totalOperatorsfn(input)+1];
        totalAmountNumbers = 0;
        for (int length = 0; length < input.length(); length++) {
            char iterator = input.charAt(length);
            String itS = String.valueOf(iterator);



            if (!operatorTest(itS)) {
                setNumber(itS);


            }
            else {


              //  operatorTest(itS);

                numbersList[totalAmountNumbers] = Double.valueOf(stringNumber);
                stringNumber = "";
                totalAmountNumbers++;
            }
            if (totalOperatorsfn(input) == 0) {
                numbersList[totalAmountNumbers] = Double.valueOf(stringNumber);
                holder.add(Math.OPERATOR.NOOP);
            }


        }

    }


    public int totalOperatorsfn(String input) { //finds total operators

        for (int length = 0; length < input.length(); length++) {
            char iterator = input.charAt(length);
            String itS = String.valueOf(iterator);

switch (itS) {

    case "+":

        totalAmountNumbers++;
        break;

    case "-":

        totalAmountNumbers++;
        break;

    case "*":

        totalAmountNumbers++;
        break;

    case "/":

        totalAmountNumbers++;
        break;

    case "^2":

        totalAmountNumbers++;
        break;


    case "sqrt":

        totalAmountNumbers++;
        break;
    default:

        break;
}




        }
        return totalAmountNumbers;
    }

    public void setNumber(String nextNumber) {

//sets number through concat like procedure
        stringNumber = stringNumber + nextNumber;
GraphingCalculatorUI.JBar.setText(stringNumber);

    }


    public boolean operatorTest(String itS) {
//checks for operator, and if so operator type then adds it to array
        //  if (itS.equals(Mfms)) {

        //   }
        switch (itS) {


            case "+":
                holder.add(Math.OPERATOR.PLUS);
                return true;

            case "-":
                holder.add(Math.OPERATOR.MINUS);
                return true;

            case "*":
                holder.add(Math.OPERATOR.MULTIPLY);
                return true;

            case "/":
                holder.add(Math.OPERATOR.DIVIDE);
                return true;

            case "^2":
                holder.add(Math.OPERATOR.SQUARED);
                return true;


            case "sqrt":
                holder.add(Math.OPERATOR.SQUAREROOT);
                return true;
            default:
                holder.add(Math.OPERATOR.NOOP);
                return false;

        }




    }




}

