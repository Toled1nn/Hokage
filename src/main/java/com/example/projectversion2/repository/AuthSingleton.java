package com.example.projectversion2.repository;

import java.util.ArrayList;
import java.util.List;

public class AuthSingleton {
    private static AuthSingleton instance = new AuthSingleton();
    private List<String> users = new ArrayList<>();

    private AuthSingleton(){
    }

    public static AuthSingleton getSingleton(){
        return instance;
    }

    public void registerAuth(String id){
        users.add(id);
    }

    public boolean isAuthenticated(String id){
        for(String s: users){
            if(s.equals(id)){
                return true;
            }
        }
        return false;
    }

}
