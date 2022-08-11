package c.inheritance;

public class ChildOverriding extends ParentOverriding {
	public ChildOverriding() {
		System.out.println("ChildOverriding Constructor.");
	}
	
	public void printName() {
		System.out.println("printName() - ChildOverriding");
	}
}