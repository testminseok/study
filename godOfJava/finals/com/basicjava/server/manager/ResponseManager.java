package com.basicjava.server.manager;

import com.basicjava.server.dto.RequestDTO;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

public class ResponseManager {
    private Socket request;
    private RequestDTO requestDTO;

    public ResponseManager(Socket request, RequestDTO requestDTO) {
        this.request = request;
        this.requestDTO = requestDTO;
    }

    public void writeResponse() {
        try (PrintStream response = new PrintStream(request.getOutputStream())) {
            response.println("HTTP/1.1 200 OK");
            response.println("Content-type: text/html");
            response.println();

            if (requestDTO.getUri().equals("/today")) {
                response.println(new Date());
            } else {
                response.println("It is Working");
            }

            response.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
