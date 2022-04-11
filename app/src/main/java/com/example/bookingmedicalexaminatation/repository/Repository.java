package com.example.bookingmedicalexaminatation.repository;

import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.model.WorkSchedule;

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

    public void checkUserNameExisted(String userName, String userRole, Service.RegisterCallBack callBack) {
        service.checkUserNameExisted(userName, userRole, callBack);
    }

    public void getAccount(String userId, String userRole, Service.CallBack callback) {
        service.getAccount(userId, userRole, callback);
    }

    public void login(String userName, String password, String userRole, Service.LoginCallBack loginCallBack) {
        service.login(userName, password, userRole, loginCallBack);
    }

    public void getAccounts(String userRole, Service.CallBack callBack) {
        service.getAccounts(userRole, callBack);
    }

    public void createAppointment(Appointment appointment, Service.AppointmentCallBack callBack) {
        service.createAppointment(appointment, callBack);
    }

    public void updateAccount(Doctor doctor, Service.CallBack callback) {
        service.updateAccount(doctor, callback);
    }

    public void updateAccount(Patient patient, Service.CallBack callback) {
        service.updateAccount(patient, callback);
    }

    public void registerWorkSchedule(WorkSchedule workSchedule, Service.WorkCallBack callBack) {
        service.registerWorkSchedule(workSchedule, callBack);
    }

    public void getWorkSchedules(String userName, Service.WorkCallBack callBack) {
        service.getWorkSchedules(userName, callBack);
    }
}

