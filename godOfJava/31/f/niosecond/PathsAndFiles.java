package f.niosecond;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsAndFiles {
    public static void main(String[] args) {
        PathsAndFiles sample = new PathsAndFiles();
        String dirPath = "D:" + File.separator + "godOfJava" + File.separator + "nio" + File.separator + "nio2";
//        sample.checkPath(dirPath);

        String dirPath2 = "D:" + File.separator + "WINDOWS";
        sample.checkPath(dirPath, dirPath2);
    }

    private void checkPath(String dirPath, String dirPath2) {
        Path path = Paths.get(dirPath);
        Path path2 = Paths.get(dirPath2);

        /*
        * 매개변수로 넘긴 Path 와 현재 Path 의 상대경로를 리턴
        * */
        Path relativize = path.relativize(path2);
        System.out.println("relativize path = " + relativize);

        /*
        * 상대경로로 되어있는것을 절대 경로로 변경하여 리턴
        * */
        Path absolute = relativize.toAbsolutePath();
        System.out.println("toAbsolutePath path = " + absolute);

        /*
        * 경로상 "." 나 ".." 을 없애는 작업을 한다.
        * */
        Path normalized = absolute.normalize();
        System.out.println("normalized path = " + normalized);

        /*
        * 현재 Path 의 가장 마지막 Path 로 추가한다.
        * */
        Path resolved = path.resolve("godOfJava");
        System.out.println("resolved path = " + resolved);
    }

    private void checkPath(String dirPath) {
        Path path = Paths.get(dirPath);

        System.out.println(path);
        System.out.println("getFileName(): " + path.getFileName());
        System.out.println("getNameCount(): " + path.getNameCount());
        System.out.println("getParent(): " + path.getParent());
        System.out.println("getRoot(): " + path.getRoot());
    }
}
