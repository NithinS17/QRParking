package com.example.amma.qrparking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class SplashScreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    SharedPreferences sp;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sp=getApplicationContext().getSharedPreferences("user",MODE_PRIVATE);
        String user1=sp.getString("USER","");
        if(user1.equals("ADMIN")){
             i =new Intent(getApplicationContext(),AdminHome.class);
        }
        else if(user1.equals("HANDLER")){
            i =new Intent(getApplicationContext(),HandlerHome.class);
        }
        else if(user1.equals("USER")){
            i =new Intent(getApplicationContext(),user.class);
        }
        else {
              i=new Intent(SplashScreen.this,MainActivity.class);

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashScreen.this.startActivity(i);
                SplashScreen.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}
