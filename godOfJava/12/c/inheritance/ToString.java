package c.inheritance;

public class ToString {
	
	public static void main(String[] args) {
		/*
			모든 클래스는 Object클래스를 상속받았으며, 
			Object클래스에는 객체를 처리하기위한 메소드와 쓰레드를 처리하기 위한 메소드로 나누어져있다.
			toString 의 경우 기본적으로는 getClass().getName() + '@' + Integer.toHexString(hashCode()); 로 이루어져있으나,
			재정의하여 사용하는것이 좋다. 
			
			toString 메소드가 자동으로 호출되는경우는
			System.out.println() 메소드에 매개변수로 들어갔을경우와
			객체에 대하여 더하기 연산을 하는 경우이다.
		*/
		ToString thisObject = new ToString();
		thisObject.toStringMethod();
	}
	
	public void toStringMethod() {
		System.out.println(this);
		System.out.println(toString());
		System.out.println("plus " + this);
	}
	
	public String toString() {
		return "ToString Class";
	}
}