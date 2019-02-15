package com.example.amma.qrparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class admin extends AppCompatActivity {
    int f;
    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void check()
    {
        f=0;
        user = (EditText)findViewById(R.id.usrusr);
        pass = (EditText)findViewById(R.id.pass);

        if(user.getText().toString().trim().length()==0)
        {
            f++;
            user.setError("Username is not entered");
            user.requestFocus();

        }
        if(pass.getText().toString().trim().length()==0)
        {
            f++;
            pass.setError("Password is not entered");
            pass.requestFocus();
        }
    }
}
