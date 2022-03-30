package com.example.bookingmedicalexaminatation.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityMainBinding;
import com.example.bookingmedicalexaminatation.view.home.HomeFragment;
import com.example.bookingmedicalexaminatation.view.more.MoreFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, HomeFragment.newInstance()).commit();
        binding.bottomMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, HomeFragment.newInstance()).commit();
                    return true;
                } else if (item.getItemId() == R.id.history) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, HistoryFragment.newInstance()).commit();
                    return true;
                } else if (item.getItemId() == R.id.more) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, MoreFragment.newInstance()).commit();
                    return true;
                }
                return false;
            }
        });


    }
}