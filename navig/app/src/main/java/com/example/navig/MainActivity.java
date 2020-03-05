package com.example.navig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.navig.fragmemt.Fragment1;
import com.example.navig.fragmemt.Fragment2;
import com.example.navig.fragmemt.Fragment3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        bottomNavigationView = findViewById(R.id.bottom_bar);
        //loadFragment(new WorkoutFragment());
        //loadFragment(new CalendarFragment(mainActivity));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_1:
                        loadFragment(new Fragment1());
                        return true;
                    case R.id.item_2:
                        loadFragment(new Fragment2());
                        return true;
                    case R.id.item_3:
                        loadFragment(new Fragment3());
                        return true;
                    /*case R.id.item_4:
                        loadFragment(new WorkoutFragment());
                        return true;
                    case R.id.item_5:
                        loadFragment(new LibraryCategories());
                        return true;*/
                    default:
                        loadFragment(new Fragment1());
                        break;
                }
                return false;
            }
        });

    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
