package examples.chap09;

import examples.chap03.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.io.File.separator;

public class ExecutionAround {

    private static final String FILE_NAME =
            "D:" + separator + "ModernJavaInAction" + separator + "chap09" + separator + "data.txt";

    public static void main(String[] args) {
        String oneLine =
                processFile((BufferedReader b) -> b.readLine());
    }

    private static String processFile(BufferedReaderProcessor p) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            return p.process(br);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
