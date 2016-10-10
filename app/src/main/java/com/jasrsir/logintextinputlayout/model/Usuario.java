package com.jasrsir.logintextinputlayout.model;

/**
 * Created by usuario on 6/10/16.
 */

public class Usuario {

    private String user;
    private String password;

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
