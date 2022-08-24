package e.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ManageTextFile {
    public static void main(String[] args) {
        ManageTextFile manager = new ManageTextFile();
        int numberCount = 10;
        String fullPath = "D:" + File.separator + "godOfJava" + File.separator + "text" + File.separator + "numbers.txt";
        manager.writeFile(fullPath, numberCount);
//        manager.readFile(fullPath);
//        manager.readFileWithScanner(fullPath);
        manager.readFileWithFiles(fullPath);
    }

    public void writeFile(String fullPath, int numberCount) {
        /*
        * JDK 1.7 부터 사용가능한 try-catch-resource 문은 Closeable interface 를 구현한 클래스라면
        * try 구문을 벗어날때 자동으로 close() 를 실행시켜준다.
        * */
        try (
                FileWriter fileWriter = new FileWriter(fullPath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             ) {

            for (int i = 0; i <= numberCount; i++) {
                bufferedWriter.write(Integer.toString(i));
                bufferedWriter.newLine();
            }
            System.out.println("Write Success !!!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }  /*finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }

    public void readFile(String fullPath) {
        try (
                FileReader fileReader = new FileReader(fullPath);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
            }
            System.out.println("Read Success !!!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFileWithScanner(String fullPath) {
        File file = new File(fullPath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            System.out.println("Read Success !!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFileWithFiles(String fullPath) {
        try {
            String data = new String(Files.readAllBytes(Paths.get(fullPath)));
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
