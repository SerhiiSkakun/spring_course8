package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            Section section1 = new Section("Football");
            Child child1 = new Child("Zaur", 5);
            Child child2 = new Child("Masha", 7);
            Child child3 = new Child("Vasia", 6);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);
            session.beginTransaction();
            session.persist(section1);
            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//            Section section2 = new Section("Volleyball");
//            Section section3 = new Section("Chess");
//            Section section4 = new Section("Math");
//            Child child4 = new Child("Igor", 10);
//            child4.addSectionToChild(section2);
//            child4.addSectionToChild(section3);
//            child4.addSectionToChild(section4);
//            session.beginTransaction();
//            session.save(child4);
//            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Section section5 = session.get(Section.class, 2);
//            System.out.println(section5);
//            System.out.println(section5.getChildren());
//            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Child child5 = session.get(Child.class, 5);
//            System.out.println(child5);
//            System.out.println(child5.getSections());
//            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Section section6 = session.get(Section.class, 2);
//            session.delete(section6);
//            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
