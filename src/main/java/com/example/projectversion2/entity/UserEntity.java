package com.example.projectversion2.entity;

import javax.persistence.*;

@Entity
public class UserEntity {
    @Id
    @Column(name = "UserID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserID;
    @Column(name = "Name",nullable = false)
    private String name;
    @Column(name = "Pass",nullable = false)
    private String pass;
    @Column(name = "Email",nullable = false)
    private String email;
    @Column(name = "CPF",nullable = false)
    private String CPF;
    @Column(name = "Token",nullable = false)
    private String token;
    @Column(name = "Permission",nullable = false)
    private int Permission;
    @Column(name = "Status_User",nullable = false)
    private boolean Status;

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getPermission() {
        return Permission;
    }

    public void setPermission(int permission) {
        Permission = permission;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getID() {
        return token;
    }

    public void setID(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
