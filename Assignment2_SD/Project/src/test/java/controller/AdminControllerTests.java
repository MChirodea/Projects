package controller;


import access.DataAccess;
import model.Drug;
import model.User;
import org.junit.jupiter.api.Test;
import view.IAdminGUI;

import javax.swing.table.DefaultTableModel;

import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AdminControllerTests {
    @Test
    public void createUser(){
        IAdminGUI adminView = mock(IAdminGUI.class);
        when(adminView.getWalletName()).thenReturn("10.99");
        when(adminView.getDrugAccType()).thenReturn("Normal");
        when(adminView.getUsernamePrice()).thenReturn("Mock") ;
        when(adminView.getPasswordStock()).thenReturn("Mock");
        when(adminView.getView(2)).thenReturn(new DefaultTableModel());
        AdminController adm = new AdminController(adminView);
        adm.addCreate(false);

    }

    @Test
    public void createDrug(){
        IAdminGUI adminView = mock(IAdminGUI.class);
        when(adminView.getWalletName()).thenReturn("Mock");
        when(adminView.getDrugAccType()).thenReturn("Legal");
        when(adminView.getUsernamePrice()).thenReturn("10.99") ;
        when(adminView.getPasswordStock()).thenReturn("10");
        when(adminView.getView(1)).thenReturn(new DefaultTableModel());
        AdminController adm = new AdminController(adminView);
        adm.addCreate(true);
    }

    @Test
    public void updateUser(){
        IAdminGUI adminView = mock(IAdminGUI.class);
        when(adminView.getWalletName()).thenReturn("0");
        when(adminView.getDrugAccType()).thenReturn("Normal");
        when(adminView.getUsernamePrice()).thenReturn("Mock") ;
        when(adminView.getPasswordStock()).thenReturn("Mock");

        when(adminView.getView(2)).thenReturn(new DefaultTableModel());
        AdminController adm = new AdminController(adminView);
        adm.addCreate(false);
        User user = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from User where username='Mock'",User.class).getSingleResult();
        when(adminView.getRowAt(0)).thenReturn(user.getId());
        adm.update(false);
    }

    @Test
    public void updateDrug(){
        IAdminGUI adminView = mock(IAdminGUI.class);
        when(adminView.getWalletName()).thenReturn("Mock");
        when(adminView.getDrugAccType()).thenReturn("Mock");
        when(adminView.getUsernamePrice()).thenReturn("10.99") ;
        when(adminView.getPasswordStock()).thenReturn("10");
        when(adminView.getView(1)).thenReturn(new DefaultTableModel());
        AdminController adm = new AdminController(adminView);
        adm.addCreate(true);
        Drug drug = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from Drug where name='Mock'",Drug.class).getSingleResult();
        when(adminView.getRowAt(0)).thenReturn(drug.getId());
        adm.update(true);
    }


    @Test
    public void deleteUser(){
        IAdminGUI adminView = mock(IAdminGUI.class);
        when(adminView.getWalletName()).thenReturn("0");
        when(adminView.getDrugAccType()).thenReturn("Normal");
        when(adminView.getUsernamePrice()).thenReturn("Mock") ;
        when(adminView.getPasswordStock()).thenReturn("Mock");
        when(adminView.getView(2)).thenReturn(new DefaultTableModel());
        AdminController adm = new AdminController(adminView);
        List<User> users = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from User where username='Mock'",User.class).list();
        for(User user : users){
            when(adminView.getRowAt(0)).thenReturn(user.getId());
            adm.delete(false);
        }

    }

    @Test
    public void deleteDrug(){
        IAdminGUI adminView = mock(IAdminGUI.class);
        when(adminView.getWalletName()).thenReturn("Mock");
        when(adminView.getDrugAccType()).thenReturn("Mock");
        when(adminView.getUsernamePrice()).thenReturn("10.99") ;
        when(adminView.getPasswordStock()).thenReturn("10");
        when(adminView.getView(1)).thenReturn(new DefaultTableModel());
        AdminController adm = new AdminController(adminView);
        List<Drug> drugs = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from Drug where name='Mock'",Drug.class).list();
        for(Drug drug : drugs){
            when(adminView.getRowAt(0)).thenReturn(drug.getId());
            adm.delete(true);
        }
    }

    @Test
    public void createUserError(){
        IAdminGUI adminView = mock(IAdminGUI.class);
        when(adminView.getWalletName()).thenReturn("not ok");
        when(adminView.getDrugAccType()).thenReturn("Normal");
        when(adminView.getUsernamePrice()).thenReturn("Mock") ;
        when(adminView.getPasswordStock()).thenReturn("Mock");
        when(adminView.getView(2)).thenReturn(new DefaultTableModel());
        AdminController adm = new AdminController(adminView);
        adm.addCreate(false);
        verify(adminView).showErrorMessage("Error: Invalid wallet!");

    }

    @Test
    public void createDrugStockError(){
        IAdminGUI adminView = mock(IAdminGUI.class);
        when(adminView.getWalletName()).thenReturn("Mock");
        when(adminView.getDrugAccType()).thenReturn("Legal");
        when(adminView.getUsernamePrice()).thenReturn("10.99") ;
        when(adminView.getPasswordStock()).thenReturn("not ok");
        when(adminView.getView(1)).thenReturn(new DefaultTableModel());
        AdminController adm = new AdminController(adminView);
        adm.addCreate(true);
        verify(adminView).showErrorMessage("Error: Invalid stock!");

    }

    @Test
    public void createDrugPriceError(){
        IAdminGUI adminView = mock(IAdminGUI.class);
        when(adminView.getWalletName()).thenReturn("Mock");
        when(adminView.getDrugAccType()).thenReturn("Legal");
        when(adminView.getUsernamePrice()).thenReturn("not ok") ;
        when(adminView.getPasswordStock()).thenReturn("10");
        when(adminView.getView(1)).thenReturn(new DefaultTableModel());
        AdminController adm = new AdminController(adminView);
        adm.addCreate(true);
        verify(adminView).showErrorMessage("Error: Invalid price!");

    }
}
