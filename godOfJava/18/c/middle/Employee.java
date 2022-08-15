package c.middle;

public class Employee {
    private String name;
    private EmployeeTypes type;
    private long salary;

    public Employee(String name, EmployeeTypes type, long salary) {
        this.name = name;
        this.type = type;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeTypes getType() {
        return type;
    }

    public void setType(EmployeeTypes type) {
        this.type = type;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}