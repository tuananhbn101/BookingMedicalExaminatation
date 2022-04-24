package com.example.bookingmedicalexaminatation.view.rate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookingmedicalexaminatation.databinding.DialogRateBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class RateDialog extends BottomSheetDialogFragment {
    private DialogRateBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogRateBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        binding.close.setOnClickListener(view -> dismiss());
    }
}
