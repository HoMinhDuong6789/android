package com.example.navigationbar.fragmemt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.navigationbar.R;

/**
 * Create by mitt on 3/5/2020.
 */
public class ItemThreeFragment extends Fragment {
    private static ItemThreeFragment mInstance;

    public static ItemThreeFragment newInstance() {
        if (mInstance == null) {
            mInstance = new ItemThreeFragment();
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
        return inflater.inflate(R.layout.fragment_item_three, container, false);
    }
}
