package com.example.bookingmedicalexaminatation.view.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.databinding.ActivityDoctorRegisterBinding;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.viewmodel.RegisterViewModel;
import com.example.bookingmedicalexaminatation.util.ModelUtil;
import com.example.bookingmedicalexaminatation.view.profile.doctor.DoctorActivity;

public class DoctorRegisterActivity extends AppCompatActivity {
    private ActivityDoctorRegisterBinding binding;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
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
                    Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Có lỗi khi đăng ký. Vui lòng thử lại sau", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.btnControl.setOnClickListener(view -> {
            if (checkEmpty()) {
                registerViewModel.checkUserNameExisted(binding.etUserName.getText().toString().trim(), Const.DOCTOR_ROLE);
            }
        });
    }

    private void register() {
        Doctor doctor = new Doctor();
        doctor.setId(ModelUtil.createDoctorId());
        doctor.setUserName(binding.etUserName.getText().toString().trim());
        doctor.setPassWord(binding.etPassword.getText().toString().trim());
        doctor.setFullName(binding.etFullName.getText().toString().trim());
        doctor.setGender(binding.etGender.getText().toString().trim());
        doctor.setDateOfBirth(binding.etDateOfBirth.getText().toString().trim());
        doctor.setPhoneNumber(binding.etPhone.getText().toString().trim());
        doctor.setSpecialist(binding.etSpecialist.getText().toString().trim());
        doctor.setNote(binding.etNote.getText().toString().trim());
        doctor.setRate(100);
        registerViewModel.registerDoctor(doctor);
    }

    private boolean checkEmpty() {
        if (binding.etUserName.getText().toString().isEmpty()
                || binding.etPassword.getText().toString().isEmpty()
                || binding.etSpecialist.getText().toString().isEmpty()
                || binding.etFullName.getText().toString().isEmpty()
                || binding.etGender.getText().toString().isEmpty()
                || binding.etDateOfBirth.getText().toString().isEmpty()
                || binding.etPhone.getText().toString().isEmpty()
                || binding.etNote.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Bạn cần điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}