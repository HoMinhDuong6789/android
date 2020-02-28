package com.example.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomDialog extends AppCompatActivity {
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        btnlogin =findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLogin();
            }
        });
    }

    private  void DialogLogin(){
        final Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.dialogcustom);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // anh xa
        final EditText txtusername = dialog.findViewById(R.id.txtUsername);
        final EditText txtpassword = dialog.findViewById(R.id.txtpassword);
        Button btndongy= dialog.findViewById(R.id.btndangnhap);
        Button btnhuy= dialog.findViewById(R.id.btnhuy);

        btndongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pd = new ProgressDialog(dialog.getContext());
                pd.setTitle("Loading...");
                pd.setMessage("Please wait.");
                pd.show();

                Runnable progressRunnable = new Runnable() {
                    @Override
                    public void run() {
                        String name= txtusername.getText().toString().trim();
                        String pass= txtpassword.getText().toString().trim();
                        if (name.equalsIgnoreCase("admin")&&pass.equalsIgnoreCase("123456")){
                            Toast.makeText(dialog.getContext(), "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                            pd.cancel();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(dialog.getContext(), "Dang nhap ko thanh cong", Toast.LENGTH_SHORT).show();
                            pd.cancel();
                        }

                    }
                };
                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 4000);



            }
        });




        //full Sreen
        // Get existing layout params for the window
        /*ViewGroup.LayoutParams params = dialog.getWindow().getAttributes();
        // Assign window properties to fill the parent
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        // Call super onResume after sizing*/

        //progessdialog
       /* ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Loading...");
        pd.setMessage("Please wait.");
        pd.setCancelable(false);
        pd.show();*/
        dialog.show();
    }
}
