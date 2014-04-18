import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

public class Calculator extends JFrame {
	/** Create Components
	========================================================= */
	
	/** Dialogs
	--------------------------------- */
	
	/** Enter a Password */
	private JLabel jlPassword = new JLabel("Password: ");
	private JPasswordField jpfPassword = new JPasswordField(12);
	private JButton jbtEnter = new JButton("Enter");
	
	/** Set a Password */
	private JLabel jlNoPassword = new JLabel("Please Set Your Password.");
	private JLabel jlSetPassword = new JLabel("New Password: ");
	private JPasswordField jpfSetPassword = new JPasswordField(12);
	private JLabel jlCheckPassword = new JLabel("Enter Again: ");
	private JPasswordField jpfCheckPassword = new JPasswordField(12);
	private JButton jbtOK = new JButton("OK");
	
	/////////////////////////////////////////////////////////////
	
	/** Menu Bar
	--------------------------------- */
	
	/** View */
	JMenuItem jmiStandard = new JMenuItem("Standard", 'S');
	JMenuItem jmiAdvanced = new JMenuItem("Advanced", 'A');
	JMenuItem jmiBigNumber = new JMenuItem("Big Number BETA", 'B');
	
	/** Edit */
	JMenuItem jmiSetPassword = new JMenuItem("Set Password", 'P');
	
	/** Help */
	JMenuItem jmiViewHelp = new JMenuItem("View Help", 'H');
	JMenuItem jmiAbout = new JMenuItem("About", 'A');
	
	/////////////////////////////////////////////////////////////
	
	/** Calculators
	--------------------------------- */
	
	/** Display Area for Standard and Advanced Calculator*/
	private JTextField jtfDisplayArea = new JTextField("0");
	
	/** Standard Calculator */
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
	
	/** Advanced Calculator */
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
	
	/** Big Number Calculator */
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
	
	/////////////////////////////////////////////////////////////
	
	/** Encode and Decode the Password
	========================================================= */
	
	/** Encode the Password
	--------------------------------- */
	/** A Very, Very Very Simple Encoder */
	String encode(String string) {
		char[] characters = new char[string.length()];
		char temp;
		
		// Add the length of the string to each character
		for (int i = 0; i < characters.length; i++)
			characters[i] = (char) (string.charAt(i) + string.length());
		
		// Reverse the String
		for (int j = 0; j < characters.length; j++) {
			temp = characters[j];
			characters[j] = characters[characters.length - j -1];
			characters[characters.length - j -1] = temp;
		} // End of the for loop	
		
		return string = new String(characters); // Return the new string
	} // End of the encode method
	
	/** Decode the Password
	---------------------------------*/
	
	/** A Very, Very Very Simple Decoder */
	String decode(String string) {
		char[] characters = new char[string.length()];
		char temp;
		
		// Subtract the length of the string from each character
		for (int i = 0; i < characters.length; i++)
			characters[i] = (char) (string.charAt(i) - string.length());
		
		// Reverse the String
		for (int j = 0; j < characters.length; j++) {
			temp = characters[j];
			characters[j] = characters[characters.length - j -1];
			characters[characters.length - j -1] = temp;
		} // End of the for loop
		
		return string = new String(characters); // Return the new string
	} // End of the decode method
	
	/** =========================================================
		Constructor
	========================================================= */
	public Calculator() {
		/** Dialogs
		========================================================= */
		
		/** Enter a Password
		---------------------------------*/
		
		/** Create Enter Password Dialog */
		final JDialog jdPassword = new JDialog((Frame)null, "Enter Password", true);
		
		/** Panels */
		JPanel p01 = new JPanel(new BorderLayout());
		p01.add(jlPassword, BorderLayout.WEST);
		p01.add(jpfPassword, BorderLayout.CENTER);
		
		JPanel p02 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p02.add(jbtEnter);
		
		/** Look */
		jdPassword.setLayout(new GridLayout(2, 1, 5, 5));
		jdPassword.add(p01);
		jdPassword.add(p02);
		jdPassword.setSize(250, 120);
		jdPassword.setLocationRelativeTo(null);

		/** Events */
		jdPassword.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);		
		
