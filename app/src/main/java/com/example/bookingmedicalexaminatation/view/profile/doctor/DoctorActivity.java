package com.example.bookingmedicalexaminatation.view.profile.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityDoctorBinding;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.login_register.DoctorRegisterActivity;
import com.example.bookingmedicalexaminatation.view.profile.adapter.DoctorAdapter;
import com.example.bookingmedicalexaminatation.viewmodel.DoctorViewModel;

import java.util.ArrayList;
import java.util.List;

public class DoctorActivity extends AppCompatActivity {
    private ActivityDoctorBinding binding;
    private DoctorViewModel doctorViewModel;
    protected DoctorAdapter doctorAdapter;
    private List<Doctor> doctors;
    private List<Doctor> doctorFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        doctorViewModel.getDoctorList();
    }

    private void init() {
        doctors = new ArrayList<>();
        doctorFilter = new ArrayList<>();
        doctorAdapter = new DoctorAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.content.listItem.setLayoutManager(layoutManager);
        binding.content.listItem.setAdapter(doctorAdapter);

        binding.content.title.back.setOnClickListener(view -> finish());
        binding.content.title.title.setText(getString(R.string.list_doctor));

        doctorViewModel = ViewModelProviders.of(this).get(DoctorViewModel.class);
        doctorViewModel.getDoctors().observe(this, new Observer<List<Doctor>>() {
            @Override
            public void onChanged(List<Doctor> doctorList) {
                doctorAdapter.setDoctors(doctorList);
                doctors = doctorList;
            }
        });

        binding.addDoctor.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), DoctorRegisterActivity.class));
        });

        doctorAdapter.setOnItemClickListener(doctor -> {
            Intent intent = new Intent(getApplicationContext(), DoctorProfileActivity.class);
            intent.putExtra(Const.DOCTOR_ROLE, doctor);
            startActivity(intent);
        });

        binding.content.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().isEmpty()) {
                    doctorFilter.clear();
                    for (Doctor doctor : doctors) {
                        if (doctor.getFullName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            doctorFilter.add(doctor);
                        }
                    }
                    doctorAdapter.setDoctors(doctorFilter);
                } else {
                    doctorAdapter.setDoctors(doctors);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}