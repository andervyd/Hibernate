package relationship.one_to_one.bi_directional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

/* add to table:
            Employee employee = new Employee("Ivan", "Tara", "IT", 3200);
            Detail detail = new Detail("Kiev", "+380674321232", "ivan@mail.com");

            employee.setEmployeeDetail(detail);
            detail.setEmployee(employee);

            session.beginTransaction();

            session.save(detail);
*/

/* get info:
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 1);
            System.out.println(detail.getEmployee() + "\n" + detail);
*/

/* delete employee with detail:
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 1);
            session.delete(detail);
*/

            // delete only detail
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 3);
            detail.getEmployee().setEmployeeDetail(null);
            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
