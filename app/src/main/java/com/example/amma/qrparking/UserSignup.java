package com.example.amma.qrparking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class UserSignup extends AppCompatActivity {
    EditText user,pass,repass,mob;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbref = database.getReference("user");
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
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

                    dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                            int nousr = Integer.parseInt(String.valueOf(dataSnapshot.getValue()));
                            dbref.setValue(nousr + 1);
                            nousr = (nousr + 1);
                            DatabaseReference usrRef = database.getReference(dbref.getKey() + nousr);
                            usrRef.child("Name").setValue(user.getText().toString());
                            usrRef.child("Phone").setValue(mob.getText().toString());
                            usrRef.child("Password").setValue(pass.getText().toString());
                            Toast.makeText(UserSignup.this, "Successfully Registered", Toast.LENGTH_LONG).show();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(UserSignup.this, "Unable to connect. Please try again later.", Toast.LENGTH_LONG).show();

                        }
                    });




















                    Intent i = new Intent(getApplicationContext(),UserSignup.class);
                    startActivity(i);
                }
            }
        });

    }


}


