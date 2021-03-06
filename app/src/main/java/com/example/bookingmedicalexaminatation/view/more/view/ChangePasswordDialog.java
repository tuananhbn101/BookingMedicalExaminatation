package com.example.bookingmedicalexaminatation.view.more.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.databinding.DialogChangePasswordBinding;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.viewmodel.ChangePasswordViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ChangePasswordDialog extends BottomSheetDialogFragment {
    private DialogChangePasswordBinding binding;
    private ChangePasswordViewModel changePasswordViewModel;
    private Patient patient;
    private Doctor doctor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogChangePasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }

    private void init() {
        binding.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePassword();
            }
        });

        changePasswordViewModel = ViewModelProviders.of(this).get(ChangePasswordViewModel.class);
        changePasswordViewModel.getObject().observe(getViewLifecycleOwner(), object -> {
            if (changePasswordViewModel.getRole().equals(Const.PATIENT_ROLE)) {
                patient = (Patient) object;
            } else {
                doctor = (Doctor) object;
            }
        });

        changePasswordViewModel.getUpdateSuccess().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Toast.makeText(getContext(), "?????i m???t kh???u th??nh c??ng", Toast.LENGTH_SHORT).show();
                    dismiss();
                } else {
                    Toast.makeText(getContext(), "?????i m???t kh???u kh??ng th??nh c??ng. Vui l??ng th??? l???i", Toast.LENGTH_SHORT).show();
                }
            }
        });

        changePasswordViewModel.getAccount();
    }

    private void updatePassword() {
        if (changePasswordViewModel.getRole().equals(Const.PATIENT_ROLE)) {
            if (binding.oldPassword.getText().toString().trim().equals(patient.getPassword())) {
                if (binding.newPassword.getText().toString().equals(binding.confirmPassword.getText().toString())) {
                    patient.setPassword(binding.confirmPassword.getText().toString().trim());
                    changePasswordViewModel.updatePassword(patient);
                } else {
                    Toast.makeText(getContext(), "M???t kh???u m???i kh??ng kh???p. Vui l??ng ki???m tra l???i", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "M???t kh???u c?? kh??ng ch??nh x??c. Vui l??ng ki???m tra l???i", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (binding.oldPassword.getText().toString().trim().equals(doctor.getPassWord())) {
                if (binding.newPassword.getText().toString().equals(binding.confirmPassword.getText().toString())) {
                    doctor.setPassWord(binding.confirmPassword.getText().toString().trim());
                    changePasswordViewModel.updatePassword(doctor);
                } else {
                    Toast.makeText(getContext(), "M???t kh???u m???i kh??ng kh???p. Vui l??ng ki???m tra l???i", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "M???t kh???u c?? kh??ng ch??nh x??c. Vui l??ng ki???m tra l???i", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
