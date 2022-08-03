public class Variable {
	
	/*
		변수의 생명주기
		
		클래스변수 - 클래스가 처음 호출 될때 생성되고 자바 프로그램이 종료될때 사라진다.
		인스턴스변수 - 객체가 생성될때 생성되고 그 객체를 참조하고 있는 다른 객체가 없으면 소멸한다.
		매개변수 - 메서드가 호출될때 생성되고 메서드가 종료될때 소멸한다.
		지역변수 - 지역변수를 선언한 중괄호 내에서만 유효하다.
		
	*/
	static int a = 1; 
	int b; // 인스턴스 변수
	
	
	public void setB(int parameterB) {
		// parameterB는 매개변수
		
		int tempB = parameterB; // tempB는 지역변수
		b = tempB;
	}
}