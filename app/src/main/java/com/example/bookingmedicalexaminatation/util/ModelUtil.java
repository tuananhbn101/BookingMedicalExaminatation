package com.example.bookingmedicalexaminatation.util;

import java.text.DecimalFormat;

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

    public static String createContactId() {
        return "contact" + System.currentTimeMillis();
    }

    public static String ratePercent(String rates) {
        String[] rateArray = rates.split(",");
        int totalRate = 0;
        for (int i = 0; i < rateArray.length; i++) {
            totalRate = totalRate + Integer.parseInt(rateArray[i]);
        }
        DecimalFormat format = new DecimalFormat("#.##");
        return format.format(((float) totalRate / rateArray.length) / 5f * 100);
    }
}
