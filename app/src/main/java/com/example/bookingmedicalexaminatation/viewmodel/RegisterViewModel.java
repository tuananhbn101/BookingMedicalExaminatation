package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.model.Patient;
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

    public void registerPatient(Patient patient) {
        repository.registerAccount(patient, this);
    }

    public void registerDoctor(Doctor doctor) {
        repository.registerAccount(doctor, this);
    }

    public void checkUserNameExisted(String userName, String useRole) {
        repository.checkUserNameExisted(userName, useRole,this);
    }
}
