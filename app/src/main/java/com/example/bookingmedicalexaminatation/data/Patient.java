package com.example.bookingmedicalexaminatation.data;

public class Patient {
    private String userId;
    public String userName;
    private String password;
    private String email;
    private String fullName;
    private String gender;
    private String birthOfDate;
    private String phone;
    private String address;
    private String job;
    private String userRole;

    public Patient() {
    }

    public Patient(String userId, String username, String password, String email, String fullName, String gender, String birthOfDate, String phone, String address, String job, String userRole) {
        this.userId = userId;
        this.userName = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.birthOfDate = birthOfDate;
        this.phone = phone;
        this.address = address;
        this.job = job;
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(String birthOfDate) {
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
