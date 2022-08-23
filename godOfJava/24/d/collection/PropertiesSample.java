package d.collection;

import java.util.Properties;
import java.util.Set;

public class PropertiesSample {
    public static void main(String[] args) {
        /*
            Properties 클래스는 HashTable 클래스를 확장하였으므로 Map 인터페이스에 있는 모든 메소드를 사용할 수 있다.
         */
        PropertiesSample sample = new PropertiesSample();
        sample.checkProperties();
    }

    public void checkProperties() {
        Properties prop = System.getProperties();
        Set<Object> keySet = prop.keySet();

        for (Object obj : keySet) {
            System.out.println(obj + " = " + prop.get(obj));
        }

        System.out.println("==============================");
        // 자주사용되는 properties
        System.out.println("user.language = " + prop.get("user.language"));
        System.out.println("user.dir = " + prop.get("user.dir"));
        System.out.println("user.home = " + prop.get("user.home"));
        System.out.println("java.io.tmpdir = " + prop.get("java.io.tmpdir"));
        System.out.println("file.encoding = " + prop.get("file.encoding"));
        System.out.println("sun.io.unicode.encoding = " + prop.get("sun.io.unicode.encoding"));
        System.out.println("path.separator = " + prop.get("path.separator"));
        System.out.println("file.separator = " + prop.get("file.separator"));
        System.out.println("line.separator = " + prop.get("line.separator"));
    }
}
