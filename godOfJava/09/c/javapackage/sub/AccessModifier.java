package c.javapackage.sub;

public class AccessModifier {
	
	// 어느패키지에서든 접근가능
	public void publicMethod() {
		
	}
	
	// 같은패키지 또는 상속받은경우에만 접근가능
	protected void protectedMethod() {
		
	}
	
	// 같은패키지에서만 접근가능
	void packagePrivateMethod() {
		
		
	}
	
	// 현재 클래스에서만 접근가능
	private void privateMethod() {
		
		
	}
}