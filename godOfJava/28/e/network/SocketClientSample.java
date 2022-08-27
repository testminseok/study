package e.network;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class SocketClientSample {
    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        sample.sendSocketSample();
    }

    private void sendSocketSample() {
        for (int i = 0; i < 3; i++) {
            sendSocketData("I like java at " + new Date());
        }

        sendSocketData("EXIT");
    }

    private void sendSocketData(String data) {
        final String host = "127.0.0.1";
        final int port = 9999;
        System.out.println("Client: Connecting");
        try (Socket client = new Socket(host, port)) {
            System.out.println("Client: Connecting status = " + client.isConnected());
            Thread.sleep(1000);

            OutputStream outputStream = client.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] bytes = data.getBytes();

            bufferedOutputStream.write(bytes);
            System.out.println("Client: Send Data");

            bufferedOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
