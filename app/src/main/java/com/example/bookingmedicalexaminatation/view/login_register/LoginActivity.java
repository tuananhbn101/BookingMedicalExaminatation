package com.example.bookingmedicalexaminatation.view.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityLoginBinding;
import com.example.bookingmedicalexaminatation.viewmodel.LoginViewModel;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.MainActivity;


public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        observer();
        action();
    }

    private void init() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getStringExtra(Const.Account.USER_NAME) != null) {
                binding.etUserName.setText(intent.getStringExtra(Const.Account.USER_NAME));
                binding.etPassword.setText(intent.getStringExtra(Const.Account.PASS_WORD));
            }
        }
    }

    private void action() {
        binding.btnLogin.setOnClickListener(view -> {
            if (checkEmpty()) {
                if(binding.etUserName.getText().toString().trim().equals("admin")){
                    loginViewModel.login(binding.etUserName.getText().toString(), binding.etPassword.getText().toString(), Const.ADMIN_ROLE);
                }else {
                    String userRole = "";
                    if (binding.checkRole.isChecked()) {
                        userRole = Const.DOCTOR_ROLE;
                    } else {
                        userRole = Const.PATIENT_ROLE;
                    }
                    loginViewModel.login(binding.etUserName.getText().toString(), binding.etPassword.getText().toString(), userRole);
                }
            }
        });
        binding.btnRegister.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), PatientRegisterActivity.class));
            finish();
        });
    }

    private void observer() {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.getLoginSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isSuccess) {
                if (isSuccess) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Sai th??ng tin t??i kho???n ho???c m???t kh???u. Vui l??ng ki???m tra l???i", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkEmpty() {
        if (binding.etUserName.getText().toString().trim().isEmpty()
                || binding.etPassword.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), getString(R.string.input_all_infor), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}