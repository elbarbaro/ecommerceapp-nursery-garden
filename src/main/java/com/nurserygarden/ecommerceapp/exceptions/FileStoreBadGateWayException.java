package com.nurserygarden.ecommerceapp.exceptions;

public class FileStoreBadGateWayException extends Exception {

    public FileStoreBadGateWayException() {
    }

    public FileStoreBadGateWayException(String message) {
        super(message);
    }

    public FileStoreBadGateWayException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStoreBadGateWayException(Throwable cause) {
        super(cause);
    }

}
