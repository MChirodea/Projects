package controller;
import access.DataAccess;
import model.Drug;
import model.Report;
import model.User;
import org.hibernate.Session;

import java.util.List;

public class AdminProvider implements IAdminProvider {

    @Override
    public List<User> getUsers() {
        return DataAccess.getInstance().getSessionFactory().openSession().createQuery("from User", User.class).list();
    }

    @Override
    public List<Drug> getDrugs() {
        return DataAccess.getInstance().getSessionFactory().openSession().createQuery("from Drug", Drug.class).list();
    }

    @Override
    public void create(Object obj) {
        try(Session session = DataAccess.getInstance().getSessionFactory().openSession()) {
            //TODO: Don't forget beginTransaction/commit when doing *changes* on the data
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(Object obj) {
        try(Session session = DataAccess.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(obj);
            if(obj instanceof User){
                List<Report> reports= session.createQuery("from Report where uid="+ ((User) obj).getId(), Report.class).list();
                for(Report report : reports ){
                    session.delete(report);
                }
            }
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void update(Object obj) {
        try(Session session = DataAccess.getInstance().getSessionFactory().openSession()) {
            //TODO: Don't forget beginTransaction/commit when doing *changes* on the data
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
            session.close();
        }
    }
}
