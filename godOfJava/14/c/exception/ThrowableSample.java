package c.exception;

public class ThrowableSample {
	
	public static void main(String[] args) {
		
		/*
			자바의 모든 예외와 오류는 Throwable 클래스를 상속받는다.
			
			그중 runtime exception은 RuntimeException을 상속받았으며, unchecked exception이라고도 한다. 
			Exception을 바로 확장한 클래스들은 Checked Exception 이다.
		*/
		ThrowableSample sample = new ThrowableSample();
		sample.throwable();
	}
	
	public void throwable() {
		
		int[] intArray = new int [5];
		
		try {
			intArray = null;
			System.out.println(intArray[5]);
		} catch (Throwable t) {
			System.out.println(t.getMessage()); // 간략한 메세지 : null
			System.out.println(t.toString()); // 좀더 상세한 메세지 : java.lang.NullPointerException
			t.printStackTrace(); // 구체적인 오류메세지, 개발할때만 사용하고 실제 프로덕션으로 배포할때는 꼭 필요한 경우가 아니고선 제외한다. (로그의 양이 길어져 용량을 많이 잡아먹는다.)
		}
	}
}