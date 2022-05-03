package com.example.bookingmedicalexaminatation.view.contact.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.databinding.ActivityContactItemBinding;
import com.example.bookingmedicalexaminatation.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<Contact> contacts;

    public ContactAdapter() {
        contacts = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ActivityContactItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.id.setText(contacts.get(position).getId());
        holder.binding.name.setText(contacts.get(position).getFullName());
        holder.binding.content.setText(contacts.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ActivityContactItemBinding binding;

        public ViewHolder(ActivityContactItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
