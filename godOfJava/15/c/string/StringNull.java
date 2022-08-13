package c.string;

public class StringNull {
	
	public static void main(String[] args) {
		
		StringNull sample = new StringNull();
		// sample.nullCheck(null);
		sample.nullCheck2(null);
	}
	
	public boolean nullCheck(String text) {
		/*
			매개변수로 넘어온 객체가 null 일 가능성이 있는경우 무조건 null 체크 로직을 추가하는것이 좋다.
		*/
		int textLength = text.length(); // null 객체를 참조할 경우 NullPointerException이 발생
		System.out.println(textLength);
		
		if (text == null) return true;
		else return false;
	}
	
	public boolean nullCheck2(String text) {
		
		if (text == null) return true;
		else {
			int textLength = text.length();
			System.out.println(textLength);
			return false;
		}
	}
}