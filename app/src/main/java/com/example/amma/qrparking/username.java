package com.example.amma.qrparking;

public class username {
    String username;
    int phno;
    public username(){}

    public username(String username,int phno) {
        this.username = username;
        this.phno=phno;
    }

    public int getPhno() {
        return phno;
    }

    public void setPhno(int phno) {
        this.phno = phno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
