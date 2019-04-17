package controller;

import access.DataAccess;
import model.User;
import org.hibernate.Session;

import java.util.List;

public class LoginProvider implements ILoginProvider{
    @Override
    public User login(String usern, String password) {
        try(Session session = DataAccess.getInstance().getSessionFactory().openSession()) {
            List<User> users = session.createQuery("from User where username='"+usern +"'", User.class).list();
            for(User user: users){
                if(user.getPassword().equals(password)) {
                    return user;
                }
            }
            return null;
        }
    }
}
