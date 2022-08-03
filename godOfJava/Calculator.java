public class Calculator {
	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.add(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
		System.out.println(calculator.subtract(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
		System.out.println(calculator.multiply(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
		System.out.println(calculator.divide(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
	
	
	public int add(int a, int b) {
		
		return a + b;
	}
	
	public int subtract(int a, int b) {
		
		return a - b;
	}
	
	public int multiply(int a, int b) {
		
		return a * b;
	}
	
	public int divide(int a, int b) {
		
		return a / b;
	}
}