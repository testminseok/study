package c.impl.enums;

public enum HealthInsurance {
	
	LEVEL_ONE(1000, 1.0),
	LEVEL_TWO(2000, 2.0),
	LEVEL_THREE(3000, 3.2),
	LEVEL_FOUR(4000, 4.5),
	LEVEL_FIVE(5000, 5.6),
	LEVEL_SIX(6000, 7.1);
	
	private final int maxSalary;
	private final double ratio;
	
	private HealthInsurance(int maxSalary, double ratio) {
		this.maxSalary = maxSalary;
		this.ratio = ratio;
	}
	
	public double getMaxSalary() {
		return maxSalary;
	}
	
	public double getRatio() {
		return ratio;
	}
	
	public static HealthInsurance getHealthInsurance(int salary) {
		if (LEVEL_ONE.getMaxSalary() >= salary) {
			return LEVEL_ONE;
		} else if (LEVEL_TWO.getMaxSalary() >= salary) {
			return LEVEL_TWO;
		} else if (LEVEL_THREE.getMaxSalary() >= salary) {
			return LEVEL_THREE;
		} else if (LEVEL_FOUR.getMaxSalary() >= salary) {
			return LEVEL_FOUR;
		} else if (LEVEL_FIVE.getMaxSalary() >= salary) {
			return LEVEL_FIVE;
		} else {
			return LEVEL_SIX;
		}
	}
	
	public static void main(String[] args) {
		int[] salaryArray = new int[] {1500, 5500, 8000};
		int salaryArrayLength = salaryArray.length;
		HealthInsurance[] insurances = new HealthInsurance[3];
		
		for (int i = 0; i < salaryArrayLength; i++) {
			insurances[i] = HealthInsurance.getHealthInsurance(salaryArray[i]);
		}
		
		for (int i = 0; i < salaryArrayLength; i++) {
			System.out.println(salaryArray[i] + " = " + insurances[i] + ", " + insurances[i].getRatio());
		}
		
	}
	
}