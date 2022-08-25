package e.network;

import java.nio.IntBuffer;

public class NioDetailSample {
    public static void main(String[] args) {
        NioDetailSample nioDetailSample = new NioDetailSample();
//        nioDetailSample.checkBuffer();
        nioDetailSample.checkBufferStatus();
    }

    public void checkBuffer() {
        try {
            IntBuffer intBuffer = IntBuffer.allocate(1024);
            for (int i = 0; i < 100; i++) {
                intBuffer.put(i);
            }

            System.out.println("Buffer capacity = " + intBuffer.capacity());
            System.out.println("Buffer limit = " + intBuffer.limit());
            System.out.println("Buffer position = " + intBuffer.position());

            intBuffer.flip();

            System.out.println("Buffer flipped !!!");
            System.out.println("Buffer limit = " + intBuffer.limit());
            System.out.println("Buffer position = " + intBuffer.position());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBufferStatus() {
        try {
            IntBuffer intBuffer = IntBuffer.allocate(1024);
            intBuffer.get();
            printBufferStatus("get", intBuffer);
            intBuffer.mark();
            printBufferStatus("mark", intBuffer);
            intBuffer.get();
            printBufferStatus("get", intBuffer);
            intBuffer.reset();
            printBufferStatus("reset", intBuffer);
            intBuffer.rewind();
            printBufferStatus("rewind", intBuffer);
            intBuffer.clear();
            printBufferStatus("clear", intBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printBufferStatus(String job, IntBuffer buffer) {
        System.out.println("Buffer " + job + " !!!!");
        System.out.format("Buffer position = %d remaining = %d limit = %d \n", buffer.position(), buffer.remaining(), buffer.limit());
    }
}
