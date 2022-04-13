package com.example.bookingmedicalexaminatation.view.appointment;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.databinding.ActivityAppointmentBinding;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.view.appointment.adapter.AppointmentAdapter;
import com.example.bookingmedicalexaminatation.viewmodel.AppointmentViewModel;

import java.util.List;

public class AppointmentActivity extends AppCompatActivity {
    private ActivityAppointmentBinding binding;
    private AppointmentViewModel appointmentViewModel;
    private AppointmentAdapter appointmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppointmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        appointmentViewModel.getAppointmentList();
    }

    private void init() {
        binding.title.title.setText("Phiếu khám");
        binding.title.back.setOnClickListener(v -> {
            finish();
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        appointmentAdapter = new AppointmentAdapter();
        binding.appointmentList.setLayoutManager(layoutManager);
        binding.appointmentList.setAdapter(appointmentAdapter);

        appointmentAdapter.setOnClickListener(new AppointmentAdapter.OnClickListener() {
            @Override
            public void onConfirmClick(int position) {
                AlertDialog alertDialog = new AlertDialog.Builder(AppointmentActivity.this)
                        .setTitle("Chấp nhận phiếu khám")
                        .setMessage("Bạn có xác nhận phiếu khám bệnh ?")
                        .setPositiveButton("Có", (dialogInterface, i) -> {
                            appointmentAdapter.updateAppointment(position);
                            appointmentViewModel.updateAppointment(appointmentAdapter.getAppointment(position));
                            dialogInterface.dismiss();
                        })
                        .setNegativeButton("Không", ((dialogInterface, i) -> {
                            dialogInterface.dismiss();
                        }))
                        .create();
                alertDialog.show();
            }
        });

        appointmentViewModel = ViewModelProviders.of(this).get(AppointmentViewModel.class);
        appointmentViewModel.getAppointments().observe(this, new Observer<List<Appointment>>() {
            @Override
            public void onChanged(List<Appointment> appointments) {
                appointmentAdapter.setAppointmentList(appointments);
            }
        });
    }
}