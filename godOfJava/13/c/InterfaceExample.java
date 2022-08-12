package c;

import c.service.MemberManager;
import c.service.MemberManagerImpl;
import c.model.MemberDTO;

public class InterfaceExample {
	
	public static void main(String[] args) {
		/*
			인터페이스는 설계시 선언해 두면 개발을 진행할때 구현에만 집중할 수 있다.
			변수명, 메소드명을 미리 정해 놓기 때문에 개발자의 역량에 따른 메소드의 이름과 매개변수 선언의 격차를 줄일 수 있다.
			공통적인 인터페이스와 abstract 클래스를 선언해 놓으면 선언과 구현을 구분할 수 있다.
		*/
		
		MemberManager manager = new MemberManagerImpl(); // MemberManager와 MemeberMenagerImpl은 상속관계이기 때문에 MemeberManager타입으로 선언할 수 있다.
		
		MemberDTO member = new MemberDTO("Min", "010XXXXXXXX", "abcd@godofjava.com");
		System.out.println(manager.addMember(member));
	}
}