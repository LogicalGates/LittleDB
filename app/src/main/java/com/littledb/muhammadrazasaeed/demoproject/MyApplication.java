package com.littledb.muhammadrazasaeed.demoproject;

import android.app.Application;

import com.razasaeed.littledb.LittleDB;

/**
 * Created by Muhammad Raza Saeed on 2/19/2019.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LittleDB.init(this, LittleDB.APPLY);
    }
}
