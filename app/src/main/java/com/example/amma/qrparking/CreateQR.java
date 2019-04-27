package com.example.amma.qrparking;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class CreateQR extends AppCompatActivity {

    EditText cno;
    ImageView imgView;
    TextView slotView;
    Button b,logout;
    String no;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);
        cno=findViewById(R.id.carnum);
        b=findViewById(R.id.book);
        imgView=findViewById(R.id.qrImage);
        logout=(Button)findViewById(R.id.logout);
        slotView=findViewById(R.id.tv9);
        Intent in = getIntent();
        Bundle b1 = in.getExtras();
        final String Hotel = b1.getString("Details");
        slotView.setText("Details");


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


               /* if (cno.length() > 0) {
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int smallerDimension = width < height ? width : height;
                    smallerDimension = smallerDimension * 3 / 4;


                    QRGEncoder qrgEncoder = new QRGEncoder(
                            cno, null,
                            QRGContents.Type.TEXT,
                            smallerDimension);
                    try {
                        bitmap = qrgEncoder.encodeAsBitmap();
                        qrImage.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        Log.v(TAG, e.toString());
                    }
                } else {
                    edtValue.setError("Required");
                }*/


            }
        });
logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(CreateQR.this, "LogOut Successfully", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(),user.class);
        startActivity(i);
    }
});

    }
}


