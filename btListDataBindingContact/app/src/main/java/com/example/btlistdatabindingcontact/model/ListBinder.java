package com.example.btlistdatabindingcontact.model;

import android.widget.ListView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;

/**
 * Create by mitt on 3/10/2020.
 */
public class ListBinder {
    @BindingAdapter("bind:dong_lv")
    public static void bindList(ListView listView, ObservableArrayList<Contact> list){
        ListAdapter  adapter= new ListAdapter(list);
        listView.setAdapter(adapter);
    }
}
