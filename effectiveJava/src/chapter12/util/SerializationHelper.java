package chapter12.util;

import java.io.*;

public class SerializationHelper {
    public static Object deserialize(byte[] serializedForm) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(serializedForm)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static byte[] serialize(Object o) {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(ba).writeObject(o);
            return ba.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
