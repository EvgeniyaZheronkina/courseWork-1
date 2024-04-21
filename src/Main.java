import java.util.Random;

public class Main {
    private static final Employee[] employees = new Employee[10];
    private static final Random random = new Random(1);

    public static void main(String[] args) {
        for (int i = 0; i < employees.length; i++) {
            double salary = Math.round(20000 + 50000 * random.nextDouble());
            employees[i] = new Employee("ФИО сотрудника " + i,
                    random.nextInt(1,6), salary);
        }

        printAll();
        System.out.println("Сумма затрат на ЗП в месяц = " + getSalarySum());
        System.out.println("Сотрудник с минимальной ЗП: " +getEmploeeWitnMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " +getEmploeeWitnMaxSalary());
        System.out.println("Срeднее значение ЗП: " +getAwerageSalary());
        printAllNames();
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

    private static Employee getEmploeeWitnMinSalary() {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() <= min.getSalary()) {
                min = employee;
            }
        }
        return min;
    }

    private static Employee getEmploeeWitnMaxSalary() {
        Employee max = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() >= max.getSalary()) {
                max = employee;
            }
        }
        return max;
    }

    private static double getAwerageSalary() {
        return getSalarySum() / employees.length;
    }

    private static void printAllNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }
}