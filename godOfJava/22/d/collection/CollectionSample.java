package d.collection;

import java.util.*;

public class CollectionSample {
    public static void main(String[] args) {
        /*
        * Collection interface Method
        * */
        CollectionSample sample = new CollectionSample();
        sample.collectionMethod();
    }

    public void collectionMethod() {
        Collection collection = new ArrayList<String>();
        System.out.println(collection.add("foo"));
        System.out.println(collection.addAll(Arrays.asList("foo","bar")));
        System.out.println(collection.contains("foo"));
        System.out.println(collection.containsAll(Arrays.asList("foo", "bar")));
        System.out.println(collection.equals(collection));
        System.out.println(collection.isEmpty());
        System.out.println(collection.iterator());
        System.out.println(collection.remove("foo"));
        System.out.println(collection.removeAll(Arrays.asList("bar")));
        System.out.println(collection.size());
        System.out.println(collection.toArray());
        System.out.println(collection.toArray(new String[0]));

    }
}