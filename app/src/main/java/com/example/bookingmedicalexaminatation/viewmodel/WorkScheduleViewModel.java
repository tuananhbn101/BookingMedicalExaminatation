package com.example.bookingmedicalexaminatation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bookingmedicalexaminatation.database.Service;
import com.example.bookingmedicalexaminatation.model.WorkSchedule;
import com.example.bookingmedicalexaminatation.repository.Repository;

import java.util.List;

public class WorkScheduleViewModel extends BaseViewModel implements Service.WorkCallBack {
    private Repository repository;
    private MutableLiveData<Boolean> registerWorkScheduleSuccess;
    private MutableLiveData<List<WorkSchedule>> workSchedules;

    public WorkScheduleViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
        registerWorkScheduleSuccess = new MutableLiveData<>();
        workSchedules = new MutableLiveData<>();
    }

    @Override
    public void registerWorkScheduleSuccess(Boolean isSuccess) {
        registerWorkScheduleSuccess.postValue(isSuccess);
    }

    @Override
    public void requestWorkSchedulesSuccess(List<WorkSchedule> workSchedulesResponse) {
        workSchedules.postValue(workSchedulesResponse);
    }

    public MutableLiveData<Boolean> getRegisterWorkScheduleSuccess() {
        return registerWorkScheduleSuccess;
    }



    public void registerWorkSchedule(WorkSchedule workSchedule) {
        workSchedule.setUserName(storage.getUserName());
        repository.registerWorkSchedule(workSchedule, this);
    }

    public MutableLiveData<List<WorkSchedule>> getWorkSchedules() {
        return workSchedules;
    }

    public void getWorkScheduleList() {
        repository.getWorkSchedules(storage.getUserName(), this);
    }
}
