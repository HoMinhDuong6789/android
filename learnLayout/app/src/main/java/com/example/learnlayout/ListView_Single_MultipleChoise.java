package com.example.learnlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnlayout.adapter.CustomAdapter;
import com.example.learnlayout.model.User;

import java.util.ArrayList;

public class ListView_Single_MultipleChoise extends AppCompatActivity {
    ListView listView;
    CustomAdapter customAdapter;
    ArrayList<User> userArrayList;
    int preSelected = -1;     // tuong ung voi ko co gia tri trong mang

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view__single__multiple_choise);
        listView = findViewById(R.id.listview);
        userArrayList = new ArrayList<User>();
        userArrayList.add(new User("Nguyen Tuan A", true));
        userArrayList.add(new User("Nguyen Tuan B", false));
        userArrayList.add(new User("Nguyen Tuan C", true));
        userArrayList.add(new User("Nguyen Tuan D", false));
        userArrayList.add(new User("Nguyen Tuan F", true));
        userArrayList.add(new User("Nguyen Tuan G", false));
        customAdapter = new CustomAdapter(ListView_Single_MultipleChoise.this, userArrayList);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = userArrayList.get(position);
                //chi chon 1
                /*user.setIscheked(true);
                userArrayList.set(position, user);
                if (preSelected > -1) {
                    User usermodel = userArrayList.get(preSelected);
                    usermodel.setIscheked(false);
                    userArrayList.set(preSelected, usermodel);
                }
                preSelected = position;
                customAdapter.UpdateListView(userArrayList);
                Toast.makeText(ListView_Single_MultipleChoise.this, userArrayList.get(position).getTen(), Toast.LENGTH_SHORT).show();*/
                //chon da lan
                if(user.isIscheked()){
                    user.setIscheked(false);
                }else{
                    user.setIscheked(true);
                }
                userArrayList.set(position, user);
                customAdapter.UpdateListView(userArrayList);
                Toast.makeText(ListView_Single_MultipleChoise.this, userArrayList.get(position).getTen()+" "+userArrayList.get(position).isIscheked(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
