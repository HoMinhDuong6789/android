package com.example.learnlayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.learnlayout.R;
import com.example.learnlayout.model.User;

import java.util.ArrayList;

/**
 * Create by mitt on 3/5/2020.
 */
public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<User> arrayList;

    public CustomAdapter(Context context, ArrayList<User> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * @param position
     * @param view
     * @param viewGroup
     * @return View thực hiến gán dữ liệu lên cho function này
     * view.setTag(viewHolder); dunfg ddeer luu casc gia tri anh xa
     */
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.dong_list_view, null);
            viewHolder = new ViewHolder();
            viewHolder.txtten = view.findViewById(R.id.txtText);
            viewHolder.ckten= view.findViewById(R.id.ckten);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        User user = (User) getItem(position);
        viewHolder.txtten.setText(user.getTen());
        if(user.isIscheked()){
            viewHolder.ckten.setChecked(true);
        }else{
            viewHolder.ckten.setChecked(false);
        }
        return view;
    }

    public void UpdateListView(ArrayList<User> users){
        this.arrayList= users;
        notifyDataSetChanged();
    }

    /**
     * ViewHolder : class này dùng để, khi chương trình khởi tạo lần đầu thì các giá trị view của chúng
     * ta đã được khỏi tạo, khi chạy lần thứ 2 thì ko cần khỏi tạo nữa, mà nó đã giữ những ánh xạ của các view đó,
     * ở làn tiếp thwo nó chỉ đổ dữ liệu vào thôi
     */
    class ViewHolder {
        TextView txtten;
        CheckBox ckten;


    }
}
