package com.example.bookingmedicalexaminatation.view.profile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityDoctorProfileBinding;

public class DoctorProfileActivity extends AppCompatActivity {
    private ActivityDoctorProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        binding.profile.title.back.setOnClickListener(view -> finish());
        binding.profile.title.title.setText(getString(R.string.doctor_profile));
        binding.profile.btnControl.setText(getString(R.string.update));
    }
}