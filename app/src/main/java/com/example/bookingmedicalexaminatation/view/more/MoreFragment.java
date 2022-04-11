package com.example.bookingmedicalexaminatation.view.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.databinding.FragmentMoreBinding;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.login_register.LoginActivity;
import com.example.bookingmedicalexaminatation.view.profile.doctor.DoctorProfileActivity;
import com.example.bookingmedicalexaminatation.view.profile.patient.PatientProfileActivity;
import com.example.bookingmedicalexaminatation.viewmodel.BaseViewModel;

public class MoreFragment extends Fragment {
    private FragmentMoreBinding binding;
    private BaseViewModel baseViewModel;

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
                }
                else {
                    startActivity(new Intent(getContext(), DoctorProfileActivity.class));
                }
            }
        });

        binding.examinationProcess.setOnClickListener(view -> {
            startActivity(new Intent(getContext(),ExaminalProcessActivity.class));
        });

        binding.privacyPolicy.setOnClickListener(view -> {
            startActivity(new Intent(getContext(),SecurityPolicyActivity.class));
        });

        binding.tutorialUse.setOnClickListener(view -> {
            startActivity(new Intent(getContext(),RegulationUseActivity.class));
        });
    }
}
