package com.example.bookingmedicalexaminatation.model;

import java.io.Serializable;

public class Appointment implements Serializable {
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
    private String from;
    private String to;
    private long price;

    public Appointment() {
    }

    public Appointment(String id, String doctorUserName, String doctorFullName, String patientUserName, String patientFullName, String date, String doctorSpecialist, String place, boolean hasInsurance, String status, String from, String to, long price) {
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
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorUserName() {
        return doctorUserName;
    }

    public void setDoctorUserName(String doctorUserName) {
        this.doctorUserName = doctorUserName;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public String getPatientUserName() {
        return patientUserName;
    }

    public void setPatientUserName(String patientUserName) {
        this.patientUserName = patientUserName;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctorSpecialist() {
        return doctorSpecialist;
    }

    public void setDoctorSpecialist(String doctorSpecialist) {
        this.doctorSpecialist = doctorSpecialist;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
