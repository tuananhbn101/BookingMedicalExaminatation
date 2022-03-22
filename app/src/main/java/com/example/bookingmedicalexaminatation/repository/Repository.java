package com.example.bookingmedicalexaminatation.repository;

import com.example.bookingmedicalexaminatation.data.Account;
import com.example.bookingmedicalexaminatation.database.Service;

public class Repository {
    private Service service;

    public Repository() {
        service = new Service();
    }

    public void registerAccount(Account account, Service.RegisterCallBack callBack) {
        service.registerAccount(account, callBack);
    }

    public void checkUserNameExisted(String userName, Service.RegisterCallBack callBack) {
        service.checkUserNameExisted(userName, callBack);
    }

    public void getAccount(String userId,Service.Callback callback) {
        service.getAccount(userId,callback);
    }

    public void login(String userName,String password,Service.LoginCallBack loginCallBack) {service.login(userName,password,loginCallBack);}
}

