package f.stream;

import java.util.ArrayList;
import java.util.List;

public class StudentForEachSample {
    public static void main(String[] args) {
        StudentForEachSample sample = new StudentForEachSample();

        List<StudentDTO> students = new ArrayList<>();
        students.add(new StudentDTO("찐빵", 43, 99, 10));
        students.add(new StudentDTO("만두", 30, 71, 85));
        students.add(new StudentDTO("꽈배기", 32, 81, 75));

        sample.printStudentNames(students);
        sample.printStudentNames2(students);

        sample.printStudent(students);
    }

    private void printStudent(List<StudentDTO> students) {
        students.stream().forEach(student -> System.out.println(student));
    }

    private void printStudentNames2(List<StudentDTO> students) {
        students.stream().map(student -> student.getName()).forEach(name -> System.out.println(name));
    }

    private void printStudentNames(List<StudentDTO> students) {
        students.forEach(student -> System.out.println(student.getName()));
    }
}
