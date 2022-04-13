package com.example.bookingmedicalexaminatation.view.more.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {
    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initAction();
    }

    private void initAction() {
        binding.title.back.setOnClickListener(view -> finish());
        binding.btnSend.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Liên hệ", Toast.LENGTH_SHORT).show();
        });
    }

    private void initView() {
        binding.title.title.setText("Liên hệ");
    }

}