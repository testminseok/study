package e.io.object;

import java.io.*;

public class ManageObject {
    public static void main(String[] args) {
        ManageObject manager = new ManageObject();
        String fullPath = "D:" + File.separator + "godOfJava" + File.separator + "text" + File.separator + "serial.obj";
        SerialDTO serialDTO = new SerialDTO("GodOfJava", 1, true, 100);
//        manager.saveObject(fullPath, serialDTO);
        manager.loadObject(fullPath);
    }

    public void saveObject(String fullPath, SerialDTO serialDTO) {
        try (
                FileOutputStream fos = new FileOutputStream(fullPath);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(serialDTO);
            System.out.println("Write Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadObject(String fullPath) {
        try (
                FileInputStream fis = new FileInputStream(fullPath);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            SerialDTO serialDTO = (SerialDTO) ois.readObject();
            System.out.println(serialDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
