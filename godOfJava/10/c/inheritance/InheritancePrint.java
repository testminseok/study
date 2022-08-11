package c.inheritance;

public class InheritancePrint {
	
	public static void main(String[] args) {
		/*
			확장을 한 클래스가 생성자를 호출하면 자동으로 부모클래스의 기본생성자를 호출한다.(클래스를 확장할려면 부모클래스에는 기본생성자를 만들어줘야한다.)
			기본생성자를 만들지 못하는 경우는 자식클래스에서 명시적으로 super(매개변수); 를 호출해줘야한다.
		*/
		Child child = new Child();
		child.printName();
	}
}