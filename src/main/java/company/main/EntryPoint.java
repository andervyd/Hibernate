package company.main;

import company.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class EntryPoint {
    public static void main(String[] args) {


        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory()) {

            Session session = factory.getCurrentSession();

            Employee employee = new Employee(
                    "Ivan", "Tara", "MANAGER", 2300);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
        }
    }
}
