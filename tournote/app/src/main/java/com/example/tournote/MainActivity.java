package com.example.tournote;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String TAG = "TourNote_MainActivity";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //drawerLayout = findViewById(R.id.activity_main);
       // drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Log.d("MainActivity Lifecycle", "===== onCreate =====");

        Log.e(TAG, "this is an Error log");
        Log.w(TAG, "this is an Warning log");
        Log.i(TAG, "this is an Information log");
        Log.d(TAG, "this is an Debug log");
        Log.v(TAG, "this is a Verbose log");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("MainActivity Lifecycle", "===== onStart =====");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("MainActivity Lifecycle", "===== onRestart =====");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("MainActivity Lifecycle", "===== onResume =====");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("MainActivity Lifecycle", "===== onPause =====");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("MainActivity Lifecycle", "===== onStop =====");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("MainActivity Lifecycle", "===== onDestroy =====");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    public void showMessage(View view) {
        Toast.makeText(this, "Your button is touched!!!", Toast.LENGTH_SHORT).show();
    }
}
