import java.util.Objects;

public class Employee {
   private static long COUNTER =1L;

    private final String fullName;
    private int department;
    private double salary;
    private final long id;


    public Employee(String fullName, int department, double salary) {
        this.id = COUNTER++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(salary, employee.salary) == 0 && Objects.equals(fullName, employee.fullName) && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

    @Override
    public String toString() {
        return "Employee {" +
                "fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }


}
