package com.example.bookingmedicalexaminatation.view.bookappointment.choosedoctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.lifecycle.Observer;

import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.profile.doctor.DoctorActivity;

import java.util.ArrayList;
import java.util.List;

public class ChooseDoctorActivity extends DoctorActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doctorAdapter.setOnItemClickListener(doctor -> {
            Intent intent = new Intent();
            intent.putExtra(Const.Configure.DOCTOR_RESULT, doctor);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

    }
}
