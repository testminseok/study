// 클래스는 그냥 껍데기 일 뿐이며 실제 로 사용하기 위해서는 new 예약어를 통한
// 갹체(instans)를 생성한 후 사용한다.
public class CarManager {
	public static void main(String[] agrs) {
		
		Car dogCar = new Car("dog");
		// Car cowCar = new Car("cow");
		
		dogCar.speedUp();
		dogCar.speedUp();
		
		// cowCar.speedUp();
		
		System.out.println(dogCar.getCurrentSpeed());
		
		dogCar.breakDown();
		
		System.out.println(dogCar.getCurrentSpeed());
		
	}
}