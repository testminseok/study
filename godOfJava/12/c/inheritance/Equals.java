package c.inheritance;

public class Equals {
	
	public static void main(String[] args) {
		/*
			자바 API 문서에 정해져있는 equals() 메소드를 overriding 할때 반드시 만족해야하는 5가지
			1. 재귀(reflexive): null이 아닌 x라는 객체의 x.equals(x) 결과는 할상 true여야한다.
			2. 대칭(symmertic): null이 아닌 x와 y객체가 있을 때 y.equals(x)가 true를 리턴했다며느 x.equals(y)도 반드시 true를 리턴해야한다.
			3. 타동적(transitive): null이 아닌 x,y,z가 있을 때 x.equals(y)가 true를 리턴하고, y.equals(z)가 true를 리턴하면 x.equals(z)는 반드시 true여야한다.
			4. 일관(consistent): null이 아닌 x와 y가 있을 때 객체가 변경되지 않은 상황에서는 몇 번을 호출하더라도 x.equals(y)는 항상 true이거나 항상 false여야한다.
			5. null과의 비교: null이 아닌 x라는 객체의 x.equals(null)의 결과는 항상 false여야한다.
			
			equals객체를 Overriding 했다면, hashCode()도 Overriding 해야한다.
			equals의 결과로 객체가 서로 같다고는 할 수 있지만, 그 값이 같다고해서 주소값이 같지는 않기 때문이다.
		*/
		Equals thisObject = new Equals();
		thisObject.equalsMethod();
		thisObject.equalsMethod2();
	}
	
	public void equalsMethod() {
		
		MemberDTO obj1 = new MemberDTO("Sangmin");
		MemberDTO obj2 = new MemberDTO("Sangmin");
		
		if (obj1 == obj2) {
			System.out.println("obj1 and obj2 is same");
		} else {
			System.out.println("obj1 and obj2 is different");
		}
	}
	
	public void equalsMethod2() {
		MemberDTO obj1 = new MemberDTO("Sangmin");
		MemberDTO obj2 = new MemberDTO("Sangmin");
		
		if (obj1.equals(obj2)) {
			System.out.println("obj1 and obj2 is same");
		} else {
			System.out.println("obj1 and obj2 is different");
		}
	}
}