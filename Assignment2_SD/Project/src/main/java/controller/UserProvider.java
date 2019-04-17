package controller;

import access.DataAccess;
import model.Drug;
import model.Report;
import model.User;
import org.hibernate.Session;

import java.util.List;

public class UserProvider implements IUserProvider{
    @Override
    public int buy(Long logID, Long id, int ammount) {
        try(Session session = DataAccess.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Drug> drugs = session.createQuery("from Drug where id="+id, Drug.class).list();
            List<User> users = session.createQuery("from User where id="+logID, User.class).list();
            if(drugs.get(0).getStock() -  ammount >= 0){
                if(users.get(0).getWallet() - (drugs.get(0).getPrice() * (float)ammount) >= 0.0f){
                    User John = users.get(0);
                    John.setWallet(John.getWallet() - (drugs.get(0).getPrice() * (float)ammount));
                    Drug drug = drugs.get(0);
                    drug.setStock(drug.getStock() -  ammount);
                    session.update(John);
                    session.update(drug);
                    session.getTransaction().commit();
                    session.close();
                    return 0;
                }else{
                    return 1;
                }
            }else{
                return 2;
            }
        }
    }

    @Override
    public List<Drug> getDRUGS() {
        return DataAccess.getInstance().getSessionFactory().openSession().createQuery("from Drug", Drug.class).list();
    }

    @Override
    public void report(Long logID, String drug, Integer amount) {
        try(Session session = DataAccess.getInstance().getSessionFactory().openSession()) {
            //TODO: Don't forget beginTransaction/commit when doing *changes* on the data
            User user = session.createQuery("from User where id="+logID,User.class).getSingleResult();
            session.beginTransaction();
            session.save(new Report(user,drug,amount));
            session.getTransaction().commit();
            session.close();
        }
    }
}
