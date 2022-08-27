package e.network;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class SocketClientSample {
    public static void main(String[] args) {
        /*
        * TCP 는 데이터가 정상적으로 전송된다는 보장이 된다.
        * 하지만 그만큼 UDP 보다 비용이 비싸고, 느리며 무겁다.
        * */
        SocketClientSample sample = new SocketClientSample();
        sample.sendSocketSample();
    }

    private void sendSocketSample() {
        for (int i = 0; i < 3; i++) {
//            sendSocketData("I like java at " + new Date());
            sendAndReceiveSocketData();
        }

//        sendSocketData("EXIT");
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

    private void sendAndReceiveSocketData() {
        final String host = "127.0.0.1";
        final int port = 9999;
        System.out.println("Client: Connecting");
        try (Socket client = new Socket(host, port)) {
            System.out.println("Client: Connecting status = " + client.isConnected());
            Thread.sleep(1000);

            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String data = "";
            StringBuilder receiveData = new StringBuilder();
            while ((data = bufferedReader.readLine()) != null) {
                receiveData.append(data);
            }

            System.out.println("Client Receive Data : " + receiveData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
