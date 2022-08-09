public class ArrayTwoDimension {
	public static void main(String[] args) {
		
		ArrayTwoDimension dimension = new ArrayTwoDimension();
		dimension.twoDimensionArray();
	}
	
	public void twoDimensionArray() {
		
		int[][] twoDim = {{1,2,3}, {11,12,13}};
		
		/*
			이차원 배열은 행열로 이루어져있으며
			각 행또는 열은 선언한타입에 배열로 이루어져있다.
		*/
		
		System.out.println(twoDim[0][0]); // 1
		System.out.println(twoDim[1][0]); // 11
		
		System.out.println(twoDim[0][1]); // 2
		System.out.println(twoDim[1][1]); // 12
		
		System.out.println(twoDim[0][2]); // 3
		System.out.println(twoDim[1][2]); // 13
		
	}
}