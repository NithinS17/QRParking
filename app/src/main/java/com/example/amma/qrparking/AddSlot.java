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
    EditText district,city,landmark,slots;
    Spinner state;
    addslotdetails slotdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_slot);
        submit=(Button)findViewById(R.id.submit);
          slotdetails=new addslotdetails();

        state=(Spinner)findViewById(R.id.sp2);
        district=(EditText)findViewById(R.id.district);
        city=(EditText)findViewById(R.id.city);
        landmark=(EditText)findViewById(R.id.landmark);
        slots=(EditText)findViewById(R.id.slots);

        reff= FirebaseDatabase.getInstance().getReference().child("ParkingSlot");
        Sspinner=(Spinner)findViewById(R.id.sp2);
        ArrayList<String> Slist=new ArrayList<>();
        Slist.add("Andhra Pradesh");
        Slist.add("Goa");
        Slist.add("Karnataka");
        Slist.add("Kerala");
        Slist.add("Maharashtra");
        Slist.add("Tamil Nadu");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Slist);
        Sspinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int slotno = Integer.parseInt(slots.getText().toString().trim());
                slotdetails.setState(state.getSelectedItem().toString().trim());
                slotdetails.setDistrict(district.getText().toString().trim());
                slotdetails.setCity(city.getText().toString().trim());
                slotdetails.setLandmark(landmark.getText().toString().trim());
                slotdetails.setNslots(slotno);
                reff.push().setValue(slotdetails);
                Toast.makeText(getApplicationContext(), "Slots Added Successfully", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), HandlerHome.class);
                startActivity(i);




            }
        });
    }
}
