import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Calculator extends JFrame {	
	
	private JLabel jlPassword = new JLabel("Password: ");
	private JPasswordField jpfPassword = new JPasswordField(12);
	private JButton jbtEnter = new JButton("Enter");	
	
	JMenuItem jmiStandard = new JMenuItem("Standard", 'S');
	JMenuItem jmiAdvanced = new JMenuItem("Advanced", 'A');
	JMenuItem jmiViewHelp = new JMenuItem("View Help", 'H');
	JMenuItem jmiAbout = new JMenuItem("About", 'A');
	
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
	
	private JButton jbtSin = new JButton("sin");
	private JButton jbtCos = new JButton("cos");
	private JButton jbtTan = new JButton("tan");
	private JButton jbtCsc = new JButton("csc");
	private JButton jbtSec = new JButton("sec");
	private JButton jbtCot = new JButton("cot");
	private JButton jbtAsin = new JButton("asin");
	private JButton jbtAcos = new JButton("acos");
	private JButton jbtAtan = new JButton("atan");
	private JButton jbtSinh = new JButton("sinh");
	private JButton jbtCosh = new JButton("cosh");
	private JButton jbtTanh = new JButton("tanh");
	
	private JButton jbtLn = new JButton("ln");
	private JButton jbtLog = new JButton("log");
	private JButton jbtLogxy = new JButton("<html>log<sub>x</sub><sup>y</sup></html>");
	private JButton jbtE = new JButton("e");
	private JButton jbtEx = new JButton("<html>e<sup>x</sup></html>");
	private JButton jbtX2 = new JButton("<html>x<sup>2</sup></html>");
	private JButton jbtX3 = new JButton("<html>x<sup>3</sup></html>");
	private JButton jbtXy = new JButton("<html>x<sup>y</sup></html>");
	private JButton jbt10x = new JButton("<html>10<sup>x</sup></html>");
	
	private JButton jbtCeil = new JButton("ceil");
	private JButton jbtFloor = new JButton("floor");
	private JButton jbtPi = new JButton("ฃk");
	private JButton jbtFactorial = new JButton("n!");

	public Calculator() {
		
		final JDialog jdPassword = new JDialog((Frame)null, "Password", true);
		JPanel p01 = new JPanel(new BorderLayout());
		p01.add(jlPassword, BorderLayout.WEST);
		p01.add(jpfPassword, BorderLayout.CENTER);
		
		JPanel p02 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p02.add(jbtEnter);
		
		jdPassword.setLayout(new GridLayout(2, 1, 5, 5));
		jdPassword.add(p01);
		jdPassword.add(p02);
		jdPassword.setSize(250, 120);
		jdPassword.setLocationRelativeTo(null);

		
		jdPassword.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);		
		
		jdPassword.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
	    	}
	    });
	    
		
		jbtEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(new String(jpfPassword.getPassword()).equals("0000"))
					jdPassword.dispose();
				else
					JOptionPane.showMessageDialog(null, "Wrong Password.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		
		JMenu viewMenu = new JMenu("View");
		viewMenu.setMnemonic('V');
		jmb.add(viewMenu);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		jmb.add(helpMenu);
		
		viewMenu.add(jmiStandard);
		viewMenu.add(jmiAdvanced);
		
		helpMenu.add(jmiViewHelp);
		helpMenu.addSeparator();
		helpMenu.add(jmiAbout);
		/////////////////////////////////////////////////////////////
		
		final JPanel p1 = new JPanel(new BorderLayout());
		jlM.setText("");
		jlM.setOpaque(true);
		jlM.setBackground(Color.WHITE);
		p1.add(jlM, BorderLayout.WEST);
		
		jtfDisplayArea.setEditable(false);
		jtfDisplayArea.setBackground(Color.WHITE);
		jtfDisplayArea.setFont(new Font("Dialog", Font.BOLD, 35));
		jtfDisplayArea.setHorizontalAlignment(JTextField.RIGHT);
		p1.add(jtfDisplayArea, BorderLayout.CENTER);
		/////////////////////////////////////////////////////////////
		
		final JPanel p2 = new JPanel(new GridLayout(5, 5, 6, 6));
		
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
		/////////////////////////////////////////////////////////////
		
		final JPanel p3 = new JPanel(new GridLayout(5, 5, 6, 6));
		
		p3.add(jbtSin);
		p3.add(jbtCos);
		p3.add(jbtTan);
		p3.add(jbtLn);
		p3.add(jbtX2);
		
		p3.add(jbtCsc);
		p3.add(jbtSec);
		p3.add(jbtCot);
		p3.add(jbtLog);
		p3.add(jbtX3);
		
		p3.add(jbtAsin);
		p3.add(jbtAcos);
		p3.add(jbtAtan);
		p3.add(jbtLogxy);
		p3.add(jbt10x);
		
		p3.add(jbtSinh);
		p3.add(jbtCosh);
		p3.add(jbtTanh);
		p3.add(jbtEx);
		p3.add(jbtXy);
		
		p3.add(jbtCeil);
		p3.add(jbtFloor);
		p3.add(jbtPi);
		p3.add(jbtE);
		p3.add(jbtFactorial);
		
		/////////////////////////////////////////////////////////////
		addWindowListener(new WindowAdapter() {
			@Override
	    	public void windowOpened(WindowEvent wa) {
				jdPassword.setVisible(true);
	    	}
	    });
		
		setLayout(new BorderLayout());
		setSize(300, 350);
		setTitle("Standard Calculator");
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		/////////////////////////////////////////////////////////////
		jmiStandard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setLayout(new BorderLayout());
				setSize(300, 350);
				setTitle("Standard Calculator");
				add(p1, BorderLayout.NORTH);
				add(p2, BorderLayout.CENTER);
			}
		});

		jmiAdvanced.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setLayout(new BorderLayout());
				setSize(650,350);
				setTitle("Advanced Calculator");
				add(p1, BorderLayout.NORTH);
				add(p2, BorderLayout.EAST);
				add(p3, BorderLayout.WEST);
			}
		});
		
		/////////////////////////////////////////////////////////////
		
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
		
		jbtSin.addActionListener(buttons);
		jbtCos.addActionListener(buttons);
		jbtTan.addActionListener(buttons);
		jbtCsc.addActionListener(buttons);
		jbtSec.addActionListener(buttons);
		jbtCot.addActionListener(buttons);
		jbtAsin.addActionListener(buttons);
		jbtAcos.addActionListener(buttons);
		jbtAtan.addActionListener(buttons);
		jbtSinh.addActionListener(buttons);
		jbtCosh.addActionListener(buttons);
		jbtTanh.addActionListener(buttons);
		
		jbtLn.addActionListener(buttons);
		jbtLog.addActionListener(buttons);
		jbtLogxy.addActionListener(buttons);
		jbtE.addActionListener(buttons);
		jbtEx.addActionListener(buttons);
		jbtX2.addActionListener(buttons);
		jbtX3.addActionListener(buttons);
		jbtXy.addActionListener(buttons);
		jbt10x.addActionListener(buttons);
		
		jbtCeil.addActionListener(buttons);
		jbtFloor.addActionListener(buttons);
		jbtPi.addActionListener(buttons);
		jbtFactorial.addActionListener(buttons);
	}
	
	enum Operator {NONE, PLUS, MINUS, MULTIPLICATION, DIVISION, MODULO, LOG, XY};
	
	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jbtClear) {
				jtfDisplayArea.setText("0");
				setAnswer(0);
				setTemp(0);
				setOperator(Operator.NONE);
				setFontSize();
			}
			else if (e.getSource() == jbtBackspace) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText().substring(0, jtfDisplayArea.getText().length() - 1));
					setFontSize();
				}
			}
			
			else if (e.getSource() == jbtPlus) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() + getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}
				setOperator(Operator.PLUS);
				setFontSize();
			}	
			else if (e.getSource() == jbtMinus) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() - getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}
				
				setOperator(Operator.MINUS);
				setFontSize();
			}
			else if (e.getSource() == jbtMultiplication) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() * getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}
				setOperator(Operator.MULTIPLICATION);
				setFontSize();
			}
			else if (e.getSource() == jbtDivision) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() / getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}
				setOperator(Operator.DIVISION);
				setFontSize();
			}
			
			else if (e.getSource() == jbtMR) {
				jtfDisplayArea.setText(answerToString(getMemory()));
			}
			else if (e.getSource() == jbtMC) {
				jtfDisplayArea.setText("0");
				jlM.setText("");
				setAnswer(0);
				setTemp(0);
				setMemory(0);
				setOperator(Operator.NONE);
				setFontSize();
			}	
			else if (e.getSource() == jbtMPlus) {
				setMemory(getMemory() + Double.parseDouble(jtfDisplayArea.getText()));
				jtfDisplayArea.setText("0");
				setTemp(0);
				setAnswer(0);
				jlM.setText("M");
			}
			else if (e.getSource() == jbtMMinus) {
				setMemory(getMemory() - Double.parseDouble(jtfDisplayArea.getText()));
				jtfDisplayArea.setText("0");
				setTemp(0);
				setAnswer(0);
				jlM.setText("M");
			}
			
			else if (e.getSource() == jbtZero) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "0");
						setFontSize();
					}	
				}
			}
			else if (e.getSource() == jbtOne) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "1");	
						setFontSize();
					}
					else
						jtfDisplayArea.setText("1");
				}
			}
			else if (e.getSource() == jbtTwo) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "2");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("2");
				}
			}	
			else if (e.getSource() == jbtThree) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "3");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("3");
				}
			}
			else if (e.getSource() == jbtFour) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "4");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("4");
				}
			}
			else if (e.getSource() == jbtFive) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "5");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("5");
				}
			}
			else if (e.getSource() == jbtSix) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "6");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("6");
				}
			}
			else if (e.getSource() == jbtSeven) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "7");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("7");
				}
			}	
			else if (e.getSource() == jbtEight) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "8");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("8");
				}
			}
			else if (e.getSource() == jbtNine) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "9");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("9");
				}
			}
			
			else if (e.getSource() == jbtSquareRoot) {
				setAnswer(Math.sqrt(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtModulo) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() % getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}
				setOperator(Operator.MODULO);
				setFontSize();
			}
			else if (e.getSource() == jbtDecimalPoint) {
				if(jtfDisplayArea.getText().indexOf('.') == -1) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + ".");
					setFontSize();
				}
			}
			else if (e.getSource() == jbtToggleSign) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					if(jtfDisplayArea.getText().startsWith("-") == false)
						jtfDisplayArea.setText("-" + jtfDisplayArea.getText());
					else 
							jtfDisplayArea.setText(jtfDisplayArea.getText().substring(1));
				}
			}
			else if (e.getSource() == jbtEqual) {
				if (getTemp() == 0)
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
				
				switch(getOperator()) {
					case PLUS:
						setAnswer((getAnswer() + getTemp()));
						break;
					case MINUS:
						setAnswer(getAnswer() - getTemp());
						break;
					case MULTIPLICATION:
						setAnswer(getAnswer() * getTemp());
						break;
					case DIVISION:
						setAnswer(getAnswer() / getTemp());
						break;
					case MODULO:
						setAnswer(getAnswer() % getTemp());
						break;
					case LOG:
						setAnswer(Math.log(getTemp())/ Math.log(getAnswer()));
						break;
					case XY:
						setAnswer(Math.pow(getAnswer(), getTemp()));
						break;
					default:
				}
				
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtSin) {
				setAnswer(Math.sin(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtCos) {
				setAnswer(Math.cos(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtTan) {
				setAnswer(Math.tan(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtCsc) {
				setAnswer(1 / (Math.sin(Double.parseDouble(jtfDisplayArea.getText()))));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtSec) {
				setAnswer(1 / (Math.cos(Double.parseDouble(jtfDisplayArea.getText()))));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtCot) {
				setAnswer(1 / (Math.tan(Double.parseDouble(jtfDisplayArea.getText()))));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtAsin) {
				setAnswer(Math.asin(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtAcos) {
				setAnswer(Math.acos(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtAtan) {
				setAnswer(Math.atan(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtSinh) {
				setAnswer(Math.sinh(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtCosh) {
				setAnswer(Math.cosh(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtTanh) {
				setAnswer(Math.tanh(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtLn) {
				setAnswer(Math.log(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtLog) {
				setAnswer(Math.log10(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtLogxy) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(Math.log(getTemp())/ Math.log(getAnswer()));
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}
				setOperator(Operator.LOG);
				setFontSize();
			}
			else if (e.getSource() == jbtE) {
				jtfDisplayArea.setText(answerToString(Math.E));
				setFontSize();
			}
			else if (e.getSource() == jbtEx) {
				setAnswer(Math.exp(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtX2) {
				setAnswer(Math.pow(Double.parseDouble(jtfDisplayArea.getText()), 2));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtX3) {
				setAnswer(Math.pow(Double.parseDouble(jtfDisplayArea.getText()), 3));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtXy) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(Math.pow(getAnswer(), getTemp()));
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}
				setOperator(Operator.XY);
				setFontSize();
			}
			else if (e.getSource() == jbt10x) {
				setAnswer(Math.pow(10, Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtCeil) {
				setAnswer(Math.ceil(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtFloor) {
				setAnswer(Math.floor(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
			else if (e.getSource() == jbtPi) {
				jtfDisplayArea.setText(answerToString(Math.PI));
				setFontSize();
			}
			else if (e.getSource() == jbtFactorial) {
				setAnswer(factorial((int)Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			}
		}
		private double answer = 0;
		private double memory = 0;
		private double temp = 0;

		private Operator operator;
		
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
		
		public void setTemp(double newTemp) {
			temp = newTemp;
		}
		
		public double getTemp() {
			return temp;
		}
		
		public void setOperator(Operator newOperator) {
			operator = newOperator;
		}
		
		public Operator getOperator() {
			return operator;
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
		
		public void setFontSize() {
			int length = 9;
			int textLength = jtfDisplayArea.getText().length();
			
			switch(getWidth()) {
				case 300:
					length = 9;
					break;
				case 650:
					length = 30;
			}
			
			if (jtfDisplayArea.getText().length() > length ) 
				jtfDisplayArea.setFont(new Font("Dialog", Font.BOLD, 35 - ((textLength - length))));

			else
				jtfDisplayArea.setFont(new Font("Dialog", Font.BOLD, 35));
		}
		
		public double factorial(int n) {
			if (n == 0)
				return 1;
			else
				return n * factorial(n - 1);
		}
	}
	
	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
