package f.defaultmethod;

public class DefaultStaticImpl implements DefaultStaticInterface {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getSince() {
        return 0;
    }

    @Override
    public String getEmail() {
        return DefaultStaticInterface.super.getEmail();
    }

//    @Override // Interface 의 print 메소드를 overriding 하려 했지만 컴파일 오류 발생
    public static void print() {
        System.out.println("impl Print");
    }
}
