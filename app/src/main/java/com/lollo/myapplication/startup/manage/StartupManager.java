package com.lollo.myapplication.startup.manage;

import android.content.Context;
import android.os.Looper;


import com.lollo.myapplication.startup.AndroidStartup;
import com.lollo.myapplication.startup.Result;
import com.lollo.myapplication.startup.Startup;
import com.lollo.myapplication.startup.StartupSortStore;
import com.lollo.myapplication.startup.sort.TopologySort;

import java.util.ArrayList;
import java.util.List;

public class StartupManager {


    private Context context;
    private List<AndroidStartup<?>> startupList;
    private StartupSortStore startupSortStore;

    public StartupManager(Context context, List<AndroidStartup<?>> startupList) {
        this.context = context;
        this.startupList = startupList;
    }

    public StartupManager start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("请在主线程调用！");
        }
        startupSortStore = TopologySort.sort(startupList);
        for (Startup<?> startup : startupSortStore.result) {
            Object result = startup.create(context);
            StartupCacheManager.getInstance().saveInitializedComponent(
                    startup.getClass(), new Result(result));
        }
        return this;
    }


    public static class Builder {
        private List<AndroidStartup<?>> startupList = new ArrayList<>();

        public Builder addStartup(AndroidStartup<?> startup) {
            startupList.add(startup);
            return this;
        }

        public Builder addAllStartup(List<AndroidStartup<?>> startups) {
            startupList.addAll(startups);
            return this;
        }


        public StartupManager build(Context context) {
            return new StartupManager(context, startupList);
        }
    }

}
