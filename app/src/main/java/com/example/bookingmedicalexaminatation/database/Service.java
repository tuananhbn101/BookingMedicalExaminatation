package com.example.bookingmedicalexaminatation.database;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookingmedicalexaminatation.data.Account;
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

    public void registerAccount(Account account, RegisterCallBack registerCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child("account").push().setValue(account, new DatabaseReference.CompletionListener() {
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

    public void login(String userName, String password, LoginCallBack loginCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Query query = databaseReference.child("account").orderByChild("userName").equalTo(userName);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Account account = snapshot.getChildren().iterator().next().getValue(Account.class);
                            if (account != null) {
                                if (password.equals(account.getPassword())) {
                                    loginCallBack.loginSuccess(snapshot.getChildren().iterator().next().getKey(),account.getUserRole());
                                } else {
                                    loginCallBack.loginSuccess("","");
                                }
                            }
                        } else {
                            loginCallBack.loginSuccess("","");
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
                Query query = databaseReference.child("account").orderByChild("userName").equalTo(username);
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

    public void getAccount(String userId,Callback callback) {
        databaseReference.child("account").child(userId).get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            } else {
                Log.d("firebase", String.valueOf(task.getResult().getValue()));
            }
        });
    }

    public interface Callback {
        void requestSuccess(Account account);
    }

    public interface RegisterCallBack {
        void registerSuccess(boolean isSuccess);

        void userNameExist(boolean isExist);
    }

    public interface LoginCallBack {
        void loginSuccess(String accountId,String userRole);
    }
}
