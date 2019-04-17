package guiInterface;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import codes.*;

class plusBtnListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		Polinome polinome1 = new Polinome();
		Polinome polinome2 = new Polinome();
		Polinome polinome3 = new Polinome();
		PoliUtils polU = new PoliUtils(0, 0);
		if(!(GuiElements.inputField.getText().equals(""))){
			polinome1 = polU.readPoli(GuiElements.inputField.getText());
		}
		if(!(GuiElements.inputField2.getText().equals(""))){
			polinome2 = polU.readPoli(GuiElements.inputField2.getText());
		}
		polinome3 = polinome1.addPoli(polinome2);
		Iterator<Monome> itm1 = polinome3.getPoli().iterator();
		String poli3 = "";

		while (itm1.hasNext()) {
			Monome montst = itm1.next();
			if (itm1.hasNext()) {
				if (montst.getGrade() != 0) {
					if (montst.getValue() > 0) {
						poli3 = poli3 + montst.getValue() + "X^" + montst.getGrade() + "+";
					} else {
						if (montst.getValue() < 0) {
							poli3 = poli3 + "(" + montst.getValue() + ")" + "X^" + montst.getGrade() + "+";
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + montst.getValue() + "+";
				}
			} else {
				if (montst.getGrade() != 0) {
					if (montst.getValue() > 0) {
						poli3 = poli3 + montst.getValue() + "X^" + montst.getGrade();
					} else {
						if (montst.getValue() < 0) {
							poli3 = poli3 + "(" + montst.getValue() + ")" + "X^" + montst.getGrade();
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + montst.getValue();
				
				}
			}
		}
		@SuppressWarnings("unused")
		GuiNew rez = new GuiNew(poli3);
	}
}

class minusBtnListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Polinome polinome1 = new Polinome();
		Polinome polinome2 = new Polinome();
		Polinome polinome3 = new Polinome();
		PoliUtils polU = new PoliUtils(0, 0);
		polinome1 = polU.readPoli(GuiElements.inputField.getText());
		polinome2 = polU.readPoli(GuiElements.inputField2.getText());
		polinome3 = polinome1.subPoli(polinome2);
		Iterator<Monome> itm1 = polinome3.getPoli().iterator();
		String poli3 = "";

		while (itm1.hasNext()) {
			Monome montst = itm1.next();
			if (itm1.hasNext()) {
				if (montst.getGrade() != 0) {
					if (montst.getValue() > 0) {
						poli3 = poli3 + montst.getValue() + "X^" + montst.getGrade() + "+";
					} else {
						if (montst.getValue() < 0) {
							poli3 = poli3 + "(" + montst.getValue() + ")" + "X^" + montst.getGrade() + "+";
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + montst.getValue() + "+";
				}
			} else {
				if (montst.getGrade() != 0) {
					if (montst.getValue() > 0) {
						poli3 = poli3 + montst.getValue() + "X^" + montst.getGrade();
					} else {
						if (montst.getValue() < 0) {
							poli3 = poli3 + "(" + montst.getValue() + ")" + "X^" + montst.getGrade();
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + montst.getValue();
				}
			}
		}
		@SuppressWarnings("unused")
		GuiNew rez = new GuiNew(poli3);
	}
}

class loadBtnListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		File f = new File("Polinome.txt");
		Scanner read = null;
		try {
			 read = new Scanner(f);
			 GuiElements.inputField.setText(read.nextLine());
			 GuiElements.inputField2.setText("");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			read.close();
		}
	}
}

class multiplyBtnListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		Collection<Monome> monTemp = new ArrayList<Monome>();
		Polinome polinome1 = new Polinome();
		Polinome polinome2 = new Polinome();
		Polinome polinome3 = new Polinome();
		PoliUtils polU = new PoliUtils(0, 0);
		polinome1 = polU.readPoli(GuiElements.inputField.getText());
		polinome2 = polU.readPoli(GuiElements.inputField2.getText());
		polinome3 = polinome1.mulPoli(polinome2);
		Iterator<Monome> itm1 = polinome3.getPoli().iterator();
		Iterator<Monome> itm2 = polinome3.getPoli().iterator();
		String poli3 = "";
		Monome mon1 = null;
		Monome mon2 = null;
		while(itm1.hasNext()){
			mon1 = itm1.next();
			itm2 = polinome3.getPoli().iterator();
			while(itm2.hasNext() && mon1 != mon2){
				mon2 = itm2.next();
			}
			while(itm2.hasNext() && itm1.hasNext()){
				mon2 = itm2.next();
				if(mon1.getGrade() == mon2.getGrade()){
					mon1.setValue(mon1.getValue() + mon2.getValue());
					monTemp.add(mon2);
				}
				
			}
		}
		polinome3.getPoli().removeAll(monTemp);
		itm1 = polinome3.getPoli().iterator();
		while (itm1.hasNext()) {
			Monome montst = itm1.next();
			if (itm1.hasNext()) {
				if (montst.getGrade() != 0) {
					if (montst.getValue() > 0) {
						poli3 = poli3 + montst.getValue() + "X^" + montst.getGrade() + "+";
					} else {
						if (montst.getValue() < 0) {
							poli3 = poli3 + "(" + montst.getValue() + ")" + "X^" + montst.getGrade() + "+";
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + montst.getValue() + "+";
				}
			} else {
				if (montst.getGrade() != 0) {
					if (montst.getValue() > 0) {
						poli3 = poli3 + montst.getValue() + "X^" + montst.getGrade();
					} else {
						if (montst.getValue() < 0) {
							poli3 = poli3 + "(" + montst.getValue() + ")" + "X^" + montst.getGrade();
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + montst.getValue();
				
				}
			}
		}
		@SuppressWarnings("unused")
		GuiNew rez = new GuiNew(poli3);
	}
}


class divideBtnListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {

	}
}

class integrateBtnListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Polinome polinome1 = new Polinome();
		Polinome polinome3 = new Polinome();
		PoliUtils polU = new PoliUtils(0, 0);
		polinome1 = polU.readPoli(GuiElements.inputField.getText());
		polinome3 = polinome1.interPoli();
		Iterator<Monome> itm1 = polinome3.getPoli().iterator();
		String poli3 = "";

		while (itm1.hasNext()) {
			Monome montst = itm1.next();
			if (itm1.hasNext()) {
				if (montst.getGradeD() != 0.0) {
					if (montst.getValueD() > 0.0) {
						poli3 = poli3 + new DecimalFormat("##.##").format(montst.getValueD()) + "X^" + montst.getGrade() + "+";
					} else {
						if (montst.getValue() < 0.0) {
							poli3 = poli3 + "(" + new DecimalFormat("##.##").format(montst.getValueD()) + ")" + "X^" + montst.getGrade() + "+";
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + new DecimalFormat("##.##").format(montst.getValueD()) + "+";
				}
			} else {
				if (montst.getGradeD() != 0.0) {
					if (montst.getValueD() > 0.0) {
						poli3 = poli3 +new DecimalFormat("##.##").format(montst.getValueD()) + "X^" + montst.getGrade();
					} else {
						if (montst.getValueD() < 0.0) {
							poli3 = poli3 + "(" + new DecimalFormat("##.##").format(montst.getValueD()) + ")" + "X^" + montst.getGrade();
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + new DecimalFormat("##.##").format(montst.getValueD());
				
				}
			}
		}
		@SuppressWarnings("unused")
		GuiNew rez = new GuiNew(poli3);
	}
}

class derivateBtnListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Polinome polinome1 = new Polinome();
		Polinome polinome3 = new Polinome();
		PoliUtils polU = new PoliUtils(0, 0);
		polinome1 = polU.readPoli(GuiElements.inputField.getText());
		polinome3 = polinome1.derPoli();
		Iterator<Monome> itm1 = polinome3.getPoli().iterator();
		String poli3 = "";

		while (itm1.hasNext()) {
			Monome montst = itm1.next();
			if (itm1.hasNext()) {
				if (montst.getGrade() != 0) {
					if (montst.getValue() > 0) {
						poli3 = poli3 + montst.getValue() + "X^" + montst.getGrade() + "+";
					} else {
						if (montst.getValue() < 0) {
							poli3 = poli3 + "(" + montst.getValue() + ")" + "X^" + montst.getGrade() + "+";
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + montst.getValue() + "+";
				}
			} else {
				if (montst.getGrade() != 0) {
					if (montst.getValue() > 0) {
						poli3 = poli3 + montst.getValue() + "X^" + montst.getGrade();
					} else {
						if (montst.getValue() < 0) {
							poli3 = poli3 + "(" + montst.getValue() + ")" + "X^" + montst.getGrade();
						} else {
							poli3 = poli3 + "";
						}
					}
				} else {
					poli3 = poli3 + montst.getValue();
				
				}
			}
		}
		@SuppressWarnings("unused")
		GuiNew rez = new GuiNew(poli3);
	}

}




@SuppressWarnings("serial")
public class GuiElements extends Frame implements ActionListener {

	public static SpringLayout f1;
	public static JTextField inputField;
	public static JTextField inputField2;
	public static JTextField outField;
	public static JButton plusBtn;
	public static JButton minusBtn;
	public static JButton multiplyBtn;
	public static JButton divBtn;
	public static JButton derivateBtn;
	public static JButton integrateBtn;
	public static JFrame frame;
	public static Container contentPane;
	public static JLabel label;
	public static JLabel labelP1;
	public static JLabel labelP2;
	public static JLabel labelP3;
	public static JButton loadBtn;

	public GuiElements() {
		// TODO Auto-generated method stub
		f1 = new SpringLayout();
		label = new JLabel("Input without space and in the following manner: 2x^3+(-1)x^1.");
		labelP1 = new JLabel("Polinome 1:");
		labelP2 = new JLabel("Polinome 2:");
		labelP3 = new JLabel("Result:");
		loadBtn = new JButton("Load Polinome");
		inputField = new JTextField(20);
		inputField2 = new JTextField(20);
		outField = new JTextField(20);
		plusBtn = new JButton("  +  ");
		minusBtn = new JButton("   -  ");
		multiplyBtn = new JButton("   *  ");
		divBtn = new JButton("   /  ");
		derivateBtn = new JButton("f'(x)");
		integrateBtn = new JButton("F(x)");
		frame = new JFrame("Polinome Calculator");
		contentPane = frame.getContentPane();
		contentPane.setLayout(f1);
		f1.putConstraint(SpringLayout.WEST, label, 20, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, loadBtn, 20, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, loadBtn, 150, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, plusBtn, 320, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, plusBtn, 30, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, inputField,80, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, inputField, 40, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, inputField2, 80, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, inputField2, 70, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, outField, 80, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, outField, 90, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, minusBtn, 320, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, minusBtn, 70, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, multiplyBtn, 320, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, multiplyBtn, 110, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, divBtn, 320, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, divBtn, 150, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, integrateBtn, 240, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, integrateBtn, 150, SpringLayout.NORTH, contentPane);

		f1.putConstraint(SpringLayout.WEST, derivateBtn, 165, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, derivateBtn, 150, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP1, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP1, 40, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP2, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP2, 70, SpringLayout.NORTH, contentPane);
		
		f1.putConstraint(SpringLayout.WEST, labelP3, 10, SpringLayout.WEST, contentPane);
		f1.putConstraint(SpringLayout.NORTH, labelP3, 90, SpringLayout.NORTH, contentPane);

		contentPane.add(label);
		contentPane.add(labelP1);
		contentPane.add(labelP2);
		contentPane.add(inputField);
		contentPane.add(inputField2);
		contentPane.add(plusBtn);
		contentPane.add(loadBtn);
		loadBtn.addActionListener(new loadBtnListener());
		plusBtn.addActionListener(new plusBtnListener());
		contentPane.add(divBtn);
		divBtn.addActionListener(new divideBtnListener());
		contentPane.add(minusBtn);
		minusBtn.addActionListener(new minusBtnListener());
		contentPane.add(multiplyBtn);
		multiplyBtn.addActionListener(new multiplyBtnListener());
		contentPane.add(derivateBtn);
		derivateBtn.addActionListener(new derivateBtnListener());
		contentPane.add(integrateBtn);
		integrateBtn.addActionListener(new integrateBtnListener());

		contentPane.setPreferredSize(new Dimension(400, 200));
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
