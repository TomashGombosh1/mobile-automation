package com.mobile.automation.framework.service;

/**
 * @author Tomash Gombosh
 */
public interface AppiumService {

    void startServer();

    void stopServer();

    boolean checkIfServerIsRunning(int port);
}
