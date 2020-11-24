package company.main;

import company.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeByDataBase {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();


/*
            // search eployee by id
            Employee getEmployees = session.get(Employee.class, 1);
            // delete employee
            session.delete(getEmployees);

            // short version
            session.delete(session.get(Employee.class, 1));
*/

            // delete employe with HQL
            session.createQuery(
                    "DELETE Employee WHERE name = 'Oleg'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
