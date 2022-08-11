package c.inheritance;

/*
	자바에서 상송을 받으려면 extends 키워드를 사용하여 상속받을 클래스를 지정해준다.
	상송을 받게 되면 부모에서 public, protected 로 선언된 필드와 메서드를 사용할 수있다.
*/
public class Child extends Parent {
	public Child() {
		System.out.println("Child Constructor.");
	}
}