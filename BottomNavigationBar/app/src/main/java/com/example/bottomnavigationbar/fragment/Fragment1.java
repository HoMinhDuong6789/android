package com.example.bottomnavigationbar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.bottomnavigationbar.R;

/**
 * Create by mitt on 3/5/2020.
 */
public class Fragment1 extends Fragment {
    private static Fragment1 mInstance;

    public static Fragment1 newInstance() {
        if (mInstance == null) {
            mInstance = new Fragment1();
        }
        return mInstance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_one, container, false);
    }
}
