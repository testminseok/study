public class Operators {
	public static void main(String[] agrs) {
		
		Operators operator = new Operators();
		
		operator.additivie();
		operator.multiplicative();
		operator.divideInt();
		operator.divideInt2();
		
	}
	
	public void additivie() {
		
		int value1 = 5;
		int value2 = 10;
		int result = value1 + value2;
		
		System.out.println(result);
		
		result = value2 - value1;
		
		System.out.println(result);
	}
	
	public void multiplicative() {
		
		int value1 = 5;
		int value2 = 10;
		int result = value1 * value2;
		
		System.out.println(result);
		
		result = value2 / value1;
		
		System.out.println(result);
	}
	
	public void divideInt() {
		/*
			int형은 정수 이기때문에 결과가 소수형이라도 정수로 나온다.
		*/
		int value1 = 5;
		int value2 = 10;
		int result = value1 / value2;
		
		System.out.println(result);
	}
	
	public void divideInt2() {
		/*
			예상하는 0.5 를 출력하기 위해선 아래와 같이 자료형은 double형으로 변경하여 계산한다.
		*/
		double value1 = 5;
		double value2 = 10;
		double result = value1 / value2;
		
		System.out.println(result);
	}
	
	public void remainder() {
		
		int value1 = 53;
		int value2 = 10;
		int result = value1 % value2;
		
		System.out.println(result);
	}
	
	
}