package com.example.hssports.gate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class ProfileActivity03 extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rb;
    TextView majorDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile03);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] items = getResources().getStringArray(R.array.education);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        //Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        //spinner.setAdapter(adapter);

        final LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout2);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        majorDes = (TextView)findViewById(R.id.textView15);

       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {
               rb = (RadioButton)findViewById(i);
               if(rb.getText().toString().equals("High school or below")) {
                   layout.setVisibility(View.GONE);
                   majorDes.setVisibility(View.GONE);
               }
               else {
                   layout.setVisibility(View.VISIBLE);
                   majorDes.setVisibility(View.VISIBLE);

               }
           }
       });

        Button nextBut = (Button) findViewById(R.id.button6);
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity03.this, ProfileActivity04.class);
                startActivity(intent);

            }
        });

//        AutoCompleteTextView at = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
//        at.setAdapter(adapter);


        String[] items2 = getResources().getStringArray(R.array.string_array_experience);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items2);
           Spinner spinner2 = (Spinner) findViewById(R.id.spinner);
         spinner2.setAdapter(adapter2);
    }

}
