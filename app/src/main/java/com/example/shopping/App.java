package com.example.shopping;


import android.app.Application;

import com.example.shopping.db.AppDB;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public AppDB getDatabase() {
        return AppDB.getInstance(this);
    }

}