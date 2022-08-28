package com.basicjava.server.manager;

import com.basicjava.server.dto.RequestDTO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RequestManager {

    private Socket request;
    private final int BUFFER_SIZE = 2_048;

    public RequestManager(Socket request) {
        this.request = request;
    }

    public RequestDTO readRequest() {
        try (InputStream inputStream = new BufferedInputStream(request.getInputStream())) {
            byte[] bytes = new byte[BUFFER_SIZE];
            inputStream.read(bytes);
            String requestData = new String(bytes).trim();

            RequestDTO requestDTO = new RequestDTO();

            if (requestData.indexOf("/today") > -1) {
                requestDTO.setUri("/today");
            }
            return requestDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new RequestDTO();
    }
}
