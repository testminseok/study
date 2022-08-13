package c.string;

public class StringCheck {
	
	public static void main(String[] args) {
		
		StringCheck sample = new StringCheck();
		String[] addresses = new String[] {
			"서울시 구로구 신도림동",
			"경기도 성남시 분당구 정자동 개발 공장",
			"서울시 구로구 개봉동"
		};
		sample.checkAddress(addresses);
		sample.containsAddress(addresses);
		sample.checkMatch();
	}
	
	public void checkAddress(String[] addresses) {
		
		int startCount = 0;
		int endCount = 0;
		String startText = "서울시";
		String endText = "동";
		
		/*
			startsWith와 endsWith 대신 indexOf를 사용할 수 있으나, indexOf는 전체 문자열을 확인해야하는 단점이있다.
		*/
		for (String address : addresses) {
			
			if (address.startsWith(startText)) {
				startCount++;
			}
			
			if (address.endsWith(endText)) {
				endCount++;
			}
			
		}
		
		System.out.println("Start with " + startText + " count is " + startCount);
		System.out.println("End with " + endText + " count is " + endCount);
		
	}
	
	public void containsAddress(String[] addresses) {
		
		int containCount = 0;
		String containText = "구로";
		
		for (String address : addresses) {
			
			if (address.contains(containText)) {
				containCount++;
			}
			
		}
		
		System.out.println("Contains " + containText + " count is " + containCount);
		
	}
	
	public void checkMatch() {
		
		/*
			regionMatches() 메서드는 아래와 같은 경우에는 결과가 무조건 false로 나온다.
			- toffset이 음수일때
			- ooffset이 음수일때
			- toffset + len이 비교 대상의 길이보다 클 때
			- ooffset + len이 other 객체의 길이보다 클 때
			- ignoreCase가 false인 경우에는 비교 범위의 문자들 중 같은 위치(index)에 있는 char가 다를때
			- ignoreCase가 true인 경우에는 비교 범위의 문자들을 모두 소문자로 변경한 후 같은 위치(index)에 있는 char가 달라야한다.
		*/
		String text = "This is a text";
		String compare1 = "is";
		String compare2 = "this";
		
		System.out.println(text.regionMatches(2, compare1, 0, 1));
		System.out.println(text.regionMatches(5, compare1, 0, 2));
		System.out.println(text.regionMatches(true, 0, compare2, 0, 4));
		
	}
}