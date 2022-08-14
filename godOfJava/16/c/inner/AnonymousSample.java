package c.inner;

public class AnonymousSample {
	
	public static void main(String[] args) {
		/*
			클래스를 만들고 그 클래스를 호출하면 그  정보는 메모리에 올라가는데, 
			클래스를많이 만들면 만들수록 메모리는 많이 필요해지며 어플레이션을 시작할때 더 많은 시간이 소요된다.
			따라서 자바에서는 이렇게 간단하게 객체를 생성할 수 있게 만들었다.
		*/
		AnonymousSample sample = new AnonymousSample();
		sample.setButtonListener();
	}
	
	public void setButtonListener() {
		
		MagicButton button = new MagicButton();
		button.setListener(new EventListener() {
			public void onClick() {
				System.out.println("Magic Button Clicked !!!");
			}
		});
		button.onClickProcess();
	}
}