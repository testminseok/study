package chapter02.item40;

import java.util.HashSet;
import java.util.Set;

/*
* 재정의한 모든 메서드에 @Override 어노테이션을 달자.
* 의식적으로 달면 실수 했을때 컴파일러가 바로 알려준다. 예외는 한 가지뿐이다.
* 구체 클래스에서 상위 클래스의 추상 메서드를 재정의한 경우엔 이 어노테이션을 달지 않아도 된다.
* 그러나 단다고 해서 해로울것도 없다.
* */
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

//    public boolean equals(Bigram b) {
//        return b.first == first && b.second == second;
//    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bigram)) {
            return false;
        }
        Bigram b = (Bigram) o;
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        System.out.println(s.size()); // Override 하지 않으면 260, Override 하면 26
    }
}
