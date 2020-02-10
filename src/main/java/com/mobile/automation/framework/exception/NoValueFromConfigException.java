package com.mobile.automation.framework.exception;

/**
 * @author Tomash Gombosh
 */
public class NoValueFromConfigException extends RuntimeException {

    private static final long serialVersionUID = 1329573108063956749L;

    public NoValueFromConfigException() {
        super();
    }

    public NoValueFromConfigException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoValueFromConfigException(final String message) {
        super(message);
    }

    public NoValueFromConfigException(final Throwable cause) {
        super(cause);
    }
}
