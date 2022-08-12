package c.util;

import c.model.MemberDTO;

public class FinalReferenceType {
	
	final MemberDTO dto = new MemberDTO();
	
	public static void main(String[] args) {
		
		/*
			final 은 재할당을 할수 없는 키워드 이다.
			따라서 참조자료형의 경우 final이 붙은 변수에 재할당은 할 수 없지만
			할당된 참조자료형에 내부 상태를 변경은 가능하다.
		*/
		FinalReferenceType referenceType = new FinalReferenceType();
		referenceType.checkDTO();
	}
	
	public void checkDTO() {
		System.out.println(dto);
		
		// dto = new MemberDTO(); // 재할당의 경우 컴파일오류
		
		dto.name = "Sangmin"; // 정상처리
		System.out.println(dto);
	}
}