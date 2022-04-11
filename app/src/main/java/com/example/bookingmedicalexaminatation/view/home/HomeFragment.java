package com.example.bookingmedicalexaminatation.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.database.Storage;
import com.example.bookingmedicalexaminatation.databinding.FragmentHomeBinding;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.view.bookappointment.BookAppointmentActivity;
import com.example.bookingmedicalexaminatation.view.more.ContactActivity;
import com.example.bookingmedicalexaminatation.view.more.IntroduceActivity;
import com.example.bookingmedicalexaminatation.view.profile.doctor.DoctorActivity;
import com.example.bookingmedicalexaminatation.view.profile.patient.PatientActivity;
import com.example.bookingmedicalexaminatation.view.workschedule.WorkScheduleActivity;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private Storage storage;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        int images[] = {R.drawable.image4, R.drawable.image2, R.drawable.image3};
        for (int i = 0; i < images.length; i++) {
            flipperImages(images[i]);
        }

        storage = new Storage(getContext());
        if (storage.getRole(Const.Account.USER_ROLE).equals(Const.ADMIN_ROLE)) {
            binding.doctorProfile.setVisibility(View.VISIBLE);
            binding.patientProfile.setVisibility(View.VISIBLE);
            binding.book.setVisibility(View.INVISIBLE);
        } else if (storage.getRole(Const.Account.USER_ROLE).equals(Const.DOCTOR_ROLE)) {
            binding.doctorProfile.setVisibility(View.INVISIBLE);
            binding.patientProfile.setVisibility(View.INVISIBLE);
            binding.registerWorkSchedule.setVisibility(View.VISIBLE);
            binding.book.setVisibility(View.INVISIBLE);
        } else {
            binding.doctorProfile.setVisibility(View.INVISIBLE);
            binding.patientProfile.setVisibility(View.INVISIBLE);
            binding.registerWorkSchedule.setVisibility(View.INVISIBLE);
        }

        binding.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), BookAppointmentActivity.class));
            }
        });

        binding.patientProfile.setOnClickListener(view -> startActivity(new Intent(getContext(), PatientActivity.class)));

        binding.doctorProfile.setOnClickListener(view -> startActivity(new Intent(getContext(), DoctorActivity.class)));

        binding.introduce.setOnClickListener(view -> startActivity(new Intent(getContext(), IntroduceActivity.class)));

        binding.contact.setOnClickListener(view -> startActivity(new Intent(getContext(), ContactActivity.class)));

        binding.registerWorkSchedule.setOnClickListener(view -> startActivity(new Intent(getContext(), WorkScheduleActivity.class)));
    }

    private void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
        binding.banner.addView(imageView);
        binding.banner.setFlipInterval(4000);
        binding.banner.setInAnimation(getContext(), android.R.anim.slide_in_left);
        binding.banner.setOutAnimation(getContext(), android.R.anim.slide_out_right);
        binding.banner.startFlipping();
    }
}
