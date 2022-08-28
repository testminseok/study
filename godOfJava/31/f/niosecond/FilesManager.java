package f.niosecond;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilesManager {

    public static void main(String[] args) {
        FilesManager manager = new FilesManager();
        String fileName = "D:" + File.separator + "godOfJava" + File.separator + "AboutThisBook.txt";
        manager.writeAndRead(fileName);
    }

    public List<String> getContents() {
        List<String> contents = new ArrayList<>();
        contents.add("무궁화 삼천리 화려강산");
        contents.add("독도는 우리땅");
        contents.add("제주도 고등어");
        contents.add("Current Date = " + new Date());

        return contents;
    }

    public Path writeFile(Path path) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        List<String> contents = getContents();
        StandardOpenOption openOption = StandardOpenOption.CREATE;
        return Files.write(path, contents, charset, openOption);
    }

    public void readFile(Path path) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        System.out.println("Path = " + path);

        List<String> fileContents = Files.readAllLines(path, charset);

        for (String content : fileContents) {
            System.out.println(content);
        }

        System.out.println();
    }

    public Path writeAndRead(String fileName) {
        Path returnPath = null;
        try {
            Path path = Paths.get(fileName);
            returnPath = writeFile(path);

            System.out.println("***** Created file contents *****");
            readFile(returnPath);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return returnPath;
    }
}
