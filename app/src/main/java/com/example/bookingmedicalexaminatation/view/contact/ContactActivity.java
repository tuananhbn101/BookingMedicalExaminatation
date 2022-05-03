package com.example.bookingmedicalexaminatation.view.contact;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingmedicalexaminatation.databinding.ActivityContactBinding;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.contact.adapter.ContactAdapter;
import com.example.bookingmedicalexaminatation.viewmodel.ContactViewModel;

public class ContactActivity extends AppCompatActivity {
    private ActivityContactBinding binding;
    private ContactViewModel contactViewModel;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        binding.title.back.setOnClickListener(view -> finish());
        binding.title.title.setText("Danh sách liên hệ");

        contactAdapter = new ContactAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.contactList.setLayoutManager(layoutManager);
        binding.contactList.setAdapter(contactAdapter);

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        contactViewModel.getContacts().observe(this, contacts -> {
            contactAdapter.setContacts(contacts);
        });

        if (contactViewModel.getRole().equals(Const.DOCTOR_ROLE)) {
            contactViewModel.getContactList(contactViewModel.getUserName());
        } else {
            contactViewModel.getContactList();
        }
    }
}