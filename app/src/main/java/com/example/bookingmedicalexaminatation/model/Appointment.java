package com.example.bookingmedicalexaminatation.model;

public class Appointment {
    private String id;
    private String doctorUserName;
    private String doctorFullName;
    private String patientUserName;
    private String patientFullName;
    private String date;
    private String doctorSpecialist;
    private String place;
    private boolean hasInsurance;
    private String status;
    private long price;

    public Appointment() {
    }

    public Appointment(String id, String doctorUserName, String doctorFullName, String patientUserName, String patientFullName, String date, String doctorSpecialist, String place, boolean hasInsurance, String status, long price) {
        this.id = id;
        this.doctorUserName = doctorUserName;
        this.doctorFullName = doctorFullName;
        this.patientUserName = patientUserName;
        this.patientFullName = patientFullName;
        this.date = date;
        this.doctorSpecialist = doctorSpecialist;
        this.place = place;
        this.hasInsurance = hasInsurance;
        this.status = status;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDoctorUserName() {
        return doctorUserName;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public String getPatientFullName() {
        return patientFullName;
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

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
