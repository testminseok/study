package e.io;

import java.io.File;
import java.io.FileFilter;

public class JPGFileFilter implements FileFilter {
    @Override
    public boolean accept(File file) {
        if (file.isFile()) {
            if (file.getName().toLowerCase().endsWith(".jpg")) {
                return true;
            }
        }

        return false;
    }
}
