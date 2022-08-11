package c.inheritance;

public class InheritanceOverriding {
	
	public static void main(String[] args) {
		/*
			부모자식간에 메서드 오버라이딩은 접근제어자, 리턴타입, 메서드명, 매개변수 수와 타입이 동일해야 성립한다.
			접근제어자의 경우 다를 수 있지만, 부모의 접근제어자 보다 작은 범위를 자식메서드에서 설정할 수 없다. ( 부모 public 자식 private 로 오버라이딩 하려고 할경우 컴파일 오류)
		*/
		ChildOverriding child = new ChildOverriding();
		child.printName();
	}
}