package com.example.bookingmedicalexaminatation.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.bookingmedicalexaminatation.util.Const;

public class Storage {
    private SharedPreferences sharedPreferences;
    private Context context;

    public Storage(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("Storage", Context.MODE_PRIVATE);
    }

    public String getRole(String key) {
        return sharedPreferences.getString(key, "");
    }

    public String getId() {
        return sharedPreferences.getString(Const.Account.ACCOUNT_ID, "");
    }

    public String getUserName() {
        return sharedPreferences.getString(Const.Account.USER_NAME, "");
    }

    public void putAccountId(String data) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Const.Account.ACCOUNT_ID, data);
        editor.commit();
    }

    public void putString(String key, String data) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, data);
        editor.commit();
    }
}
