package c.util;

/*
	final 이 클래스에 있을경우 상속이 되지 않는다.
*/
public final class FinalClass {
	
	/*
		final이 메소드에 있을경우는 Overriding을 할 수 없다. 
	*/
	public final void printLog(String data) {
		System.out.println("Data = " + data);
	}
}