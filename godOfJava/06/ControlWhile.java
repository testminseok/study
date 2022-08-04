public class ControlWhile {
	
	public static void main(String[] agrs) {
		
		ControlWhile control = new ControlWhile();
		control.whileLoop1();
	}
	
	public void whileLoop1() {
		ControlSwitch control = new ControlSwitch();
		
		int loop = 0;
		
		while (loop < 12) {
			loop++;
			control.switchCalendar(loop);
			/*
				if (loop == 6) break; // 원하는 조건문에서 반복문을 종료하고 싶을때는 break를 사용한다.
				if (loop == 6) continue; // 원하는 조건문에서 더이상 반복문의 처리문구를 처리하지 않고 다음 순번에것을 처리하고 싶은땐 continue를 사용한다.
			*/
			
		}
	}
	
	public void doWhile() {
		
		ControlSwitch control = new ControlSwitch();
		
		int loop = 0;
		
		/*
			do-while 문은 반드시 한번은 실행하고 싶을경우 사용하며, while(조건문) 뒤에 ; 세미콜론을 붙여야한다.
		*/
		do {
			loop++;
			control.switchCalendar(loop);
		} while (loop < 12);
		
	}
}