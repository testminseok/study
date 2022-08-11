package c.inheritance;

public class Dog extends Animal {
	String name = "Dog";
	int legCount = 4;
	
	public void move() {
		System.out.println("개가 움직인다.");
	}
	
	public void eatFood() {
		System.out.println("사료를 우걱우걱 먹는다~");
	}
	
	public void bark() {
		System.out.println("개가 멍멍 짖다");
	}
}