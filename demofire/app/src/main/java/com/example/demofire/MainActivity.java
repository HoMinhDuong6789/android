package com.example.demofire;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mData;
    TextView txttext = findViewById(R.id.txtText);
    ListView lvVehicle = findViewById(R.id.lvVehicle);
    ArrayList<String> arrayVehicle;
    ArrayAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayVehicle = new ArrayList<String>();
        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayVehicle);
        lvVehicle.setAdapter(adapter);
        mData = FirebaseDatabase.getInstance().getReference();
        //TH1:
        mData.child("HoTen").setValue("Chu Quang Minh");
        // get du lieu
        mData.child("HoTen").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txttext.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //TH4:
        Student student = new Student("SV1", "Nguyen Tuan Anh", "Hai Chau, Dang Nang");
        mData.child("Student").push().setValue(student);

        // bai 10 Nhan du lieu su dung AddChild voi Push String
        mData.child("KhoaHoc").push().setValue("Android 2020");
        mData.child("KhoaHoc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //bai 11 nhan du lieu su dung AddChild voi Push Object
        Vehicle vehicle = new Vehicle("Bike", 2);
        mData.child("Vehicle").push().setValue(vehicle);
        mData.child("Vehicle").push().setValue(new Vehicle("Car", 4));
        mData.child("Vehicle").push().setValue(new Vehicle("Bus",6));
        mData.child("Vehicle").push().setValue(new Vehicle("Truck", 8));
        mData.child("Vehicle").push().setValue(new Vehicle("Container", 18));
        mData.child("Vehicle").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Vehicle vehicle = dataSnapshot.getValue(Vehicle.class);
                //Toast.makeText(MainActivity.this, vehicle.name, Toast.LENGTH_SHORT).show();
                arrayVehicle.add(vehicle.name+""+vehicle.whellnumber+" whell");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        // bat su kien hoan thanh khi setValue
        /*mData.child("J4t").setValue("Android FireBase", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if(databaseError==null){
                    Toast.makeText(MainActivity.this,"Luu Thanh cong" ,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Luu ko Thanh cong" ,Toast.LENGTH_SHORT).show();
                }
            }
        });*/


        // Write a message to the database
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");*/
    }
}
