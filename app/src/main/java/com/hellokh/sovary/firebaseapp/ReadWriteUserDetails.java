package com.hellokh.sovary.firebaseapp;

public class ReadWriteUserDetails {
    public String username, email, pwd;
    public String expenses, revenue;
    private Long exp;
    private Long rev;

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

    public ReadWriteUserDetails(String textExpenses, String textRevenue) {
        this.expenses = textExpenses;
        this.revenue = textRevenue;
    }
}




