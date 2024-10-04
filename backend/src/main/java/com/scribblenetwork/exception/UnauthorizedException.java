package com.scribblenetwork.exception;

public class UnauthorizedException extends ScribbleException {

    private static final long serialVersionUID = 1L;

    public UnauthorizedException() {

    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String code, String message) {
        super(code, message);
    }


}
