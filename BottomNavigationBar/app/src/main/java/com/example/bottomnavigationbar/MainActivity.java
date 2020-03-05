package com.example.bottomnavigationbar;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bottomnavigationbar.fragment.Fragment1;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationView = findViewById(R.id.navigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment seclectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.action_1:
                        seclectedFragment = Fragment1.newInstance();
                        break;
                   /* case R.id.action_2:
                        seclectedFragment = Fragment2.newInstance();
                        break;
                    case R.id.action_3:
                        seclectedFragment = Fragment3.newInstance();
                        break;*/
                }
                return true;
            }
        });
    }


}
