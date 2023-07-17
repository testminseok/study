package chapter12.item85;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * - 직렬화 위험을 회피하는 가장 좋은 방법은 아무것도 역질렬화하지 않는 것이다.
 * - 개발자가 작성해야하는 새로운 시스템에서 자바 직렬화를 써야 할 이유는 전혀 없다.
 * - 레거시 시스템 때문에 자바 직렬화를 완전히 배제할 수 없을 때의 차선책은 신뢰할 수 없는 데이터는 절대 역직렬화 하지 않는것이다.
 * - 직렬화를 피할 수 없고 역직렬화한 데이터가 안전한지 완전히 확신할 수 없다면 객체 역직렬화 필터링을 사용하자.
 *   객체 역직렬화 필터링은 데이터 스트림이 역질렬화되기 전에 필터를 설치하는 기능이다. 클래스 단위로, 특정 클래스를 받아들이거나 거부할 수 있다.
 *   블랙리스트 방식과 화이트리스트 방식이 있는데 블랙리스트 방식보다는 화이트리스트 방식을 사용하자.
 * - 자바 직렬화 대신 직렬화 시스템이라 불리는 JSON, 프로토콜 버퍼 등의 대안을 사용하자.
 *   JSON 은 브라우저와 서버의 통신용으로 설계되었고, 프로토콜 버퍼는 구글이 서버 사이에 데이터를 교환하고 저장하기 위해 설계했다.
 *
 * 직렬화는 위험하니 피해야 한다. 시스템을 밑바닥 부터 설계한다면 JSON이나 프로토콜 버퍼 같은 대안을 사용하자.
 * 신뢰할 수 없는 데이터는 역질렬화하지 말자. 꼭 해야한다면 객체 역질렬화 필터링을 사용하되, 이마저도 모든 공격을 막아줄 수는 없음을 기억하자.
 * 클래스가 직렬화를 지원하도록 만들지 말고, 꼭 그렇게 만들어야 한다면 정말 신경써서 작성해야한다.
 * */
public class JavaSerialization {

    public static void main(String[] args) {
        // 역직렬화 폭탄으로 역질렬화 하지 못한다.
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bomb());
        try (ObjectInputStream ois = new ObjectInputStream(arrayInputStream)) {
            System.out.println(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 역질렬화 폭탄 이 스트림의 역질렬화는 영원히 계속된다.
    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();

            t1.add("foo"); // t1을 t2와 다르게 만든다.
            s1.add(t1);
            s1.add(t2);

            s2.add(t1);
            s2.add(t2);

            s1 = t1;
            s2 = t2;
        }

        return serialize(root); // root를 역직렬화하면 모든 객체가 만들어진다.
    }

    private static byte[] serialize(Set<Object> root) {
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bout)) {
            out.writeObject(root);
            out.flush();
            out.close();
            return bout.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
