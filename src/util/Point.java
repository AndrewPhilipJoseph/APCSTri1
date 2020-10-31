package util;
import java.util.ArrayList;

import view_control.GraphingCalculatorUI;
import java.util.ArrayList;
public class Point {


    private ArrayList<Double> number;
   int totalNumbers = 0;


    double x;
    double y;


    public Point(double x, double y, Seperator mathData) {
        //number[totalNumbers] = 0;
        this.x = x;
        this.y = calculate(mathData);
        GraphingCalculatorUI.JBar.setText(String.valueOf(this.y));
        //Convert(GraphingCalculatorUI.input);

    }

    public double calculate(Seperator mathData) {
        int numbers = 0;

        number = mathData.numbersList;

        totalNumbers = mathData.totalAmountNumbers;

        GraphingCalculatorUI.JBar.setText(String.valueOf(number.get(totalNumbers)));

        ArrayList<Math.OPERATOR> operator = mathData.holder;
     //   GraphingCalculatorUI.JBar.setText(String.valueOf(totalNumbers));
        while (numbers < totalNumbers) {
            number.set(numbers + 1, Math.calculateIt(number.get(numbers), operator.get(numbers), number.get(numbers + 1)));
           // GraphingCalculatorUI.JBar.setText(String.valueOf(number.get(numbers+1)));
            numbers++;
        }
        return number.get(numbers);

    }
}



    /*public boolean operatorTest(String itS) {
    if (itS.equals(Mfns)) {
        switch (itS) {
            case "+":
                holder.add(Math.OPERATOR.PLUS);
                break;

            case "-":
                holder.add(Math.OPERATOR.MINUS);
                break;

            case "*":
                holder.add(Math.OPERATOR.MULTIPLY);
                break;

            case "/":
                holder.add(Math.OPERATOR.DIVIDE);
                break;
            default:
                holder.add(Math.OPERATOR.NOOP);
                break;
        }
return true;

    }
        return false;
    }





}
*/

