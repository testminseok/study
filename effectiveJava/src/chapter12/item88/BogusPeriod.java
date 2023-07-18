package chapter12.item88;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BogusPeriod {
    // 진짜 Period 인스턴스에서는 만들어질 수 없는 바이트 스트림
    private static final byte[] serializedForm = {
            -84, -19, 0, 5, 115, 114, 0, 23, 99, 104, 97, 112, 116, 101,
            114, 49, 50, 46, 105, 116, 101, 109, 56, 56, 46, 80, 101, 114,
            105, 111, 100, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 2, 76, 0, 3, 101,
            110, 100, 116, 0, 16, 76, 106, 97, 118, 97, 47, 117, 116, 105,
            108, 47, 68, 97, 116, 101, 59, 76, 0, 5, 115, 116, 97, 114, 116,
            113, 0, 126, 0, 1, 120, 112, 115, 114, 0, 14, 106, 97, 118, 97,
            46, 117, 116, 105, 108, 46, 68, 97, 116, 101, 104, 106, -127, 1,
            75, 89, 116, 25, 3, 0, 0, 120, 112, 119, 8, 0, 0, 54, -10, 83, 18,
            -35, -128, 120, 115, 113, 0, 126, 0, 3, 119, 8, 0, 0, 55, 100,
            -123, -25, -123, -128, 120
    };

    public static void main(String[] args) {
        // 진짜 Period 인스턴스를 역직렬화해 불변식을 훼손한다.
        Period p = (Period) deserialize(serializedForm);

        System.out.println(p);
    }

    private static Object deserialize(byte[] serializedForm) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(serializedForm)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
