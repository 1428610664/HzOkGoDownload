package com.hz.hzokgodownload;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.hz.hzokgodownload.activity.DownloadAllActivity;
import com.hz.hzokgodownload.activity.DownloadFinishActivity;
import com.hz.hzokgodownload.activity.DownloadListActivity;
import com.hz.hzokgodownload.activity.DownloadingActivity;

public class MainActivity extends AppCompatActivity {

    private long firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.startDown:
                openActivity(DownloadingActivity.class);
                break;
            case R.id.allDownloadss:
                openActivity(DownloadAllActivity.class);
                break;
            case R.id.downloads:
                openActivity(DownloadListActivity.class);
                break;
            case R.id.complete:
                openActivity(DownloadFinishActivity.class);
                break;
        }
    }

    protected void openActivity(Class<?> pClass){
        Intent mIntent=new Intent(this,pClass);
        startActivity(mIntent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
