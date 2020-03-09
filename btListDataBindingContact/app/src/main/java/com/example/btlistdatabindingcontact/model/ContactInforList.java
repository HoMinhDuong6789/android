package com.example.btlistdatabindingcontact.model;

import android.view.View;

import androidx.databinding.ObservableArrayList;

import java.util.Observable;
import java.util.Random;

/**
 * Create by mitt on 3/9/2020.
 */
public class ContactInforList {
    public ObservableArrayList<Contact> list = new ObservableArrayList<>();
    private int totalContact = 100;
    Random random = new Random();
    public ContactInforList() {

        for (int i=0; i<totalContact; i++){
            String number="091";
            for(int j=0;j<7;j++){
                number+= random.nextInt(10);
            }
            Contact contact = new Contact(number, "Hoang Dieu "+i);
            list.add(contact);
        }
    }

    public void add(View view){
        String name= "Tên "+(++totalContact);
        String number="091";
        for(int j=0;j<7;j++){
            number+= random.nextInt(10);
        }
        Contact contact= new Contact(name, number);
        list.add(contact);
    }

    public void remove(View view){
        if(!list.isEmpty()){
            list.remove(0);
        }
    }
}
