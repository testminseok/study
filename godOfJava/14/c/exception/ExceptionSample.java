package c.exception;

public class ExceptionSample {
	
	public static void main(String[] args) {
		
		ExceptionSample sample = new ExceptionSample();
		// sample.arrayOutOfBounds();
		sample.arrayOutOfBoundsTryCatch();
	}
	
	public void arrayOutOfBounds() {
		
		int[] intArray = new int[5];
		
		System.out.println(intArray[5]);
	}
	
	public void arrayOutOfBoundsTryCatch() {

		/*
			try 내에 예외가 발생하지 않을경우
			try 내에 있는 모든 문장이 실행되고 try-catch 이후 처리문장도 실행된다.
			
			try 내에 예외가 발생한 경우
			예외가 발생한 즉시 try문에 다음 구분을 진행하지 않고 catch 내에 있는 처리문장을 실행하고 try-catch 이후 처리문장도 실행된다.
			
			- try문 안에서 예외가 발생했다고 try문 내에서 실행된 모든 문장이 무시되는것은 아니다. 예외가 발생하기 이전 처리구분들은 정상처리된다.
		*/
		try {
			int[] intArray = new int[5];
			
			System.out.println(intArray[5]);
			System.out.println("This code should run.");
		} catch (Exception e) {
			System.out.println("Exception occured.");
		}
		
		System.out.println("This code must run.");
	}
}