package com.example.bookingmedicalexaminatation.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.database.Storage;
import com.example.bookingmedicalexaminatation.repository.Repository;
import com.example.bookingmedicalexaminatation.util.Const;


public class LoginViewModel extends AndroidViewModel {
    public MutableLiveData<Boolean> loginSuccess;
    public Repository repository;
    public Storage storage;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginSuccess = new MutableLiveData<>();
        repository = new Repository();
        storage = new Storage(application);
    }

    public void login(String userName, String passWord, String userRole) {
        repository.login(userName, passWord, userRole, accountId -> {
            if (accountId.isEmpty()) {
                loginSuccess.postValue(false);
            } else {
                storage.putAccountId(accountId);
                storage.putString(Const.Account.USER_NAME, userName);
                loginSuccess.postValue(true);
            }
        });
    }

    public MutableLiveData<Boolean> getLoginSuccess() {
        return loginSuccess;
    }
}
