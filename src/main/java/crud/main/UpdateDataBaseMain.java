package crud.main;

import crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateDataBaseMain {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

/*
            // change salary by employee = id 1
            Employee idEmployee = session.get(Employee.class, 1);
            idEmployee.setSalary(2800);
*/

            // change salary for name
            session.createQuery(
                    "UPDATE Employee SET salary = 2300 WHERE name = 'Oleg'").executeUpdate();


            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
