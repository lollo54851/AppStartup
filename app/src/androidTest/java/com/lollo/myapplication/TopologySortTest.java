package com.lollo.myapplication;

import android.util.Log;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.lollo.myapplication.startup.Startup;
import com.lollo.myapplication.startup.StartupSortStore;
import com.lollo.myapplication.startup.sort.TopologySort;
import com.lollo.myapplication.tasks.Task1;
import com.lollo.myapplication.tasks.Task2;
import com.lollo.myapplication.tasks.Task3;
import com.lollo.myapplication.tasks.Task4;
import com.lollo.myapplication.tasks.Task5;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class TopologySortTest {

    private static final String TAG = "TopologySortTest";

    @Test
    public void testTopologySort() {
        List<Startup<?>> list = new ArrayList<>();
        list.add(new Task4());
        list.add(new Task5());
        list.add(new Task3());
        list.add(new Task2());
        list.add(new Task1());

        StartupSortStore startupSortStore = TopologySort.sort(list);
        List<Startup<?>> result = startupSortStore.getResult();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" \n======================================================\n");
        stringBuilder.append("  Task Graph:\n");
        for (Startup<?> startup : result) {
            stringBuilder.append("       ").append(startup.getClass().getName()).append("\n");
        }
        stringBuilder.append("======================================================");
        Log.e(TAG, stringBuilder.toString());
    }
}
