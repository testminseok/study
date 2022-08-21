package d.collection.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ManageHeight {

    ArrayList<ArrayList<Integer>> gradeHeights = new ArrayList<>();

    public static void main(String[] args) {
        ManageHeight manageHeight = new ManageHeight();
        manageHeight.setData();

        for (int i = 1; i <= 5; i++) {
            manageHeight.printHeight(i);
        }

        int i = 1;
        while (i <= 5) {
            manageHeight.printAverage(i);
            i++;
        }
    }

    public void printAverage(int classNo) {
        System.out.println("Class No.:" + classNo);

        ArrayList<Integer> classHeights = gradeHeights.get((classNo - 1));

        double sum = 0;
        double average = 0.0;

        for (int height : classHeights) {
            sum+= height;
        }

        average = sum / classHeights.size();
        System.out.println("Height average:" + average);
    }

    public void printHeight(int classNo) {
        System.out.println("Class No.:" + classNo);

        ArrayList<Integer> classHeights = gradeHeights.get((classNo - 1));

        int size = classHeights.size();
        for (int i = 0; i < size; i++) {
            System.out.println(classHeights.get(i));
        }
    }

    public void setData() {
        ArrayList<Integer> classNo1 =  new ArrayList<>(Arrays.asList(170, 180, 173, 175, 177));
        ArrayList<Integer> classNo2 = new ArrayList<>(Arrays.asList(160, 165, 167, 186));
        ArrayList<Integer> classNo3 = new ArrayList<>(Arrays.asList(158, 177, 187, 176));
        ArrayList<Integer> classNo4 = new ArrayList<>(Arrays.asList(173, 182, 181));
        ArrayList<Integer> classNo5 = new ArrayList<>(Arrays.asList(170, 180, 165, 177, 172));

        gradeHeights.add(classNo1);
        gradeHeights.add(classNo2);
        gradeHeights.add(classNo3);
        gradeHeights.add(classNo4);
        gradeHeights.add(classNo5);
    }
}
