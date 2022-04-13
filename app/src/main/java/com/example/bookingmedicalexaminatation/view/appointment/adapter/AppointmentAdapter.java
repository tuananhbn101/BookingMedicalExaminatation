package com.example.bookingmedicalexaminatation.view.appointment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityAppointmentItemBinding;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.util.Const;

import java.util.ArrayList;
import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {
    private List<Appointment> appointmentList;
    private OnClickListener onClickListener;

    public AppointmentAdapter() {
        appointmentList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ActivityAppointmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.id.setText(appointmentList.get(position).getId());
        holder.binding.doctor.setText(appointmentList.get(position).getDoctorUserName());
        holder.binding.date.setText(appointmentList.get(position).getDate());
        holder.binding.place.setText(appointmentList.get(position).getPlace());
        if (appointmentList.get(position).getStatus().equals(Const.Configure.CONFIRM)) {
            holder.binding.confirm.setBackgroundResource(R.color.green_light);
            holder.binding.confirm.setText("Đã tiếp nhận");

        } else {
            holder.binding.confirm.setBackgroundResource(R.color.red_light);
            holder.binding.confirm.setText("Chưa tiếp nhận");
            holder.binding.confirm.setOnClickListener(view -> onClickListener.onConfirmClick(position));
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

    public void updateAppointment(int position) {
        appointmentList.get(position).setStatus(Const.Configure.CONFIRM);
        notifyItemChanged(position);
    }

    public Appointment getAppointment(int position) {
        return appointmentList.get(position);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ActivityAppointmentItemBinding binding;

        public ViewHolder(ActivityAppointmentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnClickListener {
        void onConfirmClick(int position);
    }
}
