import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class alienMain {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("M1");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setRam(32);
        l2.setModel("XPS");
        l2.setBrand("Dell");

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("M2");
        l3.setRam(8);

        Alien a1= new Alien();
        a1.setAid(101);
        a1.setAname("Kumar");
        a1.setTech("Python");

        Alien a2= new Alien();
        a2.setAid(102);
        a2.setAname("Mani");
        a2.setTech("Java");

        Alien a3= new Alien();
        a3.setAid(103);
        a3.setAname("Charan");
        a3.setTech("C++");


        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l2, l3));
        a3.setLaptops(Arrays.asList(l2));

        l1.setAliens(Arrays.asList(a1, a2));
        l2.setAliens(Arrays.asList(a2, a3));
        l3.setAliens(Arrays.asList(a1, a3));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        transaction.commit();


        session.close();

        Session session1 = sf.openSession();
        session1.close();

        sf.close();


    }
}
