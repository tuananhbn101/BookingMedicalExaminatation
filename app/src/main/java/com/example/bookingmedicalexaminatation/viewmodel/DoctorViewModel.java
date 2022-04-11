package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.util.Const;

import java.util.List;

public class DoctorViewModel extends UserViewModel {
    private MutableLiveData<List<Doctor>> doctors;
    private MutableLiveData<Doctor> doctor;
    private MutableLiveData<Boolean> updateSuccess;

    public DoctorViewModel(@NonNull Application application) {
        super(application);
        doctor = new MutableLiveData<>();
        doctors = new MutableLiveData<>();
        updateSuccess = new MutableLiveData<>();
    }

    @Override
    public void requestDoctorSuccess(Doctor doctorResponse) {
        super.requestDoctorSuccess(doctorResponse);
        doctor.postValue(doctorResponse);
    }

    @Override
    public void requestDoctorsSuccess(List<Doctor> doctorList) {
        super.requestDoctorsSuccess(doctorList);
        doctors.postValue(doctorList);
    }

    @Override
    public void updateSuccess(Boolean isSuccess) {
        super.updateSuccess(isSuccess);
        updateSuccess.postValue(isSuccess);
    }

    public MutableLiveData<Doctor> getDoctor() {
        return doctor;
    }

    public MutableLiveData<List<Doctor>> getDoctors() {
        return doctors;
    }

    public MutableLiveData<Boolean> getUpdateSuccess() {
        return updateSuccess;
    }

    public void getDoctorInfo() {
        repository.getAccount(storage.getId(), Const.DOCTOR_ROLE, this);
    }

    public void getDoctorList() {
        repository.getAccounts(Const.DOCTOR_ROLE, this);
    }

    public void updateDoctor(Doctor doctor) {
        repository.updateAccount(doctor, this);
    }
}
