package view_control;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control_calculator.Calculator2;
import util.Math.OPERATOR;

public class CalculatorUI extends JFrame {
	private final JLabel calcArea = new JLabel("");
	public static JTextField JBar = new JTextField();
	private boolean initialCalcAreaInputState;
	private enum STATE { INITIAL, SAVE1, SAVE2, CALC }

	private STATE mathState;
	
	// calculator values
    private OPERATOR mathOp;
	private double arg1;
    private double arg2;
    private double calcAnswer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	
	private void calculateAnswer()  // method to perform calculation
	{
	    calcAnswer = util.Math.calculateIt(arg1, mathOp, arg2);
	    //runs the calculateIt method, which is a util file imported into this one. When parsed two numbers,
		// arg1 and arg2, and an operator it preforms the calculation and puts it into calcAnswer

		calcArea.setText(String.valueOf(calcAnswer));
		//this sets the calc area, to get arg1 and arg2 a similar, but reverse, function is used to convert the
		//text into a double variable.
	    arg1 = Double.parseDouble(calcArea.getText());
	    //This sets arg1 to the newly calculated number, which allows for further calculations without
		//resetting the calculator to be neccesary, and remembers the value in the case of multiple calculations
		//being preformed
	    mathState = STATE.CALC;
	    //Changes mathState for control flow

		initialCalcAreaInputState = true;
		//sets boolean initalCalcAreaInputState to true so that the visual calculator area can be updated
	}
	
	private void updateCalcArea(String string) {
		if (initialCalcAreaInputState) {  // sets text to string on initial key typed
			calcArea.setText(string);
			initialCalcAreaInputState = false;
	    } else  {                         // concatenates string to end of text subsequent keys typed
			calcArea.setText(calcArea.getText() + string);
	    }
	}
	
	/**
	 * Save values for Calculator.
	 */
	private void saveValueOfArg1() { // method to store 1st value in calculation (arg1)
	    arg1 = Double.parseDouble((calcArea.getText()));
		//sets arg1, an int variable to the text of the calc area which is the input
	    mathState = STATE.SAVE1;
	    //sets mathState to SAVE1. mathState is a STATE type variable which is a type enum created to store
		// { INITIAL, SAVE1, SAVE2, CALC } to control the flow of code

		initialCalcAreaInputState = true;

	}
	
	private void saveValueOfArg2() { // method to store 2nd value in calculation (arg2)
		if (mathState != STATE.CALC) {
			arg2 = Double.parseDouble((calcArea.getText()));
			mathState = STATE.SAVE2;
		}
	}
	
	private void saveValueOfMathOp(OPERATOR op) { // method to store operator
		mathOp = op;
	}
	//sets the operator
	private void clearCalculator() {  // helper method to clear and update calculator to default
		// calculator control
		String calcAreaDefault = "0.0";
		calcArea.setText(calcAreaDefault);
		mathState = STATE.INITIAL;
		initialCalcAreaInputState = true;
		arg1 = 0.0;
		arg2 = 0.0;
		calcAnswer = 0.0;
	}

	/**
	 * Create the frame.
	 */
	public CalculatorUI() {
		getContentPane().setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 415);
		getContentPane().setLayout(null);
		calcArea.setForeground(Color.WHITE);
		calcArea.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		calcArea.setHorizontalAlignment(SwingConstants.RIGHT);
		calcArea.setBounds(18, 26, 377, 37);
		getContentPane().add(calcArea);


		JBar.setText("");
		JBar.setForeground(Color.BLACK);
		JBar.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		JBar.setHorizontalAlignment(SwingConstants.RIGHT);
		JBar.setBounds(18, 166, 377, 67);
		getContentPane().add(JBar);

