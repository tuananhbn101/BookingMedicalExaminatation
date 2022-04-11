package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.database.Storage;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.repository.Repository;
import com.example.bookingmedicalexaminatation.util.Const;

public class ChangePasswordViewModel extends UserViewModel {
    private Repository repository;
    private Storage storage;
    private MutableLiveData<Object> object;
    private MutableLiveData<Boolean> updateSuccess;

    public ChangePasswordViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
        storage = new Storage(application);
        object = new MutableLiveData<>();
        updateSuccess = new MutableLiveData<>();
    }

    @Override
    public void requestPatientSuccess(Patient patientResponse) {
        super.requestPatientSuccess(patientResponse);
        object.postValue(patientResponse);
    }

    @Override
    public void requestDoctorSuccess(Doctor doctorResponse) {
        super.requestDoctorSuccess(doctorResponse);
        object.postValue(doctorResponse);
    }

    @Override
    public void updateSuccess(Boolean isSuccess) {
        super.updateSuccess(isSuccess);
        updateSuccess.postValue(isSuccess);
    }

    public MutableLiveData<Object> getObject() {
        return object;
    }

    public MutableLiveData<Boolean> getUpdateSuccess() {
        return updateSuccess;
    }

    public void getAccount() {
        repository.getAccount(storage.getId(), storage.getRole(Const.Account.USER_ROLE), this);
    }

    public String getRole() {
        return storage.getRole(Const.Account.USER_ROLE);
    }

    public void updatePassword(Object object) {
        if (storage.getRole(Const.Account.USER_ROLE).equals(Const.PATIENT_ROLE)) {
            Patient patient = (Patient) object;
            repository.updateAccount(patient, this);
        } else {
            Doctor doctor = (Doctor) object;
            repository.updateAccount(doctor, this);
        }
    }
}
