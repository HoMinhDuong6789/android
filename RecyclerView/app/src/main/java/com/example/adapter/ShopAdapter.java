package com.example.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.DataShop;
import com.example.recyclerview.MainActivity;
import com.example.recyclerview.R;

import java.util.ArrayList;

/**
 * Create by mitt on 2/28/2020.
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    ArrayList<DataShop> dataShops;
    Context context;

    public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }

    public void RemoveItem(int position) {
        dataShops.remove(position);
        notifyItemRemoved(position);

    }

    public void xacnhanxoa(){
        //AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
        /*AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.context);

        alertDialog.setTitle("Thong bao!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Bạn có thực sự muốn xóa?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //RemoveItem(position);
                Toast.makeText(context, "Remove" + "Xoa thanh cong", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();*/
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.activity_item_row, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtname.setText(dataShops.get(position).getName());
        holder.imgView.setImageResource(dataShops.get(position).getHinhAnh());
    }

    @Override
    public int getItemCount() {
        return dataShops.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname;
        ImageView imgView;
        ActivityMainBinding binding= DataBindingUtil.setCon
        public ViewHolder(final View view) {
            super(view);
            txtname = view.findViewById(R.id.txtName);
            imgView = view.findViewById(R.id.imgView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    xacnhanxoa();


                }
            });
        }
    }
}
