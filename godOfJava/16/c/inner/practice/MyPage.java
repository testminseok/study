package c.inner.practice;

public class MyPage {
	
	private InputBox input;
	
	public static void main(String[] args) {
		
		MyPage myPage = new MyPage();
		myPage.setUI();
		myPage.pressKey();
	}
	
	public void setUI() {
		
		input = new InputBox();
		KeyEventListener listener = new KeyEventListener() {
			
			public void onKeyDown() {
				System.out.println("Key Down.");
			}
			
			public void onKeyUp() {
				System.out.println("Key Up.");
			}
			
		};
		
		input.setKeyListener(listener);
	}
	
	public void pressKey() {
		input.listenerCalled(InputBox.KEY_DOWN);
		input.listenerCalled(InputBox.KEY_UP);
	}
	
}