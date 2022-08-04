public class ControIf {
	public static void main(String[] agrs) {
		
		ControIf contro = new ControIf();
		contro.ifStatement();
		contro.ifElseStatement();
		contro.ifAndOr();
		contro.tripleOrAnd();
		contro.elseIf(85);
	}
	
	public void ifStatement() {
		/*
			if문은 예약어로 아래와 같이 사용한다.
			일반적으로 if 문에 직접적으로 true 를 주지않으며, 처리문장이 하나만 있더라도 
			중괄호를 열고 닫는게 가독성에 좋다.
		*/
		if (true);
		if (true) System.out.println("It's true");
		if (true)
			System.out.println("It's also true");
		if (false) System.out.println("It's false");
	}
	
	public void ifElseStatement() {
		
		int value = 10;
		
		if (value > 5) System.out.println("It's bigger than 5");
		else System.out.println("It's smaller or equal than 5");
		
		if (value <= 5) 
			System.out.println("It's smaller or equal than 5");
		else 
			System.out.println("It's bigger than 5");
	}
	
	public void ifAndOr() {
		
		int age = 25;
		boolean isMarried = true;
		
		if (age > 25 && isMarried) {
			System.out.println("Age is over 25 and Married");
		}
		
		if (age > 25 || isMarried) {
			System.out.println("Age is over 25 or Married");
		}
	}
	
	public void tripleOrAnd() {
		
		int age = 25;
		boolean isMarried = true;
		double height = 180;
		
		// 조건문에 조건식이 여러개 들어갈 수 있다.
		if ((age > 25 || isMarried) && height >= 180) {
			System.out.println("Age is over 25 or Married and height is over 180");
		}
		
	}
	
	public void elseIf(int point) {
		
		// if-else문과 if-elseif-else 문이있다
		if (point > 90) {
			System.out.println("A");
		} else if (point > 80) {
			System.out.println("B");
		} else if (point > 70) {
			System.out.println("C");
		} else if (point > 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}