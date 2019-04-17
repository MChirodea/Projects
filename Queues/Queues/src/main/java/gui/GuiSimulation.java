package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingWorker;

import control.ClientGenerator;
import control.Person;
import control.Queue;



class endBtnListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		GuiSimulation.frame.setVisible(false);
		GuiSimulation.frame.dispose();
		GuiElements.frame.dispose();

	}
}

public class GuiSimulation extends Frame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7851505266286025499L;
	public static SpringLayout f1;
	public static JFrame frame;
	public static Container contentPane;
	public static JLabel labelP;
	public static JLabel labelPa;
	public static JLabel labelPb;
	public static JLabel labelP1;
	public static JLabel labelP2;
	public static JLabel labelP3;
	public static JLabel labelP4;
	public static JLabel labelP5;
	public static JLabel labelP6;
	public static JLabel labelP7;
	public static JLabel labelP8;
	public static JLabel labelP9;
	public static JLabel labelP10;
	public static JLabel labelP11;
	public static JLabel labelP12;
	public static JLabel labelP13;
	public static JLabel labelP14;
	public static JLabel labelP15;
	public int minA; 
	public int maxA; 
	public int minS; 
	public int maxS; 
	public int qNr; 
	public int simT;
	public static JButton endBtn;
	
	public GuiSimulation(int minA, int maxA, int minS, int maxS, int qNr, int simT) {
		// TODO Auto-generated method stub
		f1 = new SpringLayout();
		this.minA = minA;
		this.maxA = maxA;
		this.minS = minS;
		this.maxS = maxS;
		this.qNr = qNr;
		this.simT = simT;
		labelP = new JLabel("Warning: Number of queues is greater than 7, the program will ");
		labelPa = new JLabel("simulate the default  value  of 7. ");
		labelPb = new JLabel("We can assume that it will work the same for bigger queues.");
		labelP1 = new JLabel("Queue 1:");
		labelP2 = new JLabel("Queue 2:");
		labelP3 = new JLabel("Queue 3:");
		labelP4 = new JLabel("Queue 4:");
		labelP5 = new JLabel("Queue 5:");
		labelP6 = new JLabel("Queue 6:");
		labelP7 = new JLabel("Queue 7:");
		labelP8 = new JLabel("Wait Time Q1:");
		labelP9 = new JLabel("Wait Time Q2:");
		labelP10 = new JLabel("Wait Time Q3:");
		labelP11 = new JLabel("Wait Time Q4:");
		labelP12 = new JLabel("Wait Time Q5:");
		labelP13 = new JLabel("Wait Time Q6:");
		labelP14 = new JLabel("Wait Time Q7:");
		labelP15 = new JLabel("Remaining Simulation Time:");
		endBtn = new JButton("Exit");
		frame = new JFrame("Queue Simultator");
		contentPane = frame.getContentPane();
		contentPane.setLayout(f1);
		
		
		f1.putConstraint(SpringLayout.WEST, labelP, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP, 0, SpringLayout.NORTH, contentPane);
		f1.putConstraint(SpringLayout.WEST, labelPa, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelPa, 20, SpringLayout.NORTH, contentPane);
		f1.putConstraint(SpringLayout.WEST, labelPb, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelPb, 40, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, endBtn, 160, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, endBtn, 360, SpringLayout.NORTH, contentPane);


		f1.putConstraint(SpringLayout.WEST, labelP1, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP1, 80, SpringLayout.NORTH, contentPane);
		f1.putConstraint(SpringLayout.WEST, labelP8, 255, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP8, 80, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP2, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP2, 120, SpringLayout.NORTH, contentPane);
		f1.putConstraint(SpringLayout.WEST, labelP9, 255, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP9, 120, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP3, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP3, 160, SpringLayout.NORTH, contentPane);
		f1.putConstraint(SpringLayout.WEST, labelP10, 255, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP10, 160, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP4, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP4, 200, SpringLayout.NORTH, contentPane);
		f1.putConstraint(SpringLayout.WEST, labelP11, 255, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP11, 200, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP5, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP5, 240, SpringLayout.NORTH, contentPane);
		f1.putConstraint(SpringLayout.WEST, labelP12, 255, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP12, 240, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP6, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP6, 280, SpringLayout.NORTH, contentPane);
		f1.putConstraint(SpringLayout.WEST, labelP13, 255, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP13, 280, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP7, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP7, 320, SpringLayout.NORTH, contentPane);
		f1.putConstraint(SpringLayout.WEST, labelP14, 255, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP14, 320, SpringLayout.NORTH, contentPane);

		switch(qNr){
			case 1: contentPane.add(labelP1);
					contentPane.add(labelP8);
					break;
			case 2: contentPane.add(labelP1);
					contentPane.add(labelP2);
					contentPane.add(labelP8);
					contentPane.add(labelP9);
					break;
			
			case 3: contentPane.add(labelP1);
					contentPane.add(labelP2);
					contentPane.add(labelP3);
					contentPane.add(labelP8);
					contentPane.add(labelP9);
					contentPane.add(labelP10);
					break;
			
			case 4: contentPane.add(labelP1);
					contentPane.add(labelP2);
					contentPane.add(labelP3);
					contentPane.add(labelP4);
					contentPane.add(labelP8);
					contentPane.add(labelP9);
					contentPane.add(labelP10);
					contentPane.add(labelP11);
					break;
			
			case 5: contentPane.add(labelP1);
					contentPane.add(labelP2);
					contentPane.add(labelP3);
					contentPane.add(labelP4);
					contentPane.add(labelP5);
					contentPane.add(labelP8);
					contentPane.add(labelP9);
					contentPane.add(labelP10);
					contentPane.add(labelP11);
					contentPane.add(labelP12);
					break;
			
			case 6: contentPane.add(labelP1);
					contentPane.add(labelP2);
					contentPane.add(labelP3);
					contentPane.add(labelP4);
					contentPane.add(labelP5);
					contentPane.add(labelP6);
					contentPane.add(labelP8);
					contentPane.add(labelP9);
					contentPane.add(labelP10);
					contentPane.add(labelP11);
					contentPane.add(labelP12);
					contentPane.add(labelP13);
					break;
			
			case 7: contentPane.add(labelP1);
					contentPane.add(labelP2);
					contentPane.add(labelP3);
					contentPane.add(labelP4);
					contentPane.add(labelP5);
					contentPane.add(labelP6);
					contentPane.add(labelP7);
					contentPane.add(labelP8);
					contentPane.add(labelP9);
					contentPane.add(labelP10);
					contentPane.add(labelP11);
					contentPane.add(labelP12);
					contentPane.add(labelP13);
					contentPane.add(labelP14);
					break;
					
		   default: contentPane.add(labelP1);
					contentPane.add(labelP2);
					contentPane.add(labelP3);
					contentPane.add(labelP4);
					contentPane.add(labelP5);
					contentPane.add(labelP6);
					contentPane.add(labelP7);
					contentPane.add(labelP8);
					contentPane.add(labelP9);
					contentPane.add(labelP10);
					contentPane.add(labelP11);
					contentPane.add(labelP12);
					contentPane.add(labelP13);
					contentPane.add(labelP14);
					contentPane.add(labelP);
					contentPane.add(labelPa);
					contentPane.add(labelPb);
					break;
		}
		//contentPane.add(labelP15);
		contentPane.add(endBtn);
		endBtn.addActionListener(new endBtnListener());
		contentPane.setPreferredSize(new Dimension(400,400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		this.start();
		
	}
	public void start(){
		SwingWorker <String,Person> worker = new SwingWorker<String, Person>(){

			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
				Queue q = new Queue(1);
				Queue q1 = new Queue(2);
				Queue q2 = new Queue(3);
				Queue q3 = new Queue(4);
				Queue q4 = new Queue(5);
				Queue q5 = new Queue(6);
				Queue q6 = new Queue(7);
				ClientGenerator gen = new ClientGenerator(simT,q,q1,q2,q3,q4,q5,q6);
				
				q.start();
				q1.start();
				q2.start();
				q3.start();
				q4.start();
				q5.start();
				q6.start();
				gen.start(minA, maxA, minS, maxS, qNr);
				return null;
			}
			
		};
		worker.execute();
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
