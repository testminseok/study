package f.generic;

public class TypeInference {
    public static void main(String[] args) {
        TypeInference type = new TypeInference();
        type.makeObject1();
        type.makeObject2();
        type.makeObject3();
        type.makeObject4();
    }

    private void makeObject4() {
        /*
        * new 와 클래스 이름 사이에 타입 이름을 명시적으로 두려면, 다이아몬드를 사용하면 안된다.
        * 컴파일오류
        * */
//        GenericClass<Integer> generic = new <String> GenericClass<>("String");
//        generic.setValue(999);
    }

    private void makeObject3() {
        GenericClass<Integer> generic = new <String> GenericClass<Integer>("String");
        generic.setValue(999);
    }

    private void makeObject2() {
        GenericClass<Integer> generic = new GenericClass("String");
        generic.setValue(999);
    }

    private void makeObject1() {
        GenericClass<Integer> generic = new GenericClass<>("String");
        generic.setValue(999);
    }

}
