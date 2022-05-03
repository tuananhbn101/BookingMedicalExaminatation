package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.model.Contact;
import com.example.bookingmedicalexaminatation.repository.Repository;

import java.util.List;

public class ContactViewModel extends BaseViewModel implements Service.ContactCallBack {
    private MutableLiveData<Boolean> isSuccess;
    private MutableLiveData<List<Contact>> contacts;
    private Repository repository;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
        isSuccess = new MutableLiveData<>();
        contacts = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getIsSuccess() {
        return isSuccess;
    }

    public void createContact(Contact contact) {
        contact.setUserName(getUserName());
        contact.setFullName(getFullName());
        contact.setRole(getRole());
        repository.createContact(contact, this);
    }

    public void getContactList(String doctorUserName) {
        repository.getContacts(doctorUserName, this);
    }

    public void getContactList() {
        repository.getContacts(this);
    }

    public MutableLiveData<List<Contact>> getContacts() {
        return contacts;
    }

    @Override
    public void createSuccess(Boolean isSuccessResponse) {
        isSuccess.postValue(isSuccessResponse);
    }

    @Override
    public void requestContactsSuccess(List<Contact> contactsResponse) {
        contacts.postValue(contactsResponse);
    }
}
