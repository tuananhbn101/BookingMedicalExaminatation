package com.example.bookingmedicalexaminatation.view.profile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityProfileBinding;

public class PatientProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        binding.profile.title.title.setText(getString(R.string.patient_profile));
        binding.profile.btnControl.setText(getString(R.string.update));
    }
}