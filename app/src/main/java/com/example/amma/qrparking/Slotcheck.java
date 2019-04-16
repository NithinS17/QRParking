package com.example.amma.qrparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Slotcheck extends AppCompatActivity {
    Spinner Sspinner,Dspinner,Cspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slotcheck);

        Sspinner=(Spinner)findViewById(R.id.sp1);
        ArrayList<String> Slist=new ArrayList<>();
        Slist.add("Andhra Pradesh");
        Slist.add("Goa");
        Slist.add("Karnataka");
        Slist.add("Kerala");
        Slist.add("Maharashtra");
        Slist.add("Tamil Nadu");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.activity_list_item,Slist);
        Sspinner.setAdapter(adapter);

    }
}
