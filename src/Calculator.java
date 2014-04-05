import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

public class Calculator extends JFrame {	
	
	private JLabel jlPassword = new JLabel("Password: ");
	private JPasswordField jpfPassword = new JPasswordField(12);
	private JButton jbtEnter = new JButton("Enter");	
	
	JMenuItem jmiStandard = new JMenuItem("Standard", 'S');
	JMenuItem jmiAdvanced = new JMenuItem("Advanced", 'A');
	JMenuItem jmiBigNumber = new JMenuItem("Big Number BETA", 'B');
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
	
	private JTextArea jtaDisplayArea = new JTextArea("0", 30, 30);
	
	private JButton jbtBigZero = new JButton("0");
	private JButton jbtBigOne = new JButton("1");
	private JButton jbtBigTwo = new JButton("2");
	private JButton jbtBigThree = new JButton("3");
	private JButton jbtBigFour = new JButton("4");
	private JButton jbtBigFive = new JButton("5");
	private JButton jbtBigSix = new JButton("6");
	private JButton jbtBigSeven = new JButton("7");
	private JButton jbtBigEight = new JButton("8");
	private JButton jbtBigNine = new JButton("9");
	
	private JButton jbtBigPlus = new JButton("+");
	private JButton jbtBigMinus = new JButton("-");
	private JButton jbtBigMultiplication = new JButton("กั");
	private JButton jbtBigDivision = new JButton("กา");
	
	private JButton jbtBigEqual = new JButton("=");
	private JButton jbtBigClear = new JButton("Clear");

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
		viewMenu.add(jmiBigNumber);
		
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
		
		final JPanel p4 = new JPanel(new GridLayout(1, 10, 5, 5));
		
		p4.add(jbtBigZero);
		p4.add(jbtBigOne);
		p4.add(jbtBigTwo);
		p4.add(jbtBigThree);
		p4.add(jbtBigFour);
		p4.add(jbtBigFive);
		p4.add(jbtBigSix);
		p4.add(jbtBigSeven);
		p4.add(jbtBigEight);
		p4.add(jbtBigNine);
		
		/////////////////////////////////////////////////////////////
		
		final JPanel p5 = new JPanel(new GridLayout(6, 1, 7, 7));
		
		jbtBigEqual.setEnabled(false);
		
		p5.add(jbtBigClear);
		p5.add(jbtBigPlus);
		p5.add(jbtBigMinus);
		p5.add(jbtBigMultiplication);
		p5.add(jbtBigDivision);
		p5.add(jbtBigEqual);
		
		/////////////////////////////////////////////////////////////
		
		jtaDisplayArea.setEditable(false);
		jtaDisplayArea.setBackground(Color.WHITE);
		jtaDisplayArea.setFont(new Font("Dialog", Font.BOLD, 30));
		jtaDisplayArea.setLineWrap(true);
		jtaDisplayArea.setWrapStyleWord(false);
		
		JScrollPane jspDisplayArea = new JScrollPane(jtaDisplayArea);
		jspDisplayArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
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
				getContentPane().removeAll();
				getContentPane().invalidate();
				
				setLayout(new BorderLayout());
				setSize(300, 350);
				setTitle("Standard Calculator");
				add(p1, BorderLayout.NORTH);
				add(p2, BorderLayout.CENTER);
				
