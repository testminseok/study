public class ReferenceOverloading {
	public static void main(String[] args) {
		/*
		  오버로딩의 경우 메소드의 이름이 같고 메게변수의 타입이 다르거나, 타입의 순서가 다를때 사용할 수 있다.
		*/
		ReferenceOverloading reference = new ReferenceOverloading();
	}
	
	public void print(int data) {
		
	}
	
	public void print(String data) {
		
	}
	
	public void print(int intData, String stringData) {
		
	}
	
	public void print(String stringData, int intData) {
		
	}
}