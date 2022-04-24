package com.example.bookingmedicalexaminatation.view.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.databinding.FragmentHistoryBinding;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.history.adapter.HistoryAdapter;
import com.example.bookingmedicalexaminatation.view.rate.RateDialog;
import com.example.bookingmedicalexaminatation.viewmodel.HistoryViewModel;

import java.util.List;

public class HistoryFragment extends Fragment {
    private FragmentHistoryBinding binding;
    private HistoryViewModel appointmentViewModel;
    private HistoryAdapter adapter;

    public static HistoryFragment newInstance() {
        Bundle args = new Bundle();

        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        adapter = new HistoryAdapter();
        appointmentViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        binding.history.setLayoutManager(manager);
        binding.history.setAdapter(adapter);

        adapter.setRole(appointmentViewModel.getRole());
        adapter.setOnClickListener(new HistoryAdapter.OnClickListener() {
            @Override
            public void onRateClick(Appointment appointment) {
                if (appointmentViewModel.getRole().equals(Const.PATIENT_ROLE)) {
                    RateDialog rateDialog = new RateDialog();
                    rateDialog.show(getChildFragmentManager(), "RateDialog");
                }
            }
        });

        appointmentViewModel.getAppointments().observe(getViewLifecycleOwner(), new Observer<List<Appointment>>() {
            @Override
            public void onChanged(List<Appointment> appointments) {
                adapter.setAppointmentList(appointments);
                if (appointments.size() != 0) {
                    binding.noAppointment.setVisibility(View.GONE);
                }
            }
        });
        appointmentViewModel.getAppointmentList();
    }
}
