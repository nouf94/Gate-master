package com.example.hssports.gate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity02 extends AppCompatActivity {
    CheckBox ch1, ch2, ch3, ch4, ch5, ch6; //all types

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile02);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button nextBut = (Button) findViewById(R.id.button);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.mainBox);
        ch1 = (CheckBox) findViewById(R.id.checkBox2);
        ch2 = (CheckBox) findViewById(R.id.checkBox);
        ch3 = (CheckBox) findViewById(R.id.checkBox3);
        ch4 = (CheckBox) findViewById(R.id.checkBox7);
        ch5 = (CheckBox) findViewById(R.id.checkBox8);
        ch6 = (CheckBox) findViewById(R.id.checkBox9);

        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    if (!ch1.isChecked() && !ch2.isChecked() && !ch3.isChecked() && !ch4.isChecked() && !ch5.isChecked() && !ch6.isChecked()) {
                        Toast.makeText(ProfileActivity02.this, "Please choose the type of your special need!", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(ProfileActivity02.this, ProfileActivity03.class);
                        startActivity(intent);
                    }

                } else {
                    Intent intent = new Intent(ProfileActivity02.this, ProfileActivity03.class);
                    startActivity(intent);
                }


            }
        });


//        String[] items = getResources().getStringArray(R.array.languages_array);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        spinner.setAdapter(adapter);

    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            Log.d("Selected!", "Working");
            RelativeLayout ll = (RelativeLayout) findViewById(R.id.RL);

            ll.setVisibility(View.VISIBLE);
            //CheckBox ch = new CheckBox(this);
            //ch.setText("Ohoud");
            //ll.addView(ch);

        } else {
            RelativeLayout ll = (RelativeLayout) findViewById(R.id.RL);

            ll.setVisibility(View.GONE);
        }
    }


}
