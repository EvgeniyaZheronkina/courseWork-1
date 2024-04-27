import java.util.Random;

public class Main {
    private static final Random random = new Random(1);

    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook(7);
        employeeBook.add("Sergeev David", 36000, 1);
        employeeBook.add("Gavrilov Sergey", 28300, 2);
        employeeBook.add("Ivanov Vlad", 45800, 1);
        employeeBook.printAll();
        System.out.println();
        employeeBook.delete(2);
        employeeBook.printAll();
        System.out.println(employeeBook.getSalarySum());
        System.out.println();

        System.out.println(employeeBook.getById(3));
        System.out.println(employeeBook.getById(2));
        employeeBook.add("Goncharenko Ivan", 41200, 3);
        employeeBook.printAllNames(1);
        System.out.println();
        employeeBook.printAllNames(2);
        System.out.println();
        employeeBook.printAllNames(3);
        System.out.println();
        System.out.println(employeeBook.getEmployeeWithMinSalary(1));
        employeeBook.changeSalaryByPercent(50, 3);
        employeeBook.printAll();
        employeeBook.add("Petrov Dmitriy", 28200, 3);


        System.out.println("Сумма затрат на ЗП в месяц = " + employeeBook.getSalarySum());
        System.out.println("Сотрудник с минимальной ЗП: " + employeeBook.getEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + employeeBook.getEmployeeWithMaxSalary());
        System.out.println("Срeднее значение ЗП: " + employeeBook.getAverageSalary());
        employeeBook.printAllNames();
        System.out.println();

        System.out.println("Сотрудник с минимальной ЗП в отделе: " + employeeBook.getEmployeeWithMinSalary(3));
        System.out.println("Сотрудник с максимальной ЗП в отделе: " + employeeBook.getEmployeeMaxSalary(3));
        System.out.println("Сумма затрат на ЗП в отделе: " + employeeBook.getSalarySum(1));
        System.out.println("Срeднее значение ЗП в отделе: " + employeeBook.getAverageSalary(1));
        System.out.println();
        System.out.println("Проиндексированная ЗП всех сотрудников отдела ");
        employeeBook.changeSalaryByPercent(20, 2);
        employeeBook.printAll();
        System.out.println();
        employeeBook.printAllNames(3);
        System.out.println();
        System.out.println("ФИО сотрудника с зарплатой меньше заданной: ");
        employeeBook.printAllSalaryLess(40000);
        System.out.println();
        System.out.println("ФИО сотрудника с зарплатой больше заданной: ");
        employeeBook.printAllSalaryMore(57000);
    }


}