public class ReferenceReturn {
	public static void main(String[] args) {
		/*
			매소드에서 값을 돌려받고 싶을땐 리턴타입에 받을 자료형을 선언하고
			return 키워드를 통해 돌려받는다.
			
			void는 리턴받을 타입이 없을 경우 사용하고
			void 메서드에서 return 문을 사용할 경우 메서드를 더 이상 진행하지 않고 종료한다. 
		*/
		ReferenceReturn reference = new ReferenceReturn();
		System.out.println(reference.intReturn());
		System.out.println(reference.intArrayReturn());
		System.out.println(reference.stringReturn());
	}
	
	public int intReturn() {
		return 0;
	}
	
	public int[] intArrayReturn() {
		return new int[10];
	}
	
	public String stringReturn() {
		return "Return Value";
	}
}