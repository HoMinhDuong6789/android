package com.example.navig.fragmemt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navig.R;


public class Fragment1 extends Fragment {
    private static Fragment1 mFragment1;
    public static Fragment1 mFragment1() {
        if (mFragment1 == null) {
            mFragment1 = new Fragment1();
        }
        return mFragment1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }



}
