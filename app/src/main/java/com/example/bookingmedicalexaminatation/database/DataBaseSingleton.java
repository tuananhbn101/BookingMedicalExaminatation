package com.example.bookingmedicalexaminatation.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataBaseSingleton {
    public static DataBaseSingleton instance;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private DataBaseSingleton() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public static DataBaseSingleton getInstance() {
        if (instance == null) {
            synchronized (DatabaseReference.class) {
                if (instance == null) {
                    instance = new DataBaseSingleton();
                }
            }
        }
        return instance;
    }

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}
