package com.example.bookingmedicalexaminatation.view.rate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.DialogRateBinding;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.viewmodel.AppointmentViewModel;
import com.example.bookingmedicalexaminatation.viewmodel.DoctorViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class RateDialog extends BottomSheetDialogFragment {
    private DialogRateBinding binding;
    private DoctorViewModel doctorViewModel;
    private AppointmentViewModel appointmentViewModel;
    private String userName = "";
    private Appointment appointment;
    private Callback callBack;

    public static RateDialog newInstance(String doctorUserName, Appointment appointment) {

        Bundle args = new Bundle();
        args.putString(Const.DOCTOR_ROLE, doctorUserName);
        args.putSerializable(Const.APPOINTMENT, appointment);
        RateDialog fragment = new RateDialog();
        fragment.setArguments(args);
        return fragment;
    }

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
        Bundle bundle = getArguments();
        userName = bundle.getString(Const.DOCTOR_ROLE);
        appointment = (Appointment) bundle.getSerializable(Const.APPOINTMENT);

        binding.close.setOnClickListener(view -> dismiss());
        binding.start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.start1.setColorFilter(R.color.yellow);
                setRate(1);
            }
        });
        binding.start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.start1.setColorFilter(R.color.yellow);
                binding.start2.setColorFilter(R.color.yellow);
                setRate(2);
            }
        });
        binding.start3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.start1.setColorFilter(R.color.yellow);
                binding.start2.setColorFilter(R.color.yellow);
                binding.start3.setColorFilter(R.color.yellow);
                setRate(3);
            }
        });
        binding.start4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.start1.setColorFilter(R.color.yellow);
                binding.start2.setColorFilter(R.color.yellow);
                binding.start3.setColorFilter(R.color.yellow);
                binding.start4.setColorFilter(R.color.yellow);
                setRate(4);
            }
        });
        binding.start5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.start1.setColorFilter(R.color.yellow);
                binding.start2.setColorFilter(R.color.yellow);
                binding.start3.setColorFilter(R.color.yellow);
                binding.start4.setColorFilter(R.color.yellow);
                binding.start5.setColorFilter(R.color.yellow);
                setRate(5);
            }
        });
        doctorViewModel = ViewModelProviders.of(this).get(DoctorViewModel.class);
        appointmentViewModel = ViewModelProviders.of(this).get(AppointmentViewModel.class);
    }

    private void setRate(int rate) {
        doctorViewModel.rate(userName, rate);
        appointment.setStatus(Const.Configure.COMPLETED);
        appointmentViewModel.updateAppointment(appointment);
        dismiss();
        callBack.callback();
    }

    public void setCallBack(Callback callBack) {
        this.callBack = callBack;
    }

    public interface Callback {
        void callback();
    }
}
