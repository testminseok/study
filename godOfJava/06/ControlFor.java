public class ControlFor {
	
	public static void main(String[] agrs) {
		
		ControlFor control = new ControlFor();
		control.forLoop(10);
	}
	
	public void forLoop(int until) {
		
		int sum = 0;
		for (int i = 1; i <= until; i++) {
			sum += i;
		}
		
		System.out.println("1 to " + until + " = " + sum);
	}
}