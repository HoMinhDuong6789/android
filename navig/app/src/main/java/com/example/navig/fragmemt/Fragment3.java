package com.example.navig.fragmemt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navig.R;


public class Fragment3 extends Fragment {
    private static Fragment3 mFragment3;
    public static Fragment3 mFragment3() {
        if (mFragment3 == null) {
            mFragment3 = new Fragment3();
        }
        return mFragment3;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3, container, false);
    } 
}
