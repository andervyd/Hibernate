package loading_types;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "max_salary")
    private double maxSalary;

    @Column(name = "min_salary")
    private double minSalary;

    @OneToMany(cascade = CascadeType.ALL,
                  mappedBy = "department",
                     fetch = FetchType.LAZY) // get only department (not his employee)
//                     fetch = FetchType.EAGER) // get department and all employees
    private List<Employee> employees;

    public Department() {
        // default
    }

    public Department(String departmentName, double maxSalary, double minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department [ id: " + id +
               ", department name: " + departmentName +
               ", max salary: " + maxSalary +
               ", min salary: " + minSalary + " ]";
    }

    public void addEmployeeToDepartment(Employee employee) {
        if(employees == null) {
            employees = new ArrayList<>();
        }

        employees.add(employee);

        employee.setDepartment(this);
    }
}
