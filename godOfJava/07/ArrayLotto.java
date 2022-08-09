public class ArrayLotto {
	
	public static void main(String[] args) {
		ArrayLotto lotto = new ArrayLotto();
		lotto.init();
		//lotto.primitiveTypes();
		lotto.referenceTypes();
	}
	
	public void init() {
		
		// 자바에서의 배열은 0부터 시작하며 아래와 같이 배열의 크기를 7로 초기화했을경우
		// [0,1,2,3,4,5,6] 총 7개의 원소만 저장 가능하며 [7]에서 ArrayIndexOutOfBoundsException 이 발생한다.
		int[] lottoNumbers = new int[7];
		
		lottoNumbers[0] = 0;
		lottoNumbers[1] = 1;
		lottoNumbers[2] = 2;
		lottoNumbers[3] = 3;
		lottoNumbers[4] = 4;
		lottoNumbers[5] = 5;
		lottoNumbers[6] = 6;
		//lottoNumbers[7] = 7;
		
	}
	
	public void primitiveTypes() {
		
		byte[] byteArray = new byte[1];
		short[] shortArray = new short[1];
		int[] intArray = new int[1];
		long[] longArray = new long[1];
		float[] floatArray = new float[1];
		double[] doubleArray = new double[1];
		char[] charArray = new char[1];
		boolean[] booleanArray = new boolean[1];
		
		System.out.println("byteArray[0] = " + byteArray[0]); // 기본값 0
		System.out.println("shortArray[0] = " + shortArray[0]); // 기본값 0
		System.out.println("intArray[0] = " + intArray[0]); // 기본값 0
		System.out.println("longArray[0] = " + longArray[0]); // 기본값 0
		System.out.println("floatArray[0] = " + floatArray[0]); // 기본값 0.0
		System.out.println("doubleArray[0] = " + doubleArray[0]); // 기본값 0.0
		System.out.println("charArray[0] = '" + charArray[0] + "'"); // 기본값 '\u0000'
		System.out.println("booleanArray[0] = " + booleanArray[0]); // false
		
		
	}
	
	public void referenceTypes() {
		
		String[] strings = new String[2];
		ArrayLotto[] lotto = new ArrayLotto[2];
		
		System.out.println("strings[0] = " + strings[0]); // new 키워드를 통해 생성되지않을 경우 기본값은 null
		System.out.println("lotto[0] = " + lotto[0]); //  new 키워드를 통해 생성되지않을 경우 기본값은 null
	}
}