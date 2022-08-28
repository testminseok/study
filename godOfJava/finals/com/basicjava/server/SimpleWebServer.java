package com.basicjava.server;

import com.basicjava.server.handler.RequestHandler;

import java.net.ServerSocket;

public class SimpleWebServer {
    public static void main(String[] args) {
        SimpleWebServer server = new SimpleWebServer();
        server.run();
    }

    private void run() {
        final int port = 9000;

        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                RequestHandler requestHandler = new RequestHandler(server.accept());
                requestHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