		jdPassword.addWindowListener(new WindowAdapter() {
			@Override
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
	    	} // End of the windowClosing method 
	    }); // End of the inner class
	    
		jbtEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				java.io.File file = new java.io.File("password.txt");
				Scanner readFile;
				try {
					readFile = new Scanner(file);
					String password = decode(readFile.nextLine());
					if(new String(jpfPassword.getPassword()).equals(password))
						jdPassword.dispose();
					else
						JOptionPane.showMessageDialog(null, "Wrong Password.", "Error", JOptionPane.ERROR_MESSAGE);
					readFile.close();
				}
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} // End of the try-throw-catch
			} // End of the actionPerformed method
		}); // End of the inner class
		
		/////////////////////////////////////////////////////////////
			
		/** Set a Password
		---------------------------------*/
		
		/** Create Set Password Dialog */
		final JDialog jdSetPassword = new JDialog((Frame)null, "Set Password", true);
		
		/** Panels */
		JPanel p03 = new JPanel(new BorderLayout());
		p03.add(jlSetPassword, BorderLayout.WEST);
		p03.add(jpfSetPassword, BorderLayout.CENTER);
		
		JPanel p04 = new JPanel(new BorderLayout());
		p04.add(jlCheckPassword, BorderLayout.WEST);
		p04.add(jpfCheckPassword, BorderLayout.CENTER);
		
		JPanel p05 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p05.add(jbtOK);
		
		/** Look */
		jdSetPassword.setLayout(new GridLayout(4, 1, 5, 5));
		jdSetPassword.add(jlNoPassword);
		jdSetPassword.add(p03);
		jdSetPassword.add(p04);
		jdSetPassword.add(p05);
		jdSetPassword.setSize(250, 200);
		jdSetPassword.setLocationRelativeTo(null);
		
		/** Events*/
		jdSetPassword.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);	
		
		jdSetPassword.addWindowListener(new WindowAdapter() {
			@Override
		   	public void windowClosing(WindowEvent we) {
		    	System.exit(0);
		    } // End of the windowClosing method
		}); // End of the inner class

	    
		jbtOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				java.io.File file = new java.io.File("password.txt");
				java.io.PrintWriter writeFile;
				try {
					if (new String(jpfSetPassword.getPassword()).equals(new String(jpfCheckPassword.getPassword()))) {
						writeFile = new java.io.PrintWriter(file);
						String password = encode(new String(jpfSetPassword.getPassword()));
						writeFile.print(password);
						writeFile.close();
						jdSetPassword.dispose();
					}
					else 
						JOptionPane.showMessageDialog(null, "Check your password again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} // End of the try-throw-catch		
			} // End of the actionPerformed method
		}); // End of the inner class
		
		addWindowListener(new WindowAdapter() {
			@Override
	    	public void windowOpened(WindowEvent wa) {
				java.io.File file = new java.io.File("password.txt");
				
				if (file.exists())
					jdPassword.setVisible(true);
				else
					jdSetPassword.setVisible(true);
	    	} // End of the windowOpened method
	    }); // End of the inner class
		
		/////////////////////////////////////////////////////////////
		
		/** Help
		---------------------------------*/
		
		/** Create Help Dialog */
		final JDialog jdHelp = new JDialog((Frame)null, "Help", true);
		
		/** Create Editor Pane */
		final JEditorPane jepHelp = new JEditorPane();
		
		/** Create Scroll Pane */
		JScrollPane jspHelp = new JScrollPane(jepHelp);
		jspHelp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspHelp.setVisible(true);
		
		jepHelp.setEditorKit(new javax.swing.text.html.HTMLEditorKit());
		jepHelp.setEditable(false);
		
		/** Look */
		jdHelp.setLayout(new BorderLayout());
		jdHelp.add(jspHelp, BorderLayout.CENTER);
		jdHelp.add(p05, BorderLayout.SOUTH);
		
		jdHelp.setSize(400, 400);
		jdHelp.setLocationRelativeTo(null);
		jdHelp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		/** Read the Help.html File */
		java.net.URL helpURL = this.getClass().getResource("Help.html");

		if (helpURL != null) {
			try {
				jepHelp.setPage(helpURL);
	        }
			catch (IOException ioe) {
	            	JOptionPane.showMessageDialog(null, "Reading File Error: Help.html", "Error", JOptionPane.ERROR_MESSAGE);
	        } // End of the try-throw-catch
	    }
		else {
	        	JOptionPane.showMessageDialog(null, "Cannnot Find File: Reading File Error", "Error", JOptionPane.ERROR_MESSAGE);
	    } // End of the if-else statement
		
		/////////////////////////////////////////////////////////////
		
		/** Menus
		========================================================= */
		
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		
		/** View
		---------------------------------*/
		
		JMenu viewMenu = new JMenu("View");
		viewMenu.setMnemonic('V');
		jmb.add(viewMenu);
		
		/** Edit
		---------------------------------*/
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic('E');
		jmb.add(editMenu);
		
		/** Help
		---------------------------------*/
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		jmb.add(helpMenu);
		
		viewMenu.add(jmiStandard);
		viewMenu.add(jmiAdvanced);
		viewMenu.add(jmiBigNumber);
		
		editMenu.add(jmiSetPassword);
		
		helpMenu.add(jmiViewHelp);
		helpMenu.addSeparator();
		helpMenu.add(jmiAbout);
		
		/////////////////////////////////////////////////////////////
				
		/** Calculators
		========================================================= */
		
		/** Standard Calculator
		---------------------------------*/
		
		/** Create the Panel for Display Area */
		final JPanel p1 = new JPanel(new BorderLayout());
		
		/** Memory */
		jlM.setText("");
		jlM.setOpaque(true);
		jlM.setBackground(Color.WHITE);
		p1.add(jlM, BorderLayout.WEST);
		
		/** Display Area */
		jtfDisplayArea.setEditable(false);
		jtfDisplayArea.setBackground(Color.WHITE);
		jtfDisplayArea.setFont(new Font("Dialog", Font.BOLD, 35));
		jtfDisplayArea.setHorizontalAlignment(JTextField.RIGHT);
		p1.add(jtfDisplayArea, BorderLayout.CENTER);
		
		/////////////////////////////////////////////////////////////
		
		/** Create the Panel for Buttons */
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
		
		/** Advanced Calculator
		---------------------------------*/
		
		/** Create the Panel for Buttons */
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
		
		/** Big Number Calculator
		---------------------------------*/
		
		/** Create the Panel for Number Buttons */
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
		
		/** Create the Panel for Operator Buttons */
		final JPanel p5 = new JPanel(new GridLayout(6, 1, 7, 7));
		
		jbtBigEqual.setEnabled(false);
		
		p5.add(jbtBigClear);
		p5.add(jbtBigPlus);
		p5.add(jbtBigMinus);
		p5.add(jbtBigMultiplication);
		p5.add(jbtBigDivision);
		p5.add(jbtBigEqual);
		
		/////////////////////////////////////////////////////////////
		
		/** Look */
		jtaDisplayArea.setEditable(false);
		jtaDisplayArea.setBackground(Color.WHITE);
		jtaDisplayArea.setFont(new Font("Dialog", Font.BOLD, 30));
		jtaDisplayArea.setLineWrap(true);
		jtaDisplayArea.setWrapStyleWord(false);
		
		final JScrollPane jspDisplayArea = new JScrollPane(jtaDisplayArea);
		jspDisplayArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		/////////////////////////////////////////////////////////////
		
		/** Menus
		========================================================= */
		
		/** View
		---------------------------------*/
		
		/** Initial Calculator */
		
		setLayout(new BorderLayout());
		setSize(300, 350);
		setTitle("Standard Calculator");
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		/////////////////////////////////////////////////////////////
		
		/** Standard Calculator */
		
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
			} // End of the actionPerformed method
		}); // End of the inner class

		/** Advanced Calculator */
		
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
			} // End of the actionPerformed method
		}); // End of the inner class
		
		/** Big Number Calculator */
		
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
				add(jspDisplayArea, BorderLayout.CENTER);
				
				getContentPane().revalidate();
				repaint();
			} // End of the actionPerformed method
		}); // End of the inner class
		
		/** Edit
		---------------------------------*/
		
		/** Set Password */
		
		jmiSetPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jdSetPassword.setVisible(true);
				jdSetPassword.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

			} // End of the actionPerformed method
		}); // End of the inner class
		
		/** Help
		---------------------------------*/
		
		/** View Help */
		
		jmiViewHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jdHelp.setVisible(true);
				
			} // End of the actionPerformed method
		}); // End of the inner class
		
		/** About */
		
		jmiAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String about = "Calculator\n"
						+ "-----------------------------------------------------------------\n"
						+ "  - Standard\n  - Advanced\n  - Big Number BETA\n\n"
						+ "-----------------------------------------------------------------\n"
						+ "By\n        Yen-Yi Wu\n\n        Department of Computer Science,\n        University of Taipei,\n        Taiwan\n"
						+ "-----------------------------------------------------------------\n"
						+ "                                                                 April, 2014";
				JOptionPane.showMessageDialog(null, about, "About", JOptionPane.PLAIN_MESSAGE);
			} // End of the actionPerformed method
		}); // End of the inner class
		
		/////////////////////////////////////////////////////////////
				
		/** Buttons
		========================================================= */
		
		/** Register
		---------------------------------*/
		
		ButtonListener buttons = new ButtonListener(); 
		
		/** Standard Calculator */
		
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
		
		/////////////////////////////////////////////////////////////
		
		/** Advanced Calculator */
		
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
		
		/////////////////////////////////////////////////////////////
		
		/** Big Number Calculator */
		
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
	} // End of the constructor
	
	enum Operator {NONE, PLUS, MINUS, MULTIPLICATION, DIVISION, MODULO, LOG, XY, BIGPLUS, BIGMINUS, BIGMULTIPLICATION, BIGDIVISION};
	
	/** Listener
	---------------------------------*/
	
	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			/** Standard Calculator */
			
			if(e.getSource() == jbtClear) {
				jtfDisplayArea.setText("0");
				setAnswer(0);
				setTemp(0);
				setOperator(Operator.NONE);
				setFontSize();
			} // End of the events of the jbtClear
			
			else if (e.getSource() == jbtBackspace) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					jtfDisplayArea.setText(jtfDisplayArea.getText().substring(0, jtfDisplayArea.getText().length() - 1));
					setFontSize();
				} // End of the if statement
			} // End of the events of the jbtBackspace
			
			else if (e.getSource() == jbtPlus) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() + getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}  // End of the if-else statement
				
				setOperator(Operator.PLUS);
				setFontSize();
			} // End of the events of the jbtPlus
			
			else if (e.getSource() == jbtMinus) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() - getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}  // End of the if-else statement
				
				setOperator(Operator.MINUS);
				setFontSize();
			} // End of the events of the jbtMinus
			
			else if (e.getSource() == jbtMultiplication) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() * getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				}  // End of the if-else statement
				
				setOperator(Operator.MULTIPLICATION);
				setFontSize();
			} // End of the events of the jbtMultiplication
			
			else if (e.getSource() == jbtDivision) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() / getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				} // End of the if-else statement
				
				setOperator(Operator.DIVISION);
				setFontSize();
			} // End of the events of the jbtDivision
			
			else if (e.getSource() == jbtMR) {
				jtfDisplayArea.setText(answerToString(getMemory()));
			} // End of the events of the jbtMR
			
			else if (e.getSource() == jbtMC) {
				jtfDisplayArea.setText("0");
				jlM.setText("");
				setAnswer(0);
				setTemp(0);
				setMemory(0);
				setOperator(Operator.NONE);
				setFontSize();
			} // End of the events of the jbtMC
			
			else if (e.getSource() == jbtMPlus) {
				setMemory(getMemory() + Double.parseDouble(jtfDisplayArea.getText()));
				jtfDisplayArea.setText("0");
				setTemp(0);
				setAnswer(0);
				jlM.setText("M");
			} // End of the events of the jbtMPlus
			
			else if (e.getSource() == jbtMMinus) {
				setMemory(getMemory() - Double.parseDouble(jtfDisplayArea.getText()));
				jtfDisplayArea.setText("0");
				setTemp(0);
				setAnswer(0);
				jlM.setText("M");
			} // End of the events of the jbtMMinus
			
			else if (e.getSource() == jbtZero) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "0");
						setFontSize();
					} // End of the inner if statement
				}  // End of the if statement
			} // End of the events of the jbtZero
			
			else if (e.getSource() == jbtOne) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "1");	
						setFontSize();
					}
					else
						jtfDisplayArea.setText("1");
				}  // End of the if statement
			} // End of the events of the jbtOne
			
			else if (e.getSource() == jbtTwo) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "2");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("2");
				}  // End of the if statement
			} // End of the events of the jbtTwo
			
			else if (e.getSource() == jbtThree) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "3");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("3");
				}  // End of the if statement
			} // End of the events of the jbtThree
			
			else if (e.getSource() == jbtFour) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "4");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("4");
				}  // End of the if statement
			} // End of the events of the jbtFour
			
			else if (e.getSource() == jbtFive) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "5");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("5");
				}  // End of the if statement
			} // End of the events of the jbtFive
			
			else if (e.getSource() == jbtSix) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "6");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("6");
				}  // End of the if statement
			} // End of the events of the jbtSix
			
			else if (e.getSource() == jbtSeven) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "7");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("7");
				}  // End of the if statement
			} // End of the events of the jbtSeven
			
			else if (e.getSource() == jbtEight) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "8");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("8");
				}  // End of the if statement
			} // End of the events of the jbtEight
			
			else if (e.getSource() == jbtNine) {
				if (jtfDisplayArea.getText().length() < ((getWidth() / 100) * 5)) {
					if (jtfDisplayArea.getText().equals("0") == false) {
						jtfDisplayArea.setText(jtfDisplayArea.getText() + "9");
						setFontSize();
					}
					else
						jtfDisplayArea.setText("9");
				}  // End of the if statement
			} // End of the events of the jbtNine
			
			else if (e.getSource() == jbtSquareRoot) {
				setAnswer(Math.sqrt(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtSquareRoot
			
			else if (e.getSource() == jbtModulo) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(getAnswer() % getTemp());
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				} // End of the if-else statement
				
				setOperator(Operator.MODULO);
				setFontSize();
			} // End of the events of the jbtModulo
			
			else if (e.getSource() == jbtDecimalPoint) {
				if(jtfDisplayArea.getText().indexOf('.') == -1) {
					jtfDisplayArea.setText(jtfDisplayArea.getText() + ".");
					setFontSize();
				} // End of the if statement
			} // End of the events of the jbtDecimalPoint
			
			else if (e.getSource() == jbtToggleSign) {
				if (jtfDisplayArea.getText().equals("0") == false) {
					if(jtfDisplayArea.getText().startsWith("-") == false)
						jtfDisplayArea.setText("-" + jtfDisplayArea.getText());
					else 
							jtfDisplayArea.setText(jtfDisplayArea.getText().substring(1));
				} // End of the if-else statement
			} // End of the events of the jbtToggleSign
			
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
				} // End of the switch statement
						
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtEqual
			
			/////////////////////////////////////////////////////////////
			
			/** Advanced Calculator */
			
			else if (e.getSource() == jbtSin) {
				setAnswer(Math.sin(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtSin
			
			else if (e.getSource() == jbtCos) {
				setAnswer(Math.cos(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtCos
			
			else if (e.getSource() == jbtTan) {
				setAnswer(Math.tan(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtTan
			
			else if (e.getSource() == jbtCsc) {
				setAnswer(1 / (Math.sin(Double.parseDouble(jtfDisplayArea.getText()))));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtCsc
			
			else if (e.getSource() == jbtSec) {
				setAnswer(1 / (Math.cos(Double.parseDouble(jtfDisplayArea.getText()))));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtSec
			
			else if (e.getSource() == jbtCot) {
				setAnswer(1 / (Math.tan(Double.parseDouble(jtfDisplayArea.getText()))));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtCot
			
			else if (e.getSource() == jbtAsin) {
				setAnswer(Math.asin(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtAsin
			
			else if (e.getSource() == jbtAcos) {
				setAnswer(Math.acos(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtAcos
			
			else if (e.getSource() == jbtAtan) {
				setAnswer(Math.atan(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtAtan
			
			else if (e.getSource() == jbtSinh) {
				setAnswer(Math.sinh(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtSinh
			
			else if (e.getSource() == jbtCosh) {
				setAnswer(Math.cosh(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtCosh
			
			else if (e.getSource() == jbtTanh) {
				setAnswer(Math.tanh(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtTanh
			
			else if (e.getSource() == jbtLn) {
				setAnswer(Math.log(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtLn
			
			else if (e.getSource() == jbtLog) {
				setAnswer(Math.log10(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtLog
			
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
			} // End of the events of the jbtLogxy
			
			else if (e.getSource() == jbtE) {
				jtfDisplayArea.setText(answerToString(Math.E));
				setFontSize();
			} // End of the events of the jbtE
			
			else if (e.getSource() == jbtEx) {
				setAnswer(Math.exp(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtEx
			
			else if (e.getSource() == jbtX2) {
				setAnswer(Math.pow(Double.parseDouble(jtfDisplayArea.getText()), 2));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtX2
			
			else if (e.getSource() == jbtX3) {
				setAnswer(Math.pow(Double.parseDouble(jtfDisplayArea.getText()), 3));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtX3
			
			else if (e.getSource() == jbtXy) {
				if (getAnswer() != 0) {
					setTemp(Double.parseDouble(jtfDisplayArea.getText()));
					setAnswer(Math.pow(getAnswer(), getTemp()));
					jtfDisplayArea.setText(answerToString(getAnswer()));
				}
				else {
					setAnswer(Double.parseDouble(jtfDisplayArea.getText()));
					jtfDisplayArea.setText("0");
				} // End of the if-else statement
				
				setOperator(Operator.XY);
				setFontSize();
			} // End of the events of the jbtXy
			
			else if (e.getSource() == jbt10x) {
				setAnswer(Math.pow(10, Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbt10x
			
			else if (e.getSource() == jbtCeil) {
				setAnswer(Math.ceil(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtCeil
			
			else if (e.getSource() == jbtFloor) {
				setAnswer(Math.floor(Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtFloor
			
			else if (e.getSource() == jbtPi) {
				jtfDisplayArea.setText(answerToString(Math.PI));
				setFontSize();
			} // End of the events of the jbtPi
			
			else if (e.getSource() == jbtFactorial) {
				setAnswer(factorial((int)Double.parseDouble(jtfDisplayArea.getText())));
				jtfDisplayArea.setText(answerToString(getAnswer()));
				setFontSize();
			} // End of the events of the jbtFactorial
			
			/////////////////////////////////////////////////////////////
			
			/** Big Number Calculator */
			
			else if (e.getSource() == jbtBigZero) {
				if (jtaDisplayArea.getText().equals("0") == false)
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "0");	
			} // End of the events of the jbtBigZero
			
			else if (e.getSource() == jbtBigOne) {
				if (jtaDisplayArea.getText().equals("0") == false) 
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "1");	
				else
					jtaDisplayArea.setText("1");
			} // End of the events of the jbtBigOne
			
			else if (e.getSource() == jbtBigTwo) {
				if (jtaDisplayArea.getText().equals("0") == false) 
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "2");	
				else
					jtaDisplayArea.setText("2");
			} // End of the events of the jbtBigTwo
			
			else if (e.getSource() == jbtBigThree) {
				if (jtaDisplayArea.getText().equals("0") == false) 
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "3");	
				else
					jtaDisplayArea.setText("3");
			} // End of the events of the jbtBigThree
			
			else if (e.getSource() == jbtBigFour) {
				if (jtaDisplayArea.getText().equals("0") == false) 
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "4");	
				else
					jtaDisplayArea.setText("4");
			} // End of the events of the jbtBigFour
			
			else if (e.getSource() == jbtBigFive) {
				if (jtaDisplayArea.getText().equals("0") == false) 
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "5");	
				else
					jtaDisplayArea.setText("5");
			} // End of the events of the jbtBigFive
			
			else if (e.getSource() == jbtBigSix) {
				if (jtaDisplayArea.getText().equals("0") == false) 
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "6");	
				else
					jtaDisplayArea.setText("6");
			} // End of the events of the jbtBigSix
			
			else if (e.getSource() == jbtBigSeven) {
				if (jtaDisplayArea.getText().equals("0") == false) 
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "7");	
				else
					jtaDisplayArea.setText("7");
			} // End of the events of the jbtBigSeven
			
			else if (e.getSource() == jbtBigEight) {
				if (jtaDisplayArea.getText().equals("0") == false) 
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "8");	
				else
					jtaDisplayArea.setText("8");
			} // End of the events of the jbtBigEight
			
			else if (e.getSource() == jbtBigNine) {
				if (jtaDisplayArea.getText().equals("0") == false) 
					jtaDisplayArea.setText(jtaDisplayArea.getText() + "9");	
				else
					jtaDisplayArea.setText("9");
			} // End of the events of the jbtBigNine
			
			else if (e.getSource() == jbtBigPlus) {
				if (Double.parseDouble(jtaDisplayArea.getText()) != 0) {
					bigTemp = numberToArray(jtaDisplayArea.getText());
					jtaDisplayArea.setText("0");
				} // End of the if statement
				
				setOperator(Operator.BIGPLUS);
				disableBigOperatorButtons();
				jbtBigEqual.setEnabled(true);
			} // End of the events of the jbtBigPlus
			
			else if (e.getSource() == jbtBigMinus) {
				if (Double.parseDouble(jtaDisplayArea.getText()) != 0) {
					bigTemp = numberToArray(jtaDisplayArea.getText());
					jtaDisplayArea.setText("0");
				} // End of the if statement
				
				setOperator(Operator.BIGMINUS);
				disableBigOperatorButtons();
				jbtBigEqual.setEnabled(true);
			} // End of the events of the jbtBigMinus
			
			else if (e.getSource() == jbtBigMultiplication) {
				if (Double.parseDouble(jtaDisplayArea.getText()) != 0) {
					bigTemp = numberToArray(jtaDisplayArea.getText());
					jtaDisplayArea.setText("0");
				} // End of the if statement
				
				setOperator(Operator.BIGMULTIPLICATION);
				disableBigOperatorButtons();
				jbtBigEqual.setEnabled(true);
			} // End of the events of the jbtBigMultiplication
			
			else if (e.getSource() == jbtBigDivision) {
				if (Double.parseDouble(jtaDisplayArea.getText()) != 0) {
					bigTemp = numberToArray(jtaDisplayArea.getText());
					jtaDisplayArea.setText("0");
				} // End of the if statement
				
				setOperator(Operator.BIGDIVISION);
				disableBigOperatorButtons();
				jbtBigEqual.setEnabled(true);
			} // End of the events of the jbtBigDivision
			
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
				} // End of the switch statement
					
				setOperator(Operator.NONE);
				disableBigNumberButtons();
				jbtBigEqual.setEnabled(false);
				bigTemp = new int[] {0};
			} // End of the events of the jbtBigEqual
			
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
			} // End of the events of the jbtBigClear
		} // End of the actionPerformed method
		
		/////////////////////////////////////////////////////////////
		
		/** Methods
		========================================================= */
		
		/** Standard and Advanced Calculator
		--------------------------------- */
		private double answer = 0;
		private double memory = 0;
		private double temp = 0;
		int[] bigTemp = {0};

		private Operator operator;
		
		/** Set and Get answer, memory, temp, and operator */
		public void setAnswer(double newAnswer) {
			answer = newAnswer;
		} // End of the setAnswer method
		
		public double getAnswer() {
			return answer;
		} // End of the getAnswer method
		
		public void setMemory(double newMemory) {
			memory = newMemory;
		} // End of the setMemory method
		
		public double getMemory() {
			return memory;
		} // End of the getMemory method
		
		public void setTemp(double newTemp) {
			temp = newTemp;
		} // End of the setTemp method
		
		public double getTemp() {
			return temp;
		} // End of the getTemp method
		
		public void setOperator(Operator newOperator) {
			operator = newOperator;
		} // End of the setOperator method
		
		public Operator getOperator() {
			return operator;
		} // End of the getOperator method
		
		/////////////////////////////////////////////////////////////
		
		/** Convert the answer to a string */
		public String answerToString(double answer) {
			String string = String.valueOf(answer);
			int indexOfDot = string.indexOf('.');
			String sub = string.substring(indexOfDot + 1);
			
			while (sub.endsWith("0")) {
				if (sub.length() > 1)
					sub = sub.substring(0, sub.length());
				else
					sub = "";
			} // End of the while loop
			
			string = string.substring(0, indexOfDot + 1) + sub;
			
			if (string.endsWith("."))
				string = string.substring(0, string.length() - 1);
			
			return string;
		} // End of the answerToString method
		
		/////////////////////////////////////////////////////////////
		
		/** Resize the font*/
		public void setFontSize() {
			int length = 9;
			int textLength = jtfDisplayArea.getText().length();
				
			switch(getWidth()) {
				case 300:
					length = 9;
					break;
				case 650:
					length = 30;
			} // End of the switch statement
				
			if (jtfDisplayArea.getText().length() > length ) 
					jtfDisplayArea.setFont(new Font("Dialog", Font.BOLD, 35 - ((textLength - length))));

			else
				jtfDisplayArea.setFont(new Font("Dialog", Font.BOLD, 35));
		} // End of the setFontSize method
		
		/////////////////////////////////////////////////////////////
		
		/** Advanced Calculator
		--------------------------------- */
		
		/** Calculate the factorial */
		public double factorial(int n) {
			if (n == 0)
				return 1;
			else
				return n * factorial(n - 1);
		} // End of the factorial method
		
		/////////////////////////////////////////////////////////////
		
		/** Big Number Calculator
		--------------------------------- */
		
		/** Convert the number to an array */
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
			} // End of the for loop
			
			return bigNumber;
		} // End of the numberToArray method
		
		/** Plus */
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
			} // End of the for loop
			
			return sum;
		} // End of the plus method
		
		/** Check if the first number is bigger than or equals the second */
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
				} // End of the if statement
			} // End of the for loop
			
			if (Arrays.equals(bigNum1, bigNum2))
				iboe = true;
			
			return iboe;
		} // End of the isBiggerOrEquals method
		
		/** Minus */
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
			} // End of the if-else statement
			
			for (int i = 0; i < length; i++)
				difference[i] = big[i] - small[i];
				
			for (int j = 1; j < length; j++) {
				if (difference[length - j] < 0) {
					difference[length - j - 1]--;
					difference[length - j] += 10000;
				} // End of the if statement
			} // End of the for loop
			
			if (bigger == false) 
				difference[0] = -difference[0];
			
			return difference;
		} // End of the minus method
		
		/** Multiply */
		public int[] multiply(int[] bigNumber1, int[] bigNumber2) {
			int length = bigNumber1.length + bigNumber2.length;
			int[] product = new int[length];
			int[] bigNum1 = new int[length];
			int[] bigNum2 = new int[length];
			
			System.arraycopy(bigNumber1, 0, bigNum1, length - bigNumber1.length, bigNumber1.length);
			System.arraycopy(bigNumber2, 0, bigNum2, length - bigNumber2.length, bigNumber2.length);
			
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (i + j > length - 2)
						product[i + j - length + 1] += bigNum1[i] * bigNum2[j];
				} // End of the inner for loop
			} // End of the for loop
			
			for (int k = 1; k < length; k++) {
				product[length - k - 1] += product[length - k] / 10000;
				product[length - k] %= 10000;
			} // End of the for loop
			
			return product;
		} // End of the multiply method
		
		/** A big number plus a integer */
		public  int[] plusInteger(int[] bigNumber, int n) {
			int length = bigNumber.length + 1;
			int[] bigNum = new int[length];
			
			System.arraycopy(bigNumber, 0, bigNum, length - bigNumber.length, bigNumber.length);
				
			bigNum[length - 1] = bigNum[length - 1] + n;
			
			for (int j = 1; j < length; j++) {
				bigNum[length - j - 1] += bigNum[length - j] / 10000;
				bigNum[length - j] %= 10000;
			} // End of the for loop
			
			return bigNum;
		} // End of the plusInteger method
		
		/** Divide */
		public String divide(int[] bigNumber1, int[] bigNumber2) {
			int length = bigNumber1.length;
			int[] quotient = new int[length];
			int[] remainder = new int[length];
			int[] temp;
			
			if (arrayToString(bigNumber2).equals("0"))
				return "Infinite";
			if (isBiggerOrEquals(bigNumber2, bigNumber1) && Arrays.equals(bigNumber1, bigNumber2) == false)
				return "Invalid Input";
			
			System.arraycopy(bigNumber1, 0, remainder, 0, bigNumber1.length);

			while(isBiggerOrEquals(remainder, bigNumber2)) {
				temp = minus(remainder, bigNumber2);
				if (temp[0] < 0)
					break;
				
				System.arraycopy(temp, 0, remainder, length - temp.length, temp.length);
				quotient = plusInteger(quotient, 1);
			} // End of the while loop
			
			return arrayToString(quotient) + "\n..." + arrayToString(remainder);
		} // End of the divide method
		
		/** Convert the big number array to a string */
		public String arrayToString(int[] bigNumber) {
			String result = "";
			
			for(int i = 0; i < bigNumber.length; i++)
				result += String.valueOf(bigNumber[i]);
			
			while (result.charAt(0) == '0') {
				if (result.length() < 2)
					break;
				
				result = result.substring(1);
			} // End of the while loop
			
			return result;
		} // End of the arrayToString method
		
		/////////////////////////////////////////////////////////////
		
		/** Disable the number buttons */
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
		} // End of the disableBigNumberButtons method
		
		/** Disable the operator buttons */
		public void disableBigOperatorButtons() {
			jbtBigPlus.setEnabled(false);
			jbtBigMinus.setEnabled(false);
			jbtBigMultiplication.setEnabled(false);
			jbtBigDivision.setEnabled(false);
		} // End of the disableBigOperatorButtons method
	} // End of the ButtonListener class

	/** =========================================================
		Main Method
	========================================================= */
	
	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // End of the main method
} // End of the Calculator class
