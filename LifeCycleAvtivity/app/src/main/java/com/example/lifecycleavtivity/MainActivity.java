package com.example.lifecycleavtivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String STATE ="Trang thai";
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(STATE, "onCreate");
        btn = findViewById(R.id.btnClickme);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(STATE, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(STATE, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(STATE, "onResum");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(STATE, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(STATE, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(STATE, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        /*la mpot trong nhung thanh phan trang thai cua activity, dung de truyen, phuc hoi, luu trang thai cua mot
        * activity */
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e(STATE, "onSaveInstanceState");

    }
}
