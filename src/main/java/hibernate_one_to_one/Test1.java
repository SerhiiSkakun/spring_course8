package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
//            Employee employee = new Employee("Zaur", "Tregulov", "IT", 500);
//            Detail detail = new Detail("Baku", "01234567", "zurtregulov@gmail.com");
            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
            Detail detail = new Detail("Moscow", "01234567", "olegka@gmail.com");
            employee.setEmployeeDetail(detail);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, 1);
            System.out.println(employee1.getEmployeeDetail());
            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee2 = session.get(Employee.class, 2);
//            session.delete(employee2);
//            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
