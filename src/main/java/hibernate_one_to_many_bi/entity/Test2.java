package hibernate_one_to_many_bi.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
//            Department department = new Department("Sales", 800, 1500);
//            Employee employee1 = new Employee("Zaur", "Tregulov", 800);
//            Employee employee2 = new Employee("Elena", "Smirnova", 1500);
//            Employee employee3 = new Employee("Anton", "Sidorov", 1200);
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            department.addEmployeeToDepartment(employee3);
//            session.beginTransaction();
//            session.save(department);
//            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Get department");
            Department department1 = session.get(Department.class, 4);
            System.out.println("Show department");
            System.out.println(department1);
            System.out.println("Show employees");
            System.out.println(department1.getEmployeeList());
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
