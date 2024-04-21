import java.util.Random;

public class Main {
    private static final Employee[] employees = new Employee[10];
    private static final Random random = new Random(1);

    public static void main(String[] args) {
        for (int i = 0; i < employees.length; i++) {
            double salary = Math.round(20000 + 50000 * random.nextDouble());
            employees[i] = new Employee("ФИО сотрудника: " + i,
                    random.nextInt(1,6), salary);
        }

        printAll();
        System.out.println("Сумма затрат на ЗП в месяц = " + getSalarySum());
        System.out.println("Сотрудник с минимальной ЗП: " +getEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " +getEmployeeWithMaxSalary());
        System.out.println("Срeднее значение ЗП: " +getAverageSalary());
        printAllNames();
        System.out.println();

        System.out.println("Сотрудник с минимальной ЗП в отделе: " +getEmployeeWithMinSalary(2));
        System.out.println("Сотрудник с максимальной ЗП в отделе: " +getEmployeeWithMaxSalary(4));
        System.out.println("Сумма затрат на ЗП в отделе: " + getSalarySum(3));
        System.out.println("Срeднее значение ЗП в отделе: " +getAverageSalary(5));
        System.out.println();
        System.out.println("Проиндексированная ЗП всех сотрудников отдела ");
        changeSalaryByPercent(20,2);
        printAll();
        System.out.println();
        printAllNames(3);
        System.out.println();
        System.out.println("ФИО сотрудника с зарплатой меньше заданной: ");
        printAllSalaryLess(40000);
        System.out.println();
        System.out.println("ФИО сотрудника с зарплатой больше заданной: ");
        printAllSalaryMore(57000);
    }

    private static void printAll() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static double getSalarySum() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee getEmployeeWithMinSalary() {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() <= min.getSalary()) {
                min = employee;
            }
        }
        return min;
    }

    private static Employee getEmployeeWithMaxSalary() {
        Employee max = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() >= max.getSalary()) {
                max = employee;
            }
        }
        return max;
    }

    private static double getAverageSalary() {
        return getSalarySum() / employees.length;
    }

    private static void printAllNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    private static void changeSalaryByPercent(int percent) {
        for (Employee employee : employees) {
            double newSalary = employee.getSalary() + employee.getSalary() / 100.0 * percent;
            employee.setSalary(newSalary);
        }
    }

    private static Employee getEmployeeWithMinSalary(int department) {
        Employee min = null;
        for (Employee employee : employees) {
            if (department != employee.getDepartment()) {
                continue;
            }
            if (min == null || employee.getSalary() <= min.getSalary()) {
                min = employee;
            }
        }
        return min;
    }

    private static Employee getEmployeeWithMaxSalary(int department) {
        Employee max = null;
        for (Employee employee : employees) {
            if (department != employee.getDepartment()) {
                continue;
            }
            if (max == null || employee.getSalary() >= max.getSalary()) {
                max = employee;
            }
        }
        return max;
    }

    private static double getSalarySum(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (department != employee.getDepartment()) {
                continue;
            }
            if (department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static double getAverageSalary(int department) {
        int quantity = 0;
        double salarySum = 0;

        for (Employee employee : employees) {
            if (department != employee.getDepartment()) {
                continue;
            }
            quantity++;
            salarySum+=employee.getSalary();
        }
        return salarySum / quantity;
    }

    private static void changeSalaryByPercent(int percent, int department) {
        for (Employee employee : employees) {
            if (department != employee.getDepartment()) {
                continue;
            }
            double newSalary = employee.getSalary() + employee.getSalary() / 100.0 * percent;
            employee.setSalary(newSalary);
        }
    }

    private static void printAllNames(int department) {
        for (Employee employee : employees) {
            if (department != employee.getDepartment()) {
                continue;
            }
            System.out.println(employee.getFullName());
        }
    }

    private static void printAllSalaryMore(double salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println(String.format("id = %s, Сотрудник: %s, ЗП = %s",
                        employee.getId(), employee.getFullName(), employee.getSalary()));
            }
        }
    }

    private static void printAllSalaryLess(double salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(String.format("id = %s, Сотрудник: %s, ЗП = %s",
                        employee.getId(), employee.getFullName(), employee.getSalary()));
            }
        }
    }

}