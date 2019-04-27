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
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;





public class user extends AppCompatActivity {
    EditText username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        username = (EditText)findViewById(R.id.uname);
        password = (EditText)findViewById(R.id.pswrdd);
        Button login=(Button) findViewById(R.id.lin);
        Button Signup=(Button) findViewById(R.id.sin) ;
        Button fpass=(Button) findViewById(R.id.fpass) ;
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), UserSignup.class);
                startActivity(i);

            }
        });
        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),foregtpassword.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().length()== 0) {
                    username.setError("Username Required");
                    username.requestFocus();
                }
                else if(password.getText().toString().length()== 0) {
                    password.setError("Password Required");
                    password.requestFocus();
                }
                else{
                    final String uname = username.getText().toString().trim();
                    final String passw=password.getText().toString().trim();

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    Query query =  reference.child("user").orderByChild("username").equalTo(uname);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists())
                            { try {
                                for (DataSnapshot ca : dataSnapshot.getChildren()) {
                                    {

                                        adduser r = ca.getValue(adduser.class);
                                        String name=r.getUsername().toString().trim();
                                        String passwrd=r.getPassword().toString().trim();


                                        if(uname.equals(name) && passw.equals(passwrd))
                                        {
                                            Toast.makeText(getApplicationContext(),"Welcome "+uname,Toast.LENGTH_LONG).show();
                                            Intent i = new Intent(getApplicationContext(),SearchSlot.class);
                                            startActivity(i);
                                        }
                                        else
                                        {
                                            Toast.makeText(getApplicationContext(),"Invalid User",Toast.LENGTH_LONG).show();
                                            Intent i = new Intent(getApplicationContext(),user.class);
                                        }
                                    }
                                }
                            }catch(Exception e){}


                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });











                }
            }
        });
    }

}



