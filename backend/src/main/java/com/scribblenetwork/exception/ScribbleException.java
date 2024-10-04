package com.scribblenetwork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

public class ScribbleException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;
    private String code;
    private Exception exception;

    public ScribbleException() {

    }

    public ScribbleException(String message) {
        this.message = message;
    }

    public ScribbleException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ScribbleException(HttpStatus status, String message) {
        this.code = status.toString();
        this.message = message;
    }

    public ScribbleException(final String message, final Exception exception) {
        super(message, exception);
        this.exception = exception;
        this.message = message;
    }

    @Override
    public String getMessage() {
        if (!StringUtils.hasLength(super.getMessage()))
            return message + super.getMessage();
        else return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Exception getException() {
        return exception;
    }
}
