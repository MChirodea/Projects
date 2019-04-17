package access;

import model.Report;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class DataAccess {

    private static final DataAccess INSTANCE = new DataAccess();

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    SessionFactory sessionFactory;
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    private DataAccess(){
        try {

            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            System.err.println("Error in hibernate: ");
            e.printStackTrace();
        }
    }

    public void initializeDB() {
        try (Session session = sessionFactory.openSession()) {
            //TODO: Don't forget beginTransaction/commit when doing *changes* on the data
            session.beginTransaction();
            User john = new User(20.5f, "Normal", "user", "user");
            session.save(john);
            session.save(new User(21.0f, "Admin", "admin", "admin"));
            session.save(new Report(john, "cocaine", 2));
            session.getTransaction().commit();
            session.close();
        }
    }


    public static DataAccess getInstance(){
        return INSTANCE;
    }
}
