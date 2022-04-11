package com.example.bookingmedicalexaminatation.view.workschedule;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.databinding.ActivityWorkScheduleBinding;
import com.example.bookingmedicalexaminatation.model.WorkSchedule;
import com.example.bookingmedicalexaminatation.view.workschedule.adapter.WorkScheduleAdapter;
import com.example.bookingmedicalexaminatation.viewmodel.WorkScheduleViewModel;

import java.util.List;

public class WorkScheduleActivity extends AppCompatActivity {
    private ActivityWorkScheduleBinding binding;
    private WorkScheduleViewModel workScheduleViewModel;
    private WorkScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkScheduleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        workScheduleViewModel.getWorkScheduleList();
    }

    private void init() {
        binding.title.title.setText("Lịch làm việc");
        binding.title.back.setOnClickListener(v -> {
            finish();
        });
        binding.add.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), WorkScheduleRegisterActivity.class));
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter = new WorkScheduleAdapter();
        binding.workList.setLayoutManager(layoutManager);
        binding.workList.setAdapter(adapter);

        workScheduleViewModel = ViewModelProviders.of(this).get(WorkScheduleViewModel.class);
        workScheduleViewModel.getWorkSchedules().observe(this, new Observer<List<WorkSchedule>>() {
            @Override
            public void onChanged(List<WorkSchedule> workSchedules) {
                adapter.setWorkSchedules(workSchedules);
            }
        });
    }
}