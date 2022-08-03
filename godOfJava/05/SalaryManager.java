public class SalaryManager {
	public static void main(String[] agrs) {
		
		SalaryManager manager = new SalaryManager();
		double monthSalary = manager.getMonthlySalary(20000000);
		System.out.println(monthSalary);
	}
	
	public double getMonthlySalary(int yearlySalary) {
		
		double monthSalary = yearlySalary / 12.0;
		double tax = calculateTax(monthSalary);
		double nationalPension = calculateNationalPension(monthSalary);
		double healthInsurance = calculateHealthInsurance(monthSalary);
		
		monthSalary -= (tax + nationalPension + healthInsurance);
		
		return monthSalary;
	}
	
	public double calculateTax(double monthSalary) {
		return monthSalary * 0.125;
	}
	
	public double calculateNationalPension(double monthSalary) {
		return monthSalary * 0.081;
	}
	
	public double calculateHealthInsurance(double monthSalary) {
		return monthSalary * 0.135;
	}
}