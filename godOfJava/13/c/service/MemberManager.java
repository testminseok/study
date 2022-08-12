package c.service;

import c.model.MemberDTO;

/*
	인터페이스는 클래스 선언과 다르게 public interface 인터페이스명 의 형식으로 선언하며
	내부에 선언된 메소드들은 구현부분이 있으면 안된다. 
	
	그러나, 자바 8 부터는 default method를 선언하여 구현부분을 작성할 수 있다.
*/
public interface MemberManager {
	
	public boolean addMember(MemberDTO member);
	public boolean removeMember(String name, String phone);
	public boolean updateMember(MemberDTO member);
	
}