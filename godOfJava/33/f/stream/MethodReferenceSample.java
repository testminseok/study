package f.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class MethodReferenceSample {
    public static void main(String[] args) {
        MethodReferenceSample sample = new MethodReferenceSample();
        String[] studentNames = new String[]{"만두", "찐빵", "꽈배기"};
        sample.staticReference(studentNames);
        sample.objectReference(studentNames);
        sample.constructReference(new char[]{'G', 'o', 'd', 'O', 'f', 'J', 'a', 'v', 'a'});
    }

    interface MakeString {
        String fromBytes(char[] chars);
    }

    private void constructReference(char[] chars) {
        MakeString makeString = String::new; // 생성자 참조
        System.out.println(makeString.fromBytes(chars));
    }

    private void objectReference(String[] studentNames) {
        Arrays.sort(studentNames, String::compareToIgnoreCase); // 임의 객체 참조
        Arrays.stream(studentNames).forEach(System.out::println); // 인스턴스 메소드 참조
    }

    private void staticReference(String[] studentNames) {
        Stream.of(studentNames).forEach(MethodReferenceSample::printResult);
    }

    private static void printResult(String name) {
        System.out.println(name);
    }
}
