package com.example.amma.qrparking;

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


public class admin extends AppCompatActivity {
    EditText user, pass;
    String uname = "admin";
    String passw = "admin";
    Button cbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        user = (EditText) findViewById(R.id.usrusr);
        pass = (EditText) findViewById(R.id.pass);
        cbtn=(Button)findViewById(R.id.apass);
        Button login = (Button) findViewById(R.id.lin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().length() == 0) {
                    user.setError("Username Required");
                    user.requestFocus();
                } else if (pass.getText().toString().length() == 0) {
                    pass.setError("Password Required");
                    pass.requestFocus();
                } else {

                    if (user.equals(uname) && pass.equals(passw)) {
                        Toast.makeText(admin.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), AdminHome.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(admin.this, "Invalid User", Toast.LENGTH_SHORT).show();
                        Intent I = new Intent(getApplicationContext(), admin.class);
                    }

                  /* DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    Query query = reference.child("admin").orderByChild("username").equalTo("admin");
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (DataSnapshot ca : dataSnapshot.getChildren()) {
                                    // do something with the individual "issues"
                                    admin usr=ca.getValue(admin.class);
                                    user= (String) admin.get
                                    ty= (String) car.getType();
                                    v= (String) car.getModel();
                             t5.setText(c.getRegno());
                                    t11.setText(c.getType());
                                    t6.setText(c.getModel());
                                }
                            }
                            }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                       }
                    });
                    Intent i = new Intent(getApplicationContext(),QRScanner.class);
                    startActivity(i);*/
                }
            }
        });


        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), changeadminpass.class);
                startActivity(i);
            }
        });


    }
}