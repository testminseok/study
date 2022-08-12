package c.util;

/*
	인스턴스 변수나, 클래스 변수는 생성과동시에 초기화해야한다.
*/

public class FinalVariable {
	
	// final int instanceVariable; // 컴파일오류
	final int instanceVariable = 1; // 정상 
	
	public void method(final int parameter) {
		
		final int localVariable;
		
		localVariable = 2; // 지역변수의 final은 처음 할당할때에는 정상처리된다.
		//localVariable = 3; // 이후 재할당을 시도하면 컴파일 오류가 난다. 
		
		//parameter = 4; // 재할당을 시도하면 컴파일 오류가 난다. 
	}
}