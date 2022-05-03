package com.example.bookingmedicalexaminatation.util;

public interface Const {
    String PATIENT_ROLE = "Patient";
    String DOCTOR_ROLE = "Doctor";
    String ADMIN_ROLE = "Admin";
    String APPOINTMENT = "Appointment";
    String CONTACT = "Contact";
    String WORK_SCHEDULE = "WorkSchedule";

    interface Account {
        String ACCOUNT_ID = "account_id";
        String USER_NAME = "user_name";
        String PASS_WORD = "pass_word";
        String USER_ROLE = "user_role";
        String FULL_NAME = "full_name";
    }

    interface Configure {
        String CONTROL = "control";
        String DOCTOR_RESULT = "doctor_result";
        String DATE_RESULT = "date_result";
        String WAIT_CONFIRM = "wait_confirm";
        String CONFIRM = "confirm";
        String HISTORY = "history";
        String COMPLETED = "completed";
    }
}

