package c.string;

public class StringCompare {
	
	public static void main(String[] args) {
		
		StringCompare sample = new StringCompare();
		sample.checkString();
		sample.checkCompare();
		sample.checkCompareTo();
	}
	
	public void checkString() {
		
		String text = "한글의 길이를 알아보자";
		System.out.println("text.length() = " + text.length());
		System.out.println("text.isEmpty() = " + text.isEmpty());
		
	}
	
	public void checkCompare() {
		
		String text = "Check value";
		String text2 = "Check value";
		
		/*
			text == text2 가 같다고 나오는 이유는 자바에서는 객체들을 재사용하기 위해 Constant Pool 이라는것이 있는데 
			Strinng의 경우 동일한 값을 사용하는 객체가 있으면, 이미 만든 객체를 재사용하기 때문에 실제로 text 와 text2는 같은 객체이다. 
			
			우리의 예상대로 text != text2 를 의도하고 싶다면 
			text2의 객체를 new String("Check value")로 값을 할당하면 된다. 
		*/
		if (text == text2) {
			System.out.println("text == text2 result is same.");
		} else {
			System.out.println("text == text2 result is different.");
		}
		
		if (text.equals("Check value")) {
			System.out.println("text.equals(text2) result is same.");
		}
		
		String text3 = "check value";
		
		if (text.equalsIgnoreCase(text3)) {
			System.out.println("text.equalsIgnoreCase(text3) result is same.");
		}
	}
	
	public void checkCompareTo() {
		
		String text1 = "a";
		String text2 = "b";
		String text3 = "c";
		
		System.out.println(text2.compareTo(text1));
		System.out.println(text2.compareTo(text3));
		System.out.println(text1.compareTo(text3));
		
	}
}