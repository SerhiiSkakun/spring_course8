package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
            Session session = sessionFactory.getCurrentSession())
        {
//            Employee employee = new Employee("Misha", "Sidorov", "HR", 850);
//            Detail detail = new Detail("London", "01234567", "misha@gmail.com");
//            detail.setEmployee(employee);

            Employee employee2 = new Employee("Nikolay", "Ivanov", "HR", 850);
            Detail detail2 = new Detail("New-York", "01234567", "Nikolay@gmail.com");
            detail2.setEmployee(employee2);
            employee2.setEmployeeDetail(detail2);

            session.beginTransaction();
            session.save(detail2);
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
