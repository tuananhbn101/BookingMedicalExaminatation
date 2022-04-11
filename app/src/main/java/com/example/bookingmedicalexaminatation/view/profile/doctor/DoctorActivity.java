package com.example.bookingmedicalexaminatation.view.profile.doctor;

import android.content.Intent;
import android.os.Bundle;

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

import java.util.List;

public class DoctorActivity extends AppCompatActivity {
    private ActivityDoctorBinding binding;
    private DoctorViewModel doctorViewModel;
    protected DoctorAdapter doctorAdapter;

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
    }
}