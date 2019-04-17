package presentation;



import javax.swing.table.DefaultTableModel;

import static javax.swing.JOptionPane.*;

import java.util.ArrayList;

import dataAccessLayer.ClientAccess;
import dataAccessLayer.OrderDAO;
import dataAccessLayer.ProductAccess;
import model.Client;
import model.Order;
import model.Product;
import model.TableHelper;
/**
 * Class that initializes the order GUI.
 */
public class  GuiCreateOrder extends javax.swing.JFrame {

 
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor that initializes the Order.
	 */
    public  GuiCreateOrder() {
        initComponents();
        showData(new Product(0,0,"",0));
        showData2(new Client(0, "", "", "", ""));
    }

    @SuppressWarnings({ "serial" })
    /**
     * Method that initializes components.                    
     */
    private void initComponents() {

    	  createBTN = new javax.swing.JButton();
          jScrollPane1 = new javax.swing.JScrollPane();
          jTable1 = new javax.swing.JTable();
          jScrollPane2 = new javax.swing.JScrollPane();
          jTable2 = new javax.swing.JTable();
          backBTN = new javax.swing.JButton();
          quantityField = new javax.swing.JTextField();
          jLabel1 = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          createBTN.setText("Create Order");
          createBTN.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  createBTNActionPerformed(evt);
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
          jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
              @Override
              public void mouseClicked(java.awt.event.MouseEvent evt) {
                  jTable2MouseClicked(evt);
              }
          });
          jTable2.setModel(new javax.swing.table.DefaultTableModel(
              new Object [][] {
                 
              },
              new String [] {

              }
          ) {
           
              public boolean isCellEditable(int rowIndex, int columnIndex) {
                  return false;
              }
          });
          jScrollPane2.setViewportView(jTable2);

          backBTN.setText("Back");
          backBTN.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  backBTNActionPerformed(evt);
              }
          });

          jLabel1.setText("Quantity:");

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                      .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                  .addGap(130, 130, 130)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(backBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addGap(29, 29, 29)
                          .addComponent(createBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addGap(13, 13, 13)))
                  .addContainerGap(33, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(35, 35, 35)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                      .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addGroup(layout.createSequentialGroup()
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addGap(18, 18, 18)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(backBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(createBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          pack();
      }// </editor-fold>                        

   /**
    * Method that shows the Product table through reflection.
    * @param obj
    */
    public void showData(Object obj){
    	ArrayList<Object> list= new ProductAccess().getPRList();
    	DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    	model = new TableHelper().showData(obj, model,list);
    }
    /**
     * Method that shows the Client Table through reflection.
     * @param object
     */
    public void showData2(Object object) {
    	ArrayList<Object> list= new ClientAccess().getClientList();
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model = new TableHelper().showData(object, model,list);
		
	}
      /**
       * Method that is used by createBtn as a listener.
       * @param evt
       */
      private void createBTNActionPerformed(java.awt.event.ActionEvent evt) {                                          
          // TODO add your handling code here:
    	  int k = OrderDAO.insert(new Order(idProduct,idClient,Integer.parseInt(quantityField.getText())));
    	  if( k == -5){
    		  showMessageDialog(null, "Insufficient Stock!", "WARNING", WARNING_MESSAGE);
    	  }else{
    		   showData(new Product(0,0,"",0));
    	       showData2(new Client(0, "", "", "", ""));
    	  }
      }                                         
      /**
       * Method that is used by Client Table as a listener.
       * @param evt
       */
      private void jTable1MouseClicked(java.awt.event.MouseEvent evt){
      	int row = jTable1.rowAtPoint(evt.getPoint());
      	idClient = Integer.parseInt(jTable1.getModel().getValueAt(row, 0).toString());
    
      }
      /**
       * Method used by Product table as a listener.
       * @param evt
       */
      private void jTable2MouseClicked(java.awt.event.MouseEvent evt){
        	int row = jTable2.rowAtPoint(evt.getPoint());
        	idProduct = Integer.parseInt(jTable2.getModel().getValueAt(row, 0).toString());
 
        }
      /**
       * Method used by backBTN as a listener.
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

      private int idClient;
      private int idProduct;
      private javax.swing.JButton backBTN;
      private javax.swing.JButton createBTN;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JScrollPane jScrollPane2;
      private javax.swing.JTable jTable1;
      private javax.swing.JTable jTable2;
      private javax.swing.JTextField quantityField;
                         
}
