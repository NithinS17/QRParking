package com.example.amma.qrparking;

public class handlerclass{
    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public Integer getMob() {
        return mob;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setMob(Integer mob) {
        this.mob = mob;
    }

    String user;
 String pass;
 Integer mob;

 public  handlerclass(){}


    public handlerclass(String user, String pass, Integer mob) {
        this.user = user;
        this.pass = pass;
        this.mob = mob;
    }
}
