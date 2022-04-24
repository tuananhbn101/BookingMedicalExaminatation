package com.example.bookingmedicalexaminatation.view.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.databinding.FragmentMoreBinding;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.login_register.LoginActivity;
import com.example.bookingmedicalexaminatation.view.more.view.ChangePasswordDialog;
import com.example.bookingmedicalexaminatation.view.more.view.ExaminalProcessActivity;
import com.example.bookingmedicalexaminatation.view.more.view.RegulationUseActivity;
import com.example.bookingmedicalexaminatation.view.more.view.SecurityPolicyActivity;
import com.example.bookingmedicalexaminatation.view.profile.doctor.DoctorProfileActivity;
import com.example.bookingmedicalexaminatation.view.profile.patient.PatientProfileActivity;
import com.example.bookingmedicalexaminatation.viewmodel.BaseViewModel;
import com.example.bookingmedicalexaminatation.viewmodel.MoreViewModel;

public class MoreFragment extends Fragment {
    private FragmentMoreBinding binding;
    private BaseViewModel baseViewModel;
    private MoreViewModel moreViewModel;

    public static MoreFragment newInstance() {
        Bundle args = new Bundle();

        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMoreBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        baseViewModel = ViewModelProviders.of(this).get(BaseViewModel.class);

        binding.logOut.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), LoginActivity.class));
            getActivity().finish();
        });

        binding.passwordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePasswordDialog changePasswordDialog = new ChangePasswordDialog();
                changePasswordDialog.show(getChildFragmentManager(), "ChangePassword");
            }
        });

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baseViewModel.getRole().equals(Const.PATIENT_ROLE)) {
                    startActivity(new Intent(getContext(), PatientProfileActivity.class));
                } else {
                    startActivity(new Intent(getContext(), DoctorProfileActivity.class));
                }
            }
        });

        binding.examinationProcess.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), ExaminalProcessActivity.class));
        });

        binding.privacyPolicy.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), SecurityPolicyActivity.class));
        });

        binding.tutorialUse.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), RegulationUseActivity.class));
        });

        moreViewModel = ViewModelProviders.of(this).get(MoreViewModel.class);
        if (moreViewModel.getRole().equals(Const.DOCTOR_ROLE)) {
            moreViewModel.getDoctor().observe(getViewLifecycleOwner(), new Observer<Doctor>() {
                @Override
                public void onChanged(Doctor doctor) {
                    binding.name.setText(doctor.getFullName());
                    binding.dateOfBirth.setText(doctor.getDateOfBirth());
                    binding.gender.setText(doctor.getGender());
                }
            });
        } else {
            moreViewModel.getPatient().observe(getViewLifecycleOwner(), new Observer<Patient>() {
                @Override
                public void onChanged(Patient patient) {
                    binding.name.setText(patient.getFullName());
                    binding.dateOfBirth.setText(patient.getDateOfBirth());
                    binding.gender.setText(patient.getGender());
                }
            });
        }
        moreViewModel.getAccount();
    }
}
