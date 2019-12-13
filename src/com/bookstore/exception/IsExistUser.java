package com.bookstore.exception;

public class IsExistUser extends Exception {
    private String msg;

    public IsExistUser() {
    }

    public IsExistUser(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
