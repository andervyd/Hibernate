package relationship.one_to_many.bi_directional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
/* add
            Department department = new Department("IT", 3600, 2400);

            Employee employeeFirst = new Employee("Ivan", "Tara", 2800);
            Employee employeeSecond = new Employee("Mary", "Brood", 2900);

            department.addEmployeeToDepartment(employeeFirst);
            department.addEmployeeToDepartment(employeeSecond);

            session.beginTransaction();

            session.save(department);

*/

/* get all
            session.beginTransaction();

            Department department = session.get(Department.class, 3);

            List<Employee> list = department.getEmployees();
            for(Employee employee : list) {
                System.out.println(employee);
            }

            System.out.println(department);
//            System.out.println(department.getEmployees());

*/

/* get employee => department
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 4);
            System.out.println(employee.getDepartment());
*/

            // delete employee
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 4);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
