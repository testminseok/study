public class ManageHeight {
	
	int[][] gradeHeights;
	
	public static void main(String[] args) {
		ManageHeight manage = new ManageHeight();
		manage.setData();
		
		int gradeHeightsLength = manage.gradeHeights.length;
		
		for (int i = 0; i < gradeHeightsLength; i++) {
			manage.printHeight(i);
		}
		
		for (int i = 0; i < gradeHeightsLength; i++) {
			manage.printAverage(i);
		}
	}
	
	public void setData() {
		
		gradeHeights = new int[5][];
		gradeHeights[0] = new int[] {170, 180, 173, 175, 177};
		gradeHeights[1] = new int[] {160, 165, 167, 186};
		gradeHeights[2] = new int[] {158, 177, 187, 176};
		gradeHeights[3] = new int[] {173, 182, 181};
		gradeHeights[4] = new int[] {170, 180, 165, 177, 172};
	}
	
	public void printAverage(int classNo) {
		
		double totalHeigthAverage = 0.0;
		int classTotalStudent = gradeHeights[classNo].length;
		
		System.out.println("Class No.:" + (classNo + 1));
		
		for (int i = 0; i < classTotalStudent; i++) {
			totalHeigthAverage += gradeHeights[classNo][i];
		}
		
		System.out.println(totalHeigthAverage / classTotalStudent);
	}
	
	public void printHeight(int classNo) {
		
		int classTotalStudent = gradeHeights[classNo].length;
		
		
		System.out.println("Class No.:" + (classNo + 1));
		for (int i = 0; i < classTotalStudent; i++) {
			System.out.println(gradeHeights[classNo][i]);
		}
	}
}