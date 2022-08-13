package c.exception;

public class MultiCatchSample {
	
	public static void main(String[] args) {
		
		MultiCatchSample sample = new MultiCatchSample();
		sample.multiCatch();
	}
	
	public void multiCatch() {
		
		/*
			- try 다음에 오는 catch 블록은 1개 이상 있을수 있다.
			- 먼저 선언한 catch 블록의 예외 클래스가 다음에 선언한 catch 블록의 부모에 속하면, 자식에 속하는 catch 블록은 절대 실행될 일이 없으므로 컴파일이 되지않는다.
			- 하나의 try 블록에서는 예외가 발생하면 그 예외와 관련이 있는 catch 블록을 찾아서 실행한다.
			- catch 블록 중 발생한 예외와 관련있는 블록이 없으면, 예외가 발생되면서 해당 쓰레드는 끝난다.
				따라서, 마지막 catch 블록에는 Exception 클래스로 묶어주는 버릇을 들여 놓아야 안전한 프로그램이 될 수 있다.
		*/
		int[] intArray = new int[5];
		
		try {
			System.out.println(intArray[5]);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException occurred");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException occurred");
		} catch (Exception e) {
			System.out.println(intArray.length);
		} finally {
			System.out.println("Here is finally.");
		}
		
		System.out.println("This coid must run.");
	}
}