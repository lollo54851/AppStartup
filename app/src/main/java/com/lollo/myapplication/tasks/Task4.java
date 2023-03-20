package com.lollo.myapplication.tasks;

import android.content.Context;
import android.os.SystemClock;

import com.lollo.myapplication.startup.AndroidStartup;
import com.lollo.myapplication.startup.Startup;
import com.lollo.myapplication.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class Task4 extends AndroidStartup<Void> {

    static List<Class<? extends Startup<?>>> depends;

    static {
        depends = new ArrayList<>();
        depends.add(Task2.class);
    }

    @Override
    public Void create(Context context) {
        LogUtils.log("Task4：学习Http");
        SystemClock.sleep(1_000);
        LogUtils.log("Task4：掌握Http");
        return null;
    }


    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return depends;
    }

    @Override
    public boolean callCreateOnMainThread() {
        return false;
    }

    @Override
    public boolean waitOnMainThread() {
        return false;
    }
}
