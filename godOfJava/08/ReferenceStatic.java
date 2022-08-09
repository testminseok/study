public class ReferenceStatic {
	
	public static String name = "Min";
	
	public static void main(String[] args) {
		/*
			static 키워드를 사용하면 객체의 생성없이 사용할 수 있다.
			하지만, static 메서드에서는 static 키워드가 붙은 클래스 변수만 사용할 수 있으며, 
			그 외에는 static 메서드 내부에서 생성한 값, 매게변수만 사용가능하다.
			클래스변수로 만들경우 모든 개체에서 하나의 값을 바라본다. 
		*/
		ReferenceStatic.staticMethod();
		ReferenceStatic.staticMethodCallVariable();
	}
	
	public static void staticMethod() {
		System.out.println("This is a staticMethod");
	}
	
	public static void staticMethodCallVariable() {
		int data = 123;
		System.out.println(name);
		System.out.println(data);
	}
}