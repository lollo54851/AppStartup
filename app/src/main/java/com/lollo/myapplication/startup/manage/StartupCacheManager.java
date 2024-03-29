package com.lollo.myapplication.startup.manage;


import com.lollo.myapplication.startup.Result;
import com.lollo.myapplication.startup.Startup;

import java.util.concurrent.ConcurrentHashMap;

public class StartupCacheManager {
    private ConcurrentHashMap<Class<? extends Startup>, Result> mInitializedComponents =
            new ConcurrentHashMap();
    private static StartupCacheManager mInstance;

    private StartupCacheManager() {

    }

    public static StartupCacheManager getInstance() {
        if (mInstance == null) {
            synchronized (StartupCacheManager.class) {
                if (mInstance == null) {
                    mInstance = new StartupCacheManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * save result of initialized component.
     */
    public void saveInitializedComponent(Class<? extends Startup> zClass, Result result) {
        mInitializedComponents.put(zClass, result);
    }

    /**
     * check initialized.
     */
    public boolean hadInitialized(Class<? extends Startup> zClass) {
        return mInitializedComponents.containsKey(zClass);
    }

    public <T> Result<T> obtainInitializedResult(Class<? extends Startup<T>> zClass) {
        return mInitializedComponents.get(zClass);
    }


    public void remove(Class<? extends Startup> zClass) {
        mInitializedComponents.remove(zClass);
    }

    public void clear() {
        mInitializedComponents.clear();
    }
}
