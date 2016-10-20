package com.example.hssports.gate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity01 extends AppCompatActivity {

    ArrayList<String> selectedItems = new ArrayList<String>(); // for validation purpose

    ListView  lv;
    boolean flag = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile01);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button nextBut = (Button) findViewById(R.id.button);




        lv = (ListView) findViewById(R.id.listView);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        final String[] items = getResources().getStringArray(R.array.interests);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.txt_01, items);
        lv.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.button);

       //setOnItemClickListener if there is item clicked it will add it to a list
        // when user click the next button check if the list is empty or not !

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView)view).getText().toString();
                selectedItems.add(item);
            }
        });




        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(!selectedItems.isEmpty()) {
                    Intent intent = new Intent(ProfileActivity01.this, ProfileActivity02.class);
                    startActivity(intent);
                }
                else
               {
                   Toast.makeText(ProfileActivity01.this,"Please select at least one interest!",Toast.LENGTH_LONG).show();

               }

            }
        });



    }


}
