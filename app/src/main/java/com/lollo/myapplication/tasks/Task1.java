package com.lollo.myapplication.tasks;

import android.content.Context;
import android.os.SystemClock;

import androidx.annotation.Nullable;


import com.lollo.myapplication.startup.AndroidStartup;
import com.lollo.myapplication.startup.Startup;
import com.lollo.myapplication.util.LogUtils;

import java.util.List;

public class Task1 extends AndroidStartup<String> {

    @Nullable
    @Override
    public String create(Context context) {
        LogUtils.log("Task1：学习Java基础");
        SystemClock.sleep(3_000);
        LogUtils.log("Task1：掌握Java基础");
        return "Task1返回数据";
    }


    //执行此任务需要依赖哪些任务
    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return super.dependencies();
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
