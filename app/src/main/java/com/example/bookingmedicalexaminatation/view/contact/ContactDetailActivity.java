package com.example.bookingmedicalexaminatation.view.contact;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.databinding.ActivityContactBinding;
import com.example.bookingmedicalexaminatation.databinding.ActivityContactDetailBinding;
import com.example.bookingmedicalexaminatation.model.Contact;
import com.example.bookingmedicalexaminatation.util.ModelUtil;
import com.example.bookingmedicalexaminatation.viewmodel.ContactViewModel;

public class ContactDetailActivity extends AppCompatActivity {
    private ActivityContactDetailBinding binding;
    private ContactViewModel contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initAction();
    }

    private void initAction() {
        binding.title.back.setOnClickListener(view -> finish());
        binding.btnSend.setOnClickListener(view -> {
            Contact contact = new Contact();
            contact.setId(ModelUtil.createContactId());
            contact.setReason(binding.reason.getText().toString().trim());
            contact.setContent(binding.content.getText().toString().trim());
            contactViewModel.createContact(contact);
        });
    }

    private void initView() {
        binding.title.title.setText("Liên hệ");
        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        contactViewModel.getIsSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    Toast.makeText(getApplicationContext(),"Gửi thành công",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

}