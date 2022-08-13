package c.exception;

public class ThrowSample {
	
	public static void main(String[] args) {
		
		ThrowSample sample = new ThrowSample();
		sample.throwException(13);
		sample.throwsException(13);
	}
	
	public void throwException(int number) {
		
		try {
			if (number > 12) {
				throw new Exception("Number is over than 12");
			}
			
			System.out.println("Number is " + number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
		메서드 내에서 별다른 예외를 처리하지 않을경우 throws 키워드를 사용해 발생할 수 있는 예외를 이 메소드를 호출한곳으로 넘길수 있다.
		이 메소드를 호출한 곳에서는 try-catch문으로 호출부분을 감싸주거나, 호출한 메소드에서도 throws할 수 있다.
		
		또한 예외가 여러개라면 ','(콤마)로 구분하여 여러개를 나열 할 수 있다.
	*/
	public void throwsException(int number) throws Exception {
				
		if (number > 12) {
			throw new Exception("Number is over than 12");
		}
		
		System.out.println("Number is " + number);
	
	}
}