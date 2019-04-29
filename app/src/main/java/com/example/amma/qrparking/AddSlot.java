package com.example.amma.qrparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddSlot extends AppCompatActivity {
    Spinner Sspinner,Dspinner,Cspinner;
    Button submit;
    DatabaseReference reff;
    EditText landmark,slots;
    Spinner city;
    addslotdetails slotdetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_slot);
        submit=(Button)findViewById(R.id.submit);
          slotdetails=new addslotdetails();

        city=(Spinner)findViewById(R.id.sp2);
        landmark=(EditText)findViewById(R.id.landmark);
        slots=(EditText)findViewById(R.id.slots);

        reff= FirebaseDatabase.getInstance().getReference().child("ParkingSlot");
        Sspinner=(Spinner)findViewById(R.id.sp2);
        ArrayList<String> Slist=new ArrayList<>();
        Slist.add("Aluva");
        Slist.add("Kalamassery");
        Slist.add("Kakkanad");
        Slist.add("Edapally");
        Slist.add("Vytilla");
        Slist.add("Kaloor");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Slist);
        Sspinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(landmark.getText().toString().length()== 0) {
                    landmark.setError("Landmark Required");
                    landmark.requestFocus();
                }
                else if(slots.getText().length()==0)
                {
                    slots.setError("Enter slots");
                    slots.requestFocus();
                }
                else
                {

                    int slotno = Integer.parseInt(slots.getText().toString().trim());
                    slotdetails.setCity(city.getSelectedItem().toString().trim());
                    slotdetails.setLandmark(landmark.getText().toString().trim());
                    slotdetails.setNslots(slotno);

                    reff.push().setValue(slotdetails);
                    Toast.makeText(getApplicationContext(), "Slots Added Successfully", Toast.LENGTH_LONG).show();

                    Intent i = new Intent(getApplicationContext(),addImage.class);
                    startActivity(i);
                    finish();
                }



            }
        });




            }

    }

