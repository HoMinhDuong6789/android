package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databinding.databinding.ActivityMainBinding;
import com.example.databinding.model.User;

public class MainActivity extends AppCompatActivity implements  MainContact.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding= DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        User user = new User("Ronaldo", "Cris");
        binding.setUser(user);
        MainActivityPresenter mainActivityPresenter= new MainActivityPresenter(this);
        TemperatureDate temperatureDate= new TemperatureDate("10", "123");
        binding.setTemp(temperatureDate);
        binding.setPresenter(mainActivityPresenter);
    }

    public void xemthongtin(View view) {

    }

    @Override
    public void showData(TemperatureDate temperatureDate) {
        String celsius = temperatureDate.getCelsius();
        Toast.makeText(this, celsius, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
