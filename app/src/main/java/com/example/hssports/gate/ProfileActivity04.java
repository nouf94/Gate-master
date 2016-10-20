package com.example.hssports.gate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity04 extends AppCompatActivity {

    ArrayList<String> selectedItems = new ArrayList<String>(); // for validation purpose


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile04);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView lv = (ListView) findViewById(R.id.listView2);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);




        String[] items = getResources().getStringArray(R.array.languages_array);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.txt_01, items);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView)view).getText().toString();
                selectedItems.add(item);
            }
        });
        Button submitBut = (Button) findViewById(R.id.button3);


        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedItems.isEmpty()) {
//                    Intent intent = new Intent(ProfileActivity01.this, ProfileActivity02.class);
//                    startActivity(intent);
                    Toast.makeText(ProfileActivity04.this,"Go to the next page!",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(ProfileActivity04.this,"Please select at least one langauge!",Toast.LENGTH_LONG).show();

                }
            }
        });

    }

}
