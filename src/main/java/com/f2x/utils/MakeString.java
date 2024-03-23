package com.f2x.utils;
import com.f2x.models.User;

import static com.f2x.utils.UtilProperties.getData;

public class MakeString {
    public static String getStringFirstname(User user){
        return getData("string.first.name")+user.getFirstName();
    }

    public static String getStringLastName(User user){
        return getData("string.last.name")+user.getLastName();
    }

    public static String getStringEmail(User user){
        return getData("string.email")+user.getEmail();
    }

    public static String getStringName(User user){
        return getData("string.name")+user.getFirstName();
    }
    public static String getStringJob(User user){
        return getData("string.job")+user.getJob();
    }
    public static String getStringRegisterId(){return getData("string.id");
    }
    public static String getStringRegisterToken(){
        return getData("string.token");
    }



}
