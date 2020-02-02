package com.mobile.automation.framework.exception;

/**
 * @author Tomash Gombosh
 */
public class NoSuchOsException extends RuntimeException {

    private static final long serialVersionUID = -5980197442061756936L;

    public NoSuchOsException() {
        super();
    }

    public NoSuchOsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoSuchOsException(final String message) {
        super(message);
    }

    public NoSuchOsException(final Throwable cause) {
        super(cause);
    }
}
