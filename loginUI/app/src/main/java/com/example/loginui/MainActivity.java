package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnlogginwithfb, btnlogginwithgoogle;
    public ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        action();
    }

    private void initComponent() {
        btnlogginwithfb= findViewById(R.id.btnlogginwithfb);
        btnlogginwithgoogle = findViewById(R.id.btnlogginwithgoogle);
        progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Vui lòng chờ");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMax(100);
    }

    private void action() {
        btnlogginwithfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Runnable progressRunnable = new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.cancel();
                        showDialogs();
                    }
                };
                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 200);
            }
        });

        btnlogginwithgoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Runnable progressRunnable = new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.cancel();
                        showDialog();
                    }
                };
                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 200);

            }
        });
    }

    private void showDialog(){
        Rect displayRectangle = new Rect();
        Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.activity_dialog_login);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(900, 950);
        //dialog.getWindow().getAttributes().windowAnimations = an
        Button bntTryAgain = dialog.findViewById(R.id.btntryagian);
        dialog.show();
    }

    private void showDialogs(){
        Rect displayRectangle = new Rect();
        final Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.activity_dialoglogins);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(900, 950);
        //dialog.getWindow().getAttributes().windowAnimations = an
        dialog.show();
        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                dialog.cancel();
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 1000);
    }

}
