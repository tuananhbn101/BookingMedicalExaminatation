package com.example.bookingmedicalexaminatation.view.bookappointment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.databinding.ActivityBookAppoimentBinding;

public class BookAppointmentActivity extends AppCompatActivity {
    private ActivityBookAppoimentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookAppoimentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }


}