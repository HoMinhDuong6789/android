package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private View rootView;
    private Button btnShowFragment;
    private OnClickListener mlisListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_first, container, false);
        initView();
        return rootView;

    }

    public void setListener(OnClickListener listener){
        this.mlisListener= listener;
    }

    private void initView() {
        btnShowFragment = rootView.findViewById(R.id.btn_showfragment);
        btnShowFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlisListener.clickButton();
            }
        });
    }

    public  interface  OnClickListener{
        void clickButton();
    }



}
