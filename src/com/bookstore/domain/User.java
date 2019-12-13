package com.bookstore.domain;

import java.io.Serializable;

public class User implements Serializable{
    private int userId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String userSex;
    private String userPhone;
    private String userDesc;
    private String activeCode;
    private int staus;
    private String role;
    private String registerTime;

    public User() {
    }

    public User(int userId, String userEmail, String userName, String userPwd, String userSex, String userPhone, String userDesc, String activeCode, int staus, String role, String registerTime) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userDesc = userDesc;
        this.activeCode = activeCode;
        this.staus = staus;
        this.role = role;
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userDesc='" + userDesc + '\'' +
                ", activeCode='" + activeCode + '\'' +
                ", staus=" + staus +
                ", role='" + role + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public int getStaus() {
        return staus;
    }

    public void setStaus(int staus) {
        this.staus = staus;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
}
