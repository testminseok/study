package com.basicjava.server.handler;

import com.basicjava.server.dto.RequestDTO;
import com.basicjava.server.manager.RequestManager;
import com.basicjava.server.manager.ResponseManager;

import java.net.Socket;

public class RequestHandler extends Thread {
    private Socket request;

    public RequestHandler(Socket request) {
        this.request = request;
    }

    @Override
    public void run() {
        RequestManager requestManager = new RequestManager(request);
        RequestDTO requestDTO = requestManager.readRequest();

        System.out.println("---[" + request.isClosed() + "]---");

        ResponseManager responseManager = new ResponseManager(request, requestDTO);
        responseManager.writeResponse();
    }
}
