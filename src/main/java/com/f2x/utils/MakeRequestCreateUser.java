package com.f2x.utils;

public class MakeRequestCreateUser {
    public static String getRequest(String name, String job){
        String request =  "{\"name\": \""+name+"\",\"job\": \""+job+"\"}";
        return request;

    }
}
