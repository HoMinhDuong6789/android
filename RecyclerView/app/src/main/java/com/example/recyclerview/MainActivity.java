package com.example.recyclerview;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.ShopAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        //recyclerView.addItemDecoration(dividerItemDecoration);
        //tao duong ke ngay giua cac item
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(), R.drawable.custome_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //Add resource Data
        ArrayList<DataShop> arrayList = new ArrayList<>();
        arrayList.add(new DataShop(R.drawable.iphone, "iphone_11_pro_max_green_400x400"));
        arrayList.add(new DataShop(R.drawable.iphone, "iphone_11_pro_max_green_400x400"));
        arrayList.add(new DataShop(R.drawable.samsung, "samsung"));
        arrayList.add(new DataShop(R.drawable.oppo, "iphone_11_pro_max_green_400x400"));
        arrayList.add(new DataShop(R.drawable.iphone, "iphone_11_pro_max_green_400x400"));
        arrayList.add(new DataShop(R.drawable.samsung, "samsung"));
        arrayList.add(new DataShop(R.drawable.oppo, "iphone_11_pro_max_green_400x400"));
        //
        ShopAdapter shopAdapter = new ShopAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(shopAdapter);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User("Test","User");
        user.setFirstName("Luong");
        user.setLastName("Dong");
        binding.setUser(user);

    }
}
