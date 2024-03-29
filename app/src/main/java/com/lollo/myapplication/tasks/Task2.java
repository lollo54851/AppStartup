package com.lollo.myapplication.tasks;

import android.content.Context;
import android.os.SystemClock;

import androidx.annotation.Nullable;


import com.lollo.myapplication.startup.AndroidStartup;
import com.lollo.myapplication.startup.Startup;
import com.lollo.myapplication.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class Task2 extends AndroidStartup<Void> {
    static List<Class<? extends Startup<?>>> depends;

    static {
        depends = new ArrayList<>();
        depends.add(Task1.class);
    }

    @Nullable
    @Override
    public Void create(Context context) {
        LogUtils.log("Task2：学习Socket");
        SystemClock.sleep(800);
        LogUtils.log("Task2：掌握Socket");
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
