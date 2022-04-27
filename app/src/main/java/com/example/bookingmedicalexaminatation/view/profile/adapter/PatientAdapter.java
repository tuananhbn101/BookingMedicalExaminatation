package com.example.bookingmedicalexaminatation.view.profile.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.FragmentPatientItemBinding;
import com.example.bookingmedicalexaminatation.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    private List<Patient> patients;
    private OnClickListener onClickListener;

    public PatientAdapter() {
        patients = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(FragmentPatientItemBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.name.setText("BN. " + patients.get(position).getFullName());
        holder.binding.dateOfBirth.setText(patients.get(position).getDateOfBirth());
        holder.binding.gender.setText(patients.get(position).getGender());
        holder.binding.phoneNumber.setText(patients.get(position).getPhone());
        holder.binding.address.setText(patients.get(position).getAddress());
        if(patients.get(position).getGender().toLowerCase(Locale.ROOT).equals("Nam".toLowerCase())){
            holder.binding.avatar.setImageResource(R.drawable.man);
        }else {
            holder.binding.avatar.setImageResource(R.drawable.woman);
        }
        holder.binding.getRoot().setOnClickListener(view -> onClickListener.onItemClick(patients.get(position)));
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private FragmentPatientItemBinding binding;

        public ViewHolder(FragmentPatientItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnClickListener {
        void onItemClick(Patient patient);
    }
}
