package relationship.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class).addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

/* add
            Section section = new Section("Football");

            Child child1 = new Child("Ivan", 5);
            Child child2 = new Child("Oleg", 6);
            Child child3 = new Child("Alex", 6);

            section.addChildToSection(child1);
            section.addChildToSection(child2);
            section.addChildToSection(child3);

            Section section1 = new Section("Swimming");
            Section section2 = new Section("Chess");

            Child child = new Child("Olga", 7);

            child.addSectionToChild(section1);
            child.addSectionToChild(section2);

            session.save( ... );
            session.persist( ... );

*/

/* get
            Section section = session.get(Section.class, 1);

            System.out.println(section);

            for(Child child : section.getChildList()) {
                System.out.println(child);
            }
*/

// delete
            session.beginTransaction();

            Child child = session.get(Child.class, 1);
            session.delete(child);

            Section section = session.get(Section.class, 14);
            session.delete(section);


            session.getTransaction().commit();
            System.out.println("\n  Done  \n");
        }
    }
}