package c.javapackage;

import c.javapackage.sub.AccessModifier;

public class AccessCall {
	
	public static void main(String[] args) {
		
		AccessModifier accessModifier = new AccessModifier();
		
		accessModifier.publicMethod();
		accessModifier.protectedMethod(); // 접근 오류 
		accessModifier.packagePrivateMethod(); // 접근 오류
		accessModifier.privateMethod(); // 접근오류
	}
}