package examples.chap18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 주어진 숫자 리스트의 모든 서브집합의 멤버로 구성된 값을 반환
 * */
public class SubsetsMain {

    public static void main(String[] args) {
        // [[], [9], [4], [4, 9], [1], [1, 9], [1, 4], [1, 4, 9]]
        System.out.println(subsets(Arrays.asList(1, 4, 9)));
    }

    public static List<List<Integer>> subsets(List<Integer> list) {
        /*
        * 입력 리스트가 비어있다면 빈 리스트 자신이 서브 집합이다.
        * */
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }

        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        /*
        * 빈 리스트가 아니면 먼저 하나의 요소를 꺼내고 나머지 요소의 모든 서브집합을 찾아서 subans 로 전달한다.
        * subans 는 절반의 정답을 포함한다.
        * */
        List<List<Integer>> subans = subsets(rest);
        /*
        * 정답의 나머지 절반을 포함하는 subans2 는 subans 의 모든 리스트에 처음 꺼낸 요소를 앞에 추가해서 만든다.
        * */
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    private static List<List<Integer>> concat(List<List<Integer>> subans, List<List<Integer>> subans2) {
        List<List<Integer>> result = new ArrayList<>(subans);
        result.addAll(subans2);

        return result;
    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subans) {
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> list : subans) {
            /*
            * 리스트를 복사한 다음에 복사한 리스트에 요소를 추가한다.
            * 구조체가 가변이더라도 저수준 구조를 복사하진 않는다.
            * */
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }

        return result;
    }
}
