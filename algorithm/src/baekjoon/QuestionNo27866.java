package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionNo27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String str = inputStreamReader.readLine();
        int index = Integer.parseInt(inputStreamReader.readLine()) - 1;
        System.out.println(str.charAt(index));
    }
}
