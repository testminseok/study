package com.basicjava.server;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServerInitial {

    private final int BUFFER_SIZE = 2_048;

    public static void main(String[] args) {
        SimpleWebServerInitial server = new SimpleWebServerInitial();
        server.start();
    }

    private void start() {
        final int port = 9999;
        try (ServerSocket server = new ServerSocket(port)) {

            while (true) {
                Socket client = server.accept();
                InputStream request = new BufferedInputStream(client.getInputStream());

                byte[] bytes = new byte[BUFFER_SIZE];
                request.read(bytes);
                String requestData = new String(bytes).trim();

                System.out.println("Request Data = \n" + requestData);
                System.out.println("-----------");

                PrintStream response = new PrintStream(client.getOutputStream());
                response.println("HTTP/1.1 200 OK");
                response.println("Content-type: text/html");
                response.println();

                response.println("It is Working");
                response.flush();
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
