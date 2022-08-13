package c.string;

public class StringSample {
	
	public static void main(String[] args) {
		
		StringSample sample = new StringSample();
		
		sample.convert();
	}
	
	public void convert() {
		
		try {
			String korean = "갓오브자바!!";
			byte[] array1 = korean.getBytes("UTF-16"); // EUC-KR의 경우 한글 2글자를 표현하기 위해 4바이트를 사용하지만 UTF-16은 6바이트를 사용한다. 
			
			for (byte data : array1) {
				System.out.print(data + " ");
			}
			
			System.out.println();
			
			String korean2 = new String(array1, "UTF-16");
			System.out.println(korean2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}