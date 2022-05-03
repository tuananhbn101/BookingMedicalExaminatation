package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.repository.Repository;
import com.example.bookingmedicalexaminatation.util.Const;

import java.util.List;

public class HistoryViewModel extends BaseViewModel implements Service.AppointmentCallBack {
    private Repository repository;
    private MutableLiveData<List<Appointment>> appointments;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
        appointments = new MutableLiveData<>();
    }

    @Override
    public void createSuccess(Boolean isSuccess) {

    }

    @Override
    public void getAppointmentsSuccess(List<Appointment> appointmentsResponse) {
        for (int i = appointmentsResponse.size() - 1; i >= 0; i--) {
            if (appointmentsResponse.get(i).getStatus().equals(Const.Configure.WAIT_CONFIRM)
                    || appointmentsResponse.get(i).getStatus().equals(Const.Configure.CONFIRM)) {
                appointmentsResponse.remove(i);
            }
        }
        appointments.postValue(appointmentsResponse);
    }


    public MutableLiveData<List<Appointment>> getAppointments() {
        return appointments;
    }

    public void getAppointmentList() {
        repository.getAppointmentList(storage.getUserName(), storage.getRole(Const.Account.USER_ROLE), this);
    }

}
