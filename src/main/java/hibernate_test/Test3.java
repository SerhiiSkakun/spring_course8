package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            employee.setSalary(450);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("from Employee where firstName = 'name' AND salary > 500")
                    .getResultList()
                    .forEach(System.out::println);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Employee set salary = 1000 where firstName = 'name' AND salary > 500").executeUpdate();
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete Employee where firstName = 'name' AND salary > 500").executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
