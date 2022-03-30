package com.example.bookingmedicalexaminatation.repository;

import com.example.bookingmedicalexaminatation.data.Doctor;
import com.example.bookingmedicalexaminatation.data.Patient;
import com.example.bookingmedicalexaminatation.database.Service;

public class Repository {
    private Service service;

    public Repository() {
        service = new Service();
    }

    public void registerAccount(Patient patient, Service.RegisterCallBack callBack) {
        service.registerAccount(patient, callBack);
    }

    public void registerAccount(Doctor doctor, Service.RegisterCallBack callBack) {
        service.registerAccount(doctor, callBack);
    }

    public void checkUserNameExisted(String userName, Service.RegisterCallBack callBack) {
        service.checkUserNameExisted(userName, callBack);
    }

    public void getAccount(String userId, Service.Callback callback) {
        service.getAccount(userId, callback);
    }

    public void login(String userName, String password, String userRole, Service.LoginCallBack loginCallBack) {
        service.login(userName, password, userRole, loginCallBack);
    }
}

