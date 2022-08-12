package c.service;

import c.model.MemberDTO;

/*
	추상 클래스는 구현부를 가진 메서드를 선언해 놓을 수 있으며, 
	생성자를 통한 상태주입이 가능하다. 
*/
public abstract class MemberManagerAbstract {
	
	public abstract boolean addMember(MemberDTO member);
	public abstract boolean removeMember(String name, String phone);
	public abstract boolean updateMember(MemberDTO member);
	
	public void printLog(String data) {
		System.out.println("Data = " + data);
	}
}