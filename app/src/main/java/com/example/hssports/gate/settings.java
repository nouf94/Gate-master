package com.example.hssports.gate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by user on 10/15/2016.
 */

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content,new Prefsettings()).commit();


    }

    @SuppressLint("ValidFragment")
        private class Prefsettings extends PreferenceFragment {


            @Override
            public void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                addPreferencesFromResource(R.xml.settings);

            }

        }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

