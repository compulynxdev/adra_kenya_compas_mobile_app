package com.compastbc;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.compastbc.data.AppDataManager;


/**
 * Created by hemant.
 * Date: 30/8/18
 * Time: 2:59 PM
 */

public class Compas extends Application {

    public static double LATITUDE = 0.0236;
    public static double LONGITUDE = 37.9062;
    private static Compas instance;
    private AppDataManager appInstance;

    public static synchronized Compas getInstance() {
        if (instance != null) {
            return instance;
        }
        return new Compas();
    }

    public AppDataManager getDataManager() {
        return appInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appInstance = AppDataManager.getInstance(this);
        //AppLogger.e("DeviceModelName", Build.MODEL);
    }

}
