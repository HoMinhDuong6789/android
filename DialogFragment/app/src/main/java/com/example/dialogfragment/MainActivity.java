package com.example.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DeleteData{
    Button btnXoa;
    DeleteData deleteData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnXoa = findViewById(R.id.btnXoa);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHopthoai hopthoai= new FragmentHopthoai();
                hopthoai.show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    @Override
    public void GiaTriXoa(boolean delete) {
        if(delete){ //true
            Toast.makeText(this, "Ban chon Xoa", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Ban chon ko xoa", Toast.LENGTH_SHORT).show();
        }
    }
}
