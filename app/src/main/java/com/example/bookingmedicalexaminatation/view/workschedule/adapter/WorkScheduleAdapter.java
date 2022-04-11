package com.example.bookingmedicalexaminatation.view.workschedule.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.databinding.ActivityWorkScheduleItemBinding;
import com.example.bookingmedicalexaminatation.model.WorkSchedule;

import java.util.ArrayList;
import java.util.List;

public class WorkScheduleAdapter extends RecyclerView.Adapter<WorkScheduleAdapter.ViewHolder> {
    private List<WorkSchedule> workSchedules;

    public WorkScheduleAdapter() {
        workSchedules = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(ActivityWorkScheduleItemBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.id.setText(workSchedules.get(position).getId());
        holder.binding.date.setText(workSchedules.get(position).getDate());
        holder.binding.place.setText(workSchedules.get(position).getPlace());
        holder.binding.time.setText(workSchedules.get(position).getFrom() + " - " + workSchedules.get(position).getTo());
    }

    @Override
    public int getItemCount() {
        return workSchedules.size();
    }

    public void setWorkSchedules(List<WorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ActivityWorkScheduleItemBinding binding;

        public ViewHolder(ActivityWorkScheduleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
