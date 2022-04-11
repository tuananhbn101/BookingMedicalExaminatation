package com.example.bookingmedicalexaminatation.view.profile.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.databinding.FragmentDoctorItemBinding;
import com.example.bookingmedicalexaminatation.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    private List<Doctor> doctors;
    private OnItemClickListener onItemClickListener;

    public DoctorAdapter() {
        doctors = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentDoctorItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.name.setText(doctors.get(position).getFullName());
        holder.binding.specialist.setText("Chuyên khoa : " + doctors.get(position).getSpecialist());
        holder.binding.rate.setText(doctors.get(position).getRate() + " %");
        holder.binding.getRoot().setOnClickListener(view -> {
            onItemClickListener.onItemClick(doctors.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private FragmentDoctorItemBinding binding;

        public ViewHolder(FragmentDoctorItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Doctor doctor);
    }
}
