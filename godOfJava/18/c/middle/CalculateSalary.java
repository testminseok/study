package c.middle;

public class CalculateSalary {

    public static void main(String[] args) {
        CalculateSalary calculateSalary = new CalculateSalary();
        calculateSalary.calculateSalaries();
    }

    public void getSalaryIncrease(Employee employee) {
        System.out.println(employee.getName() + " = " + employee.getType().getSalaryIncrease(employee.getSalary()));
    }

    public void calculateSalaries() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("LeeDaeRi", EmployeeTypes.OWNER, 1000000000L);
        employees[1] = new Employee("KimManager", EmployeeTypes.MANAGER, 100000000L);
        employees[2] = new Employee("WhangDesign", EmployeeTypes.DESIGNER, 70000000L);
        employees[3] = new Employee("ParkArchi", EmployeeTypes.ARCHITECT, 80000000L);
        employees[4] = new Employee("LeeDevelop", EmployeeTypes.DEVELOPER, 60000000L);

        for (Employee employee : employees) {
            getSalaryIncrease(employee);
        }
    }
}