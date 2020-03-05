package com.example.navig.fragmemt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navig.R;


public class Fragment2 extends Fragment {
    private static Fragment2 mFragment2;
    public static Fragment2 mFragment2() {
        if (mFragment2 == null) {
            mFragment2 = new Fragment2();
        }
        return mFragment2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
}
