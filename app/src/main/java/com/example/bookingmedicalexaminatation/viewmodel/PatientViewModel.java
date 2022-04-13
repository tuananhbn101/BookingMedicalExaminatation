package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.repository.Repository;
import com.example.bookingmedicalexaminatation.util.Const;

import java.util.List;

public class PatientViewModel extends UserViewModel {
    private MutableLiveData<List<Patient>> patients;
    private Repository repository;

    public PatientViewModel(@NonNull Application application) {
        super(application);
        patients = new MutableLiveData<>();
        repository = new Repository();
    }

    @Override
    public void requestPatientSuccess(Patient patientResponse) {
        super.requestPatientSuccess(patientResponse);
        patient.postValue(patientResponse);
    }

    @Override
    public void requestPatientsSuccess(List<Patient> patientList) {
        super.requestPatientsSuccess(patientList);
        patients.postValue(patientList);
    }

    @Override
    public void updateSuccess(Boolean isSuccess) {
        super.updateSuccess(isSuccess);
        updateSuccess.postValue(isSuccess);
    }

    public MutableLiveData<List<Patient>> getPatients() {
        return patients;
    }

    public void getPatientInfo() {
        repository.getAccount(storage.getId(), Const.PATIENT_ROLE, this);
    }

    public void updatePatient(Patient patient) {
        repository.updateAccount(patient, this);
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    public void getPatientList() {
        repository.getAccounts(Const.PATIENT_ROLE, this);
    }
}
