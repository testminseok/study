public class ArrayLength {
	public static void main(String[] args) {
		ArrayLength array = new ArrayLength();
		array.printArrayLength();
		array.printArray();
	}
	
	public void printArrayLength() {
		
	}
	
	public void printArray() {
		int[][] twoDim = {{1,2,3}, {4,5,6}};
		System.out.println("twoDim.lenth = " + twoDim.length);
		System.out.println("twoDim[0].lenth = " + twoDim[0].length);
		
		// Bad 아래처럼 for문에서 length를 참조하는것은 성능상 좋지않다.
		//for (int i = 0; i < twoDim.length; i++) {
			//for (int j = 0; j < twoDim[i].length; j++) {
				//System.out.println("twoDim[" + i + "][" + j + "] = " + twoDim[i][j]);
			//}
		//}
		
		// Good
		int twoDimLength = twoDim.length;
		for (int i = 0; i < twoDimLength; i++) {
			int twoDim1Length = twoDim[i].length;
			for (int j = 0; j < twoDim1Length; j++) {
				System.out.println("twoDim[" + i + "][" + j + "] = " + twoDim[i][j]);
			}
		}
	}
}