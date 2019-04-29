package com.example.amma.qrparking;

public class adduser {
    private String username;
    private String password;
    private String confirmpass;
    private Integer phonenum;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public adduser(String username,String password,String confirmpass,int phonenum) {
        this.username = username;
        this.password=password;
        this.confirmpass=confirmpass;
        this.phonenum=phonenum;

    }
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public Integer getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(Integer phonenum) {
        this.phonenum = phonenum;
    }

    public adduser() {
    }
}
