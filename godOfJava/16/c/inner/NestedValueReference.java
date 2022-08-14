package c.inner;

public class NestedValueReference {
	
	public int publicInt = 0;
	protected int protectedInt = 1;
	int justInt = 2;
	private int privateInt = 3;
	static int staticInt = 4;
	
	static class StaticNested {
		
		public void setValue() {
			/*
				Static Nested Class 는 그것을 감싸고 있는 클래스의 static 필드만 접근이 가능하다. 
			*/
			staticInt = 14;
		}
		
	}
	
	class Inner {
		
		public void setValue() {
			
			/*
				Inner Class 는 그것을 감싸고 있는 클래스의 어느필드라도 접근이 가능하다.
				(InnerClass 를 사용하려면 그것을 감싸고 있는 클래스도 객체로 인스턴스화 해야하기때문에)
			*/
			publicInt = 20;
			protectedInt = 21;
			justInt = 22;
			privateInt = 23;
			staticInt = 24;
			
		}
	}
	
	public void setValue() {
		
		EventListener listener = new EventListener() {
			public void onClick() {
				
				publicInt = 30;
				protectedInt = 31;
				justInt = 32;
				privateInt = 33;
				staticInt = 34;
				
			}
		};
	}
}