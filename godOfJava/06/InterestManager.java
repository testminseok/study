public class InterestManager {
	
	public static void main(String[] args) {
		
		InterestManager manager = new InterestManager();
		
		for (int i = 1; i <= 365; i+= 1) {
			System.out.println(manager.calculateAmount(i, 1000000));
		}
		
	}
	
	public double getInterestRate(int day) {
		
		if (day > 0 && day <= 90) {
			return 0.005;
		} else if (day >= 91 && day <= 180) {
			return 0.01;
		} else if (day >= 181 && day <= 364) {
			return 0.02;
		} else {
			return 0.056;
		}
	}
	
	public double calculateAmount(int day, long amount) {
		return amount + getInterestRate(day);
	}
}