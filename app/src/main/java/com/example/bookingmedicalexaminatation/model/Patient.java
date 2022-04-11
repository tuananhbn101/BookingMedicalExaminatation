package com.example.bookingmedicalexaminatation.model;

import java.io.Serializable;

public class Patient implements Serializable {
    private String id;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private String gender;
    private String birthOfDate;
    private String phone;
    private String address;
    private String job;

    public Patient() {
    }

    public Patient(String id, String username, String password, String email, String fullName, String gender, String birthOfDate, String phone, String address, String job) {
        this.id = id;
        this.userName = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.birthOfDate = birthOfDate;
        this.phone = phone;
        this.address = address;
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return birthOfDate;
    }

    public void setDateOfBirth(String birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
