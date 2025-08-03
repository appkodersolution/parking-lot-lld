package com.appkoder.parkinglot.account;

public abstract class Account {
    protected String username;
    protected String password;

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    public void logout() {
        System.out.println(username + " logged out.");
    }
}