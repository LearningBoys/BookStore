package com.bookstore.exception;

public class NotExistUser extends Exception {
    private String msg;

    public NotExistUser() {
    }

    public NotExistUser(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
