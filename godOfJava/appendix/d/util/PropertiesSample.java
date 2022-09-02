package d.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesSample {
    public static void main(String[] args) {
        PropertiesSample sample = new PropertiesSample();
        sample.storeAndLoad();
    }

    private void storeAndLoad() {
        Properties prop = new Properties();
        String fileName = "D:" + File.separator + "godOfJava" + File.separator + "test.properties";

        try (
                FileWriter fileWriter = new FileWriter(fileName);
                FileReader fileReader = new FileReader(fileName)
        ) {

            prop.setProperty("Key1", "Key1-Value");
            prop.store(fileWriter, "Sample");

            Properties loadProp = new Properties();
            loadProp.load(fileReader);

            System.out.println(loadProp);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
