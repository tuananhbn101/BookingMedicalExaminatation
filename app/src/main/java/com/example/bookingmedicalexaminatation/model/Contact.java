package com.example.bookingmedicalexaminatation.model;

public class Contact {
    private String id;
    private String userName;
    private String reason;
    private String content;
    private String role;

    public Contact() {
    }

    public Contact(String id, String userName, String reason, String content, String role) {
        this.id = id;
        this.userName = userName;
        this.reason = reason;
        this.content = content;
        this.role = role;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
