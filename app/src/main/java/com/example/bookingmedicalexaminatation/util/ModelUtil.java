package com.example.bookingmedicalexaminatation.util;

public class ModelUtil {
    public static String createPatientId() {
        return "patient" + System.currentTimeMillis();
    }
    public static String createDoctorId() {
        return "doctor" + System.currentTimeMillis();
    }
    public static String createAppointmentId() {
        return "appointment" + System.currentTimeMillis();
    }
    public static String createWorkScheduleId() {
        return "workSchedule" + System.currentTimeMillis();
    }
}
