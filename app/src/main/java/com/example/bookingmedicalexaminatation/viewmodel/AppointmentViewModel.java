package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.repository.Repository;
import com.example.bookingmedicalexaminatation.util.Const;

import java.util.List;

public class AppointmentViewModel extends BaseViewModel implements Service.AppointmentCallBack {
    private Repository repository;
    private MutableLiveData<List<Appointment>> appointments;

    public AppointmentViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
        appointments = new MutableLiveData<>();
    }

    public MutableLiveData<List<Appointment>> getAppointments() {
        return appointments;
    }

    public void getAppointmentList() {
        repository.getAppointmentList(storage.getUserName(), storage.getRole(Const.Account.USER_ROLE), this);
    }

    public void updateAppointment(Appointment appointment) {
        repository.createAppointment(appointment, this);
    }

    @Override
    public void createSuccess(Boolean isSuccess) {

    }

    @Override
    public void getAppointmentsSuccess(List<Appointment> appointmentsResponse) {
        for (int i = 0; i < appointmentsResponse.size(); i++) {
            if (appointmentsResponse.get(i).getStatus().equals(Const.Configure.HISTORY)
                    || appointmentsResponse.get(i).getStatus().equals(Const.Configure.COMPLETED)) {
                appointmentsResponse.remove(i);
            }
        }
        appointments.postValue(appointmentsResponse);
    }
}
