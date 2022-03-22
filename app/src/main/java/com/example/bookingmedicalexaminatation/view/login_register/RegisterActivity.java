package com.example.bookingmedicalexaminatation.view.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.data.Account;
import com.example.bookingmedicalexaminatation.databinding.ActivityRegisterBinding;
import com.example.bookingmedicalexaminatation.model.RegisterViewModel;
import com.example.bookingmedicalexaminatation.util.AccountUtil;
import com.example.bookingmedicalexaminatation.util.Const;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        action();
    }

    private void init() {
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        registerViewModel.getExist().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean exist) {
                if (!binding.etUserName.getText().toString().isEmpty() && exist) {
                    binding.etUserName.setError("Username đã tồn tại");
                } else {
                    register();
                }
            }
        });

        registerViewModel.getRegisterSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean success) {
                if (success) {
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    intent.putExtra(Const.Account.USER_NAME, binding.etUserName.getText().toString().trim());
                    intent.putExtra(Const.Account.PASS_WORD, binding.etPassword.getText().toString().trim());
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Có lỗi khi đăng ký. Vui lòng thử lại sau", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void action() {
        binding.btnRegister.setOnClickListener(v -> {
            if (checkEmpty()) {
                registerViewModel.checkUserNameExisted(binding.etUserName.getText().toString().trim());
            }
        });
        binding.title.btnBack.setOnClickListener(v -> finish());
    }

    private void register() {
        Account account = new Account();
        account.setUserId(AccountUtil.createAccountId());
        account.setUserName(binding.etUserName.getText().toString().trim());
        account.setPassword(binding.etPassword.getText().toString().trim());
        account.setEmail(binding.etEmail.getText().toString().trim());
        account.setFullName(binding.etFullName.getText().toString().trim());
        account.setGender(binding.etGender.getText().toString().trim());
        account.setBirthOfDate(binding.etDateOfBirth.getText().toString().trim());
        account.setPhone(binding.etPhone.getText().toString().trim());
        account.setAddress(binding.etAddress.getText().toString().trim());
        account.setJob(binding.etJob.getText().toString().trim());
        account.setUserRole(Const.userRole);
        registerViewModel.registerAccount(account);
    }

    private boolean checkEmpty() {
        if (binding.etUserName.getText().toString().isEmpty()
                || binding.etPassword.getText().toString().isEmpty()
                || binding.etEmail.getText().toString().isEmpty()
                || binding.etFullName.getText().toString().isEmpty()
                || binding.etGender.getText().toString().isEmpty()
                || binding.etDateOfBirth.getText().toString().isEmpty()
                || binding.etPhone.getText().toString().isEmpty()
                || binding.etAddress.getText().toString().isEmpty()
                || binding.etJob.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Bạn cần điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}