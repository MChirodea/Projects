package gui;

import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import javax.swing.table.DefaultTableModel;

import accounts.Account;
import accounts.SavingAccount;
import accounts.SpendingAccount;
import bankM.Bank;
import clients.Person;

public class GuiAccounts extends javax.swing.JFrame {
	private Bank bank;
	private static final long serialVersionUID = -6520496990800935146L;

	public GuiAccounts() {
		FileInputStream fi;
		try {
			fi = new FileInputStream(new File("Bank.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			bank = (Bank) oi.readObject();
			fi.close();
			oi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			bank = new Bank();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
		showData2();
		showData();
	}

	@SuppressWarnings({ "unchecked", "serial" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		accountTable = new javax.swing.JTable();
		backBTN = new javax.swing.JButton();
		addBTN = new javax.swing.JButton();
		editBTN = new javax.swing.JButton();
		delBTN = new javax.swing.JButton();
		searchBTN = new javax.swing.JButton();
		nameLBL = new javax.swing.JLabel();
		pidLBL = new javax.swing.JLabel();
		addressLBL = new javax.swing.JLabel();
		typeField = new javax.swing.JTextField();
		interestField = new javax.swing.JTextField();
		depositField = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		personTable = new javax.swing.JTable();
		atmBTN = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				FileOutputStream fo;
				try {
					fo = new FileOutputStream(new File("Bank.txt"));
					ObjectOutputStream oo = new ObjectOutputStream(fo);
					oo.writeObject(bank);
					fo.close();
					oo.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		accountTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null } },
				new String[] { "ID", "Account Type", "Holder ID", "Deposit", "Limit", "Interest" }) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
					java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				accountTableMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(accountTable);

		backBTN.setText("Back");
		backBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backBTNActionPerformed(evt);
			}
		});

