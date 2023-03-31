package com.lollo.myapplication;

import android.app.Application;
import com.lollo.myapplication.startup.manage.StartupManager;
import com.lollo.myapplication.tasks.Task1;
import com.lollo.myapplication.tasks.Task2;
import com.lollo.myapplication.tasks.Task3;
import com.lollo.myapplication.tasks.Task4;
import com.lollo.myapplication.tasks.Task5;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /******* 添加任务方式：
         * 方式二：通过配置ContentProvider的方式添加任务(详见Manifest文件配置:StartupProvider)
         * 下面是方式一:通过创建StartupManager的方式管理任务
        new StartupManager.Builder()
                .addStartup(new Task5())
                .addStartup(new Task4())
                .addStartup(new Task3())
                .addStartup(new Task2())
                .addStartup(new Task1())
                .build(this)
                .start()
                .await();
                **********/
    }
}
