package c.inner;

public class InnerSample {
	
	public static void main(String[] args) {
		
		/*
			내부클래스는 캘슐화가 필요할때, 내부구현을 감추고 싶을때 사용한다.
			
			-ex 한 파일에서만 사용할 공통클래스를 선언할때
		*/
		InnerSample sample = new InnerSample();
		sample.makeInnerObject();
		
	}
	
	public void makeInnerObject() {
		
		OuterOfInner outer = new OuterOfInner();
		OuterOfInner.Inner inner = outer.new Inner();
		
		inner.setValue(30);
		
		System.out.println(inner.getValue());
	}
}