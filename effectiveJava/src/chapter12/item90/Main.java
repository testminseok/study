package chapter12.item90;

import java.io.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Period p = new Period(new Date(), new Date());
        // Period 를 직렬화 하면 SerializationProxy 가 byte[] 로 직렬화 된다. (writeReplace 메서드)
        byte[] serializedForm = serialize(p);

        // Period 를 역직렬화 하면 SerializationProxy 가 역직렬화 되고, 이를 통해 Period 를 생성한다. (프록시의 readResolve 메서드)
        Object deserialize = deserialize(serializedForm);
        System.out.println(deserialize);
    }

    private static Object deserialize(byte[] serializedForm) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(serializedForm)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static byte[] serialize(Object o) {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(ba).writeObject(o);
            return ba.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
