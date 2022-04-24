package com.example.bookingmedicalexaminatation.util;

public class TextInputUtil {
    private static final String userNameRegex = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    private static final String passWordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    private static final String emailRegex = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    private static final String dateRegex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    public static boolean checkUserName(String userName) {
        if (userName.matches(userNameRegex)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPassWord(String passWord) {
        if (passWord.matches(passWordRegex)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkEmail(String email) {
        if (email.matches(emailRegex)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean dateCheck(String date) {
        if (date.matches(dateRegex)) {
            return true;
        } else {
            return false;
        }
    }
}
