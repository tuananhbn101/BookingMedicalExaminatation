package com.example.bookingmedicalexaminatation.view.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityDoctorBinding;

public class DoctorActivity extends AppCompatActivity {
    private ActivityDoctorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        binding.content.title.back.setOnClickListener(view -> finish());
        binding.content.title.title.setText(getString(R.string.list_doctor));
    }
}