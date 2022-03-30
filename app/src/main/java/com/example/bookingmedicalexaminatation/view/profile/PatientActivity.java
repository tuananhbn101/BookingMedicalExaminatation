package com.example.bookingmedicalexaminatation.view.profile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityPatientBinding;

public class PatientActivity extends AppCompatActivity {
    private ActivityPatientBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPatientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        binding.content.title.back.setOnClickListener(view -> finish());
        binding.content.title.title.setText(getString(R.string.patient_list));
    }
}