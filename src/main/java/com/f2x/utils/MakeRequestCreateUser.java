package com.f2x.utils;

public class MakeRequestCreateUser {
    public static String getRequest(String name, String job){
        String request =  "{\"name\": \""+name+"\",\"job\": \""+job+"\"}";
        return request;

    }

    public static String getRequestRegister(String email, String password){
        String request =  "{\"email\": \""+email+"\",\"password\": \""+password+"\"}";
        return request;

    }

    public static String getRequestRegister(String email){
        String request =  "{\"email\": \""+email+"\",";
        return request;

    }

}
