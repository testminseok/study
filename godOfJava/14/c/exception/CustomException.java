package c.exception;

public class CustomException {
	
	public static void main(String[] args) {
		
		CustomException sample = new CustomException();
		try {
			sample.throwException(13);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	
	public void throwException(int number) throws MyException {
	
		try {
			if (number > 12) {
				throw new MyException("Number is over than 12");
			}
			
			System.out.println("Number is " + number);
		} catch (MyException e) {
			e.printStackTrace();
		}
	
	}
}