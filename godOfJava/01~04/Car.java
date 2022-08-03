// 클래스는 상태와 행위로 이루어져 있다.
public class Car {
	
	int speed; // 속도
	int distance; // 주행거리
	String color; // 차 색상
	String onwerName;
	
	public Car(String onwerName) {
		this.onwerName = onwerName;
	}
	
	public void speedUp() {
		this.speed += 5;
		System.out.println(this.onwerName + "speedUp!!");
	}
	
	public void breakDown() {
		this.speed -= 10;
		System.out.println(this.onwerName + "breakDown!!");
	}
	
	public int getCurrentSpeed() {
		return this.speed;
	}
}