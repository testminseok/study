package e.io;

import java.io.File;
import java.io.FilenameFilter;

public class JPGFilenameFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        if (name.toLowerCase().endsWith(".jpg")) {
            return true;
        }

        return false;
    }
}
