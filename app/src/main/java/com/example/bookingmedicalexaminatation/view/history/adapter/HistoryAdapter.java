package com.example.bookingmedicalexaminatation.view.history.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.FragmentHistoryItemBinding;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.util.Const;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<Appointment> appointmentList;
    private OnClickListener onClickListener;
    private String role;

    public HistoryAdapter() {
        appointmentList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentHistoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.id.setText(appointmentList.get(position).getId());
        holder.binding.date.setText(appointmentList.get(position).getDate());
        holder.binding.place.setText(appointmentList.get(position).getPlace());
        if (role.equals(Const.DOCTOR_ROLE)) {
            holder.binding.rate.setVisibility(View.GONE);
            holder.binding.patient.setText(appointmentList.get(position).getPatientUserName());
        } else {
            holder.binding.userTitle.setText("Bác sỹ :");
            holder.binding.patient.setText(appointmentList.get(position).getDoctorFullName());
            if (appointmentList.get(position).getStatus().equals(Const.Configure.HISTORY)) {
                holder.binding.rate.setBackgroundResource(R.color.color_primary);
                holder.binding.rate.setText("Đánh giá");
                holder.binding.rate.setOnClickListener(view -> onClickListener.onRateClick(appointmentList.get(position)));
            } else if (appointmentList.get(position).getStatus().equals(Const.Configure.COMPLETED)) {
                holder.binding.rate.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
        notifyDataSetChanged();
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private FragmentHistoryItemBinding binding;

        public ViewHolder(FragmentHistoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnClickListener {
        void onRateClick(Appointment appointment);
    }
}
