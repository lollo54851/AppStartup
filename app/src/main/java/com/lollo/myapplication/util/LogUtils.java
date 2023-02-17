package com.lollo.myapplication.util;

import android.util.Log;

public class LogUtils {

    private static final String TAG = "LolloAppStartup";

    public static void log(String msg) {
        Log.i(TAG, msg);
    }
}
