package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;



class loadBtnListener implements ActionListener {

	
	public void actionPerformed(ActionEvent e) {
		
			String inpA = null;
			String inpS = null;
			String inpQ = null; 
			String inpT = null;
			String[] termsA = null;
			String[] termsS = null;
			int minA = 0;
			int maxA = 0;
			int minS = 0;
			int maxS = 0;
			int qNr = 4;
			int simT = 15;
			
			
			if(!(GuiElements.inputField.getText().equals(""))){
				inpA = GuiElements.inputField.getText();
				termsA= inpA.split("\\/");
				minA = Integer.parseInt(termsA[0]);
				maxA = Integer.parseInt(termsA[1]);
			}
			if(!(GuiElements.inputField2.getText().equals(""))){
				inpS = GuiElements.inputField2.getText();
				termsS = inpS.split("\\/");
				minS = Integer.parseInt(termsS[0]);
				maxS = Integer.parseInt(termsS[1]);
			}
			if(!(GuiElements.inputField3.getText().equals(""))){
				inpQ = GuiElements.inputField3.getText();
				qNr = Integer.parseInt(inpQ);
			}
			if(!(GuiElements.inputField4.getText().equals(""))){
				inpT = GuiElements.inputField4.getText();
				simT = Integer.parseInt(inpT);
			}
				
			@SuppressWarnings("unused")
			GuiSimulation newG = new GuiSimulation(minA, maxA, minS, maxS, qNr, simT);
			GuiElements.frame.setVisible(false);
		}
	}

public class GuiElements extends Frame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static SpringLayout f1;
	public static JTextField inputField;
	public static JTextField inputField2;
	public static JTextField inputField3;
	public static JTextField inputField4;
	public static JFrame frame;
	public static Container contentPane;
	public static JLabel label;
	public static JLabel labelP1;
	public static JLabel labelP2;
	public static JLabel labelP3;
	public static JLabel labelP4;
	public static JButton loadBtn;

	
	
	public GuiElements() {
		// TODO Auto-generated method stub
		f1 = new SpringLayout();
		label = new JLabel("Warning: For MIN/MAX write as: MIN/MAX.");
		labelP1 = new JLabel("Introduce MIN/MAX for client arrival time (in seconds):");
		labelP2 = new JLabel("Introduce MIN/MAX for service time (in seconds):");
		labelP3 = new JLabel("Nr. of Queues (Between 1-7):");
		labelP4 = new JLabel("Simulation Time (in seconds):");
		loadBtn = new JButton("Start!");
		inputField = new JTextField(5);
		inputField2 = new JTextField(5);
		inputField3 = new JTextField(5);
		inputField4 = new JTextField(5);
		frame = new JFrame("Queue Simultator");
		contentPane = frame.getContentPane();
		contentPane.setLayout(f1);
		f1.putConstraint(SpringLayout.WEST, label, 80, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, loadBtn, 150, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, loadBtn, 200, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, inputField,320, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, inputField, 40, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, inputField2, 320, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, inputField2, 80, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, inputField3, 320, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, inputField3, 120, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, inputField4, 320, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, inputField4, 160, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, labelP1, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP1, 40, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP2, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP2, 80, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP3, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP3, 120, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP4, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP4, 160, SpringLayout.NORTH, contentPane);

		contentPane.add(label);
		contentPane.add(labelP1);
		contentPane.add(labelP2);
		contentPane.add(labelP3);
		contentPane.add(labelP4);
		
		contentPane.add(inputField);
		contentPane.add(inputField2);
		contentPane.add(inputField3);
		contentPane.add(inputField4);
		contentPane.add(loadBtn);
		loadBtn.addActionListener(new loadBtnListener());
		contentPane.setPreferredSize(new Dimension(400, 250));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// Invoke the constructor to setup the GUI, by allocating an instance
		@SuppressWarnings("unused")
		GuiElements app = new GuiElements();
		// or simply "new AWTCounter();" for an anonymous instance
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
