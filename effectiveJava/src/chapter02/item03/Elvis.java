package chapter02.item03;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    /*
    * 권한이 있는 클라이언트가 리픅랙션 API 인 AccessibleObject.setAccessible 을 사용해 private 생성자를 호출할 수 있다.
    * 이러한 공격을 방지하려면 생성자를 수정하여 두 번째 객체가 생성되려 할 때 예외를 던지게 하면된다.
    * */
    private Elvis() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public void leaveTheBuilding() { }
}
