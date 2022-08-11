package c.inheritance;

public class Cat extends Animal {
	String name = "Cat";
	int legCount = 4;
	
	public void move() {
		System.out.println("고양이가 움직인다.");
	}
	
	public void eatFood() {
		System.out.println("생성을 냠냠 먹는다~");
	}
	
	public void bark() {
		System.out.println("고양이가 야옹하며 짖다.");
	}
}