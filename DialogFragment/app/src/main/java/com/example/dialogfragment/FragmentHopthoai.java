package com.example.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Create by mitt on 2/28/2020.
 */
public class FragmentHopthoai extends DialogFragment {
    DeleteData deleteData;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        deleteData = (DeleteData) getActivity();

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Xac Nhan");
        dialog.setMessage("ban co muon xoa san pham ko?");
        dialog.setPositiveButton("co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteData.GiaTriXoa(true);
                //Toast.makeText(getActivity(), "Da Xoas", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteData.GiaTriXoa(false);
            }
        });
        //dialog.show();
        //chuyen elert --> daialog
        Dialog hopthoai = dialog.create();

        return hopthoai;
    }
}
