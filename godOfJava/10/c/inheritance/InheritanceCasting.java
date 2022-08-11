package c.inheritance;

public class InheritanceCasting {
	
	public static void main(String[] args) {
		/*
			자식 클래스를 부모클래스로 형변환은 가능하지만 그 반대되는 경우는 컴파일 오류가 발생한다.
			자신 클래스에서는 부모클래스의 필드와 메서드를 온전히 모두 사용가능하여 부모클래스로 변환해도 사용에 이상이 없지만,
			그 반대되는 부모클래스에서 자식클래스의 필드와 메서드를 사용하지 못하기 때문이다.
			
			하지만, 자식클래스를 부모클래스로 형변환 한 객체는 자식클래스로 다시 형변환이 가능하다.
		*/
		InheritanceCasting inheritance = new InheritanceCasting();
		inheritance.objectCast();
		inheritance.objectArray();
	}
	
	public void objectCast() {
		ParentCasting parent = new ParentCasting();
		ChildCasting child = new ChildCasting();
		
		ParentCasting parent2 = child;
		// ChildCasting child2 = parent; // 컴파일 오류
		// ChildCasting child2 = parent2; // 컴파일 정상 
	}
	
	public void objectArray() {
		/*
			일반적으로 여러개의 값을 처리하거나, 매개변수로 값을 전달할때에는 보통 부모클래스의 타입으로 보낸다.
		*/
		ParentCasting[] parentArray = new ParentCasting[3];
		parentArray[0] = new ChildCasting();
		parentArray[1] = new ParentCasting();
		parentArray[2] = new ChildCasting();
		
		objectTypeCheck(parentArray);
	}
	
	public void objectTypeCheck(ParentCasting[] parentArray) {
		/*
			해당 객체가 부모인지 자식인지 판별은 instanceof 예약어를 사용하여 구분한다. 
			또한 instanceof 키워드로 구분할경우 맨 하위 자식부터 검증해야한다. 
			부모부터 검증할경우 모두 해당되기 때문에.
		*/
		for (ParentCasting parent : parentArray) {
			if (parent instanceof ChildCasting) {
				System.out.println("ChildCasting");
				ChildCasting child = (ChildCasting) parent;
				child.printAge();
			} else if (parent instanceof ParentCasting) {
				System.out.println("ParentCasting");
			}
		}
	}
}