package com.hellokh.sovary.firebaseapp;

public class ReadWriteUserDetails {
    public String username, email, pwd;
    public String amount, amount1;
    private Long exp;

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public ReadWriteUserDetails(){

    };

    public ReadWriteUserDetails(String textUsername, String textEmail, String textPwd){
        this.username = textUsername;
        this.email = textEmail;
        this.pwd = textPwd;
    }

    public ReadWriteUserDetails(String textAmount, String textAmount1) {
        this.amount = textAmount;
        this.amount1 = textAmount1;
    }


}

