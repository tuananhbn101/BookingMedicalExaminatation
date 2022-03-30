package com.example.bookingmedicalexaminatation.database;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookingmedicalexaminatation.data.Doctor;
import com.example.bookingmedicalexaminatation.data.Patient;
import com.example.bookingmedicalexaminatation.util.Const;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service {
    private DatabaseReference databaseReference;
    private ExecutorService executorService;
    private final int THREAD_NUMBER = 4;

    public Service() {
        databaseReference = DataBaseSingleton.getInstance().getDatabaseReference();
        executorService = Executors.newFixedThreadPool(THREAD_NUMBER);
    }

    public void registerAccount(Patient patient, RegisterCallBack registerCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child(Const.patientRole).push().setValue(patient, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error != null) {
                            registerCallBack.registerSuccess(false);
                        } else {
                            registerCallBack.registerSuccess(true);
                        }
                    }
                });
            }
        });
    }

    public void registerAccount(Doctor doctor, RegisterCallBack registerCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child(Const.doctorRole).push().setValue(doctor, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error != null) {
                            registerCallBack.registerSuccess(false);
                        } else {
                            registerCallBack.registerSuccess(true);
                        }
                    }
                });
            }
        });
    }

    public void login(String userName, String password, String userRole, LoginCallBack loginCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Query query = databaseReference.child("patient").orderByChild("userName").equalTo(userName);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            if (userRole.equals(Const.patientRole)) {
                                Patient patient = snapshot.getChildren().iterator().next().getValue(Patient.class);
                                if (patient != null) {
                                    if (password.equals(patient.getPassword())) {
                                        loginCallBack.loginSuccess(snapshot.getChildren().iterator().next().getKey());
                                    } else {
                                        loginCallBack.loginSuccess("");
                                    }
                                }
                            } else {
                                Doctor doctor = snapshot.getChildren().iterator().next().getValue(Doctor.class);
                                if (doctor != null) {
                                    if (password.equals(doctor.getPassWord())) {
                                        loginCallBack.loginSuccess(snapshot.getChildren().iterator().next().getKey());
                                    } else {
                                        loginCallBack.loginSuccess("");
                                    }
                                }
                            }
                        } else {
                            loginCallBack.loginSuccess("");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    public void checkUserNameExisted(String username, RegisterCallBack registerCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Query query = databaseReference.child("patient").orderByChild("userName").equalTo(username);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            registerCallBack.userNameExist(true);
                        } else {
                            registerCallBack.userNameExist(false);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    public void getAccount(String userId, Callback callback) {
        databaseReference.child("patient").child(userId).get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            } else {
                Log.d("firebase", String.valueOf(task.getResult().getValue()));
            }
        });
    }

    public interface Callback {
        void requestSuccess(Patient patient);
    }

    public interface RegisterCallBack {
        void registerSuccess(boolean isSuccess);

        void userNameExist(boolean isExist);
    }

    public interface LoginCallBack {
        void loginSuccess(String accountId);
    }
}
