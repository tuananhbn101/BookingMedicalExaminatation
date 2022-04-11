package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.repository.Repository;

import java.util.List;

public abstract class UserViewModel extends BaseViewModel implements Service.CallBack {
    protected Repository repository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    @Override
    public void requestDoctorSuccess(Doctor doctorResponse) {

    }

    @Override
    public void requestPatientSuccess(Patient patientResponse) {

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
}
