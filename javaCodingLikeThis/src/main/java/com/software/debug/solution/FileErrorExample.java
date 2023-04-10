package com.software.debug.solution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileErrorExample {
    
    public static Logger logger = Logger.getLogger(FileErrorExample.class.getName());
    
    public static void main(String[] args) {
        FileErrorExample fileErrorExample = new FileErrorExample();
        try {
            fileErrorExample.errorMethod("test.txt", "ttt");
        } catch (FileAlreadyExistsException e) {
            logger.throwing("FileErrorExample", "main", e);
            logger.log(Level.ALL, "파일 생성오류");
        }
    }
    
    private void errorMethod(String path, String str) throws FileAlreadyExistsException {
        try {
            File file = new File(path);
            Files.createFile(file.toPath());
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            logger.warning("파일 쓰기오류");
        }
    }
}
