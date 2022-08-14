package c.inner;

public class NestedSample {
	
	public static void main(String[] args) {
		
		/*
			Static Nested Class 는 한 곳에서만 사용되는 클래스를 논리적으로 묶어서 처리할 필요가 있을때 사용한다.
			
			
			예로 대학교와 초등학교라는 클래스가 있을때 학생이라는 클래스를 만들면 이 학생은 초등학교의 학생인지 대학교에 학생인지 알기 어렵다.
			물론 대학교학생 클래스와 초등학교학생 클래스를 만들어도 되지만 , 대학교.학생, 초등학교.학생 으로 만들면 학생이라는 클래스의 용도가 명확해진다.
			- 이와 같이 겉으로 보기엔 유사하지만, 내부적으로 구현이 달라야 할때 사용한다.
			
		*/
		NestedSample sample = new NestedSample();
		sample.makeStaticNestedObject();
		
	}
	
	public void makeStaticNestedObject() {
		
		OuterOfStatic.StaticNested staticNested = new OuterOfStatic.StaticNested();
		staticNested.setValue(3);
		
		System.out.println(staticNested.getValue());
	}
}