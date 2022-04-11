package com.example.bookingmedicalexaminatation.view.workschedule;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.databinding.ActivityWorkScheduleRegisterBinding;
import com.example.bookingmedicalexaminatation.model.WorkSchedule;
import com.example.bookingmedicalexaminatation.util.ModelUtil;
import com.example.bookingmedicalexaminatation.viewmodel.WorkScheduleViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class WorkScheduleRegisterActivity extends AppCompatActivity {
    private ActivityWorkScheduleRegisterBinding binding;
    private WorkScheduleViewModel workScheduleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkScheduleRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        binding.title.title.setText("Đăng ký lịch làm việc");
        binding.title.back.setOnClickListener(v -> {
            finish();
        });

        binding.date.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, day);
                    String myFormat = "dd-MM-yyyy";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
                    binding.date.setText(dateFormat.format(calendar.getTime()));
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        binding.from.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    calendar.set(Calendar.HOUR_OF_DAY, i);
                    calendar.set(Calendar.MINUTE, i1);
                    String myFormat = "HH:mm";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
                    binding.from.setText(dateFormat.format(calendar.getTime()));
                }
            }, 7, 0, true);
            timePickerDialog.show();
        });

        binding.to.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    calendar.set(Calendar.HOUR_OF_DAY, i);
                    calendar.set(Calendar.MINUTE, i1);
                    String myFormat = "HH:mm";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
                    binding.to.setText(dateFormat.format(calendar.getTime()));
                }
            }, 17, 0, true);
            timePickerDialog.show();
        });

        binding.registerWorkSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkSchedule workSchedule = new WorkSchedule();
                workSchedule.setId(ModelUtil.createWorkScheduleId());
                workSchedule.setDate(binding.date.getText().toString().trim());
                workSchedule.setPlace(binding.place.getSelectedItem().toString().trim());
                workSchedule.setFrom(binding.from.getText().toString().trim());
                workSchedule.setTo(binding.to.getText().toString().trim());
                workSchedule.setPrice(binding.price.getText().toString().trim());
                workScheduleViewModel.registerWorkSchedule(workSchedule);
            }
        });

        setAdapter();

        observer();
    }

    private void observer(){
        workScheduleViewModel = ViewModelProviders.of(this).get(WorkScheduleViewModel.class);
        workScheduleViewModel.getRegisterWorkScheduleSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isSuccess) {
                if(isSuccess){
                    Toast.makeText(getApplicationContext(),"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Đăng kí không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setAdapter() {
        List<String> dummy = new ArrayList<>();
        dummy.add("Phòng 8 - T1");
        dummy.add("Phòng 3 - T4");
        dummy.add("Phòng 2 - T2");
        dummy.add("Phòng 1 - T3");
        dummy.add("Phòng 6 - T7");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, dummy);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        binding.place.setAdapter(adapter);
    }
}