		addBTN.setText("Add Account");
		addBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addBTNActionPerformed(evt);
			}
		});

		editBTN.setText("Edit Account");
		editBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editBTNActionPerformed(evt);
			}
		});

		delBTN.setText("Delete Account");
		delBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				delBTNActionPerformed(evt);
			}
		});

		searchBTN.setText("Search by Name");
		searchBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchBTNActionPerformed(evt);
			}
		});

		nameLBL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		nameLBL.setText("Account Type:");

		pidLBL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		pidLBL.setText("Deposit:");

		addressLBL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		addressLBL.setText("Interest:");

		personTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "id", "Name", "PID", "Address", "Phone" }) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { true, false, false, true, true };

			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		personTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				personTableMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(personTable);

		atmBTN.setText("ATM Simulator");
		atmBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				atmBTNActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout
								.createSequentialGroup().addGroup(layout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addGap(15, 15, 15)
														.addComponent(jScrollPane1))
										.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(backBTN, javax.swing.GroupLayout.PREFERRED_SIZE,
																102, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup().addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(addressLBL,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 68,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(nameLBL).addComponent(pidLBL,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 68,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(31, 31, 31)
																.addGroup(layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(typeField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				129,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(depositField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				129,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(interestField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				129,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
														.addGroup(layout.createSequentialGroup().addComponent(atmBTN,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGap(236, 236, 236)))
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(addBTN,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				103,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18, 18, 18)
																		.addComponent(editBTN,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				103,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18, 18, 18).addComponent(delBTN)
																		.addGap(18, 18, 18).addComponent(searchBTN))
																.addComponent(jScrollPane2))))))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(28, 28, 28)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2,
										javax.swing.GroupLayout.PREFERRED_SIZE, 154,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(nameLBL).addComponent(typeField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(pidLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(depositField, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(22, 22, 22)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(addressLBL).addComponent(interestField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(33, 33, 33).addComponent(atmBTN, javax.swing.GroupLayout.PREFERRED_SIZE,
												43, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(backBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(editBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(delBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(searchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		pack();
	}// </editor-fold>

	public void showData2() {
		LinkedHashSet<Person> list = bank.getClients();
		Iterator<Person> itp = list.iterator();
		DefaultTableModel model = (DefaultTableModel) personTable.getModel();
		model.setRowCount(0);
		Object[] row = new Object[5];
		while (itp.hasNext()) {
			Person temp = itp.next();
			row[0] = temp.getId();
			row[1] = temp.getHolderName();
			row[2] = temp.getpID();
			row[3] = temp.getAddress();
			row[4] = temp.getPhoneNr();
			model.addRow(row);
		}

	}

	public void showData() {
		LinkedHashMap<Person, LinkedHashSet<Object>> list = bank.getAccounts();
		DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
		model.setRowCount(0);
		Object[] row = new Object[6];
		for (Entry<Person, LinkedHashSet<Object>> entry : list.entrySet()) {
			Person pa = entry.getKey();
			LinkedHashSet<Object> tempa = entry.getValue();
			Iterator<Object> ito = tempa.iterator();
			while (ito.hasNext()) {
				Object temp = ito.next();
				Account temp2 = (Account) temp;
				if (temp2.getAccType() == 1) {
					SavingAccount temp3 = (SavingAccount) temp;
					row[0] = temp3.getID();
					row[1] = "Saving";
					row[2] = pa.getId();
					row[3] = temp3.getSavings();
					if (temp3.getlimit() == true) {
						row[4] = "Not Withdrawn/Deposited yet";
					} else {
						row[4] = "Withdrawn";
					}
					row[5] = temp3.getInterest();
				} else {
					SpendingAccount temp3 = (SpendingAccount) temp;
					row[0] = temp3.getID();
					row[1] = "Spending";
					row[2] = pa.getId();
					row[3] = temp3.getTotal();
					row[4] = "Unlimited";
					row[5] = 0;
				}
				model.addRow(row);
			}
		}
	}

	private void atmBTNActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (ac != null) {
			try {
				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			} catch (ClassNotFoundException ex) {
				java.util.logging.Logger.getLogger(GuiATM.class.getName()).log(java.util.logging.Level.SEVERE, null,
						ex);
			} catch (InstantiationException ex) {
				java.util.logging.Logger.getLogger(GuiATM.class.getName()).log(java.util.logging.Level.SEVERE, null,
						ex);
			} catch (IllegalAccessException ex) {
				java.util.logging.Logger.getLogger(GuiATM.class.getName()).log(java.util.logging.Level.SEVERE, null,
						ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
				java.util.logging.Logger.getLogger(GuiATM.class.getName()).log(java.util.logging.Level.SEVERE, null,
						ex);
			}
			FileOutputStream fo;
			try {
				fo = new FileOutputStream(new File("Bank.txt"));
				ObjectOutputStream oo = new ObjectOutputStream(fo);
				oo.writeObject(bank);
				fo.close();
				oo.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dispose();
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new GuiATM(ac).setVisible(true);
				}
			});
		}else{
			showMessageDialog(null, "Select an account first!","WARNING", WARNING_MESSAGE);
			return;
		}
	}

	private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = accountTable.rowAtPoint(evt.getPoint());
		int id = Integer.parseInt(accountTable.getModel().getValueAt(row, 0).toString());
		String accType = accountTable.getModel().getValueAt(row, 1).toString();
		int holderId = Integer.parseInt(accountTable.getModel().getValueAt(row, 2).toString());
		int deposit = Integer.parseInt(accountTable.getModel().getValueAt(row, 3).toString());
		String limit = accountTable.getModel().getValueAt(row, 4).toString();
		int interest = Integer.parseInt(accountTable.getModel().getValueAt(row, 5).toString());
		cID = holderId;
		typeField.setText(accType);
		depositField.setText(Integer.toString(deposit));
		interestField.setText(Integer.toString(interest));
		if (accType.equals("Saving")) {
			SavingAccount temp2 = new SavingAccount(holderId, id, interest, deposit);
			if (limit.equals("Withdrawn")) {
				temp2.setLimit(false);
			}
			ac = temp2;
		} else {
			SpendingAccount temp2 = new SpendingAccount(holderId, id, deposit);
			ac = temp2;
		}
	}

	private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GuiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GuiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GuiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GuiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		FileOutputStream fo;
		try {
			fo = new FileOutputStream(new File("Bank.txt"));
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(bank);
			fo.close();
			oo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.dispose();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GuiStart().setVisible(true);
			}
		});
	}

	private void addBTNActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		// Aici adaug account, dar nu inainte de a creea un client pentur a
		// adauga cont.
		// Amu pentru a selecta clientul, o sa am inca un mini-tabel cu persoane
		// si dau click, am rezolvat problema.
		if (p == null) {
			showMessageDialog(null, "No client Selected!", "WARNING", WARNING_MESSAGE);
			return;
		}
		if (!(depositField.getText().matches("[0-9]+"))) {
			showMessageDialog(null, "Only digits permmitted for deposit!", "WARNING", WARNING_MESSAGE);
			return;
		}
		if (!(interestField.getText().matches("[0-9]+"))) {
			showMessageDialog(null, "Only digits permmitted for interest!", "WARNING", WARNING_MESSAGE);
			return;
		}
		if (typeField.getText().equals("Saving")) {
			SavingAccount temp = new SavingAccount(p.getId(), bank.getAutoINCA(),
					Integer.parseInt(interestField.getText()), Integer.parseInt(depositField.getText()));
			bank.addHolderAccount(temp, p);
		} else {
			if (typeField.getText().equals("Spending")) {
				SpendingAccount temp = new SpendingAccount(p.getId(), bank.getAutoINCA(),
						Integer.parseInt(depositField.getText()));
				bank.addHolderAccount(temp, p);
			} else {
				showMessageDialog(null, "Only 'Saving'/'Spending' permitted!", "WARNING", WARNING_MESSAGE);
			}
		}
		showData();
	}

	private void editBTNActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (!(depositField.getText().matches("[0-9]+"))) {
			showMessageDialog(null, "Only digits permmitted for deposit!", "WARNING", WARNING_MESSAGE);
			return;
		}
		if (!(interestField.getText().matches("[0-9]+"))) {
			showMessageDialog(null, "Only digits permmitted for interest!", "WARNING", WARNING_MESSAGE);
			return;
		}
		int deposit = Integer.parseInt(depositField.getText());
		int interest = Integer.parseInt(interestField.getText());
		String accType = typeField.getText();
		if (accType.equals("Saving")) {
			Account sa = (Account) ac;
			SavingAccount temp = new SavingAccount(sa.getHolder(), sa.getID(), interest, deposit);
			bank.writeAcc(sa.getHolder(), temp);
			showData();
		} else {
			Account sa = (Account) ac;
			SpendingAccount temp = new SpendingAccount(sa.getHolder(), sa.getID(), deposit);
			bank.writeAcc(sa.getHolder(), temp);
			showData();
		}
	}

	private void delBTNActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Account acT = (Account) ac;
		bank.remHolderAccount(acT.getID(), cID);
		showData();
	}

	private void searchBTNActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		LinkedHashSet<Object> temp = bank.readAcc(p.getId());
		DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
		model.setRowCount(0);
		Object[] row = new Object[6];
		Iterator<Object> ito = temp.iterator();
		while (ito.hasNext()) {
			Account temp2 = (Account) ito.next();
			if (temp2.getAccType() == 1) {
				SavingAccount temp3 = (SavingAccount) temp2;
				row[0] = temp3.getID();
				row[1] = "Saving";
				row[2] = temp3.getHolder();
				row[3] = temp3.getSavings();
				if (temp3.getlimit() == true) {
					row[4] = "Not Withdrawn yet";
				} else {
					row[4] = "Withdrawn";
				}
				row[5] = temp3.getInterest();
			} else {
				SpendingAccount temp3 = (SpendingAccount) temp2;
				row[0] = temp3.getID();
				row[1] = "Spending";
				row[2] = temp3.getHolder();
				row[3] = temp3.getTotal();
				row[4] = "Unlimited";
				row[5] = 0;
			}
			model.addRow(row);
		}
	}

	private void personTableMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = personTable.rowAtPoint(evt.getPoint());
		int id = Integer.parseInt(personTable.getModel().getValueAt(row, 0).toString());
		String name = personTable.getModel().getValueAt(row, 1).toString();
		String PID = personTable.getModel().getValueAt(row, 2).toString();
		String address = personTable.getModel().getValueAt(row, 3).toString();
		String phone = personTable.getModel().getValueAt(row, 4).toString();
		p = new Person(id, name, PID, address, phone);
	}

	// Variables declaration - do not modify
	private Person p;
	private Object ac;
	private int cID;
	private javax.swing.JTable accountTable;
	private javax.swing.JButton addBTN;
	private javax.swing.JLabel addressLBL;
	private javax.swing.JButton backBTN;
	private javax.swing.JButton delBTN;
	private javax.swing.JButton editBTN;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField typeField;
	private javax.swing.JTextField interestField;
	private javax.swing.JTextField depositField;
	private javax.swing.JLabel nameLBL;
	private javax.swing.JTable personTable;
	private javax.swing.JLabel pidLBL;
	private javax.swing.JButton searchBTN;
	private javax.swing.JButton atmBTN;
	// End of variables declaration
}
