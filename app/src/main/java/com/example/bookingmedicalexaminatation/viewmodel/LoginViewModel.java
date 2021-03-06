package com.example.bookingmedicalexaminatation.viewmodel;

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
        repository.login(userName, passWord, userRole, (accountId, userRole1, fullName) -> {
            if (accountId.isEmpty()) {
                loginSuccess.postValue(false);
            } else {
                storage.putAccountId(accountId);
                storage.putString(Const.Account.USER_ROLE, userRole1);
                storage.putString(Const.Account.USER_NAME, userName);
                storage.putString(Const.Account.FULL_NAME, fullName);
                loginSuccess.postValue(true);
            }
        });
    }

    public MutableLiveData<Boolean> getLoginSuccess() {
        return loginSuccess;
    }
}
