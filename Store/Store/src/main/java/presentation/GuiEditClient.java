package presentation;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import businessLayer.ClientValidator;
import dataAccessLayer.ClientAccess;
import dataAccessLayer.ClientDAO;
import model.Client;
import model.TableHelper;
/**
 * Class that initializes the Client GUI.
 * @author mchir
 *
 */
public class GuiEditClient extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Constructor taht calls initComponents and shows taht initail data on the table.
	 */
	public GuiEditClient() {
		initComponents();
		showData(new Client(0, "", "", "", ""));
	}
	/**
	 * Method that initializes the GUI.
	 */
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		addClient = new javax.swing.JButton();
		editClient = new javax.swing.JButton();
		delClient = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		nameField = new javax.swing.JTextField();
		emailField = new javax.swing.JTextField();
		phoneField = new javax.swing.JTextField();
		adressField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		addClient.setText("Add Client");
		addClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addClientActionPerformed(evt);
			}
		});

		editClient.setText("Edit Client");
		editClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editClientActionPerformed(evt);
			}
		});

		delClient.setText("Delete Client");
		delClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				delClientActionPerformed(evt);
			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {}) {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jLabel1.setText("Name");

		jLabel2.setText("Email");

		jLabel3.setText("Phone Nr.");

		jLabel4.setText("Adress");
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
		jButton1.setFont(new java.awt.Font("Tahoma", 0, 18));
		jButton1.setText("Back");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
										.createSequentialGroup()
										.addGap(18, 18, 18)
										.addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel1)
														.addComponent(jLabel2).addComponent(jLabel3)
														.addComponent(jLabel4))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 290,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 290,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(adressField,
																javax.swing.GroupLayout.PREFERRED_SIZE, 290,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(phoneField,
																javax.swing.GroupLayout.PREFERRED_SIZE, 290,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147,
																Short.MAX_VALUE)
														.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
																108, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(delClient, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(editClient, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(addClient, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(42, 42, 42))
								.addGroup(
										layout.createSequentialGroup().addComponent(jScrollPane1).addContainerGap()))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(13, 13, 13).addComponent(addClient,
										javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(adressField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel4))
										.addContainerGap(26, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(editClient, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 53,
														Short.MAX_VALUE)
												.addComponent(delClient, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(16, 16, 16)))));

		pack();
	}// </editor-fold>
	/**
	 * Shows table data.
	 * @param object
	 */
	public void showData(Object object) {
		ArrayList<Object> list= new ClientAccess().getClientList();
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model = new TableHelper().showData(object, model,list);
		
	}
	/**
	 * Method used by addClient button as a listener.
	 * @param evt
	 */
	private void addClientActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ClientValidator val = new ClientValidator();
		val.insertClient(
				new Client(nameField.getText(), emailField.getText(), phoneField.getText(), adressField.getText()));
		showData(new Client(0, "", "", "", ""));

	}
	/**
	 * Method used by editClient button as a listener.
	 * @param evt
	 */
	private void editClientActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ClientValidator val = new ClientValidator();
		val.editClient(
				new Client(id, nameField.getText(), emailField.getText(), phoneField.getText(), adressField.getText()));
		showData(new Client(0, "", "", "", ""));
	}
	/**
	 * Method used by delClient button as a listener.
	 * @param evt
	 */
	private void delClientActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ClientDAO.delete(
				new Client(id, nameField.getText(), emailField.getText(), phoneField.getText(), adressField.getText()));
		showData(new Client(0, "", "", "", ""));
	}
	/**
	 * Method that is used by Client table as a listener.
	 * @param evt
	 */
	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
		int row = jTable1.rowAtPoint(evt.getPoint());
		id = Integer.parseInt(jTable1.getModel().getValueAt(row, 0).toString());
		nameField.setText(jTable1.getModel().getValueAt(row, 1).toString());
		emailField.setText(jTable1.getModel().getValueAt(row, 2).toString());
		phoneField.setText(jTable1.getModel().getValueAt(row, 3).toString());
		adressField.setText(jTable1.getModel().getValueAt(row, 4).toString());

	}
	/**
	 * Method used by BackBTN as a listener.
	 * @param evt
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
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

		this.dispose();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GuiStart().setVisible(true);
			}
		});
	}

	private int id = 5;
	private javax.swing.JButton addClient;
	private javax.swing.JButton jButton1;
	private javax.swing.JTextField adressField;
	private javax.swing.JButton delClient;
	private javax.swing.JButton editClient;
	private javax.swing.JTextField emailField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField nameField;
	private javax.swing.JTextField phoneField;

}
