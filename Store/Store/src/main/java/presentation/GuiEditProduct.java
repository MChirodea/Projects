package presentation;



import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businessLayer.ProductValidator;
import dataAccessLayer.ProductAccess;
import dataAccessLayer.ProductDAO;
import model.Product;
import model.TableHelper;
/**
 * Class that initializes the Product GUI.
 * @author mchir
 *
 */
public class GuiEditProduct extends javax.swing.JFrame {

	private static final long serialVersionUID = 6454214437471441741L;
	/**
	 * Constructor that initializes the Gui.
	 */
    public GuiEditProduct() {
        initComponents();
        showData(new Product(0,0,"",0));
    }

                         
    @SuppressWarnings("serial")
	private void initComponents() {

    	addProduct = new javax.swing.JButton();
        editProduct = new javax.swing.JButton();
        delProduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        priceField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backBTN = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addProduct.setText("Add Product");
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });

        editProduct.setText("Edit Product");
        editProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductActionPerformed(evt);
            }
        });

        delProduct.setText("Delete Product");
        delProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delProductActionPerformed(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
 
            },
            new String [] {

            }
        ) {
          
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Name");

        jLabel2.setText("Stock");

        backBTN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backBTN.setText("Back");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        jLabel3.setText("Price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(editProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(delProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
     }// </editor-fold>                        

  
    /**
     * Shows the Products in teh table, by using reflection.
     * @param obj
     */
    public void showData(Object obj){
    	ArrayList<Object> list= new ProductAccess().getPRList();
    	DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    	model = new TableHelper().showData(obj, model,list);
    }
    /**
     * Method that is used by the table as a mouse listener.
     * @param evt
     */
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt){
    	int row = jTable1.rowAtPoint(evt.getPoint());
    	id = Integer.parseInt(jTable1.getModel().getValueAt(row, 0).toString());
    	nameField.setText(jTable1.getModel().getValueAt(row, 2).toString());
    	priceField.setText(jTable1.getModel().getValueAt(row, 1).toString());
    	emailField.setText(jTable1.getModel().getValueAt(row, 3).toString());
     
    }
    /**
     * Method that is used by the addProduct button as listener.
     * @param evt
     */
     private void addProductActionPerformed(java.awt.event.ActionEvent evt) {                                           
         // TODO add your handling code here:
    	 ProductValidator val = new ProductValidator();
     	val.insertProduct(new Product(Integer.parseInt(priceField.getText()),nameField.getText(), Integer.parseInt(emailField.getText())));
     	showData(new Product(0,0,"",0));
     }                                          
     /**
      * Method that is used by the editProduct button as a listener.
      * @param evt
      */
     private void editProductActionPerformed(java.awt.event.ActionEvent evt) {                                            
         // TODO add your handling code here:
    	 ProductValidator val = new ProductValidator();
      	val.editProduct(new Product(id,Integer.parseInt(priceField.getText()),nameField.getText(), Integer.parseInt(emailField.getText())));
      	showData(new Product(0,0,"",0));
     }                                           
     /**
      * Method that is used by the backButton as a listener.
      * @param evt
      */
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
         
     	this.dispose();
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new GuiStart().setVisible(true);
             }
         });
     }                                       
     /**
      * Method taht is used by delProduct button as a listener.
      * @param evt
      */
     private void delProductActionPerformed(java.awt.event.ActionEvent evt) {                                           
         // TODO add your handling code here:
    	ProductDAO.delete(new Product(id,Integer.parseInt(priceField.getText()),nameField.getText(), Integer.parseInt(emailField.getText())));
      	showData(new Product(0,0,"",0));
     }                                          

     private int id = 0;            
     private javax.swing.JButton addProduct;
     private javax.swing.JButton backBTN;
     private javax.swing.JButton delProduct;
     private javax.swing.JButton editProduct;
     private javax.swing.JTextField emailField;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JTable jTable1;
     private javax.swing.JTextField nameField;
     private javax.swing.JTextField priceField;
                                     
}