package com.example.amma.qrparking;

public class userdetails {
    String username,password,confirmpass;
    int phonenum;

    public userdetails(String username,String password,String confirmpass,int phonenum) {
        this.username = username;
        this.password=password;
        this.confirmpass=confirmpass;
        this.phonenum=phonenum;

    }

    public int getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(int phonenum) {
        this.phonenum = phonenum;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
