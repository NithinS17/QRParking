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
import java.util.ArrayList;
import java.util.List;

public class NoOfUsrs extends AppCompatActivity {
    TextView txt1;
    List<username> list= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_of_usrs);
        txt1=findViewById(R.id.txt1);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        Query query = reference.child("username");
        query.addValueEventListener (new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if (dataSnapshot.exists()) {
                    try {
                      /*  Integer length = Integer.parseInt(String.valueOf(dataSnapshot.getChildrenCount()));
                        String [] s = new String[length];
                        String [] s1 = new String[length];
                        for (DataSnapshot ca : dataSnapshot.getChildren()) {
                            txt1.setSingleLine(false);
                            s[length]=ca.getKey();
                            s1[length]=ca.getValue().toString();
                            length--;

                        }
                        for(int j =length;j>0;j++)
                        {
                            txt1.setText(s[j]+" "+s1[j]+"\n");
                        }*/
                        for (DataSnapshot ca : dataSnapshot.getChildren()) {
                            txt1.setText(ca.getValue().toString());
                        }
                    }
                    catch (Exception e){
                        Toast.makeText(NoOfUsrs.this, e.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}

