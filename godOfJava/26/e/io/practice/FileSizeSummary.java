package e.io.practice;

import java.io.File;
import java.text.DecimalFormat;

public class FileSizeSummary {

    private final long KB = 1_024;
    private final long MB = 1_024 * 1_024;
    private final long GB = 1_024 * 1_024 * 1_024;
    private DecimalFormat format;

    public FileSizeSummary() {
        format = new DecimalFormat("#.##");
    }

    public static void main(String[] args) {
        FileSizeSummary fileSizeSummary = new FileSizeSummary();
        String path = "D:" + File.separator + "godOfJava" + File.separator;
        long sum = fileSizeSummary.printFileSize(path);
        System.out.println(path + "'s total size = " + sum);
    }

    private long printFileSize(String path) {
        File dir = new File(path);
        long result = 0L;

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    result += file.length();
                    System.out.println(file.getAbsolutePath() + " = " + file.length());
                    System.out.println(convertFileLength(file.length()));
                } else {
                    String tempDirName = file.getAbsolutePath();
                    long fileLength = printFileSize(tempDirName);
                    result += fileLength;
                }
            }
        }
        return result;
    }

    private String convertFileLength(long fileLength) {
        if (fileLength < KB) {
            return fileLength + " b";
        } else if (fileLength < MB) {
            return format.format(1.0 * fileLength / KB) + " kb";
        } else if (fileLength < GB) {
            return format.format(1.0 * fileLength / MB) + " mb";
        } else {
            return format.format(1.0 * fileLength / GB) + " gb";
        }
    }
}
