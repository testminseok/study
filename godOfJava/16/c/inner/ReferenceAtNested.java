package c.inner;

public class ReferenceAtNested {
	
	static class StaticNested {
		
		private int staticNestedInt = 99;
		
	}
	
	class Inner {
		
		private int innerValue = 100;
		
	}
	
	public void setValue(int value) {
		
		/*
			InnerClass 와 StaticNested Class 를 감싸는 클래스에서는 해당 객체들의 private 필드에도 접근이 가능하다. 
		*/
		StaticNested nested = new StaticNested();
		nested.staticNestedInt = value;
		
		Inner inner = new Inner();
		inner.innerValue = value;
		
	}
}