package e.io;

import java.io.File;
import java.util.Date;

public class FileSample {
    public static void main(String[] args) {
        FileSample sample = new FileSample();
        String pathName = "D:" + File.separator + "godOfJava" + File.separator + "text";
//        String pathName = "D:\\godOfJava\\text";
        sample.makeDir(pathName);
        sample.checkPath(pathName);
        sample.checkFileMethod(pathName);
        sample.canFileMethod(pathName);
        sample.lastModified(pathName);
    }

    public void makeDir(String pathName) {
        /*
        * file.mkdir 의 경우 상위 디렉토리를 만들지 않으면 하위 파일, 디렉토리를 생성하지 못한다.
        * ex ) D:\\godOfJava\\text 의 경우 godOfJava 디렉토리가 없으므로 text 디렉토리를 생성하지 못한다.
        * */
        File file = new File(pathName);
//        System.out.println("Make " + pathName + " result = " + file.mkdir());
        System.out.println("Make " + pathName + " result = " + file.mkdirs());
    }

    public void checkPath(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " is exists? = " + file.exists());
    }

    public void checkFileMethod(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " is directory ? = " + file.isDirectory());
        System.out.println(pathName + " is file ? = " + file.isFile());
        System.out.println(pathName + " is hidden ? = " + file.isHidden());
    }

    public void canFileMethod(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " can read ? = " + file.canRead());
        System.out.println(pathName + " can write ? = " + file.canWrite());
        System.out.println(pathName + " can execute ? = " + file.canExecute());
    }

    public void lastModified(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " last modified = " + new Date(file.lastModified()));
    }
}
