package com.example.bookingmedicalexaminatation.view.bookappointment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.databinding.ActivityBookAppoimentBinding;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.appointment.AppointmentActivity;
import com.example.bookingmedicalexaminatation.view.bookappointment.choosedoctor.ChooseDoctorActivity;
import com.example.bookingmedicalexaminatation.viewmodel.BookAppointmentViewModel;

public class BookAppointmentActivity extends AppCompatActivity {
    private ActivityBookAppoimentBinding binding;
    private BookAppointmentViewModel bookAppointmentViewModel;
    private Patient patient;
    private static int REQUEST_CODE = 1;
    private Doctor doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookAppoimentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null && data.getSerializableExtra(Const.Configure.DOCTOR_RESULT) != null) {
                    doctor = (Doctor) data.getSerializableExtra(Const.Configure.DOCTOR_RESULT);
                    binding.doctorName.setText(doctor.getFullName());
                }
            }
        }
    }

    private void init() {
        bookAppointmentViewModel = ViewModelProviders.of(this).get(BookAppointmentViewModel.class);
        bookAppointmentViewModel.getBookAppointmentSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean createAppointmentSuccess) {
                if (createAppointmentSuccess) {
                    startActivity(new Intent(getApplicationContext(), AppointmentActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Đặt lịch khám không thành công. Xin thử lại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bookAppointmentViewModel.getPatient().observe(this, new Observer<Patient>() {
            @Override
            public void onChanged(Patient patientResponse) {
                patient = patientResponse;
                binding.patientName.setText(patient.getFullName());
            }
        });

        bookAppointmentViewModel.getPatientInfo();

        binding.doctorName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), ChooseDoctorActivity.class), REQUEST_CODE);
            }
        });
    }


}