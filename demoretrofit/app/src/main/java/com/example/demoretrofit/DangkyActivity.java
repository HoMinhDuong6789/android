package com.example.demoretrofit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit.APIUtils;
import retrofit.DataClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangkyActivity extends AppCompatActivity {
    ImageView imgvdangky;
    EditText edittextdkmatkhau, edittextdangkytk;
    Button btnhuy, btnxacnhan;
    int Requset_Code_Image = 123;
    String realpath;
    String taikhoan;
    String matkhau;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        anhxa();
        imgvdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Requset_Code_Image);
            }
        });
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taikhoan = edittextdkmatkhau.getText().toString();
                matkhau = edittextdkmatkhau.getText().toString();

               /* if(taikhoan.length()>0 && matkhau.length()>0){
                File file = new File("E:\\_workspaces\\Android\\android\\demoretrofit\\app\\src\\main\\res\\drawable\\iconfinder_barcode_363078.png");
                *//*String file_path= file.getAbsolutePath();
                String [] mangtenfile = file_path.split("\\.");
                file_path = mangtenfile[0] + System.currentTimeMillis()+"."+mangtenfile[1];*//*
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("uploaded_file","E:\\_workspaces\\Android\\android\\demoretrofit\\app\\src\\main\\res\\drawable\\iconfinder_barcode_363078.png", requestBody);
                DataClient dataClient = APIUtils.getDataClient();
                Call<String> callback = dataClient.uploadPhoto(body);
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response != null){
                            String message = response.body();
                            Log.d("BBBB", message);
                            if(message.length() >0){*/
                               DataClient insertData = APIUtils.getDataClient();
                               Call<String> callback = insertData.InsertData(taikhoan, matkhau, "image/");
                               callback.enqueue(new Callback<String>() {
                                   @Override
                                   public void onResponse(Call<String> call, Response<String> response) {
                                       String result = response.body();
                                       if(result.equals("Success")){
                                           Toast.makeText(DangkyActivity.this, "Them thanh cong!", Toast.LENGTH_SHORT);



                                           finish();
                                       }
                                   }

                                   @Override
                                   public void onFailure(Call<String> call, Throwable t) {
                                       Log.d("FFFFFFFFFFFFFF",t.getMessage());
                                   }
                               });
                            }

                   /* }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("FFFFFFFFFFFFFF",t.getMessage());
                    }
                });

            }else{
                    Toast.makeText(DangkyActivity.this, "Hay nhap du lieu thong tin", Toast.LENGTH_SHORT);
            }
            }*/
        });
    }

    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Requset_Code_Image && resultCode == RESULT_OK){
            Uri uri= data.getData();
            realpath = getRealPathFromURI(uri);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iconfinder_social_57_547459);
            imgvdangky.setImageBitmap(bitmap);
            /*try {
                //InputStream inputStream = getContentResolver().openInputStream(uri);

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }*/
        }
    }

    private void anhxa() {
        imgvdangky = findViewById(R.id.imgvdangky);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iconfinder_social_57_547459);
        imgvdangky.setImageBitmap(bitmap);
        edittextdangkytk =  findViewById(R.id.edittextdangkytk);
        edittextdkmatkhau =  findViewById(R.id.edittextdkmatkhau);
        btnhuy =  findViewById(R.id.btnhuy);
        btnxacnhan =  findViewById(R.id.btnxacnhan);
    }
}
