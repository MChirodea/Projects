package guiInterface;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;





class okBtnListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		GuiNew.frame.setVisible(false);
		GuiNew.frame.dispose();

	}
}

class useBtnListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		GuiNew.frame.setVisible(false);
		GuiElements.inputField.setText(GuiNew.poli);
		GuiElements.inputField2.setText("");
		GuiNew.frame.dispose();

	}
}

class saveBtnListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		PrintWriter out = null;
		try {
			out = new PrintWriter("Polinome.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out.write(GuiNew.poli);
		out.close();
		GuiNew.frame.setVisible(false);
		GuiNew.frame.dispose();

	}
}

@SuppressWarnings("serial")
class GuiNew extends Frame implements ActionListener{
	public static SpringLayout f1;
	public static JLabel label;
	public static JButton saveBtn;
	public static JButton okBtn;
	public static JButton useBtn;
	public static JFrame frame;
	public static Container contentPane;
	public static String poli;
	
	public GuiNew(String result){
		poli = result;
		f1 = new SpringLayout();
		label = new JLabel("Result: " +result);
		saveBtn = new JButton("Save Result");
		okBtn = new JButton("   OK   ");
		useBtn = new JButton("Use Result");
		frame = new JFrame("Polinome Calculator");
		contentPane = frame.getContentPane();
		contentPane.setLayout(f1);
		
		f1.putConstraint(SpringLayout.WEST, label,130, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, label, 20, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, saveBtn,30, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, saveBtn, 60, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, useBtn,170, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, useBtn, 60, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, okBtn,300, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, okBtn, 60, SpringLayout.NORTH, contentPane);
		
		contentPane.add(label);
		contentPane.add(saveBtn);
		saveBtn.addActionListener(new saveBtnListener());
		useBtn.addActionListener(new useBtnListener());
		okBtn.addActionListener(new okBtnListener());
		contentPane.add(useBtn);
		contentPane.add(okBtn);


		contentPane.setPreferredSize(new Dimension(400, 100));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
