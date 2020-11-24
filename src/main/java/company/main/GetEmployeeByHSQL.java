package company.main;

import company.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class GetEmployeeByHSQL {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory()) {

            Session session = factory.getCurrentSession();

            session.beginTransaction();

/*            // all list employee to table
            List<Employee> listEmployees = session.createQuery("from Employee")
                    .getResultList();
*/

            // all list employees where name employee is Oleg
            List<Employee> listEmployees = session.createQuery(" FROM Employee WHERE name = 'Oleg'")
                    .getResultList(); // 'name' is field of class Employee


            for(Employee employees : listEmployees) {
                System.out.println(employees);
            }



            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
