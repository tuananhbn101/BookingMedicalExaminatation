package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.bookingmedicalexaminatation.database.Storage;
import com.example.bookingmedicalexaminatation.util.Const;

public class BaseViewModel extends AndroidViewModel {
    protected Storage storage;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        storage = new Storage(application);
    }

    public String getRole() {
        return storage.getRole(Const.Account.USER_ROLE);
    }

    public String getUserName(){
        return storage.getUserName();
    }

    public String getFullName(){
        return storage.getFullName();
    }
}
