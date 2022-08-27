package e.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class DatagramClientSample {
    public static void main(String[] args) {
        DatagramClientSample sample = new DatagramClientSample();
        sample.sendDatagramSample();
    }

    private void sendDatagramSample() {
        for (int i = 0; i < 3; i++) {
            sendDatagramData("I liked UDP " + new Date());
        }
        sendDatagramData("EXIT");
    }

    private void sendDatagramData(String data) {
        final String serverHost = "127.0.0.1";
        final int serverPort = 9999;
        try (DatagramSocket client = new DatagramSocket()) {

            InetAddress address = InetAddress.getByName(serverHost);

            byte[] bytes = data.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, address, serverPort);
            client.send(packet);

            System.out.println("Client: Send Data = " + data);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
