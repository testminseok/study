package chapter09.item58;

import javax.lang.model.element.Element;
import java.util.*;

/**
 * 전통적인 for 문과 비교했을 때 for-each 문은 명료하고, 유연하고, 버그를 예방해준다.
 * 성능 저하도 없다. 가능한 모든 곳에서 for-each 문을 사용하자.
 *
 * for-each 문을 사용할 수 없는 상황 세가지
 * - 파괴적인 필터링(destructive filtering) : 컬렉션을 순회하면서 선택된 원소를 제거해야 한다면 반복자의 remove 메서드를 호출해야 한다.
 *                                          자바 8부터는 Collection의 removeIf 메서드를 사용해 컬렉션을 명시적으로 순회하면서 원소를 제거하는 일을 피할 수 있다.
 * - 변형(transforming) : 리스트나 배열을 순회하면서 그 원소의 값 일부 혹은 전체를 교체해야 한다면 리스트의 반복자나 배열의 인덱스를 사용해야 한다.
 * - 병렬 반복(parallel iteration) : 여러 컬렉션을 병렬로 순회해야 한다면 각각의 반복자와 인덱스 변수를 사용해 엄격하고 명시적으로 제어해야 한다.
 * */
public class UseTheForEach {
    public static void main(String[] args) {

        // 컬렉션 순회하기 - 더 나은 방법이 있다.
        List<Element> c = new ArrayList<>();
        for (Iterator<Element> i = c.iterator(); i.hasNext(); ) {
            Element e = i.next();
            // e로 무언가를 한다.
        }

        // 배열 순회하기 - 더 나은 방법이 있다.
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            // arr[i]로 무언가를 한다.
            int el = arr[i];
        }

        // 컬렉션과 배열을 순회하는 올바른 관용구
        for (Element e : c) {
            // e로 무언가를 한다.
        }

        // 버그를 찾아보자.
        List<Card> deck = new ArrayList<>();
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                /*
                * i.next() 를 안쪽 반복문에서 호출되는 바람에 카드당 한번씩 불리고 있다
                * 그래서 숫자가 바닥나면 반복문에 NoSuchElementException 이 발생한다.
                * */
                deck.add(new Card(i.next(), j.next()));
            }
        }

        // 문제는 고쳤지만 보기 좋진 않다. 더 나은 방법이 있다.
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            Suit suit = i.next();
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                deck.add(new Card(suit, j.next()));
            }
        }

        // 컬렉션이나 배열의 중첩 반복을 위한 권장 관용구
        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }

        // 같은 버그, 다른 증상
        Collection<Face> faces = EnumSet.allOf(Face.class);
        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                /*
                * 이 반복문은 예외를 던지진 않지만 가능한 조합을 단 여섯 쌍만 출력하고 끝나버린다.
                * */
                System.out.println(i.next() + " " + j.next());
            }
        }
    }

    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    private static class Card {
        public Card(Suit next, Rank next1) {

        }
    }

    enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX }
}
