package com.example.amma.qrparking;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class UserHome extends AppCompatActivity {
    EditText carnum,phnenum,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        carnum=(EditText)findViewById(R.id.carnum);
        phnenum=(EditText)findViewById(R.id.mob);
        //date=(EditText)findViewById(R.id.calander);

        if(carnum.getText().toString().length()== 0) {
            carnum.setError("Username Required");
            carnum.requestFocus();
        }
        else if(phnenum.getText().toString().length()== 0) {
            phnenum.setError("Username Required");
            phnenum.requestFocus();
        }
        else if(date.getText().toString().length()== 0) {
            date.setError("Username Required");
            date.requestFocus();
        }
        else {
           Intent i =new Intent(getApplicationContext(),SearchSlot.class);
           startActivity(i);
        } 




        /*final Calendar myCalendar = Calendar.getInstance();

        //final EditText edittext= (EditText) findViewById(R.id.calander);
        final DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
            private void updateLabel() {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                edittext.setText(sdf.format(myCalendar.getTime()));
            }
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(UserHome.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });*/


    }

}
