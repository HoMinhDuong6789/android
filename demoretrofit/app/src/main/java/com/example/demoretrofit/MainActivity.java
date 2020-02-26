package com.example.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit.APIUtils;
import retrofit.DataClient;
import retrofit.SinhVien;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btndangky, btndangnhap;
    EditText edittexttaikhoan, edittextmatkhau;
    String taikhoan, matkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DangkyActivity.class);
                startActivity(intent);
            }
        });

        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taikhoan = edittexttaikhoan.getText().toString();
                matkhau = edittextmatkhau.getText().toString();
                if(taikhoan.length()>0 && matkhau.length()>0){
                    DataClient dataClient= APIUtils.getDataClient();
                    Call<List<SinhVien>> callback= dataClient.logindata(taikhoan, matkhau);
                    Log.d("LOGINNNNNNNNNN SVVVVVVVVV", taikhoan+" "+ matkhau);
                    callback.enqueue(new Callback<List<SinhVien>>() {
                        @Override
                        public void onResponse(Call<List<SinhVien>> call, Response<List<SinhVien>> response) {
                            Log.d("LOGINNNNNNNNNN SVVVVVVVVV", taikhoan+" "+ matkhau);
                            ArrayList<SinhVien> mangsinhvien = (ArrayList<SinhVien>) response.body();
                            if(mangsinhvien.size()>0){
                                Log.d("LOGINNNNNNN SVVVVVVVVVVV", mangsinhvien.get(0).getTaikhoan());
                                Intent intent = new Intent(MainActivity.this, thongtinnguoidungActivity.class);
                                intent.putExtra("mangsinhvien", mangsinhvien);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<SinhVien>> call, Throwable t) {
                                Log.d("LOGIN SV", "tai khoan ko ton tai");
                        }
                    });
                }
            }
        });
    }

    private void anhxa() {
      btndangky= findViewById(R.id.btndangky);
      btndangnhap= findViewById(R.id.btndangnhap);
      edittexttaikhoan = findViewById(R.id.edittexttaikhoan);
      edittextmatkhau = findViewById(R.id.edittextmatkhau);
    }
}
