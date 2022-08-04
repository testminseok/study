public class ControlLabel {

	public static void main(String[] agrs) {
		ControlLabel control = new ControlLabel();
		control.printTimesTable();
	}
	
	public void printTimesTable() {
		labelTest:
		for (int i = 2; i < 10; i++) {
			
			if (i == 3) continue labelTest;
			for (int j = 1; j < 10; j++) {
				System.out.println( i + " * " + j + " = " + i * j);
			}
			
		}
	}
}