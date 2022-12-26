package examples.chap17.temperature;

import java.security.SecureRandom;

/**
 * 원격 온도계를 흉내 낸다. (0에서 99 사이의 화씨 온도를 임의로 만들어 연속적으로 보고).
 * */
public record TempInfo(String town, int temp) {

    public static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static TempInfo fetch(String town) {
        /*
         * 1/10 확률로 온도 가져오기 작업이 실패한다.
         * 아래 코드 주석시 StackOverflowError 에러 발생 해결
         * */
//        if (SECURE_RANDOM.nextInt(10) == 0) {
//            throw new RuntimeException("온도를 가져오는데 실패하였습니다.");
//        }

        return new TempInfo(town, SECURE_RANDOM.nextInt(100)); // 0에서 99사이에서 임의의 화씨 온도를 반환한다.
    }

    @Override
    public String toString() {
        return "TempInfo{" +
                "town='" + town + '\'' +
                ", temp=" + temp +
                '}';
    }
}
