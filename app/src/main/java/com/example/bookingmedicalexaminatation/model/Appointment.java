package com.example.bookingmedicalexaminatation.model;

public class Appointment {
    private String id;
    private String doctorUserName;
    private String patientUserName;
    private String date;
    private String doctorSpecialist;
    private String place;
    private boolean hasInsurance;
    private String status;

    public Appointment() {
    }

    public Appointment(String id, String doctorUserName, String patientUserName, String date, String doctorSpecialist, String place, boolean hasInsurance, String status) {
        this.id = id;
        this.doctorUserName = doctorUserName;
        this.patientUserName = patientUserName;
        this.date = date;
        this.doctorSpecialist = doctorSpecialist;
        this.place = place;
        this.hasInsurance = hasInsurance;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getDoctorUserName() {
        return doctorUserName;
    }

    public String getPatientUserName() {
        return patientUserName;
    }

    public String getDate() {
        return date;
    }

    public String getDoctorSpecialist() {
        return doctorSpecialist;
    }

    public String getPlace() {
        return place;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDoctorUserName(String doctorUserName) {
        this.doctorUserName = doctorUserName;
    }

    public void setPatientUserName(String patientUserName) {
        this.patientUserName = patientUserName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDoctorSpecialist(String doctorSpecialist) {
        this.doctorSpecialist = doctorSpecialist;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}
