package f.trycatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResource {
    public void newScanFile(String fileName, String encoding) {
        /*
        * try-with-resource 문 에서 () 소괄호 안에 객체는 AutoCloseable 인터페이스를 상속하고 있으면
        * try 문이 종료될시 close() 메소드를 호출해준다.
        * */
        try (Scanner scanner = new Scanner(new File(fileName), encoding)) {
            System.out.println(scanner.nextLine());
        } catch (IllegalArgumentException | FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void scanFile(String fileName, String encoding) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName), encoding);
            System.out.println(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        } catch (FileNotFoundException ffe) {
            ffe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) scanner.close();
        }
    }
}
