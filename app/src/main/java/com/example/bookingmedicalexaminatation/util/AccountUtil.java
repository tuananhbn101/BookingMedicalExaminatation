package com.example.bookingmedicalexaminatation.util;

public class AccountUtil {
    public static String createPatientId() {
        return "patient" + System.currentTimeMillis();
    }
    public static String createDoctorId() {
        return "doctor" + System.currentTimeMillis();
    }
}
