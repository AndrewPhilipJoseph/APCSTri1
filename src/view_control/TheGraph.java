package view_control;

import util.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TheGraph extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphingCalculatorUI frame = new GraphingCalculatorUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public TheGraph(ArrayList<Point> Cords) {
int domain1, domain2, range1, range2;
domain1 = -1000000;
domain2 = 1000000;
range1 = -1000000;
range2 = 1000000;

        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, domain2-domain1, range2-range1);
        getContentPane().setLayout(null);

        for (int x = -999999; x < 999999; x = x + 1) {
            new drawRect(Cords, x);
        }

    }
    }


    class drawRect extends JFrame {

    public drawRect(ArrayList<Point> Cords, int x) {

        setBounds((int) (Cords.get(x).x*100), (int) (Cords.get(x).y*100), 1, (int) ((Cords.get(x+1).y*100-Cords.get(x-1).y*100)));

    }

    }





