package com.software.basic.problem;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * 자바 1.5 이상에서는 foreach 를 사용할 수 있지만 개발자들은 무의식적으로 배열을 제어하는 데 for 반복문을 사용한다.
 * 분명 for 가 약간의 실행 속도 향상과 섬세한 설정이 가능하다는 장점이 있지만 일반적인 배열을 순회할 경우
 * foreach 를 이용하면 코드가 간단해지고 불필요한 증감변수를 사용할 필요가 없다는 장점이 있다.
 * */
public class ForeachExample {
    public static void main(String[] args) {

        // 임의의 정수를 생성하기 위한 난수 객체
        SecureRandom randomScore = new SecureRandom();

        List<String> students = new ArrayList<>();
        students.add("짱구");
        students.add("짱아");
        students.add("흰둥이");

        String[] subjects = {"국어", "수학", "영어", "국사"};

        defaultForLoop(randomScore, students, subjects);
        foreachLoop(randomScore, students, subjects);
    }

    /**
     * foreach 를 사용할 경우 불필요한 증감변수가 필요하지 않으며 코드의 가독성이 상대적으로 높아진다.
     * */
    private static void foreachLoop(SecureRandom randomScore, List<String> students, String... subjects) {
        for (String student :
                students) {
            System.out.println("학생명 : " + student);
            for (String subject :
                    subjects) {
                System.out.println("과목 : " + subject + ", 점수 : " + (randomScore.nextInt(100) + 1));
            }
        }
    }

    /**
     * 아래 코드는 일반적인 for 를 사용한 중첩 반복문의 예로,
     * 반복문을 사용할 때 i 와 j 라는 부가적인 변수를 생성해야한다.
     * 그로 인해 코드의 가독성이 떨어지고 논리적인 버그가 발생할 가능성이 있다.
     * */
    private static void defaultForLoop(SecureRandom randomScore, List<String> students, String... subjects) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("학생명 : " + students.get(i));

            for (int j = 0; j < subjects.length; j++) {
                System.out.println("과목 : " + subjects[j] + ", 점수 : " + (randomScore.nextInt(100) + 1));
            }
        }
    }
}
