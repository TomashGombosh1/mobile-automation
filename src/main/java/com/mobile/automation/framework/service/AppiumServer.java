package com.mobile.automation.framework.service;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author Tomash Gombosh
 */
public class AppiumServer implements AppiumService {

    @Override
    public void startServer() {
        SERVICE.start();
    }

    @Override
    public void stopServer() {
        SERVICE.stop();
    }

    @Override
    public boolean checkIfServerIsRunning(int port) {
        return false;
    }

    public boolean checkIfServerIsRunnning(final int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        }
        return isServerRunning;
    }
}
