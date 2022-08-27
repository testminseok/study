package e.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerSample {
    public static void main(String[] args) {
        SocketServerSample sample = new SocketServerSample();
//        sample.startServer();
        sample.startReplyServer();
    }

    private void startServer() {
        int port = 9999;
        try (
                ServerSocket server = new ServerSocket(port);
        ) {
            while (true) {
                System.out.println("Server:Waiting for request.");
                Socket client = server.accept();
                System.out.println("Server:Accepted.");

                InputStream inputStream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

                String data = "";
                StringBuilder receivedData = new StringBuilder();
                while ((data = in.readLine()) != null) {
                    receivedData.append(data);
                }
                System.out.println("Received Data : " + receivedData);

                in.close();
                inputStream.close();
                client.close();

                if (receivedData != null && "EXIT".equals(receivedData.toString())) {
                    System.out.println("STOP SocketServer");
                    break;
                }

                System.out.println("------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void startReplyServer() {
        int port = 9999;
        try (
                ServerSocket server = new ServerSocket(port);
        ) {
            while (true) {
                System.out.println("Server:Waiting for request.");
                Socket client = server.accept();
                System.out.println("Server:Accepted.");

                OutputStream outputStream = client.getOutputStream();
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));

                out.write("OK");

                out.close();
                System.out.println("------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
