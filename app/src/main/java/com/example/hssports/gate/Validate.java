package com.example.hssports.gate;

import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by Ohoud on 07/10/16.
 */
public class Validate
{
    EditText et2;

    public Validate(EditText et)
    {
        et2 = et;
    }

    public boolean isEmpty()
    {
        if(et2.getText().toString().trim().length()<= 0)
        {
            Log.d("Empty!",et2.toString());
            return true;
        }

        return false;

    }

    public boolean isValidEmail(String email)
    {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}
