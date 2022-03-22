package com.example.bookingmedicalexaminatation.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.data.Account;
import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.repository.Repository;

public class RegisterViewModel extends AndroidViewModel implements Service.RegisterCallBack {
    private Repository repository;
    private MutableLiveData<Boolean> exist;
    private MutableLiveData<Boolean> registerSuccess;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
        exist = new MutableLiveData<>();
        registerSuccess = new MutableLiveData<>();
    }

    @Override
    public void registerSuccess(boolean isSuccess) {
        registerSuccess.postValue(isSuccess);
    }

    @Override
    public void userNameExist(boolean isExist) {
        exist.postValue(isExist);
    }


    public MutableLiveData<Boolean> getExist() {
        return exist;
    }

    public MutableLiveData<Boolean> getRegisterSuccess() {
        return registerSuccess;
    }

    public void registerAccount(Account account) {
        repository.registerAccount(account, this);
    }

    public void checkUserNameExisted(String userName) {
        repository.checkUserNameExisted(userName, this);
    }
}
