package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
//            Department department = new Department("IT", 300, 1200);
//            Employee employee1 = new Employee("Zaur", "Tregulov", 800);
//            Employee employee2 = new Employee("Elena", "Smirnova", 1000);
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            session.beginTransaction();
//            session.save(department);
//            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Department department1 = session.get(Department.class, 1);
            System.out.println(department1);
            System.out.println(department1.getEmployeeList());
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee3 = session.get(Employee.class, 1);
            System.out.println(employee3);
            System.out.println(employee3.getDepartment());
            session.delete(employee3);
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
