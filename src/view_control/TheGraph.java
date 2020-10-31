package view_control;

import javax.swing.*;
import java.awt.*;

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


    public TheGraph() {
int domain1, domain2, range1, range2;
domain1 = -10000;
domain2 = 10000;
range1 = -10000;
range2 = 10000;

        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, , 315);
        getContentPane().setLayout(null);



    }
    }





