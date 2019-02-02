package com.sample;


public class login {
    public boolean check(String username, String password){
        if(username.equals("astitwa") && password.equals("hello"))
            return true;
        else
            return false;
    }
}
