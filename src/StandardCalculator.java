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
