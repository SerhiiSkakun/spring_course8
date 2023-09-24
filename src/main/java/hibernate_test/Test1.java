package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("name2", "surname", "department", 555);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, 1);
            session.getTransaction().commit();
            System.out.println(employee1);

            System.out.println("Done!");
        }
    }
}
