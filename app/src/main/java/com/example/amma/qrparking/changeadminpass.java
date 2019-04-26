package com.example.amma.qrparking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class changeadminpass extends AppCompatActivity {
    Button btn;
    EditText newpass,cnewpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeadminpass);
        btn=(Button)findViewById(R.id.apcbtn);
        newpass=(EditText)findViewById(R.id.newpass);
        cnewpass=(EditText)findViewById(R.id.cnewpass);


    }

}
