package tac.application.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tac.application.util.InToPost;
/**
 * Creates the user interface part of the application.
 * This is a Singleton class.
 */
public class CalculatorUI extends JFrame {

	private static CalculatorUI instance = null;

	private Insets insets = new Insets(1, 1, 1, 1);
	private static final long serialVersionUID = 1L;

	private JTextField text2;
	private JTextField text;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton divide;
	private JButton leftParen;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton multiply;
	private JButton rightParen;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton sum;
	private JButton subtraction;
	private JButton reset;
	private JButton zero;
	private JButton point;
	private JButton equal;

	private StringBuffer equation = new StringBuffer();
	private StringBuffer buffer =  new StringBuffer();

	public JTextField getText2() {
		return text2;
	}

	public void setText2(JTextField text2) {
		this.text2 = text2;
	}

	public JTextField getText() {
		return text;
	}

	public void setText(JTextField text) {
		this.text = text;
	}

	public JButton getSeven() {
		return seven;
	}

	public void setSeven(JButton seven) {
		this.seven = seven;
	}

	public JButton getEight() {
		return eight;
	}

	public void setEight(JButton eight) {
		this.eight = eight;
	}

	public JButton getNine() {
		return nine;
	}

	public void setNine(JButton nine) {
		this.nine = nine;
	}

	public JButton getDivide() {
		return divide;
	}

	public void setDivide(JButton divide) {
		this.divide = divide;
	}

	public JButton getSqrt() {
		return leftParen;
	}

	public void setSqrt(JButton leftParen) {
		this.leftParen = leftParen;
	}

	public JButton getFour() {
		return four;
	}

	public void setFour(JButton four) {
		this.four = four;
	}

	public JButton getFive() {
		return five;
	}

	public void setFive(JButton five) {
		this.five = five;
	}

	public JButton getSix() {
		return six;
	}

	public void setSix(JButton six) {
		this.six = six;
	}

	public JButton getMultiply() {
		return multiply;
	}

	public void setMultiply(JButton multiply) {
		this.multiply = multiply;
	}

	public JButton getReciproc() {
		return rightParen;
	}

	public void setReciproc(JButton rightParen) {
		this.rightParen = rightParen;
	}

	public JButton getOne() {
		return one;
	}

	public void setOne(JButton one) {
		this.one = one;
	}

	public JButton getTwo() {
		return two;
	}

	public void setTwo(JButton two) {
		this.two = two;
	}

	public JButton getThree() {
		return three;
	}

	public void setThree(JButton three) {
		this.three = three;
	}

	public JButton getSum() {
		return sum;
	}

	public void setSum(JButton sum) {
		this.sum = sum;
	}

	public JButton getSubtraction() {
		return subtraction;
	}

	public void setSubtraction(JButton subtraction) {
		this.subtraction = subtraction;
	}

	public JButton getReset() {
		return reset;
	}

	public void setReset(JButton reset) {
		this.reset = reset;
	}

	public JButton getZero() {
		return zero;
	}

	public void setZero(JButton zero) {
		this.zero = zero;
	}

	public JButton getPoint() {
		return point;
	}

	public void setPoint(JButton point) {
		this.point = point;
	}

	public JButton getEqual() {
		return equal;
	}

	public void setEqual(JButton equal) {
		this.equal = equal;
	}

