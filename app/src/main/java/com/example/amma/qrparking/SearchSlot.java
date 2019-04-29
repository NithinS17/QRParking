package com.example.amma.qrparking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchSlot extends AppCompatActivity {
    EditText ed1;
    public Spinner staticSpinner;
    ImageView i1, i2, i3, i4;
    String place;
    public Button button;
    Button b1, b2, b3, b4, btn;
    TextView tx1,tx2,tx3,tx4,tx5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_slot);
        setContentView(R.layout.activity_search_slot);
        i1 = findViewById(R.id.img1);
        i2 = findViewById(R.id.img2);
        i3 = findViewById(R.id.img3);
        i4 = findViewById(R.id.img4);
        b1 = findViewById(R.id.select1);
        b2 = findViewById(R.id.select2);
        b3 = findViewById(R.id.select3);
        b4 = findViewById(R.id.select4);
        tx1=findViewById(R.id.txtv1);
        tx2=findViewById(R.id.txtv2);
        tx3= findViewById(R.id.txtv3);
        tx4=findViewById(R.id.txtv4);
        btn = findViewById(R.id.select);

        Spinner dropdown = findViewById(R.id.static_spinner);
        String[] items = new String[]{"Edapally", "Aluva", "Kalamassery", "Kaloor", "Vytila", "Kakkanad"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                place = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       /* staticSpinner = (Spinner) findViewById(R.id.static_spinner);
        ArrayList<String> Slist = new ArrayList<>();
        Slist.add("Aluva");
        Slist.add("Kalamassery");
        Slist.add("Kakkanad");
        Slist.add("Edapally");
        Slist.add("Vytilla");
        Slist.add("Palarivattom");
        Slist.add("Kaloor");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_search_slot, Slist);

        //adapter.setDropDownViewResource(android.R.layout.activity_list_item);
        staticSpinner.setAdapter(adapter);
    }

      public abstract class ItemSelectedListener implements AdapterView.OnItemSelectedListener {


        String firstItem = String.valueOf(staticSpinner.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

            if (firstItem.equals(String.valueOf(staticSpinner.getSelectedItem()))) {

            } else {
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
                place = parent.getItemAtPosition(pos).toString();


            }


            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            Query query = reference.child("parking slots").orderByChild("city").equalTo(place);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) try {
                        for (DataSnapshot ca : dataSnapshot.getChildren()) {
                            {
                                addslotdetails s = ca.getValue(addslotdetails.class);
                                String cityname = s.getCity().toString().trim();

                            }
                        }
                    } catch (Exception e) {


                    }
                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }*/


       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(getApplicationContext(),CreateQR.class);
               Bundle b = new Bundle();
               b.putString("Details", tx1.getText().toString());
               i.putExtras(b);
               startActivity(i);
               finish();

           }
       });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),CreateQR.class);
                Bundle b = new Bundle();
                b.putString("Details", tx2.getText().toString());
                i.putExtras(b);
                startActivity(i);
                finish();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),CreateQR.class);
                Bundle b = new Bundle();
                b.putString("Details", tx3.getText().toString());
                i.putExtras(b);
                startActivity(i);
                finish();

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),CreateQR.class);
                Bundle b = new Bundle();
                b.putString("Details", tx4.getText().toString());
                i.putExtras(b);
                startActivity(i);
                finish();

            }
        });



    }

    public void select(View view) {
        if (place.equals("Edapally")) {
            i1.setImageResource(R.drawable.edap1);
            tx1.setText("Metro Station,Near LULU mall\nHandler:Joseph\nFare:Rs.35/hr");
            i2.setImageResource(R.drawable.edap2);
            tx2.setText("Palarivattom,Near Church\nHandler:George\nFare:Rs.20/hr");
            i3.setImageResource(R.drawable.edap3);
            tx3.setText("Aluva Road,Near LULU mall\nHandler:John\nFare:Rs.30/hr");
            i4.setImageResource(R.drawable.edap4);
            tx4.setText("Vytilla Road,Near Obron mall\nHandler:David\nFare:Rs.25/hr");
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);
        }

        if (place.equals("Aluva")) {
            i1.setImageResource(R.drawable.aluva1);
            tx1.setText("Metro Station,Ernakulam Road\nHandler:Sreerag\nFare:Rs.35/hr");
            i2.setImageResource(R.drawable.aluva2);
            tx2.setText("Palarivattom,Near Church\nHandler:Aswin\nFare:Rs.20/hr");
            i3.setImageResource(R.drawable.aluva3);
            tx3.setText("Aluva Road,Near LULU mall\nHandler:Suraj\nFare:Rs.30/hr");
            i4.setImageResource(R.drawable.aluva4);
            tx4.setText("Vytilla Road,Near Obron mall\nHandler:Ananthu\nFare:Rs.25/hr");
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);
        }

        if (place.equals("Kalamassery")) {
            i1.setImageResource(R.drawable.kalam1);
            tx1.setText("Metro Station,Ernakulam Road\nHandler:Abhi\nFare:Rs.35/hr");
            i2.setImageResource(R.drawable.kalam2);
            tx2.setText("Palarivattom,Near Church\nHandler:Akash\nFare:Rs.20/hr");
            i3.setImageResource(R.drawable.kalam3);
            tx3.setText("Aluva Road,Near LULU mall\nHandler:Nirmal\nFare:Rs.30/hr");
            i4.setImageResource(R.drawable.kalam4);
            tx4.setText("Vytilla Road,Near Obron mall\nHandler:Unni\nFare:Rs.25/hr");
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);
        }
        if (place.equals("Vytila")) {
            i1.setImageResource(R.drawable.vytila1);
            tx1.setText("Metro Station,Ernakulam Road\nHandler:Arjun\nFare:Rs.35/hr");
            i2.setImageResource(R.drawable.vytila2);
            tx2.setText("Palarivattom,Near Church\nHandler:Aswin\nFare:Rs.20/hr");
            i3.setImageResource(R.drawable.vytila3);
            tx3.setText("Aluva Road,Near LULU mall\nHandler:Jishnu\nFare:Rs.30/hr");
            i4.setImageResource(R.drawable.vytila4);
            tx4.setText("Vytilla Road,Near Obron mall\nHandler:Sergio\nFare:Rs.25/hr");
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);
        }
        if (place.equals("Kaloor")) {
            i1.setImageResource(R.drawable.kaloor1);
            tx1.setText("Metro Station,Ernakulam Road\nHandler:Jordi\nFare:Rs.35/hr");
            i2.setImageResource(R.drawable.kaloor2);
            tx2.setText("Palarivattom,Near Church\nHandler:Philip\nFare:Rs.20/hr");
            i3.setImageResource(R.drawable.kaloor3);
            tx3.setText("Aluva Road,Near LULU mall\nHandler:Luiz\nFare:Rs.30/hr");
            i4.setImageResource(R.drawable.kaloor4);
            tx4.setText("Vytilla Road,Near Obron mall\nHandler:Ivan\nFare:Rs.25/hr");
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);
        }
        if (place.equals("Kakkanad")) {
            i1.setImageResource(R.drawable.kakk1);
            tx1.setText("Metro Station,Ernakulam Road\nHandler:Suraez\nFare:Rs.35/hr");
            i2.setImageResource(R.drawable.kakk2);
            tx2.setText("Palarivattom,Near Church\nHandler:Rakitic\nFare:Rs.20/hr");
            i3.setImageResource(R.drawable.kakk3);
            tx3.setText("Aluva Road,Near LULU mall\nHandler:Dembele\nFare:Rs.30/hr");
            i4.setImageResource(R.drawable.kakk4);
            tx4.setText("Vytilla Road,Near Obron mall\nHandler:Arturo\nFare:Rs.25/hr");
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);
        }
    }



}

