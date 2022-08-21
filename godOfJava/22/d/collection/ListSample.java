package d.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class ListSample {
    public static void main(String[] args) {
        ListSample sample = new ListSample();
        sample.checkArrayList1();
        System.out.println("=============================");
        sample.checkArrayList2();
        System.out.println("=============================");
        sample.checkArrayList3();
        System.out.println("=============================");
        sample.checkArrayList4();
        System.out.println("=============================");
        sample.checkArrayList5();
        System.out.println("=============================");
        sample.checkArrayList6();
        System.out.println("=============================");
        sample.checkArrayList7();
        System.out.println("=============================");
        sample.checkArrayList8();
        System.out.println("=============================");
    }

    public void checkArrayList1() {
        ArrayList list1 = new ArrayList();
        list1.add(new Object());
        list1.add("ArrayListSample");
        list1.add(new Double(1));
    }

    public void checkArrayList2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(1, "A1");
        for (String tempData :
                list) {
            System.out.println(tempData);
        }
    }

    public void checkArrayList3() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(1, "A1");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("0 ");
        list2.addAll(list);

        for (String tempData :
                list2) {
            System.out.println(tempData);
        }
    }

    public void checkArrayList4() {
        /*
        * ArrayList<String> list2 = list; 처럼 list2 객체를 할당하는경우
        * list 의 참조 주소값이 할당되므로 list 의 원본값이 변경되면 list2 의 값도변경된다.
        * 때문에 list.addAll() 또는 new ArrayList<>(list) 처럼 데이터를 항당해야한다.
        * */
        ArrayList<String> list = new ArrayList<>();
        list.add("A");

        ArrayList<String> list2 = list;
        list.add("Ooops");

    }

    public void checkArrayList5() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println("list.get(" + i +") = " + list.get(i));
        }
    }

    public void checkArrayList6() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        /*
        * 매개변수로 반환하려는 타입의 배열을 지정해준다.
        * 실제로 매개변수로 넘긴 객체에 값을 담아주지만,
        * ArrayList 객체의 데이터 크기가 매개변수로 넘어간 배열 객체보다 클 경우 매개변로 넘긴 배열의 모든값이 null로 채워진다.
        * */
        String[] strList = list.toArray(new String[0]);
        System.out.println(strList[0]);
    }

    public void checkArrayList7() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        /*
         *  String[] tempArray = new String[0]; 에서 String 배열의 크기를
         * 5로 지정했을경우 {A, B, C, null, null},
         * 2로 지정했을경우 {null, null}
         * 때문에 배열의 크기를 0으로 지정해주는게 좋다.
         */
        String[] tempArray = new String[0];
        String[] strList = list.toArray(tempArray);

        for (String temp : strList) {
            System.out.println(temp);
        }
    }

    public void checkArrayList8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");

//        System.out.println("Removed " + list.remove("A"));

        list.removeAll(Arrays.asList("A"));

        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println("list.get(" + i + ") = " + list.get(i));
        }
    }
}
