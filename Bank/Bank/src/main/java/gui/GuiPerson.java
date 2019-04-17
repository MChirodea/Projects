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
import java.util.LinkedHashSet;

import javax.swing.table.DefaultTableModel;
import bankM.Bank;
import clients.Person;

/**
 *
 * @author mchir
 */
@SuppressWarnings("serial")
public class GuiPerson extends javax.swing.JFrame {
	private Bank bank;

	public GuiPerson() {
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
		showData();
	}

	@SuppressWarnings({ "unchecked" })
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		personTable = new javax.swing.JTable();
		backBTN = new javax.swing.JButton();
		addBTN = new javax.swing.JButton();
		delBTN = new javax.swing.JButton();
		editBTN = new javax.swing.JButton();
		pidField = new javax.swing.JTextField();
		addressField = new javax.swing.JTextField();
		phoneField = new javax.swing.JTextField();
		nameField = new javax.swing.JTextField();
		pidLBL = new javax.swing.JLabel();
		nameLBL = new javax.swing.JLabel();
		addressLBL = new javax.swing.JLabel();
		phoneLBL = new javax.swing.JLabel();

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

		personTable
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null,null, null, null, null }, {null, null, null, null, null },
								{ null,null, null, null, null }, { null,null, null, null, null } },
						new String[] { "ID","Name", "PID", "Address", "Phone" }) {
					@SuppressWarnings("rawtypes")
					Class[] types = new Class[] { java.lang.Integer.class,java.lang.String.class, java.lang.String.class,
							java.lang.String.class, java.lang.String.class };
					boolean[] canEdit = new boolean[] { false,false, false, false, false };

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
		jScrollPane1.setViewportView(personTable);

		backBTN.setText("Back");
		backBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backBTNActionPerformed(evt);
			}
		});

		addBTN.setText("Add Client");
		addBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addBTNActionPerformed(evt);
			}
		});

		delBTN.setText("Delete Client");
		delBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				delBTNActionPerformed(evt);
			}
		});

		editBTN.setText("Edit Client");
		editBTN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editBTNActionPerformed(evt);
			}
		});

		pidLBL.setFont(new java.awt.Font("Tahoma", 0, 18));
		pidLBL.setText("PID:");

		nameLBL.setFont(new java.awt.Font("Tahoma", 0, 18));
		nameLBL.setText("Name:");

		addressLBL.setFont(new java.awt.Font("Tahoma", 0, 18));
		addressLBL.setText("Address:");

		phoneLBL.setFont(new java.awt.Font("Tahoma", 0, 18));
		phoneLBL.setText("Phone:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
								jScrollPane1)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
												.createSequentialGroup()
												.addComponent(backBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(71, 71, 71)
												.addComponent(addBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(editBTN, javax.swing.GroupLayout.PREFERRED_SIZE,
														103, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(delBTN,
														javax.swing.GroupLayout.PREFERRED_SIZE, 104,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
														.createSequentialGroup()
														.addComponent(phoneLBL, javax.swing.GroupLayout.PREFERRED_SIZE,
																68, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(phoneField))
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(addressLBL,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 68,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18).addComponent(addressField))
												.addGroup(layout.createSequentialGroup()
														.addComponent(pidLBL, javax.swing.GroupLayout.PREFERRED_SIZE,
																68, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(pidField))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
														.createSequentialGroup()
														.addComponent(nameLBL, javax.swing.GroupLayout.PREFERRED_SIZE,
																68, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(nameField,
																javax.swing.GroupLayout.PREFERRED_SIZE, 129,
																javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGap(0, 167, Short.MAX_VALUE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(46, 46, 46)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nameLBL).addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(pidLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pidField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(addressLBL).addComponent(addressField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(phoneLBL).addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(delBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(editBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(backBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(addBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));

		pack();
	}

	public void showData() {
		LinkedHashSet<Person> list = bank.getClients();
		Iterator<Person> itp = list.iterator();
		DefaultTableModel model = (DefaultTableModel) personTable.getModel();
		model.setRowCount(0);
		Object[] row = new Object[5];
		while(itp.hasNext()){
			Person temp = itp.next();
			row[0] = temp.getId();
			row[1] = temp.getHolderName();
			row[2] = temp.getpID();
			row[3] = temp.getAddress();
			row[4] = temp.getPhoneNr();
			model.addRow(row);
		}

	}

	private void addBTNActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if(!(pidField.getText().matches("[0-9]+"))){
			showMessageDialog(null, "Only digits permmitted for PID!", "WARNING", WARNING_MESSAGE);
			return;
		}
		if(!(phoneField.getText().matches("[0-9]+"))){
			showMessageDialog(null, "Only digits permmitted for phone!", "WARNING", WARNING_MESSAGE);
			return;
		}
		Person client = new Person(bank.getAutoINCP(), this.nameField.getText(),
				this.pidField.getText(), this.addressField.getText(), this.phoneField.getText());
		bank.addPerson(client);
		this.showData();
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
			oo.writeObject(this.bank);
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

	private void editBTNActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Person temp = new Person(p.getId(),nameField.getText(),pidField.getText(),addressField.getText(),phoneField.getText());
		bank.editClient(temp, p);
		showData();
	}

	private void delBTNActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		bank.removePerson(p.getId());
		showData();
		
	}

	private void personTableMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = personTable.rowAtPoint(evt.getPoint());
		int id = Integer.parseInt(personTable.getModel().getValueAt(row, 0).toString());
		String name = personTable.getModel().getValueAt(row, 1).toString();
		String PID = personTable.getModel().getValueAt(row, 2).toString();
		String address = personTable.getModel().getValueAt(row, 3).toString();
		String phone = personTable.getModel().getValueAt(row, 4).toString();
		nameField.setText(name);
		pidField.setText(PID);
		addressField.setText(address);
		phoneField.setText(phone);
		p = new Person(id, name, PID, address, phone);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	Person p;
	private javax.swing.JButton addBTN;
	private javax.swing.JTextField addressField;
	private javax.swing.JLabel addressLBL;
	private javax.swing.JButton backBTN;
	private javax.swing.JButton delBTN;
	private javax.swing.JButton editBTN;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField nameField;
	private javax.swing.JLabel nameLBL;
	private javax.swing.JTable personTable;
	private javax.swing.JTextField phoneField;
	private javax.swing.JLabel phoneLBL;
	private javax.swing.JTextField pidField;
	private javax.swing.JLabel pidLBL;
}
