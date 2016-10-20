package com.example.hssports.gate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Validate checkEmail, checkUN, checkName, checkPW, checkCPW;
    EditText email, username,name, password, confPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get the values
        email = (EditText)findViewById(R.id.editText3);
        username = (EditText)findViewById(R.id.editText4);
        name = (EditText)findViewById(R.id.editText5);
        password = (EditText)findViewById(R.id.editText6);
        confPw = (EditText)findViewById(R.id.editText7);

        checkEmail = new Validate(email);
        checkUN = new Validate(username);
        checkName = new Validate(name);
        checkPW = new Validate(password);
        checkCPW = new Validate(confPw);


        Button nextBut = (Button) findViewById(R.id.button);
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Check if all entries are none empty !
                if(checkEmail.isEmpty() || checkUN.isEmpty()||checkName.isEmpty()||checkPW.isEmpty()||checkCPW.isEmpty()) {
                   Toast.makeText(RegisterActivity.this, "Please enter all fields!", Toast.LENGTH_LONG).show();
               }else
                {
                    //check if it is email pattern
                    if(checkEmail.isValidEmail(email.getText().toString())){

                        //check if user has write the same password
                        if(password.getText().toString().trim().equals(confPw.getText().toString().trim()))
                        {
                            Intent intent = new Intent(RegisterActivity.this, ProfileActivity01.class);
                            startActivity(intent);


                        }
                        else {

                            Toast.makeText(RegisterActivity.this, "your password doesn't match the confirmed one!", Toast.LENGTH_LONG).show();

                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "Invalid email address!", Toast.LENGTH_LONG).show();
                    }



                }
            }
        });
    }


}
