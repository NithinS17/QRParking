package com.example.amma.qrparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class user extends AppCompatActivity {
    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        user = (EditText)findViewById(R.id.usrusr);
        pass = (EditText)findViewById(R.id.pswrdd);
        Button login=(Button) findViewById(R.id.lin);
        Button Singup=(Button) findViewById(R.id.sin) ;
        Singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user.this, UserSignup.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().length()== 0) {
                    user.setError("Username Required");
                    user.requestFocus();
                }
                else if(pass.getText().toString().length()== 0) {
                    pass.setError("Password Required");
                    pass.requestFocus();
                }
                else{
                    Intent i = new Intent(getApplicationContext(),user.class);
                    startActivity(i);
                }
            }
        });

    }

}
