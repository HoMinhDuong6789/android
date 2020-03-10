package com.example.btlistdatabindingcontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ListView;

import com.example.btlistdatabindingcontact.databinding.ActivityMainBinding;
import com.example.btlistdatabindingcontact.model.ContactInforList;
import com.example.btlistdatabindingcontact.model.ListHeading;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        ListHeading heading = new ListHeading("Danh Sach Cac Contact");
        binding.setHeading(heading);

        ContactInforList inforList= new ContactInforList();

        binding.setInfor(inforList);
    }
}
