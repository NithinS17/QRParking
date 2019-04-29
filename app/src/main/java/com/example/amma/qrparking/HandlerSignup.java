package com.example.amma.qrparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HandlerSignup extends AppCompatActivity {

    EditText user,pass,repass,mob,email;
    DatabaseReference reff;
    addhandler  addhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_signup);

        user = (EditText)findViewById(R.id.usrusr);
        repass = (EditText)findViewById(R.id.repass);
        pass = (EditText)findViewById(R.id.pass);
        email = (EditText)findViewById(R.id.hemail);
        mob = (EditText)findViewById(R.id.mob);
        Button login=(Button) findViewById(R.id.lin);
        addhandler=new addhandler();
        reff= FirebaseDatabase.getInstance().getReference().child("handler");

        final String mail = email.getText().toString().trim();

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().length()== 0) {
                    user.setError("Username Required");
                    user.requestFocus();
                }
                else if(email.getText().toString().length()== 0) {
                    email.setError("Email Required");
                    email.requestFocus();
                }
                else if(!mail.matches(emailPattern)) {
                    email.setError("Invalid Email");
                    email.requestFocus();
                }
                else if(pass.getText().toString().length()== 0) {
                    pass.setError("Password Required");
                    pass.requestFocus();
                }
                else if(repass.getText().toString().length()== 0) {
                    repass.setError("Password Required");
                    repass.requestFocus();
                }
                else if(mob.getText().toString().length()== 0) {
                    mob.setError("Password Required");
                    mob.requestFocus();
                }
                /*else if(!repass.equals("pass")){
                    Toast.makeText(getApplicationContext(),"Password & Confirm password must be same",Toast.LENGTH_LONG).show();
                    repass.requestFocus();

                }*/
                else {
                    //if(repass.equals("pass")) {
                    int phonenum = Integer.parseInt(mob.getText().toString().trim());
                    addhandler.setUsername(user.getText().toString().trim());
                    addhandler.setPassword(pass.getText().toString().trim());
                    addhandler.setEmail(email.getText().toString().trim());
                    addhandler.setConfirmpass(repass.getText().toString().trim());
                    addhandler.setPhonenum(phonenum);
                    reff.push().setValue(addhandler);
                    DatabaseReference dt=FirebaseDatabase.getInstance().getReference("nohandler");
                    dt.child("hand").child(user.getText().toString().trim()).setValue(phonenum);
                    Toast.makeText(getApplicationContext(), "Signed up Successfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), HandlerHome.class);
                    startActivity(i);
                    //}
                    //else{
                    //  Toast.makeText(getApplicationContext(), "Something went wrong Try again later", Toast.LENGTH_LONG).show();
                    // Intent i = new Intent(getApplicationContext(), handler.class);
                    // startActivity(i);
                    //}
                }
            }
        });
    }
}
