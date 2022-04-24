package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.model.Contact;
import com.example.bookingmedicalexaminatation.repository.Repository;

public class ContactViewModel extends BaseViewModel implements Service.ContactCallBack {
    private MutableLiveData<Boolean> isSuccess;
    private Repository repository;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
        isSuccess = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getIsSuccess() {
        return isSuccess;
    }

    public void createContact(Contact contact) {
        contact.setUserName(getUserName());
        contact.setRole(getRole());
        repository.createContact(contact, this);
    }

    @Override
    public void createSuccess(Boolean isSuccessResponse) {
        isSuccess.postValue(isSuccessResponse);
    }
}
