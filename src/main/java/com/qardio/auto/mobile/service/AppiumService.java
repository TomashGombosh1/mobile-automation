package com.qardio.auto.mobile.service;

/**
 * @author Tomash Gombosh
 */
public interface AppiumService {

    void startServer();

    void stopServer();

    boolean checkIfServerIsRunning(int port);
}
