package e.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServerSample {
    public static void main(String[] args) {
        DatagramServerSample sample = new DatagramServerSample();
        sample.startServer();
    }

    private void startServer() {
        final int port = 9999;

        try (DatagramSocket server = new DatagramSocket(port)) {
            int bufferLength = 256;
            byte[] bytes = new byte[bufferLength];

            DatagramPacket packet = new DatagramPacket(bytes, bufferLength);

            while (true) {
                System.out.println("Server: Waiting for request.");

                server.receive(packet);
                int dataLength = packet.getLength();

                System.out.println("Server: Receive Data length = " + dataLength);

                String data = new String(packet.getData(), 0, dataLength);

                System.out.println("Received data: " + data);

                if (data.equals("EXIT")) {
                    System.out.println("STOP DatagramServer");
                    break;
                }
                System.out.println("-------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
