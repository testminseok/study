package e.io;

import java.io.File;

public class FileFilterSample {
    public static void main(String[] args) {
        FileFilterSample sample = new FileFilterSample();
        String path = "D:" + File.separator + "godOfJava" + File.separator + "text";
        sample.checkList(path);
    }

    public void checkList(String path) {
        try {
            File file = new File(path);
//            File[] mainFileList = file.listFiles();
            File[] mainFileList = file.listFiles(new JPGFileFilter());
            for (File tempFile : mainFileList) {
                System.out.println(tempFile.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
