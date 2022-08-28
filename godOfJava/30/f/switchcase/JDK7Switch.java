package f.switchcase;

public class JDK7Switch {
    public static void main(String[] args) {
        /*
        * JDK7 부터 Switch 문에 String 값 사용가능
        * */
        JDK7Switch switchSample = new JDK7Switch();
        System.out.println(switchSample.salaryIncreaseAmount(3));
    }

    private double salaryIncreaseAmount(int employeeLevel) {
        switch (employeeLevel) {
            case 1: // CEO
                return 10.0;
            case 2: // Manager :
                return 15.0;
            case 3: // Engineer, Developer:
                return 100.0;
            case 4: // Designer, Planner:
                return 20.0;
        }

        return 0.0;
    }

    private double salaryIncreaseAmount(String employeeLevel) {
        switch (employeeLevel) {
            case "CEO":
                return 10.0;
            case "Manager":
                return 15.0;
            case "Engineer":
            case "Developer":
                return 100.0;
            case "Designer":
            case "Planner":
                return 20.0;
        }

        return 0.0;
    }
}
