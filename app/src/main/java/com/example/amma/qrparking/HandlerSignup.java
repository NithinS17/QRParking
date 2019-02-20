package com.example.amma.qrparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HandlerSignup extends AppCompatActivity {

    EditText user,pass,repass,mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_signup);

        user = (EditText)findViewById(R.id.usrusr);
        repass = (EditText)findViewById(R.id.repass);
        pass = (EditText)findViewById(R.id.pass);
        mob = (EditText)findViewById(R.id.mob);
        Button login=(Button) findViewById(R.id.lin);

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
                else if(repass.getText().toString().length()== 0) {
                    repass.setError("Password Required");
                    repass.requestFocus();
                }
                else if(mob.getText().toString().length()== 0) {
                    mob.setError("Password Required");
                    mob.requestFocus();
                }
                else{
                    Intent i = new Intent(getApplicationContext(),UserSignup.class);
                    startActivity(i);
                }
            }
        });
    }
}
