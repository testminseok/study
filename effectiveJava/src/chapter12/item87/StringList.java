package chapter12.item87;

import java.io.Serializable;

/**
 * 논리적으로 이 클래스는 일련의 문자열을 표현한다. 물리적으로는 문자열들을 이중 연결 리스트로 연결했다.
 * 이 클래스에 기본 직렬화 형태를 사용하면 각 노드의 양방향 연결 정보를 포함해 모든 엔트리(Entry)를 철두철미하게 기록한다.
 *
 * 객체의 물리적 표현과 논리적 표현의 차이가 클 때 기본 직렬화 형태를 사용하면 크게 네 가지 면에서 문제가 생긴다.
 * 1. 공개 API가 현재의 내부 표현 방식에 영구히 묶인다.
 *    이 클래스에서 private 클래스인 Entry 가 공개 API가 되어 버린다.
 *    다음 릴리스에서도 StringList 클래스는 여전히 연결 리스트로 표현된 입력도 처리할 수 있어야 한다.
 *    연결 리스트를 더는 사용하지 않더라도 관련코드를 제거할 수 없다.
 * 2. 너무 많은 공간을 차지할 수 있다.
 *    이 클래스에서 직렬화 형태는 연결 리스트의 모든 엔트리와 연결 정보까지 기록했지만, 엔트리와 연결 정보는 내부 구현에 해당하니
 *    직렬화 형태에 포함할 가치가 없다. 이처럼 직렬화 형태가 너무 커져서 디스크에 저장하거나 네트워크로 전송하는 속도가 느려진다.
 * 3. 시간이 너무 많이 걸릴 수 있다.
 *    직렬화 로직은 객체 그래프의 위상에 관한 정보가 없으니 그래프를 직접 순회해볼 수밖에 없다.
 * 4. 스택 오버플로를 일으킬 수 있다.
 *    기본 직렬화 과정은 객체 그래프를 재귀 순회하는데, 이 작업은 중간 정도의 크기의 객체 그래프에서도 자칫 스택 오버플로를 일으킬 수 있다.
 *
 * */
public class StringList implements Serializable {
    private int size = 0;
    private Entry head = null;

    private static class Entry implements Serializable {
        String data;
        Entry next;
        Entry previous;
    }

    // ... // 나머지 코드 생략
}
