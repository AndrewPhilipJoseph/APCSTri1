package control_calculator;

import util.Math;
import util.Seperator;
import view_control.CalculatorUI;

//package view_control;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.util.ArrayList;

import util.Math.OPERATOR;


public class Calculator2 extends JFrame {
static public String output;

    public Calculator2() {
            EventQueue.invokeLater(() -> {
                //starts when input is recieved
                try {
                    CalculatorUI frame = new CalculatorUI();
                    frame.setVisible(true);
                    //creates the UI
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

    }




    public Calculator2(String input) {



double calcNumbers[];
int totalAmountCalcNumbers = 0;
Seperator in = new Seperator(input);


        totalAmountCalcNumbers = in.totalAmountNumbers;
        calcNumbers = new double[totalAmountCalcNumbers];
        calcNumbers = in.numbersList;



        ArrayList<OPERATOR> operator = new ArrayList<OPERATOR>();
               operator = in.holder;
       // CalculatorUI.JBar.setText("hello");
        int numbers = 0;
      while (numbers < totalAmountCalcNumbers) {
          calcNumbers[numbers + 1] = Math.calculateIt(calcNumbers[numbers], operator.get(numbers), calcNumbers[numbers + 1]);
            // operator.get(numbers)
            numbers++;
        }


output = String.valueOf(calcNumbers[numbers]);


//new Seperator(input);
    }


}
