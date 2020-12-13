package relationship.one_to_one.uni_directional.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class)
                .buildSessionFactory();

             Session session = factory.getCurrentSession()) {

/* add employee:
            Employee employee = new Employee(
                    "Mary", "Lee", "HR", 2500);

            Detail detail = new Detail(
                    "Kiev", "+380979645634", "mary@mail.com");

            employee.setEmployeeDetail(detail);

            session.beginTransaction();

            session.save(employee);
*/

/* get employee:
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee + "\n" + employee.getEmployeeDetail());
*/

            // delete employee:
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
