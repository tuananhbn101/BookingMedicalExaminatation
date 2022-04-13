package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.database.Storage;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.util.Const;

import java.util.List;

public class BookAppointmentViewModel extends UserViewModel implements Service.AppointmentCallBack {
    private MutableLiveData<Boolean> bookAppointmentSuccess;
    private MutableLiveData<Patient> patient;
    private Storage storage;

    public BookAppointmentViewModel(@NonNull Application application) {
        super(application);
        bookAppointmentSuccess = new MutableLiveData<>();
        patient = new MutableLiveData<>();
        storage = new Storage(application);
    }

    @Override
    public void requestPatientSuccess(Patient patientResponse) {
        super.requestPatientSuccess(patientResponse);
        patient.postValue(patientResponse);
    }

    @Override
    public void createSuccess(Boolean isSuccess) {
        bookAppointmentSuccess.postValue(isSuccess);
    }

    @Override
    public void getAppointmentsSuccess(List<Appointment> appointments) {

    }

    public MutableLiveData<Boolean> getBookAppointmentSuccess() {
        return bookAppointmentSuccess;
    }

    public MutableLiveData<Patient> getPatient() {
        return patient;
    }

    public void createAppointment(Appointment appointment) {
        repository.createAppointment(appointment, this);
    }

    public void getPatientInfo() {
        repository.getAccount(storage.getId(), Const.PATIENT_ROLE, this);
    }
}
