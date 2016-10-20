package com.example.hssports.gate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.*;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements AsyncResponse {
    EditText username,pw;
    Validate checkUN,checkPW;
    boolean noneEmpty = false;
    boolean sucess = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         username = (EditText) findViewById(R.id.editText);
          pw = (EditText) findViewById(R.id.editText2);
        Button loginB = (Button) findViewById(R.id.loginB);

        checkUN = new Validate(username);
        checkPW = new Validate(pw);

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap postData = new HashMap();
                postData.put("btnLogin", "Login");
                postData.put("mobile", "android");
                postData.put("txtUsername", username.getText().toString());
                postData.put("txtPassword", pw.getText().toString() );

                PostResponseAsyncTask loginTask =
                        new PostResponseAsyncTask(LoginActivity.this, postData);
               loginTask.execute("http://10.5.197.97/client/login.php");
            }
        });


        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               //Check if all entries are none empty!
                if(checkUN.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter username", Toast.LENGTH_LONG).show();

                }
                else
                {
                    noneEmpty = true;
                }

                if(checkPW.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_LONG).show();
                }
                else
                noneEmpty = true;

                //if there is data, login !
                if(noneEmpty) {
                    HashMap postData = new HashMap();
                   postData.put("btnLogin",
                            "Login");
                    postData.put("mobile", "android");
                   postData.put("txtUsername", username.getText().toString());
                   postData.put("txtPassword", pw.getText().toString());

                   PostResponseAsyncTask loginTask =
                           new PostResponseAsyncTask(LoginActivity.this, postData);
                  loginTask.execute("http://192.168.100.4/client/login.php");
                   if(sucess)
                   {
                        Intent intent = new Intent(LoginActivity.this, UserMainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }



    @Override
    public void processFinish(String s) {
        if(s.equals("success")){
            Toast.makeText(this, "Login Successfully",
                    Toast.LENGTH_LONG).show();
            sucess = true;
        }
        else
        {
            Toast.makeText(this, "Wrong email or password!",
                    Toast.LENGTH_LONG).show();
        }
    }
}
