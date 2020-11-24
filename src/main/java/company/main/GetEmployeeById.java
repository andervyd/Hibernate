package company.main;

import company.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetEmployeeById {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory()) {

            Session session = factory.getCurrentSession();

            // added employee to table
            Employee employee = new Employee("Alex", "Volkov", "IT", 2400);

            session.beginTransaction();
            session.save(employee);
//            session.getTransaction().commit();

            // get employee by table
            int idEmployee = employee.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();

            Employee getEmployee = session.get(Employee.class, idEmployee); // id employee
            System.out.println(getEmployee);

            session.getTransaction().commit();






            System.out.println("Done");
        }
    }
}
