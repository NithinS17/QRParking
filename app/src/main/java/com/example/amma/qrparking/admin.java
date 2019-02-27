package com.example.amma.qrparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class admin extends AppCompatActivity {
    //int f;
    EditText user,pass;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

       // f=0;
        user = (EditText)findViewById(R.id.usrusr);
        pass = (EditText)findViewById(R.id.pass);
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
                else{
                    Intent i = new Intent(getApplicationContext(),AdminHome.class);
                    startActivity(i);
                }
           }
       });




    }
}