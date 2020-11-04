package util;
import java.util.ArrayList;

import view_control.GraphingCalculatorUI;
import java.util.ArrayList;
public class Point {


    private ArrayList<Double> number;
   int totalNumbers = 0;


   public double x;
    public double y;


    public Point(double x, Seperator mathData) {
        //number[totalNumbers] = 0;
        getX(x);
        this.y = calculate(mathData);
        GraphingCalculatorUI.JBar.setText(String.valueOf(this.y));
        //Convert(GraphingCalculatorUI.input);

    }

    public double calculate(Seperator mathData) {
        int numbers = 0;

        number = mathData.numbersList;

        totalNumbers = mathData.totalAmountNumbers;

      //  GraphingCalculatorUI.JBar.setText(String.valueOf(number.get(totalNumbers)));

        ArrayList<Math.OPERATOR> operator = mathData.holder;
     //   GraphingCalculatorUI.JBar.setText(String.valueOf(totalNumbers));
        while (numbers < totalNumbers) {
            number.set(numbers + 1, Math.calculateIt(number.get(numbers), operator.get(numbers), number.get(numbers + 1)));
           // GraphingCalculatorUI.JBar.setText(String.valueOf(number.get(numbers+1)));
            numbers++;
        }
        return number.get(numbers);

    }


    void getX(double x) {
        this.x = x;
    }
}



