package com.elarslan.stock.exception;

/**
 * This checked exception class is created for static/compile-time classes
 */
public class InvalidActionException extends Exception {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    public InvalidActionException(String message) {
        super(message);
    }

    public InvalidActionException(String message, Throwable cause) {
        super(message, cause);
    }
}
