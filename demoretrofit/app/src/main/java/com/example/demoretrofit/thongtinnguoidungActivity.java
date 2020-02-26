package com.example.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.SinhVien;

public class thongtinnguoidungActivity extends AppCompatActivity {
    Button btnDelete;
    TextView txttaikhoan, txtmatkhau;
    ImageView imguser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinnguoidung);
        anhxa();
        init();
    }

    private void init() {
        //nhan du lieu
        Intent intent = getIntent();
        ArrayList<SinhVien> sinhVienArrayList = intent.getParcelableArrayListExtra("mangsinhvien");
        Log.d("mangSVVVVVVVVVVVVVV", sinhVienArrayList.get(0).getTaikhoan());
        txttaikhoan.setText("Tai khoan: "+sinhVienArrayList.get(0).getTaikhoan());
        txtmatkhau.setText("Mat Khau: "+sinhVienArrayList.get(0).getMatkhau());
        Picasso.get().load(R.drawable.iconfinder_social_57_547459);
                //load(sinhVienArrayList.get(0).getHinhanh()).into(imguser);
    }

    private void anhxa() {
        btnDelete = findViewById(R.id.btndelete);
        txttaikhoan = findViewById(R.id.txttaikhoan);
        txtmatkhau = findViewById(R.id.txtmatkhau);
        imguser = findViewById(R.id.imguser);
    }
}
