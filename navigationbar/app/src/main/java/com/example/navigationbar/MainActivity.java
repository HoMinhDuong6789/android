package com.example.navigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.navigationbar.fragmemt.ItemOneFragment;
import com.example.navigationbar.fragmemt.ItemThreeFragment;
import com.example.navigationbar.fragmemt.ItemTowFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Activity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainActivity = this;
//        bottomNavigationView.findViewById(R.id.navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment selectedFragment = null;
//                switch (item.getItemId()) {
//                    case R.id.action_item1:
//                        selectedFragment = ItemOneFragment.newInstance();
//                        break;
//                    case R.id.action_item2:
//                        selectedFragment = ItemTowFragment.newInstance();
//                        break;
//                    case R.id.action_item3:
//                        selectedFragment = ItemThreeFragment.newInstance();
//                        break;
//                }
//                return false;
//            }
//        });
            bottomNavigationView.findViewById(R.id.navigation);
            loadFragment(new ItemOneFragment());
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_item1:
                        loadFragment(new ItemOneFragment());
                        return true;
                    case R.id.action_item2:
                        loadFragment(new ItemTowFragment());
                        return true;
                    case R.id.action_item3:
                        loadFragment(new ItemThreeFragment());
                        return true;
                }
                return false;
            }
        });

    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fram_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
