package d.collection;

import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        StackSample sample = new StackSample();
        sample.checkPeek();
    }

    public void checkPeek() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack.peek()); // peek : 가장 늦게 삽입된 원소를 반환
            System.out.println(stack.pop());  // pop : 가장 늦게 삽입된 원소를 반환하고 stack에서 제거함
        }

        System.out.println("size = " + stack.size());
    }
}
