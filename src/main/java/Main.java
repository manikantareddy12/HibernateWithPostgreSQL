import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();

        s1.setsName("Chetan");
        s1.setRollNo(108);
        s1.setsAge(12);

//        Configuration cfg  = new Configuration();
//        cfg.addAnnotatedClass(Student.class);
//        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        Student s2 = session.get(Student.class,102 );

        session.remove(s2);

        transaction.commit();

        session.close();
        sf.close();
        System.out.println(s2);

        }
    }
