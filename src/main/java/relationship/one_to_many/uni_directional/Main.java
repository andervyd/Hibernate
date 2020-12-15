package relationship.one_to_many.uni_directional;

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

/* // add
            Department department = new Department("MANAGER", 2400, 1800);

            Employee employeeFirst = new Employee("Ivan", "Tara", 1200);
            Employee employeeSecond = new Employee("John", "Lee", 1600);

            department.addEmployeeToDepartment(employeeFirst);
            department.addEmployeeToDepartment(employeeSecond);

            session.beginTransaction();

            session.save(department);
*/

/* // get all
            session.beginTransaction();

            Department department = session.get(Department.class, 3);

            List<Employee> list = department.getEmployees();
            for(Employee employee : list) {
                System.out.println(employee);
            }

            System.out.println(department);
//            System.out.println(department.getEmployees());
*/

// delete employee (if delete department = delete all employee)
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 6);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
