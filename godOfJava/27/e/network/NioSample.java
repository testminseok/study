package e.network;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioSample {
    public static void main(String[] args) {
        NioSample sample = new NioSample();
        sample.basicWriteAndRead();
    }

    public void basicWriteAndRead() {
        String fileName = "D:" + File.separator + "godOfJava" + File.separator + "text" + File.separator + "nio.txt";
        try {
            writeFile(fileName, "My First NIO Sample");
            readFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String fileName, String data) throws IOException {
        FileChannel fileChannel = new FileOutputStream(fileName).getChannel();
        byte[] bytes = data.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        fileChannel.write(byteBuffer);
        fileChannel.close();
    }

    public void readFile(String fileName) throws IOException {
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get());
        }

        fileChannel.close();
    }
}
