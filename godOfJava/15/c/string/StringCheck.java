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
		System.out.println("=================");
		sample.containsAddress(addresses);
		System.out.println("=================");
		sample.checkMatch();
		System.out.println("=================");
		sample.checkIndexOf();
		System.out.println("=================");
		sample.checkSplit();
		System.out.println("=================");
		sample.checkTrim();
		System.out.println("=================");
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
	
	public void checkIndexOf() {
		
		String text = "Java technology is both a programming language and a platform.";
		
		// indexOf는 왼쪽을 시작으로 오른쪽으로 탐색을 시작한다.
		System.out.println(text.indexOf('a'));
		System.out.println(text.indexOf("a "));
		System.out.println(text.indexOf('a', 20));
		System.out.println(text.indexOf("a ", 20));
		System.out.println(text.indexOf('z'));
		
		// lastIndexOf는 오른쪽을 시작으로 왼쪽으로 탐색을 시작한다.
		System.out.println(text.lastIndexOf('a'));
		System.out.println(text.lastIndexOf("a "));
		System.out.println(text.lastIndexOf('a', 20));
		System.out.println(text.lastIndexOf("a ", 20));
		System.out.println(text.lastIndexOf('z'));
		
	}
	
	public void checkSplit() {
		
		/*
			자바에서 문자열을 여러 개의 문자열의 배열로 나누는방법은 String.split()을 사용하는것과
			java.util.StringTokenizer를 사용하는것이 있다.
			
			- 정규식을 사용하며 문자열을 나눌려면 split() 을 그냥 특정문자열로 나눌려면 StringTokenizer를 사용하면 된다.
		*/
		String text = "Java technology is both a programming language and a platform.";
		String[] splitArray = text.split(" ");
		
		for (String value : splitArray) {
			System.out.println(value);
		}
		
	}
	
	public void checkTrim() {
		
		/*
			trim() 은 문자열에 양쪽 공백만 제거해준다. 문자와 문자 사이에 공백은 지워주지 않는다.
			
			문자열이 공백만으로 이루어져있는지, 공백을 제외한 값이 있는지 확인하는 용도로 자주사용된다.
		*/
		String[] strings = new String[] {
			" a", " b ", "   c", "d    ", "e      f", "    "
		};
		
		for (String value : strings) {
			System.out.println("[" + value + "]");
			System.out.println("[" + value.trim() + "]");
		}
		
	}
}