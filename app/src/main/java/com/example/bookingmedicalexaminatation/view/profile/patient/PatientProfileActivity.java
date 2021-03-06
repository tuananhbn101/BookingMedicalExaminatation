package com.example.bookingmedicalexaminatation.view.profile.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityProfileBinding;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.viewmodel.PatientViewModel;

public class PatientProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    private PatientViewModel patientViewModel;
    private Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void init() {
        patient = new Patient();
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getSerializableExtra(Const.PATIENT_ROLE) != null) {
                patient = (Patient) intent.getSerializableExtra(Const.PATIENT_ROLE);
                updateUI(patient);
            } else {
                patientViewModel.getPatient().observe(this, new Observer<Patient>() {
                    @Override
                    public void onChanged(Patient patientResponse) {
                        patient = patientResponse;
                        updateUI(patient);
                    }
                });

                patientViewModel.getPatientInfo();
            }
        }

        patientViewModel.getUpdateSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Toast.makeText(getApplicationContext(), "C???p nh???t th??nh c??ng", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "C???p nh???t kh??ng th??nh c??ng. Vui l??ng th??? l???i", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.profile.title.title.setText(getString(R.string.patient_profile));
        binding.profile.btnControl.setText(getString(R.string.update));

        binding.profile.btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patient.setFullName(binding.profile.etFullName.getText().toString().trim());
                patient.setEmail(binding.profile.etEmail.getText().toString().trim());
                patient.setGender(binding.profile.etGender.getText().toString().trim());
                patient.setDateOfBirth(binding.profile.etDateOfBirth.getText().toString().trim());
                patient.setPhone(binding.profile.etPhone.getText().toString().trim());
                patient.setJob(binding.profile.etJob.getText().toString().trim());
                patient.setAddress(binding.profile.etAddress.getText().toString().trim());

                patientViewModel.updatePatient(patient);
            }
        });
    }

    private void updateUI(Patient patient) {
        binding.profile.etUserName.setText(patient.getUserName());
        binding.profile.etUserName.setEnabled(false);
        binding.profile.etPassword.setText(patient.getPassword());
        binding.profile.etPassword.setEnabled(false);
        binding.profile.etFullName.setText(patient.getFullName());
        binding.profile.etEmail.setText(patient.getEmail());
        binding.profile.etGender.setText(patient.getGender());
        binding.profile.etDateOfBirth.setText(patient.getDateOfBirth());
        binding.profile.etPhone.setText(patient.getPhone());
        binding.profile.etJob.setText(patient.getJob());
        binding.profile.etAddress.setText(patient.getAddress());
    }
}