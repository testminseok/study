package chapter09.item59;

import java.util.Random;

/**
 * 바퀴를 다시 발명하지 말자. 아주 특별한 나만의 기능이 아니라면 누군가 이미 라이브러리 형태로 구현해놓았을 가능성이 크다.
 * 그런 라이브러리가 있다면, 쓰면된다. 있는지 잘 모르겠다면 찾아보라. 일반적으로 라이브러리의 코드는 직접 작성한 것보다
 * 품질이 좋고, 점차 개선될 가능성이 크다. 코드 품질에도 규모의 경제가 적용된다. 즉, 라이브러리 코드는 개발자 각자가 작성하는 것보다
 * 주목을 훨씬 많이 받으므로 코드 품질도 그만큼 높아진다.
 *
 * java 개발자라면 적어도 java.lang, java.util, java.io 같은 핵심 패키지부터 익혀나가야 한다.
 * */
public class UseTheLibrary {
    // 흔하지만 문제가 심각한 코드!
    static Random rnd = new Random();
    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for(int i = 0; i < 1000000; i++) {
            if(random(n) < n/2) {
                low++;
            }
        }
        System.out.println(low); // 666,666 에 가까운 값을 얻는다.
    }
}
