package com.example.amma.qrparking;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class noofhandlers extends AppCompatActivity {
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noofhandlers);
        txt1=findViewById(R.id.txt1);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        Query query = reference.child("nohandler");
        query.addValueEventListener (new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    try { for (DataSnapshot ca : dataSnapshot.getChildren()) {
                        txt1.setText(ca.getValue().toString());
                    }
                    }
                    catch (Exception e){
                        Toast.makeText(noofhandlers.this, e.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    }
