package com.example.amma.qrparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class scannedresult extends AppCompatActivity {
    TextView scnrslt;
    String rslt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scannedresult);
        scnrslt=(TextView)findViewById(R.id.scnrslt);
        Bundle b =getIntent().getExtras();
        rslt=b.getString("result");
        scnrslt.setText(rslt);
    }
}
