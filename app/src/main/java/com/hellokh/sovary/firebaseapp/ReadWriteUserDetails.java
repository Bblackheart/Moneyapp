package com.hellokh.sovary.firebaseapp;

public class ReadWriteUserDetails {
    public String username, email, pwd;

    public ReadWriteUserDetails(){};

    public ReadWriteUserDetails(String textUsername, String textEmail, String textPwd){
        this.username = textUsername;
        this.email = textEmail;
        this.pwd = textPwd;
    }
}
