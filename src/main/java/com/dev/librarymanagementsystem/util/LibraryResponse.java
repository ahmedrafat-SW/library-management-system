package com.dev.librarymanagementsystem.util;

public class LibraryResponse <T>{

    private int code;
    private String message;
    private Exception exception;
    private T data;


    public LibraryResponse() {
    }

    public LibraryResponse(T data) {
        this.data = data;
    }

    public LibraryResponse(T data, int code) {
        this.data = data;
        this.code = code;
    }

    public LibraryResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public LibraryResponse(int code, String message, Exception exception) {
        this.code = code;
        this.message = message;
        this.exception = exception;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
