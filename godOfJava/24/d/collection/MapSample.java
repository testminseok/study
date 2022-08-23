package d.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSample {
    public static void main(String[] args) {
        /*
         * HaspMap 클래스는 버킷의 갯수를 지정해주지 않았을경우 기본 8개의 버킷을 가진다.
         * 해시 충돌이 일어날경우 Separate Chaining 을 통해 LinkedList 로 값이 나열되며
         * 그 LinkedList 의 값이 8개 이상이 될경우 Red-Black Tree 로 변경되어 성능을 최적화시킨다.
         * */
        MapSample sample = new MapSample();
        sample.checkHashMap();
        System.out.println("====================");
        sample.checkKeySet();
        System.out.println("====================");
        sample.checkValues();
        System.out.println("====================");
        sample.checkHashMapEntry();
        System.out.println("====================");
        sample.checkContains();
        System.out.println("====================");
        sample.checkRemove();
        System.out.println("====================");
    }

    public void checkRemove() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.remove("A");
        System.out.println(map.size());
    }

    public void checkContains() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("B", "B");
        map.put("C", "C");

        System.out.println(map.containsKey("A"));
        System.out.println(map.containsKey("Z"));
        System.out.println(map.containsValue("a"));
        System.out.println(map.containsValue("z"));
    }

    public void checkHashMapEntry() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("B", "B");
        map.put("C", "C");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " = " +  entry.getValue());
        }
    }

    public void checkValues() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("B", "B");
        map.put("C", "C");

        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println("value = " + value);
        }
    }

    public void checkKeySet() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("B", "B");
        map.put("C", "C");

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " = " + map.get(key));
        }
    }

    public void checkHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("A", "aaa"); // 키값을 중복해서 넣을경우 기존에 있던 값에 덮어씌워진다.
        System.out.println(map.get("A")); // aaa
        System.out.println(map.get("B")); // null
    }
}
