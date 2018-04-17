package com.zwh.task;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "task_test";

    public void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(this.getLocalClassName());
        showMsg();
    }

    public void showMsg() {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList = am.getRunningTasks(10);
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTaskInfoList) {
            Log.i(TAG, "id: " + runningTaskInfo.id);
            Log.i(TAG, "number of activities: " + runningTaskInfo.numActivities);
            Log.i(TAG, "topActivity: " + runningTaskInfo.topActivity.getClassName());
            Log.i(TAG, "baseActivity: " + runningTaskInfo.baseActivity.getClassName());
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent");
    }

    public void onClickA(View view) {
        startActivity(AActivity.class);
    }

    public void onClickB(View view) {
        startActivity(BActivity.class);
    }

    public void onClickC(View view) {
        startActivity(CActivity.class);
    }

    public void onClickD(View view) {
        startActivity(DActivity.class);
    }
}
