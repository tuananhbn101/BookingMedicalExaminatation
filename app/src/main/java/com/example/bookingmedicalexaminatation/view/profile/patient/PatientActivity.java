package com.example.bookingmedicalexaminatation.view.profile.patient;

import android.content.Intent;
import android.os.Bundle;

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

public class PatientActivity extends AppCompatActivity {
    private ActivityPatientBinding binding;
    private PatientViewModel patientViewModel;
    private PatientAdapter patientAdapter;

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
        binding.content.title.back.setOnClickListener(view -> finish());
        binding.content.title.title.setText(getString(R.string.patient_list));

        patientAdapter = new PatientAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.content.listItem.setLayoutManager(layoutManager);
        binding.content.listItem.setAdapter(patientAdapter);

        patientAdapter.setOnClickListener(patient -> {
            Intent intent = new Intent(getApplicationContext(),PatientProfileActivity.class);
            intent.putExtra(Const.PATIENT_ROLE,patient);
            startActivity(intent);
        });

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        patientViewModel.getPatients().observe(this, patients -> {
            patientAdapter.setPatients(patients);
        });
    }
}