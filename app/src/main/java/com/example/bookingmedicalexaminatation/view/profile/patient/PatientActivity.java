package com.example.bookingmedicalexaminatation.view.profile.patient;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityPatientBinding;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.profile.adapter.PatientAdapter;
import com.example.bookingmedicalexaminatation.viewmodel.PatientViewModel;

import java.util.ArrayList;
import java.util.List;

public class PatientActivity extends AppCompatActivity {
    private ActivityPatientBinding binding;
    private PatientViewModel patientViewModel;
    private PatientAdapter patientAdapter;
    private List<Patient> patients;
    private List<Patient> patientFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPatientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        patientViewModel.getPatientList();
    }

    private void init() {
        patients = new ArrayList<>();
        patientFilter = new ArrayList<>();

        binding.content.title.back.setOnClickListener(view -> finish());
        binding.content.title.title.setText(getString(R.string.patient_list));

        patientAdapter = new PatientAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.content.listItem.setLayoutManager(layoutManager);
        binding.content.listItem.setAdapter(patientAdapter);

        patientAdapter.setOnClickListener(patient -> {
            Intent intent = new Intent(getApplicationContext(), PatientProfileActivity.class);
            intent.putExtra(Const.PATIENT_ROLE, patient);
            startActivity(intent);
        });

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        patientViewModel.getPatients().observe(this, patients -> {
            patientAdapter.setPatients(patients);
            this.patients = patients;
        });

        binding.content.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().isEmpty()) {
                    patientFilter.clear();
                    for (Patient patient : patients) {
                        if (patient.getFullName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            patientFilter.add(patient);
                        }
                    }
                    patientAdapter.setPatients(patientFilter);
                } else {
                    patientAdapter.setPatients(patients);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}