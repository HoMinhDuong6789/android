package com.example.btlistdatabindingcontact.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import com.example.btlistdatabindingcontact.R;
import com.example.btlistdatabindingcontact.databinding.DongLvBinding;

/**
 * Create by mitt on 3/9/2020.
 */
public class ListAdapter  extends BaseAdapter {
    private ObservableArrayList<Contact> list;
    private LayoutInflater inflater;

    public ListAdapter(ObservableArrayList<Contact> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater== null){
            inflater= (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        DongLvBinding binding = DataBindingUtil.inflate(inflater, R.layout.dong_lv, parent, false);
        binding.setInfo(list.get(position));
        return binding.getRoot();
    }
}