				getContentPane().revalidate();
				repaint();
			}
		});

		jmiAdvanced.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().invalidate();
				
				setLayout(new BorderLayout());
				setSize(650,350);
				setTitle("Advanced Calculator");
				add(p1, BorderLayout.NORTH);
				add(p2, BorderLayout.EAST);
				add(p3, BorderLayout.WEST);
				
				getContentPane().revalidate();
				repaint();
			}
		});
		
		jmiBigNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().invalidate();
				
				setLayout(new BorderLayout());
				setSize(650,350);
				setTitle("Big Number Calculator (BETA)");
				add(p4, BorderLayout.SOUTH);
				add(p5, BorderLayout.EAST);
				add(jtaDisplayArea, BorderLayout.CENTER);
				
				getContentPane().revalidate();
				repaint();
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
		
		jbtBigPlus.addActionListener(buttons);
		jbtBigMinus.addActionListener(buttons);
		jbtBigMultiplication.addActionListener(buttons);
		jbtBigDivision.addActionListener(buttons);
		
		jbtBigZero.addActionListener(buttons);
		jbtBigOne.addActionListener(buttons);
		jbtBigTwo.addActionListener(buttons);
		jbtBigThree.addActionListener(buttons);
		jbtBigFour.addActionListener(buttons);
		jbtBigFive.addActionListener(buttons);
		jbtBigSix.addActionListener(buttons);
		jbtBigSeven.addActionListener(buttons);
		jbtBigEight.addActionListener(buttons);
		jbtBigNine.addActionListener(buttons);
		
		jbtBigEqual.addActionListener(buttons);
		jbtBigClear.addActionListener(buttons);
	}
	
	enum Operator {NONE, PLUS, MINUS, MULTIPLICATION, DIVISION, MODULO, LOG, XY, BIGPLUS, BIGMINUS, BIGMULTIPLICATION, BIGDIVISION};
	
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
			else if (e.getSource() == jbtBigZero) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "0");	
				}
			}
			else if (e.getSource() == jbtBigOne) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "1");	
				}
				else
					jtaDisplayArea.setText("1");
			}
			else if (e.getSource() == jbtBigTwo) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "2");	
				}
				else
					jtaDisplayArea.setText("2");
			}	
			else if (e.getSource() == jbtBigThree) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "3");	
				}
				else
					jtaDisplayArea.setText("3");
			}
			else if (e.getSource() == jbtBigFour) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "4");	
				}
				else
					jtaDisplayArea.setText("4");
			}
			else if (e.getSource() == jbtBigFive) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "5");	
				}
				else
					jtaDisplayArea.setText("5");
			}
			else if (e.getSource() == jbtBigSix) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "6");	
				}
				else
					jtaDisplayArea.setText("6");
			}
			else if (e.getSource() == jbtBigSeven) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "7");	
				}
				else
					jtaDisplayArea.setText("7");
			}	
			else if (e.getSource() == jbtBigEight) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "8");	
				}
				else
					jtaDisplayArea.setText("8");
			}
			else if (e.getSource() == jbtBigNine) {
				if (jtaDisplayArea.getText().equals("0") == false) {
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "9");	
				}
				else
					jtaDisplayArea.setText("9");
			}
			else if (e.getSource() == jbtBigPlus) {
				if (Double.parseDouble(jtaDisplayArea.getText()) != 0) {
					bigTemp = numberToArray(jtaDisplayArea.getText());
					jtaDisplayArea.setText("0");
				}
				setOperator(Operator.BIGPLUS);
				disableBigOperatorButtons();
				jbtBigEqual.setEnabled(true);
			}	
			else if (e.getSource() == jbtBigMinus) {
				if (Double.parseDouble(jtaDisplayArea.getText()) != 0) {
					bigTemp = numberToArray(jtaDisplayArea.getText());
					jtaDisplayArea.setText("0");
				}
				
				setOperator(Operator.BIGMINUS);
				disableBigOperatorButtons();
				jbtBigEqual.setEnabled(true);
			}
			else if (e.getSource() == jbtBigMultiplication) {
				if (Double.parseDouble(jtaDisplayArea.getText()) != 0) {
					bigTemp = numberToArray(jtaDisplayArea.getText());
					jtaDisplayArea.setText("0");
				}
				
				setOperator(Operator.BIGMULTIPLICATION);
				disableBigOperatorButtons();
				jbtBigEqual.setEnabled(true);
			}
			else if (e.getSource() == jbtBigDivision) {
				if (Double.parseDouble(jtaDisplayArea.getText()) != 0) {
					bigTemp = numberToArray(jtaDisplayArea.getText());
					jtaDisplayArea.setText("0");
				}
				
				setOperator(Operator.BIGDIVISION);
				disableBigOperatorButtons();
				jbtBigEqual.setEnabled(true);
			}
			else if (e.getSource() == jbtBigEqual) {
				int[] bigTemp2 = numberToArray(jtaDisplayArea.getText());
					switch(getOperator()) {
						case BIGPLUS:
							jtaDisplayArea.setText(arrayToString(plus(bigTemp, bigTemp2)));
							break;
						case BIGMINUS:
							jtaDisplayArea.setText(arrayToString(minus(bigTemp, bigTemp2)));
							break;
						case BIGMULTIPLICATION:
							jtaDisplayArea.setText(arrayToString(multiply(bigTemp, bigTemp2)));
							break;
						case BIGDIVISION:
							jtaDisplayArea.setText(divide(bigTemp, bigTemp2));
							break;
						default:
					}
					setOperator(Operator.NONE);
					disableBigNumberButtons();
					jbtBigEqual.setEnabled(false);
					bigTemp = new int[] {0};
			}
			else if (e.getSource() == jbtBigClear) {
				jtaDisplayArea.setText("0");
				
				setOperator(Operator.NONE);
				bigTemp = new int[] {0};
				
				jbtBigZero.setEnabled(true);
				jbtBigOne.setEnabled(true);
				jbtBigTwo.setEnabled(true);
				jbtBigThree.setEnabled(true);
				jbtBigFour.setEnabled(true);
				jbtBigFive.setEnabled(true);
				jbtBigSix.setEnabled(true);
				jbtBigSeven.setEnabled(true);
				jbtBigEight.setEnabled(true);
				jbtBigNine.setEnabled(true);
				
				jbtBigPlus.setEnabled(true);
				jbtBigMinus.setEnabled(true);
				jbtBigMultiplication.setEnabled(true);
				jbtBigDivision.setEnabled(true);
				
				jbtBigEqual.setEnabled(false);
			}
		}
		private double answer = 0;
		private double memory = 0;
		private double temp = 0;
		int[] bigTemp = {0};

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
		
		public int[] numberToArray(String number) {
			int length = (int)Math.ceil((double)number.length() / 4);
			int[] bigNumber = new int[length];
			
			String temp;
			
			for (int i = 1; i <= length; i++) {
				if ( i == 0)
					temp = number.substring(number.length() - 4 * i);
				else if (number.length() - 4 * i < 0)
					temp = number.substring(0, number.length() - 4 * (i - 1));
				else
					temp = number.substring(number.length() - 4 * i, number.length() - 4 * (i - 1));
				
				bigNumber[length - i] = Integer.parseInt(temp);
			}
			
			return bigNumber;
		}
		
		public int[] plus(int[] bigNumber1, int[] bigNumber2) {
			int length = (bigNumber1.length > bigNumber2.length) ? bigNumber1.length + 1 : bigNumber2.length + 1;
			int[] sum = new int[length];
			int[] bigNum1 = new int[length];
			int[] bigNum2 = new int[length];
			
			System.arraycopy(bigNumber1, 0, bigNum1, length - bigNumber1.length, bigNumber1.length);
			System.arraycopy(bigNumber2, 0, bigNum2, length - bigNumber2.length, bigNumber2.length);

			for (int i = 0; i < length; i++)
				sum[i] = bigNum1[i] + bigNum2[i];
				
			for (int j = 1; j < length; j++) {
				sum[length - j - 1] += sum[length - j] / 10000;
				sum[length - j] %= 10000;
			}
			
			return sum;
		}
		
		public int[] minus(int[] bigNumber1, int[] bigNumber2) {
			int length = (bigNumber1.length > bigNumber2.length) ? bigNumber1.length : bigNumber2.length;
			int[] difference = new int[length];
			int[] big = new int[length];
			int[] small = new int[length];
			
			boolean bigger = isBiggerOrEquals(bigNumber1, bigNumber2);
			
			if (bigger) {
				System.arraycopy(bigNumber1, 0, big, length - bigNumber1.length, bigNumber1.length);
				System.arraycopy(bigNumber2, 0, small, length - bigNumber2.length, bigNumber2.length);
			}
			else {
				System.arraycopy(bigNumber1, 0, small, length - bigNumber1.length, bigNumber1.length);
				System.arraycopy(bigNumber2, 0, big, length - bigNumber2.length, bigNumber2.length);
			}
			
			for (int i = 0; i < length; i++)
				difference[i] = big[i] - small[i];
				
			for (int j = 1; j < length; j++) {
				if (difference[length - j] < 0) {
					difference[length - j - 1]--;
					difference[length - j] += 10000;
				}
			}
			
			if (bigger == false) {
				difference[0] = -difference[0];
			}
			
			return difference;
		}
		
		public int[] multiply(int[] bigNumber1, int[] bigNumber2) {
			int length = bigNumber1.length * bigNumber2.length;
			int[] product = new int[length];
			int[] bigNum1 = new int[length];
			int[] bigNum2 = new int[length];
			
			System.arraycopy(bigNumber1, 0, bigNum1, length - bigNumber1.length, bigNumber1.length);
			System.arraycopy(bigNumber2, 0, bigNum2, length - bigNumber2.length, bigNumber2.length);
			
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (i + j < length)
						product[i + j] += bigNum1[i] * bigNum2[j];
				}
			}
			
			for (int k = 1; k < length; k++) {
				product[length - k - 1] += product[length - k] / 10000;
				product[length - k] %= 10000;
			}
			
			return product;
		}
		
		public boolean isBiggerOrEquals(int[] bigNumber1, int[] bigNumber2) {
			int length = (bigNumber1.length > bigNumber2.length) ? bigNumber1.length : bigNumber2.length;
			int[] bigNum1 = new int[length];
			int[] bigNum2 = new int[length];
			
			System.arraycopy(bigNumber1, 0, bigNum1, length - bigNumber1.length, bigNumber1.length);
			System.arraycopy(bigNumber2, 0, bigNum2, length - bigNumber2.length, bigNumber2.length);
			
			boolean iboe = false;
			
			for (int i = 0; i < length; i++) {
				if(bigNum1[i] > bigNum2[i]) {
					iboe = true;
					break;
				}
			}
			
			if (Arrays.equals(bigNum1, bigNum2))
				iboe = true;
			
			return iboe;
		}
		
		public  int[] plusInteger(int[] bigNumber, int n) {
			int length = bigNumber.length + 1;
			int[] bigNum = new int[length];
			
			System.arraycopy(bigNumber, 0, bigNum, length - bigNumber.length, bigNumber.length);
				
			bigNum[length - 1] = bigNum[length - 1] + n;
			
			for (int j = 1; j < length; j++) {
				bigNum[length - j - 1] += bigNum[length - j] / 10000;
				bigNum[length - j] %= 10000;
			}
			
			return bigNum;
		}
		
		public String divide(int[] bigNumber1, int[] bigNumber2) {
			int length = bigNumber1.length;
			int[] quotient = new int[length];
			int[] remainder = new int[length];
			int[] temp;
			
			System.arraycopy(bigNumber1, 0, remainder, 0, bigNumber1.length);

			while(isBiggerOrEquals(remainder, bigNumber2)) {
				temp = minus(remainder, bigNumber2);
				if (temp[0] < 0)
					break;
				
				System.arraycopy(temp, 0, remainder, length - temp.length, temp.length);
				quotient = plusInteger(quotient, 1);
			}
			
			return arrayToString(quotient) + "\n..." + arrayToString(remainder);
		}
		
		public String arrayToString(int[] bigNumber) {
			String result = "";
			
			for(int i = 0; i < bigNumber.length; i++)
				result += String.valueOf(bigNumber[i]);
			
			while (result.charAt(0) == '0')
				result = result.substring(1);
			
			return result;
		}
		
		public void disableBigNumberButtons() {
			jbtBigZero.setEnabled(false);
			jbtBigOne.setEnabled(false);
			jbtBigTwo.setEnabled(false);
			jbtBigThree.setEnabled(false);
			jbtBigFour.setEnabled(false);
			jbtBigFive.setEnabled(false);
			jbtBigSix.setEnabled(false);
			jbtBigSeven.setEnabled(false);
			jbtBigEight.setEnabled(false);
			jbtBigNine.setEnabled(false);
		}
		
		public void disableBigOperatorButtons() {
			jbtBigPlus.setEnabled(false);
			jbtBigMinus.setEnabled(false);
			jbtBigMultiplication.setEnabled(false);
			jbtBigDivision.setEnabled(false);
		}
	}
	
	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
