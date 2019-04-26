package com.example.amma.qrparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Slotcheck extends AppCompatActivity {
    String batch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slotcheck);

        Spinner dropdown = findViewById(R.id.sp1);
        String[] items = new String[]{"Int MCA 2015", "Int MCA 2016", "Int MCA 2017", "Int MCA 2018", "MCA LAT 2017", "MCA LAT 2018"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                batch = (String) parent.getItemAtPosition(position);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
