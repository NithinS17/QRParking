package com.example.amma.qrparking;

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

import java.util.ArrayList;
import java.util.List;

public class SearchSlot extends AppCompatActivity {
    EditText ed1;
    public Spinner staticSpinner;
    ImageView i1, i2, i3, i4;
    String place;
    public Button button;
    Button b1, b2, b3, b4, btn;

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
        btn = findViewById(R.id.select);


        staticSpinner = (Spinner) findViewById(R.id.static_spinner);
        ArrayList<String> Slist = new ArrayList<>();
        Slist.add("Aluva");
        Slist.add("Kalamassery");
        Slist.add("Kakkanad");
        Slist.add("Edapally");
        Slist.add("Vytilla");
        Slist.add("Palarivattom");
        Slist.add("Kaloor");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, Slist);
        staticSpinner.setAdapter(adapter);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

        }
        public  void select(View view)
        {
            if(place.equals("Edapally"))
            {
               i1.setImageResource(R.drawable.edap1);
               i2.setImageResource(R.drawable.edap2);
               i3.setImageResource(R.drawable.edap3);
               i4.setImageResource(R.drawable.edap4);
               b1.setVisibility(View.VISIBLE);
               b2.setVisibility(View.VISIBLE);
               b3.setVisibility(View.VISIBLE);
               b4.setVisibility(View.VISIBLE);
            }
        }
    }
}
