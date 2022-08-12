package c.service;

import c.model.MemberDTO;

/*
	인터페이스는 클래스 선언과 다르게 public interface 인터페이스명 의 형식으로 선언하며
	내부에 선언된 메소드들은 구현부분이 있으면 안된다. 
	
	그러나, 자바 8 부터는 default method를 선언하여 구현부분을 작성할 수 있다.
	
	여기서 문득 그러면 default method를 사용할 수 있다면 인터페이스와 추상클래스가 다른게 뭐지 라는 궁금증이 들어 찾아보았다.
	
	우선 인터페이스는 상수를 제외한 필드를 가질 수 없기때문에 상태를 관리할 수 없다. 추상클래스는 가능.
	인터페이스는 다중상속이 가능하지만 추상클래스는 단일 상속만 가능하다. (인터페이스는 클래스로 구현하거나, 인터페이스로 확장이 가능하지만, 추상클래스는 확장만 가능하다.)
	서로 다른 목적을 가진다. 인터페이스는 구현에 목적이 있지만, 추상클래스는 확장에 목적이 있다.
	인터페이스는 생성자가 없지만 추상클래스는 생성자를 정의할 수 있다.
	인터페이스는 Object 클래스에 메소드들을 사용할 수 없다.
	
*/
public interface MemberManager {
	
	String color = "";
	
	public boolean addMember(MemberDTO member);
	public boolean removeMember(String name, String phone);
	public boolean updateMember(MemberDTO member);
	
}