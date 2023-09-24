package hibernate_one_to_maniy_uni;

import hibernate_one_to_maniy_uni.entity.Department;
import hibernate_one_to_maniy_uni.entity.Employee;
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
//            Department department = new Department("HR", 500, 1500);
//            Employee employee1 = new Employee("Oleg", "Ivanov", 800);
//            Employee employee2 = new Employee("Andrey", "Sidorov", 1000);
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
            Department department2 = session.get(Department.class, 1);
            session.delete(department2);
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
