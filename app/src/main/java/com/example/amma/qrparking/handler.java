package com.example.amma.qrparking;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class handler extends AppCompatActivity {
EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        user = (EditText)findViewById(R.id.usrusr);
        pass = (EditText)findViewById(R.id.pswrdd);
        Button login=(Button) findViewById(R.id.lin);
        Button Singup=(Button) findViewById(R.id.sin) ;

        Singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(handler.this, HandlerSignup.class));
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
                    final String uname = user.getText().toString().trim();
                    final String passw=pass.getText().toString().trim();

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    Query query =  reference.child("handler").orderByChild("username").equalTo(uname);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists())
                            { try {
                                for (DataSnapshot ca : dataSnapshot.getChildren()) {
                                    {

                                        addhandler r = ca.getValue(addhandler.class);
                                        String name=r.getUsername().toString().trim();
                                        String passwrd=r.getPassword().toString().trim();


                                        if(uname.equals(name) && passw.equals(passwrd))
                                        {
                                            Toast.makeText(getApplicationContext(),"Welcome "+uname,Toast.LENGTH_LONG).show();
                                            Intent i = new Intent(getApplicationContext(),HandlerHome.class);
                                            startActivity(i);
                                        }
                                        else
                                        {
                                            Toast.makeText(getApplicationContext(),"Invalid User",Toast.LENGTH_LONG).show();
                                            Intent i = new Intent(getApplicationContext(),handler.class);
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
