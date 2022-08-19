package d.lang;

public class JavaLangSystem {

    public static void main(String[] args) {
        JavaLangSystem sample = new JavaLangSystem();
        sample.systemPropertiesCheck();
    }

    public void systemPropertiesCheck() {
        long startTime = System.currentTimeMillis();
        long startNanoTime = System.nanoTime();
        System.out.println("java.version = " + System.getProperty("java.version"));
        System.out.println("JAVA_HOME = " + System.getProperty("JAVA_HOME"));

        System.out.println("Milli second = " + (System.currentTimeMillis() - startTime));
        System.out.println("JAVA_HOME = " + (System.nanoTime() - startNanoTime));
    }

}
