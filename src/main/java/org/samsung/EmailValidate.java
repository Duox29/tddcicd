package org.samsung;

import com.sun.jdi.request.DuplicateRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmailValidate {
    static Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    public static List<String> emailList = new ArrayList<>();
    public static String Register(String email){
        if(isEmailValidate(email)){
            if(!isEmailDuplicated(email)){
                addMailToList(email);
                return "Register Success";
            }
        }
        return "Register Failed";
    }
    public static boolean isEmailValidate(String email){
        return pattern.matcher(email).matches();
    }
    public static boolean isEmailDuplicated(String email){
        boolean result = emailList.contains(email);
        if(result){
            throw new DuplicateRequestException("Email already exists");
        }
        return false;
    }
    public static void addMailToList(String email){
        emailList.add(email);
    }
    public static void emptyMailList(){
        emailList.clear();
    }
}
