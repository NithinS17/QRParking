package com.example.amma.qrparking;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class CreateQR extends AppCompatActivity {

    EditText cno;
    ImageView imgView;
    Button b;
    String no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);
        cno=findViewById(R.id.carnum);
        b=findViewById(R.id.lin);
        imgView=findViewById(R.id.qrImage);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=cno.getText().toString();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{

                    BitMatrix bitMatrix = multiFormatWriter.encode("txt", BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    imgView.setImageBitmap(bitmap);





                } catch (WriterException e) {
                    e.printStackTrace();
                }


            }
        });


    }
}


