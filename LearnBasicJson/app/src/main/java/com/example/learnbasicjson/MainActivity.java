package com.example.learnbasicjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.learnbasicjson.model.Contact;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayList<Contact> listContact;
    ArrayAdapter<Contact> adapterContact;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        lvContact = findViewById(R.id.lvContact);
        listContact = new ArrayList<>();
        adapterContact = new ArrayAdapter<Contact>(MainActivity.this, android.R.layout.simple_list_item_1, listContact);
        lvContact.setAdapter(adapterContact);
    }

    class ContactTask extends AsyncTask<Void, Void, ArrayList<Contact>>{
        @Override
        protected ArrayList<Contact> doInBackground(Void... voids) {
            ArrayList<Contact> contacts= new ArrayList<>();
            try{
                URL url= new URL("link");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(connection.getInputStream());


            }catch (Exception e){
                Log.e("Erros: ", e.getMessage());
            }

            return contacts;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            adapterContact.clear();
        }

        @Override
        protected void onPostExecute(ArrayList<ContactTask> contactTasks) {
            super.onPostExecute(contactTasks);
            adapterContact.clear();
            adapterContact.addAll(listContact);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}


