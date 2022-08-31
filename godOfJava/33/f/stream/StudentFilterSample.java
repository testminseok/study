package f.stream;

import java.util.ArrayList;
import java.util.List;

public class StudentFilterSample {
    public static void main(String[] args) {
        StudentFilterSample sample = new StudentFilterSample();

        List<StudentDTO> students = new ArrayList<>();
        students.add(new StudentDTO("찐빵", 43, 99, 10));
        students.add(new StudentDTO("만두", 30, 71, 85));
        students.add(new StudentDTO("꽈배기", 32, 81, 75));

        sample.filterWithScoreForLoop(students, 80);
        sample.filterWithScoreForStream(students, 80);
    }

    private void filterWithScoreForStream(List<StudentDTO> students, int scoreCutLine) {
        students.stream()
                .filter(student -> student.getScoreMath() >= 80)
                .map(StudentDTO::getName)
                .forEach(System.out::println);
    }

    private void filterWithScoreForLoop(List<StudentDTO> students, int scoreCutLine) {
        for (StudentDTO student : students) {
            if (student.getScoreMath() > scoreCutLine) {
                System.out.println(student.getName());
            }
        }
    }
}
