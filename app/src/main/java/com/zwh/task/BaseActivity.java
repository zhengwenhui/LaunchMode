package com.zwh.task;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "task_test";
    private TextView msgTextView;

    public void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(this.getLocalClassName());
    }

    @Override
    protected void onResume(){
        super.onResume();
        msgTextView = findViewById(R.id.msg);
        showMsg();
    }

    public void showMsg() {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList = am.getRunningTasks(10);
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTaskInfoList) {
            msgTextView.append("id: " + runningTaskInfo.id);
            msgTextView.append("number of activities: " + runningTaskInfo.numActivities);
            msgTextView.append("topActivity: " + runningTaskInfo.topActivity.getClassName());
            msgTextView.append("baseActivity: " + runningTaskInfo.baseActivity.getClassName());
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        msgTextView.append("onNewIntent");
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
