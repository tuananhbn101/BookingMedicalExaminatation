package com.example.bookingmedicalexaminatation.view.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.data.Doctor;
import com.example.bookingmedicalexaminatation.databinding.ActivityDoctorRegisterBinding;
import com.example.bookingmedicalexaminatation.model.RegisterViewModel;
import com.example.bookingmedicalexaminatation.util.AccountUtil;
import com.example.bookingmedicalexaminatation.view.profile.DoctorActivity;

public class DoctorRegisterActivity extends AppCompatActivity {
    private ActivityDoctorRegisterBinding binding;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void init() {
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        registerViewModel.getExist().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean exist) {
                if (!binding.etUserName.getText().toString().isEmpty() && exist) {
                    binding.etUserName.setError("Username đã tồn tại");
                } else {
                    register();
                }
            }
        });

        registerViewModel.getRegisterSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean success) {
                if (success) {
                    Intent intent = new Intent(getApplicationContext(), DoctorActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Có lỗi khi đăng ký. Vui lòng thử lại sau", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void register() {
        Doctor doctor = new Doctor();
        doctor.setId(AccountUtil.createDoctorId());
        doctor.setUserName(binding.etUserName.getText().toString().trim());
        doctor.setPassWord(binding.etPassword.getText().toString().trim());
        doctor.setFullName(binding.etFullName.getText().toString().trim());
        doctor.setGender(binding.etGender.getText().toString().trim());
        doctor.setDateOfBirth(binding.etDateOfBirth.getText().toString().trim());
        doctor.setPhoneNumber(binding.etPhone.getText().toString().trim());
        doctor.setSpecialist(binding.etSpecialist.getText().toString().trim());
        doctor.setNote(binding.etNote.getText().toString().trim());
        registerViewModel.registerDoctor(doctor);
    }
}