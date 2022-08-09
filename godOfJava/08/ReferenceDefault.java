public class ReferenceDefault {
	
	String arg;
	
	public ReferenceDefault() {
		this.arg = "Default arg";
	}
	
	public ReferenceDefault(String arg) {
		// 여기서 this한 현재 ReferenceDefault 객체 자체를 의미한다.
		this.arg = arg;
	}
	
	public static void main(String[] agrs) {
		/*
			클래스의 생성자는 정의해놓은 생성자가 없을경우 기본생성자를 만들어준다.
			하지만, 정의해놓은 생성자 ReferenceDefault(String arg) 과 같이 정의해놓은 생성자가 존재할 경우
			기본생성자를 만들어주지 않는다.
		*/
		ReferenceDefault reference = new ReferenceDefault();
	}
}