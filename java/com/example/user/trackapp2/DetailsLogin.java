package com.example.user.trackapp2;

public class DetailsLogin {

    String fullname;
    Long loginid;
    String password;

    DetailsLogin(){

    }

    DetailsLogin(String full,Long id,String pass){

        this.fullname=full;
        this.loginid=id;
        this.password=pass;

    }

    DetailsLogin(Long id,String pass){

        this.loginid=id;
        this.password=pass;

    }

    void setFullName(String full){

        this.fullname=full;

    }

    String getFullName(){

        return this.fullname;

    }

    void setLoginId(Long id){

        this.loginid=id;

    }

    Long getLoginId(){

        return this.loginid;

    }

    void setPassword(String pass){

        this.password=pass;

    }

}
