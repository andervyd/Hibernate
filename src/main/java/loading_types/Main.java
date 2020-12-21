package loading_types;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            System.out.println("\n  Get department ...");
            Department department = session.get(Department.class, 5);

            System.out.println("\n  Show department ...");
            System.out.println(department);

            System.out.println("\n  Show employees of the department ...");
            for(Employee employee : department.getEmployees()) {
                System.out.println(employee);
            }

            session.getTransaction().commit();
            System.out.println("\n  Done  \n");
        }
    }
}
/*  Output EAGER:
          Show department ...
        Department [ id: 5, department name: SUPPORT, max salary: 900.0, min salary: 1600.0 ]

          Show employees of the department ...
        Employee [ id: 8, name: John, surname: Morales, salary: 1400.0 ]
        Employee [ id: 9, name: Done, surname: Foster, salary: 1400.0 ]
        Employee [ id: 10, name: Sam, surname: Jackson, salary: 1300.0 ]

          Done

    Output LAZY:
          Show department ...
Department [ id: 5, department name: SUPPORT, max salary: 900.0, min salary: 1600.0 ]

  Show employees of the department ...
2020-Dec-21 05:37:13 AM [main] DEBUG org.hibernate.SQL - select employees0_.department_id as departme5_1_0_, employees0_.id as id1_1_0_, employees0_.id as id1_1_1_, employees0_.department_id as departme5_1_1_, employees0_.name as name2_1_1_, employees0_.salary as salary3_1_1_, employees0_.surname as surname4_1_1_ from new_employees employees0_ where employees0_.department_id=?
Hibernate: select employees0_.department_id as departme5_1_0_, employees0_.id as id1_1_0_, employees0_.id as id1_1_1_, employees0_.department_id as departme5_1_1_, employees0_.name as name2_1_1_, employees0_.salary as salary3_1_1_, employees0_.surname as surname4_1_1_ from new_employees employees0_ where employees0_.department_id=?
2020-Dec-21 05:37:13 AM [main] TRACE org.hibernate.type.descriptor.sql.BasicBinder - binding parameter [1] as [INTEGER] - [5]
2020-Dec-21 05:37:13 AM [main] TRACE org.hibernate.type.descriptor.sql.BasicExtractor - extracted value ([id1_1_1_] : [INTEGER]) - [8]

...

2020-Dec-21 05:37:13 AM [main] TRACE org.hibernate.type.descriptor.sql.BasicExtractor - extracted value ([departme5_1_0_] : [INTEGER]) - [5]
2020-Dec-21 05:37:13 AM [main] TRACE org.hibernate.type.descriptor.sql.BasicExtractor - extracted value ([id1_1_0_] : [INTEGER]) - [10]
Employee [ id: 8, name: John, surname: Morales, salary: 1400.0 ]
Employee [ id: 9, name: Done, surname: Foster, salary: 1400.0 ]
Employee [ id: 10, name: Sam, surname: Jackson, salary: 1300.0 ]

  Done

*///:~