	/**
	 * The constructor which shows the UI.
	 */
	private CalculatorUI(){

		this.add(createUI());

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("calculator.png")));

		this.setTitle("Dalina's calculator");
		this.setSize(300,300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Creates the panel which includes all the UI elements.
	 * @return A panel.
	 */
	private JPanel createUI(){
		JPanel calculator = new JPanel(new GridBagLayout());
		calculator.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		calculator.add(createTopPanel(), new GridBagConstraints(0, 0, 1, 1, 0, 0, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 1, 1));
		calculator.add(createMiddlePanel(), new GridBagConstraints(0, 1, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));

		return calculator;
	}
	/**
	 * Creates a panel containing a field in which the user sees the results.
	 * @return A panel.
	 */
	private JPanel createTopPanel(){
		JPanel topPanel = new JPanel(new GridBagLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.RED));

		text2 = new JTextField();
		text2.setEditable(false);
		text2.setEnabled(false);

		text = new JTextField("0");
		text.setEditable(false);
		text.setEnabled(false);
		//		text.setPreferredSize(new Dimension(320,500));

		topPanel.add(text2, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 1, 1));
		topPanel.add(text, new GridBagConstraints(0, 1, 1, 1, 1, 1, 
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 1, 1));

		return topPanel;
	}
	/**
	 * Creates a panel with all the numbers and operations performed by the calculator.
	 * @return A panel.
	 */
	private JPanel createMiddlePanel(){
		JPanel middlePanel = new JPanel(new GridBagLayout());
		middlePanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

		seven = new JButton("7");
		seven.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("7");
				text.setText(buffer.toString());

				equation.append("7");
				text2.setText(equation.toString());
			}
		});
		eight = new JButton("8");
		eight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("8");
				text.setText(buffer.toString());

				equation.append("8");
				text2.setText(equation.toString());
			}
		});
		nine = new JButton("9");
		nine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("9");
				text.setText(buffer.toString());

				equation.append("9");
				text2.setText(equation.toString());
			}
		});
		divide = new JButton("/");
		divide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				text.setText("/");
				buffer.delete(0, buffer.length());	

				equation.append("/");
				text2.setText(equation.toString());
			}
		});
		leftParen = new JButton("(");
		leftParen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				text.setText("(");
				buffer.delete(0, buffer.length());

				equation.append("(");
				text2.setText(equation.toString());
			}
		});

		four = new JButton("4");
		four.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("4");
				text.setText(buffer.toString());

				equation.append("4");
				text2.setText(equation.toString());
			}
		});

		five = new JButton("5");
		five.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("5");
				text.setText(buffer.toString());

				equation.append("5");
				text2.setText(equation.toString());
			}
		});

		six = new JButton("6");
		six.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("6");
				text.setText(buffer.toString());

				equation.append("6");
				text2.setText(equation.toString());
			}
		});

		multiply = new JButton("*");
		multiply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				text.setText("*");
				buffer.delete(0, buffer.length());

				equation.append("*");
				text2.setText(equation.toString());
			}
		});

		rightParen = new JButton(")");
		rightParen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				text.setText(")");
				buffer.delete(0, buffer.length());

				equation.append(")");
				text2.setText(equation.toString());
			}
		});

		one = new JButton("1");
		one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("1");
				text.setText(buffer.toString());

				equation.append("1");
				text2.setText(equation.toString());
			}
		});

		two = new JButton("2");
		two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("2");
				text.setText(buffer.toString());

				equation.append("2");
				text2.setText(equation.toString());
			}
		});

		three = new JButton("3");
		three.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("3");
				text.setText(buffer.toString());

				equation.append("3");
				text2.setText(equation.toString());
			}
		});

		sum = new JButton("+");
		sum.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				text.setText("+");
				buffer.delete(0, buffer.length());

				equation.append("+");
				text2.setText(equation.toString());
			}
		});

		subtraction = new JButton("-");
		subtraction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				text.setText("-");
				buffer.delete(0, buffer.length());

				equation.append("-");
				text2.setText(equation.toString());
			}
		});


		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("0");
				text2.setText("");

				buffer.delete(0, buffer.length());
				equation.delete(0, equation.length());
			}
		});
		zero = new JButton("0");
		zero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append("0");
				text.setText(buffer.toString());

				equation.append("0");
				text2.setText(equation.toString());
			}
		});

		point = new JButton(".");
		point.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setEnabled(true);
				buffer.append(".");
				text.setText(buffer.toString());

				equation.append(".");
				text2.setText(equation.toString());
			}
		});

		equal = new JButton("=");
		equal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Calculate the result from equation and put it 
				//in the text JTextField.
//				String input = equation.toString();
//				String output;
//				InToPost theTrans = new InToPost(input);
//				output = theTrans.doTrans(); 
//				text.setText(output);
//				
//				System.out.println("Postfix is " + output + '\n');
				InToPost x = new InToPost();
				Double result = x.calculate(equation.toString());
				text.setText(result.toString());
			}
		});

		middlePanel.add(seven, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(eight, new GridBagConstraints(1, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(nine, new GridBagConstraints(2, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(divide, new GridBagConstraints(3, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(leftParen, new GridBagConstraints(4, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, insets, 1, 1));

		middlePanel.add(four, new GridBagConstraints(0, 1, 1, 1, 0, 0, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(five, new GridBagConstraints(1, 1, 1, 1, 0, 0, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(six, new GridBagConstraints(2, 1, 1, 1, 0, 0, 
				GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(multiply, new GridBagConstraints(3, 1, 1, 1, 0, 0, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(rightParen, new GridBagConstraints(4, 1, 1, 1, 1, 1, 
				GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, insets, 1, 1));

		middlePanel.add(one, new GridBagConstraints(0, 2, 1, 1, 0, 0, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(two, new GridBagConstraints(1, 2, 1, 1, 0, 0, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(three, new GridBagConstraints(2, 2, 1, 1, 0, 0, 
				GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(sum, new GridBagConstraints(3, 2, 1, 1, 0, 0, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(subtraction, new GridBagConstraints(4, 2, 1, 1, 1, 1, 
				GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, insets, 1, 1));

		middlePanel.add(reset, new GridBagConstraints(0, 3, 2, 1, 0, 0, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(zero, new GridBagConstraints(2, 3, 1, 1, 0, 0, 
				GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(point, new GridBagConstraints(3, 3, 1, 1, 0, 0, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 1, 1));
		middlePanel.add(equal, new GridBagConstraints(4, 3, 1, 1, 1, 1, 
				GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, insets, 1, 1));

		return middlePanel;
	}

	public static CalculatorUI getInstance() 
	{ 
		// To ensure only one instance is created 
		if (instance == null) { 
			instance = new CalculatorUI(); 
		} 
		return instance; 
	} 
}
