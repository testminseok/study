package c.middle;

import java.util.function.Function;

public enum EmployeeTypes {
    OWNER(1, (Long salary) -> {
        return salary + (salary * -0.95);
    }),
    MANAGER(2, (Long salary) -> {
        return salary + (salary * 0.1);
    }),
    DESIGNER(3, (Long salary) -> {
        return salary + (salary * 0.2);
    }),
    ARCHITECT(4, (Long salary) -> {
        return salary + (salary * 0.3);
    }),
    DEVELOPER(5, (Long salary) -> {
        return salary + (salary * 1.0);
    });

    private int value;
    private Function<Long, Double> calculrateSalary;

    private EmployeeTypes(int value, Function<Long, Double> calculrateSalary) {
        this.value = value;
        this.calculrateSalary = calculrateSalary;
    }

    public int getValue() {
        return value;
    }

    public double getSalaryIncrease(long salary) {
        return this.calculrateSalary.apply(salary);
    }
}