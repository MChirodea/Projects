package presentation;

/**
 * Class that Initializez the Starting GUI.
 * @author mchir
 *
 */
public class GuiStart extends javax.swing.JFrame {

	private static final long serialVersionUID = -4477484969419426593L;
	/**
	 * Constructor that initializes the gui.
	 */
	public GuiStart() {
        initComponents();
    }
	/**
	 * Method that when called, initializes the gui.
	 */
    private void initComponents() {

    	   clientBTN = new javax.swing.JButton();
           orderBTN = new javax.swing.JButton();
           productBTN = new javax.swing.JButton();
           label1 = new javax.swing.JLabel();

           setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

           clientBTN.setText("Clients");
           clientBTN.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   clientBTNActionPerformed(evt);
               }
           });

           orderBTN.setText("New Order");
           orderBTN.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   orderBTNActionPerformed(evt);
               }
           });

           productBTN.setText("Products");
           productBTN.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   productBTNActionPerformed(evt);
               }
           });

           label1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
           label1.setText("Store Editor");

           javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
           getContentPane().setLayout(layout);
           layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                   .addContainerGap()
                   .addComponent(clientBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                   .addComponent(orderBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addGap(44, 44, 44)
                   .addComponent(productBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addContainerGap())
               .addGroup(layout.createSequentialGroup()
                   .addGap(138, 138, 138)
                   .addComponent(label1)
                   .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
           );
           layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                   .addGap(98, 98, 98)
                   .addComponent(label1)
                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       .addComponent(clientBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(orderBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(productBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGap(29, 29, 29))
           );

           pack();
    }
    /**
     * Method used by clientBTN as a listener.
     * @param evt
     */
    private void clientBTNActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiEditClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiEditClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiEditClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiEditClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiEditClient().setVisible(true);
            }
        });
    }                                        
    /**
     * Method htat is uded by OrderBTN as a listener
     * @param evt
     */
    private void orderBTNActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	 try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger( GuiCreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger( GuiCreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger( GuiCreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger( GuiCreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>

         this.dispose();
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new  GuiCreateOrder().setVisible(true);
             }
         });
    }                                        
    /**
     * Method that is used by Product button as a listener.
     * @param evt
     */
    private void productBTNActionPerformed(java.awt.event.ActionEvent evt) {                                         

    	  // TODO add your handling code here:
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiEditProduct().setVisible(true);
            }
        });
    }                                        

    /**
     * The main Method, this is where the whole project starts.
     * @param args
     */
    public static void main(String args[]) {

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
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiStart().setVisible(true);
            }
        });
    }

                  
    private javax.swing.JButton clientBTN;
    private javax.swing.JButton orderBTN;
    private javax.swing.JButton productBTN;
    private javax.swing.JLabel label1;
                  
}
