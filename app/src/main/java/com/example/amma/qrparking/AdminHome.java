package com.example.amma.qrparking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AdminHome extends AppCompatActivity {
    ImageButton user,handler;
    Button logout;
    SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        user=(ImageButton)findViewById(R.id.userdetails);
        handler=(ImageButton)findViewById(R.id.handlerdetails);
        logout=findViewById(R.id.lout);
        sp=getApplicationContext().getSharedPreferences("user",MODE_PRIVATE);



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putString("USER","").apply();
                Intent i = new Intent(getApplicationContext(),admin.class);
                startActivity(i);
                finish();
            }
        });


        handler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(),noofhandlers.class);
                startActivity(i);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),NoOfUsrs.class);
                startActivity(i);
            }
        });
    }

}
