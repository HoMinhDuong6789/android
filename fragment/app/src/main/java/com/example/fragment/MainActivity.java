package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFirstFragment();
        //initFragment();
        //showFirstFragment();
    }

    /*private void showFirstFragment() {
        getSupportFragmentManager().beginTransaction().show(firstFragment).hide(secondFragment).commit();
    }
    private void showSecondFragment() {
        getSupportFragmentManager().beginTransaction().show(secondFragment).hide(firstFragment).addToBackStack(null).commit();
    }
    */

    private void initFragment() {
        firstFragment = new FirstFragment();
        firstFragment.setListener(new FirstFragment.OnClickListener() {
            @Override
            public void clickButton() {
            //   showSecondFragment();
            }
        });
        secondFragment = new SecondFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.ln_main, firstFragment, FirstFragment.class.getName())
                .add(R.id.ln_main, secondFragment, SecondFragment.class.getName())
                .commit();
    }



    private void showFirstFragment(){
        if(firstFragment ==null){
            firstFragment = new FirstFragment();
            firstFragment.setListener(new FirstFragment.OnClickListener() {
                @Override
                public void clickButton() {
                    showSecondFragment();
                }
            });

        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ln_main, firstFragment, FirstFragment.class.getName()).commit();


    }

    private void showSecondFragment(){
        if(secondFragment ==null){
            secondFragment = new SecondFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ln_main, secondFragment, SecondFragment.class.getName())
                .addToBackStack(null).commit();


    }
}