		JButton button_1 = new JButton("1");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_1.setBackground(Color.white);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_1.setBackground(new Color(236, 120, 20));
			}
		});
		button_1.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_1.setOpaque(true);
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(236, 120, 20));
		button_1.addActionListener(e -> updateCalcArea(button_1.getText()));
		button_1.setBounds(35, 270, 75, 40);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_2.setBackground(Color.white);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_2.setBackground(new Color(236, 120, 20));
			}
		});
		button_2.addActionListener(e -> updateCalcArea(button_2.getText()));
		button_2.setOpaque(true);
		button_2.setForeground(Color.WHITE);
		button_2.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_2.setBackground(new Color(236, 120, 20));
		button_2.setBounds(122, 270, 75, 40);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_3.setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_3.setBackground(new Color(236, 120, 20));;
			}
		});
		button_3.addActionListener(e -> updateCalcArea(button_3.getText()));
		button_3.setOpaque(true);
		button_3.setForeground(Color.WHITE);
		button_3.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_3.setBackground(new Color(236, 120, 20));
		button_3.setBounds(209, 270, 75, 40);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_4.setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_4.setBackground(new Color(236, 120, 20));
			}
		});
		button_4.addActionListener(e -> updateCalcArea(button_4.getText()));
		button_4.setOpaque(true);
		button_4.setForeground(Color.WHITE);
		button_4.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_4.setBackground(new Color(236, 120, 20));
		button_4.setBounds(35, 218, 75, 40);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_5.setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_5.setBackground(new Color(236, 120, 20));
			}
		});
		button_5.addActionListener(e -> updateCalcArea(button_5.getText()));
		button_5.setOpaque(true);
		button_5.setForeground(Color.WHITE);
		button_5.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_5.setBackground(new Color(236, 120, 20));
		button_5.setBounds(122, 218, 75, 40);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_6.setBackground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_6.setBackground(new Color(236, 120, 20));
			}
		});
		button_6.addActionListener(e -> updateCalcArea(button_6.getText()));
		button_6.setOpaque(true);
		button_6.setForeground(Color.WHITE);
		button_6.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_6.setBackground(new Color(236, 120, 20));
		button_6.setBounds(209, 218, 75, 40);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_7.setBackground(Color.WHITE);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_7.setBackground(new Color(236, 120, 20));
			}
		});
		button_7.addActionListener(e -> updateCalcArea(button_7.getText()));
		button_7.setOpaque(true);
		button_7.setForeground(Color.WHITE);
		button_7.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_7.setBackground(new Color(236, 120, 20));
		button_7.setBounds(35, 166, 75, 40);

		getContentPane().add(button_7);

		JButton button_8 = new JButton("8");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_8.setBackground(Color.white);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_8.setBackground(new Color(236, 120, 20));
			}
		});
		button_8.addActionListener(e -> updateCalcArea(button_8.getText()));
		button_8.setOpaque(true);
		button_8.setForeground(Color.WHITE);
		button_8.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_8.setBackground(new Color(236, 120, 20));
		button_8.setBounds(122, 166, 75, 40);


		getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setBackground(Color.WHITE);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_9.setBackground(new Color(236, 120, 20));
			}
		});
		button_9.addActionListener(e -> updateCalcArea(button_9.getText()));
		button_9.setOpaque(true);
		button_9.setForeground(Color.WHITE);
		button_9.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_9.setBackground(new Color(236, 120, 20));
		button_9.setBounds(209, 166, 75, 40);


		getContentPane().add(button_9);
		
		JButton button_0 = new JButton("0");
		button_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_0.setBackground(Color.WHITE);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_0.setBackground(new Color(236, 120, 20));
			}
		});
		button_0.addActionListener(e -> updateCalcArea(button_0.getText()));
		button_0.setOpaque(true);
		button_0.setForeground(Color.WHITE);
		button_0.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_0.setBackground(new Color(236, 120, 20));
		button_0.setBounds(35, 322, 150, 40);
		getContentPane().add(button_0);
		
		JButton button_plus = new JButton("+");
		button_plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_plus.setBackground(Color.WHITE);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_plus.setBackground(new Color(236, 120, 20));
			}
		});
		button_plus.addActionListener(e -> {
			 updateCalcArea(button_plus.getText());
		});
		button_plus.setOpaque(true);
		button_plus.setForeground(Color.WHITE);
		button_plus.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_plus.setBackground(new Color(236, 120, 20));
		button_plus.setBounds(327, 218, 75, 40);
		getContentPane().add(button_plus);
		
		JButton button_minus = new JButton("-");
		button_minus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_minus.setBackground(Color.WHITE);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_minus.setBackground(new Color(236, 120, 20));
			}
		});
		button_minus.addActionListener(e -> {
			updateCalcArea(button_minus.getText());
		});
		button_minus.setOpaque(true);
		button_minus.setForeground(Color.WHITE);
		button_minus.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_minus.setBackground(new Color(236, 120, 20));;
		button_minus.setBounds(327, 270, 75, 40);
		getContentPane().add(button_minus);
		
		JButton button_equals = new JButton("=");
		button_equals.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_equals.setBackground(Color.WHITE);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_equals.setBackground(new Color(236, 120, 20));
			}
		});
		button_equals.addActionListener(e -> {

			//JBar.setText(calcArea.getText());
		String input = calcArea.getText();
	new Calculator2(input);
		String output = Calculator2.output;
			calcArea.setText(String.valueOf(output));
		});
		button_equals.setOpaque(true);
		button_equals.setForeground(Color.WHITE);
		button_equals.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_equals.setBackground(new Color(236, 120, 20));
		button_equals.setBounds(327, 322, 75, 40);
		getContentPane().add(button_equals);
		
		JButton button_clear = new JButton("AC");
		button_clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_clear.setBackground(Color.white);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_clear.setBackground(new Color(236, 120, 20));;
			}
		});
		button_clear.addActionListener(e -> clearCalculator());
		button_clear.setOpaque(true);
		button_clear.setForeground(Color.BLACK);
		button_clear.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_clear.setBackground(new Color(236, 120, 20));
		button_clear.setBounds(35, 64, 75, 40);
		getContentPane().add(button_clear);
		
		JLabel lblElliesCalculator = new JLabel("Sample Calculator -- design by Ellie");
		lblElliesCalculator.setBounds(6, 6, 134, 16);
		getContentPane().add(lblElliesCalculator);



		JButton button_multiply = new JButton("*");
		button_multiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_multiply.setBackground(Color.WHITE);
			}

			public void mouseReleased(MouseEvent e) {
				button_multiply.setBackground(new Color(236, 120, 20));;
			}
		});
		button_multiply.addActionListener(e -> {
			updateCalcArea(button_multiply.getText());
		});
		button_multiply.setOpaque(true);
		button_multiply.setForeground(Color.WHITE);
		button_multiply.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_multiply.setBackground(new Color(236, 120, 20));;
		button_multiply.setBounds(327, 165, 75, 40);
		getContentPane().add(button_multiply);



		JButton button_divide = new JButton("/");
		button_divide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_divide.setBackground(Color.WHITE);
			}

			public void mouseReleased(MouseEvent e) {
				button_divide.setBackground(new Color(236, 120, 20));
			}
		});
		button_divide.addActionListener(e -> {
			updateCalcArea(button_divide.getText());
		});
		button_divide.setOpaque(true);
		button_divide.setForeground(Color.WHITE);
		button_divide.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_divide.setBackground(new Color(236, 120, 20));;
		button_divide.setBounds(327, 113, 75, 40);
		getContentPane().add(button_divide);


		JButton button_dot = new JButton(".");
		button_dot.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { button_dot.setBackground(Color.WHITE);
			}

			public void mouseReleased(MouseEvent e) {
				button_dot.setBackground(new Color(236, 120, 20));
			}
		});
		button_dot.addActionListener(e -> updateCalcArea(button_dot.getText()));
		button_dot.setOpaque(true);
		button_dot.setForeground(Color.WHITE);
		button_dot.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_dot.setBackground(new Color(236, 120, 20));
		button_dot.setBounds(205, 322, 75, 40);
		getContentPane().add(button_dot);




		button_multiply.addActionListener(e -> {
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.DIVIDE);
		});
		button_divide.setOpaque(true);
		button_divide.setForeground(Color.WHITE);
		button_divide.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_divide.setBackground(new Color(236, 120, 20));;
		button_divide.setBounds(327, 113, 75, 40);
		getContentPane().add(button_divide);


		JButton button_pom = new JButton("+/-");
		button_pom.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { button_pom.setBackground(Color.WHITE);
			}

			public void mouseReleased(MouseEvent e) {
				button_pom.setBackground(new Color(236, 120, 20));
			}
		});
		button_pom.addActionListener(e -> {
			saveValueOfArg1();
					arg2=-1;
			saveValueOfMathOp(OPERATOR.MULTIPLY);
			calculateAnswer();
				});
		button_pom.setOpaque(true);
		button_pom.setForeground(Color.WHITE);
		button_pom.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_pom.setBackground(new Color(236, 120, 20));
		button_pom.setBounds(209, 113, 75, 40);
		getContentPane().add(button_pom);



		JButton button_sqrd = new JButton("^2");
		button_sqrd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { button_sqrd.setBackground(Color.WHITE);
			}

			public void mouseReleased(MouseEvent e) {
				button_sqrd.setBackground(new Color(236, 120, 20));
			}
		});
		button_pom.addActionListener(e -> {
			updateCalcArea(button_sqrd.getText());
		});
		button_sqrd.setOpaque(true);
		button_sqrd.setForeground(Color.WHITE);
		button_sqrd.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_sqrd.setBackground(new Color(236, 120, 20));
		button_sqrd.setBounds(35, 113, 75, 40);
		getContentPane().add(button_sqrd);

		JButton button_sqrroot = new JButton("sqrt");
		button_sqrroot.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { button_sqrroot.setBackground(Color.WHITE);
			}

			public void mouseReleased(MouseEvent e) {
				button_sqrroot.setBackground(new Color(236, 120, 20));
			}
		});
		button_sqrroot.addActionListener(e -> {
			updateCalcArea(button_sqrroot.getText());
		});
		button_sqrroot.setOpaque(true);
		button_sqrroot.setForeground(Color.WHITE);
		button_sqrroot.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
		button_sqrroot.setBackground(new Color(236, 120, 20));
		button_sqrroot.setBounds(122, 113, 75, 40);
		getContentPane().add(button_sqrroot);
	}
}






	
