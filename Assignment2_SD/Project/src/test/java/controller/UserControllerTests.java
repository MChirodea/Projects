package controller;


import access.DataAccess;
import model.Drug;
import model.User;
import org.junit.jupiter.api.Test;
import view.IAdminGUI;
import view.IUserGUI;

import javax.swing.table.DefaultTableModel;

import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTests {


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
    public void successfulBuy(){
        IUserGUI userView = mock(IUserGUI.class);
        createDrug();
        createUser();
        when(userView.getAmmount()).thenReturn("1");
        User user = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from User where username='Mock'",User.class).getSingleResult();
        Drug drug = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from Drug where name='Mock'",Drug.class).getSingleResult();
        when(userView.getRowAt(0)).thenReturn(drug.getId());
        when(userView.getLog()).thenReturn(user.getId());
        UserController cntl = new UserController(userView);
        when(userView.getView()).thenReturn(new DefaultTableModel());
        cntl.buy();
        deleteDrug();
        deleteUser();
        verify(userView).showErrorMessage("Notice: Transaction successful!");

    }

    @Test
    public void errorBuyAmount(){
        IUserGUI userView = mock(IUserGUI.class);
        createDrug();
        createUser();
        when(userView.getAmmount()).thenReturn("not ok");
        User user = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from User where username='Mock'",User.class).getSingleResult();
        Drug drug = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from Drug where name='Mock'",Drug.class).getSingleResult();
        when(userView.getRowAt(0)).thenReturn(drug.getId());
        when(userView.getLog()).thenReturn(user.getId());
        UserController cntl = new UserController(userView);
        when(userView.getView()).thenReturn(new DefaultTableModel());
        cntl.buy();
        deleteDrug();
        deleteUser();
        verify(userView).showErrorMessage("Error: Invalid input!");
    }

    @Test
    public void errorBuyNoFunds(){
        IUserGUI userView = mock(IUserGUI.class);
        createDrug();
        createUser();
        when(userView.getAmmount()).thenReturn("1");
        User user = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from User where username='Mock'",User.class).getSingleResult();
        Drug drug = DataAccess.getInstance().getSessionFactory().openSession().createQuery("from Drug where name='Mock'",Drug.class).getSingleResult();
        when(userView.getRowAt(0)).thenReturn(drug.getId());
        when(userView.getLog()).thenReturn(user.getId());
        UserController cntl = new UserController(userView);
        when(userView.getView()).thenReturn(new DefaultTableModel());
        cntl.buy();
        cntl.buy();
        deleteDrug();
        deleteUser();
        verify(userView).showErrorMessage("Error: Not enough funds!");
    }




}
