package com.example.bookingmedicalexaminatation.view.profile.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityDoctorProfileBinding;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.viewmodel.DoctorViewModel;

public class DoctorProfileActivity extends AppCompatActivity {
    private ActivityDoctorProfileBinding binding;
    private Doctor doctor;
    private DoctorViewModel doctorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        doctor = new Doctor();
        doctorViewModel = ViewModelProviders.of(this).get(DoctorViewModel.class);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getSerializableExtra(Const.DOCTOR_ROLE) != null) {
                doctor = (Doctor) intent.getSerializableExtra(Const.DOCTOR_ROLE);
                updateUI(doctor);
            } else {
                doctorViewModel.getDoctor().observe(this, new Observer<Doctor>() {
                    @Override
                    public void onChanged(Doctor doctorResponse) {
                        doctor = doctorResponse;
                        updateUI(doctor);
                    }
                });

                doctorViewModel.getDoctorInfo();
            }
        }

        doctorViewModel.getUpdateSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean updateSuccess) {
                if (updateSuccess) {
                    Toast.makeText(getApplicationContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cập nhật không thành công. Vui lòng thử lại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.profile.title.back.setOnClickListener(view -> finish());
        binding.profile.title.title.setText(getString(R.string.doctor_profile));
        binding.profile.btnControl.setText(getString(R.string.update));

        binding.profile.btnControl.setOnClickListener(view -> {
            doctor.setPassWord(binding.profile.etPassword.getText().toString().trim());
            doctor.setFullName(binding.profile.etFullName.getText().toString().trim());
            doctor.setGender(binding.profile.etGender.getText().toString().trim());
            doctor.setDateOfBirth(binding.profile.etDateOfBirth.getText().toString().trim());
            doctor.setPhoneNumber(binding.profile.etPhone.getText().toString().trim());
            doctor.setSpecialist(binding.profile.etSpecialist.getText().toString().trim());
            doctor.setNote(binding.profile.etNote.getText().toString().trim());
            doctorViewModel.updateDoctor(doctor);
        });
    }

    private void updateUI(Doctor doctor) {
        binding.profile.etUserName.setText(doctor.getUserName());
        binding.profile.etUserName.setEnabled(false);
        binding.profile.etPassword.setText(doctor.getPassWord());
        binding.profile.etPassword.setEnabled(false);
        binding.profile.etFullName.setText(doctor.getFullName());
        binding.profile.etGender.setText(doctor.getGender());
        binding.profile.etDateOfBirth.setText(doctor.getDateOfBirth());
        binding.profile.etPhone.setText(doctor.getPhoneNumber());
        binding.profile.etSpecialist.setText(doctor.getSpecialist());
        binding.profile.etNote.setText(doctor.getNote());
    }
}