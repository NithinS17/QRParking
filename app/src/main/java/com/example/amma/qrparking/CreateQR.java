package com.example.amma.qrparking;

import android.app.usage.ExternalStorageStats;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Environment;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CreateQR extends AppCompatActivity {

    EditText cno;
    ImageView imgView;
    TextView slotView;
    Button b,logout;
    SharedPreferences sp;
    String TAG = "GenerateQRCode";
    String inputValue;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);
        cno=findViewById(R.id.carnum);
        b=findViewById(R.id.book);
        sp=getApplicationContext().getSharedPreferences("user",MODE_PRIVATE);

        imgView=findViewById(R.id.qrImage);
        logout=(Button)findViewById(R.id.logout);
        slotView=findViewById(R.id.tv9);
        Intent in = getIntent();
        Bundle b1 = in.getExtras();
        final String place = b1.getString("Details");
        slotView.setText(place);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                inputValue = cno.getText().toString().trim();
                if (inputValue.length() > 0) {
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int smallerDimension = width < height ? width : height;
                    smallerDimension = smallerDimension * 3 / 4;

                    qrgEncoder = new QRGEncoder(
                            inputValue, null,
                            QRGContents.Type.TEXT,
                            smallerDimension);
                    try {
                        bitmap = qrgEncoder.encodeAsBitmap();
                        imgView.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        Log.v(TAG, e.toString());
                    }
                } else {
                    cno.setError("Required");
                }
            }
        });

     /*   save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean save;
                String result;
                try {
                    save = QRGSaver.save(savePath, cno.getText().toString().trim(), bitmap, QRGContents.ImageType.IMAGE_JPEG);
                    result = save ? "Image Saved" : "Image Not Saved";
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });*/

logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sp.edit().putString("USER","").apply();
        Toast.makeText(CreateQR.this, "LogOut Successfully", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(),user.class);
        startActivity(i);
        finish();
    }
});

    }
}


