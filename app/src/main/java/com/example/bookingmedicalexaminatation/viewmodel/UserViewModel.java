package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.repository.Repository;
import com.example.bookingmedicalexaminatation.util.Const;

import java.util.List;

public abstract class UserViewModel extends BaseViewModel implements Service.CallBack {
    protected Repository repository;
    protected MutableLiveData<Doctor> doctor;
    protected MutableLiveData<Patient> patient;
    protected MutableLiveData<Boolean> updateSuccess;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
        doctor = new MutableLiveData<>();
        patient = new MutableLiveData<>();
        updateSuccess = new MutableLiveData<>();
    }

    @Override
    public void requestDoctorSuccess(Doctor doctorResponse) {
        doctor.postValue(doctorResponse);
    }

    @Override
    public void requestPatientSuccess(Patient patientResponse) {
        patient.postValue(patientResponse);
    }

    @Override
    public void requestPatientsSuccess(List<Patient> patientList) {

    }

    @Override
    public void requestDoctorsSuccess(List<Doctor> doctorList) {

    }

    @Override
    public void updateSuccess(Boolean isSuccess) {

    }

    public MutableLiveData<Doctor> getDoctor() {
        return doctor;
    }

    public MutableLiveData<Patient> getPatient() {
        return patient;
    }

    public MutableLiveData<Boolean> getUpdateSuccess() {
        return updateSuccess;
    }

    public void getAccount() {
        repository.getAccount(storage.getId(), storage.getRole(Const.Account.USER_ROLE), this);
    }
}
