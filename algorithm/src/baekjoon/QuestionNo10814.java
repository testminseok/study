package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuestionNo10814 {

    private static class Customer implements Comparable<Customer> {
        int index;
        int age;
        String name;

        public Customer(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Customer o) {
            int compare = Integer.compare(this.age, o.age);
            if (compare == 0) {
                return Integer.compare(this.index, o.index);
            }
            return compare;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inputStreamReader.readLine());
        List<Customer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(inputStreamReader.readLine(), " ");
            int age = Integer.parseInt(stringTokenizer.nextToken());
            String name = stringTokenizer.nextToken();
            Customer customer = new Customer(i, age, name);
            list.add(customer);
        }

        Collections.sort(list);

        StringBuilder builder = new StringBuilder();
        for (Customer customer : list) {
            builder.append(customer.age).append(" ").append(customer.name).append("\n");
        }
        System.out.println(builder);
    }
}
