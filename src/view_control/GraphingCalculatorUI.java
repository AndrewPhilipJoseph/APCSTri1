package view_control;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import javax.swing.JButton;
import java.util.ArrayList;


public class GraphingCalculatorUI extends JFrame {
    JTextField TBar;
    char[] x;
    char[] y;
    char[][] point = new char[][] {x, y};


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

public GraphingCalculatorUI()
{
    /*getContentPane().setBackground(new Color(175, 238, 238));
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 418, 315);
    getContentPane().setLayout(null);
    TBar.setForeground(Color.WHITE);
    TBar.setFont(new Font("Lucida Grande", Font.PLAIN, 72));
    TBar.setHorizontalAlignment(SwingConstants.RIGHT);
    TBar.setBounds(18, 6, 377, 67);
    getContentPane().add(TBar);
*/
    JButton GCalculate = new JButton("Calculate");
    GCalculate.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
    GCalculate.setOpaque(true);
    GCalculate.setForeground(Color.WHITE);
    GCalculate.setBackground(Color.PINK);
    //GCalculate.addActionListener(e -> ArrayList<point> = );
    GCalculate.setBounds(35, 86, 75, 40);
    getContentPane().add(GCalculate);


}



}

