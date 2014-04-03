import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StandardCalculator extends JFrame {
	private JTextField jtfDisplayArea = new JTextField("0");
	
	private JLabel jlM = new JLabel("M");
	
	private JButton jbtClear = new JButton("C");
	private JButton jbtBackspace = new JButton("ก๖");
	
	private JButton jbtPlus = new JButton("+");
	private JButton jbtMinus = new JButton("-");
	private JButton jbtMultiplication = new JButton("กั");
	private JButton jbtDivision = new JButton("กา");
	
	private JButton jbtMR = new JButton("MR");
	private JButton jbtMC = new JButton("MC");
	private JButton jbtMPlus = new JButton("M+");
	private JButton jbtMMinus = new JButton("M-");
	
	private JButton jbtZero = new JButton("0");
	private JButton jbtOne = new JButton("1");
	private JButton jbtTwo = new JButton("2");
	private JButton jbtThree = new JButton("3");
	private JButton jbtFour = new JButton("4");
	private JButton jbtFive = new JButton("5");
	private JButton jbtSix = new JButton("6");
	private JButton jbtSeven = new JButton("7");
	private JButton jbtEight = new JButton("8");
	private JButton jbtNine = new JButton("9");
	
	private JButton jbtSquareRoot = new JButton("กิ");
	private JButton jbtModulo = new JButton("%");
	private JButton jbtDecimalPoint = new JButton(".");
	private JButton jbtToggleSign = new JButton("กำ");
	private JButton jbtEqual = new JButton("=");
	
	private double answer = 0;
	private double memory = 0;

	public StandardCalculator() {
		JPanel p1 = new JPanel(new BorderLayout());
		jlM.setText("");
		jlM.setOpaque(true);
		jlM.setBackground(Color.WHITE);
		p1.add(jlM, BorderLayout.WEST);
		
		jtfDisplayArea.setEditable(false);
		jtfDisplayArea.setBackground(Color.WHITE);
		jtfDisplayArea.setFont(new Font("Dialog", Font.BOLD, 35));
		jtfDisplayArea.setHorizontalAlignment(JTextField.RIGHT);
		p1.add(jtfDisplayArea, BorderLayout.CENTER);
		
		
		JPanel p2 = new JPanel(new GridLayout(5, 5, 6, 6));
		
		p2.add(jbtClear);
		p2.add(jbtBackspace);
		p2.add(jbtSquareRoot);
		p2.add(jbtModulo);
		p2.add(jbtPlus);
		
		p2.add(jbtMR);
		p2.add(jbtSeven);
		p2.add(jbtEight);
		p2.add(jbtNine);
		p2.add(jbtMinus);
		
		p2.add(jbtMC);
		p2.add(jbtFour);
		p2.add(jbtFive);
		p2.add(jbtSix);
		p2.add(jbtMultiplication);
		
		p2.add(jbtMPlus);
		p2.add(jbtOne);
		p2.add(jbtTwo);
		p2.add(jbtThree);
		p2.add(jbtDivision);
		
		p2.add(jbtMMinus);
		p2.add(jbtZero);
		p2.add(jbtDecimalPoint);
		p2.add(jbtToggleSign);
		p2.add(jbtEqual);
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		ButtonListener buttons = new ButtonListener(); 
		
		jbtClear.addActionListener(buttons);
		jbtBackspace.addActionListener(buttons);
		
		jbtPlus.addActionListener(buttons);
		jbtMinus.addActionListener(buttons);
		jbtMultiplication.addActionListener(buttons);
		jbtDivision.addActionListener(buttons);
		
		jbtMR.addActionListener(buttons);
		jbtMC.addActionListener(buttons);
		jbtMPlus.addActionListener(buttons);
		jbtMMinus.addActionListener(buttons);
		
		jbtZero.addActionListener(buttons);
		jbtOne.addActionListener(buttons);
		jbtTwo.addActionListener(buttons);
		jbtThree.addActionListener(buttons);
		jbtFour.addActionListener(buttons);
		jbtFive.addActionListener(buttons);
		jbtSix.addActionListener(buttons);
		jbtSeven.addActionListener(buttons);
		jbtEight.addActionListener(buttons);
		jbtNine.addActionListener(buttons);
		
		jbtSquareRoot.addActionListener(buttons);
		jbtModulo.addActionListener(buttons);
		jbtDecimalPoint.addActionListener(buttons);
		jbtToggleSign.addActionListener(buttons);
		jbtEqual.addActionListener(buttons);
	}
	
	public void setAnswer(double newAnswer) {
		answer = newAnswer;
	}
	
	public double getAnswer() {
		return answer;
	}
	
	public void setMemory(double newMemory) {
		memory = newMemory;
	}
	
	public double getMemory() {
		return memory;
	}
	
	public String answerToString(double answer) {
		String string = String.valueOf(answer);
		int indexOfDot = string.indexOf('.');
		String sub = string.substring(indexOfDot + 1);
		
		while (sub.endsWith("0")) {
			if (sub.length() > 1)
				sub = sub.substring(0, sub.length());
			else
				sub = "";
		}
		
		string = string.substring(0, indexOfDot + 1) + sub;
		
		if (string.endsWith("."))
			string = string.substring(0, string.length() - 1);
		
		return string;
	}
	
	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jbtClear) {
				jtfDisplayArea.setText("0");
				setAnswer(0);
				setFontSize();
			}
			else if (e.getSource() == jbtBackspace) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText().substring(0, jtfDisplayArea.getText().length() - 1));
					setFontSize();
				}
			}
			
			else if (e.getSource() == jbtPlus) {
				
			}	
			else if (e.getSource() == jbtMinus) {
				
			}
			else if (e.getSource() == jbtMultiplication) {
				
			}
			else if (e.getSource() == jbtDivision) {
				
			}
			
			else if (e.getSource() == jbtMR) {
			}
			else if (e.getSource() == jbtMC) {
				jtfDisplayArea.setText("0");
				jlM.setText("");
				setAnswer(0);
				setMemory(0);
				setFontSize();
			}	
			else if (e.getSource() == jbtMPlus) {
				jtfDisplayArea.setText("0");
				setAnswer(0);
				jlM.setText("M");
			}
			else if (e.getSource() == jbtMMinus) {
				jtfDisplayArea.setText("0");
				setAnswer(0);
				jlM.setText("M");
			}
			
			else if (e.getSource() == jbtZero) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "0");
					setFontSize();
				}
			}
			else if (e.getSource() == jbtOne) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "1");	
					setFontSize();
				}
				else
					jtfDisplayArea.setText("1");
			}
			else if (e.getSource() == jbtTwo) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "2");
					setFontSize();
				}
				else
					jtfDisplayArea.setText("2");
			}	
			else if (e.getSource() == jbtThree) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "3");
					setFontSize();
				}
				else
					jtfDisplayArea.setText("3");
			}
			else if (e.getSource() == jbtFour) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "4");
					setFontSize();
				}
				else
					jtfDisplayArea.setText("4");
			}
			else if (e.getSource() == jbtFive) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "5");
					setFontSize();
				}
				else
					jtfDisplayArea.setText("5");
			}
			else if (e.getSource() == jbtSix) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "6");
					setFontSize();
				}
				else
					jtfDisplayArea.setText("6");
			}
			else if (e.getSource() == jbtSeven) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "7");
					setFontSize();
				}
				else
					jtfDisplayArea.setText("7");
			}	
			else if (e.getSource() == jbtEight) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "8");
					setFontSize();
				}
				else
					jtfDisplayArea.setText("8");
			}
			else if (e.getSource() == jbtNine) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + "9");
					setFontSize();
				}
				else
					jtfDisplayArea.setText("9");
			}
			
			else if (e.getSource() == jbtSquareRoot) {
				setAnswer(Math.sqrt(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
			}
			else if (e.getSource() == jbtModulo) {

			}
			else if (e.getSource() == jbtDecimalPoint) {
				if(jtfDisplayArea.getText().indexOf('.') == -1) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + ".");
					setFontSize();
				}
			}
			else if (e.getSource() == jbtToggleSign) {
				if(jtfDisplayArea.getText().startsWith("-") == false)
					jtfDisplayArea.setText("-" + jtfDisplayArea.getText());
				else
					jtfDisplayArea.setText(jtfDisplayArea.getText().substring(1));
			}
			else if (e.getSource() == jbtEqual) {
				
			}
		}
		
		public void setFontSize() {
			if (jtfDisplayArea.getText().length() > 9 ) {
				if (jtfDisplayArea.getText().length() % 2 == 0)
					jtfDisplayArea.setFont(new Font("Dialog", Font.BOLD, 35 - ((jtfDisplayArea.getText().length() - 9))));
			}
		}
	}
	
	public static void main(String[] args) {
		StandardCalculator frame = new StandardCalculator();
		frame.setSize(300,350);
		frame.setTitle("Standard Calculator");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
