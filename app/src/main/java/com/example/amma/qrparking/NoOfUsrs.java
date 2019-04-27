package com.example.amma.qrparking;

import android.content.Intent;
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

import java.lang.reflect.Array;

public class NoOfUsrs extends AppCompatActivity {
    String name;
    Integer i,nousr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_of_usrs);

        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference().child("user").child("userno");
        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                nousr = Integer.parseInt(String.valueOf(dataSnapshot.getValue()));
                final String[] mStrings = new String[nousr];
                for (i=1;i<nousr+1;i++)
                {

                    DatabaseReference usref = FirebaseDatabase.getInstance().getReference().child("user").child("username").child("user"+i);
                    usref.addListenerForSingleValueEvent(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
                for (int k = 1;k<nousr;k++) {
                    name = "tv"+k;
                    int id = getResources().getIdentifier(name, "id", getPackageName());
                    if (id != 0) {
                        TextView textView = (TextView) findViewById(id);
                        Toast.makeText(NoOfUsrs.this, String.valueOf(mStrings[k]), Toast.LENGTH_SHORT).show();
                        textView.setText(mStrings[k]);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }

}

