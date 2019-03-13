package com.example.amma.qrparking;

import android.arch.lifecycle.AndroidViewModel;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class UserSignup extends AppCompatActivity {
    EditText email,password,repass,mob;


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        email = (EditText)findViewById(R.id.email);
        repass = (EditText)findViewById(R.id.repass);
        password = (EditText)findViewById(R.id.pass);
        mob = (EditText)findViewById(R.id.mob);
        final Button login=(Button) findViewById(R.id.lin);
        mAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString();
                String Password=password.getText().toString();
                String rePassword=repass.getText().toString();
                if(email.getText().toString().length()== 0) {
                    email.setError("Username Required");
                    email.requestFocus();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
                {
                    Toast.makeText(getApplicationContext(),"Enter valid email address!!",Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().length()== 0) {
                    password.setError("Password Required");
                    password.requestFocus();
                }
                else if(repass.getText().toString().length()== 0) {
                        repass.setError("Password Required");
                        repass.requestFocus();
                }

                else if(mob.getText().toString().length()== 0) {
                    mob.setError("Mobile number Required");
                    mob.requestFocus();
                }
                else
                    {

                        mAuth.createUserWithEmailAndPassword(Email,Password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful())
                                        {
                                            Toast.makeText(getApplicationContext(),"User Registered Successfully",Toast.LENGTH_LONG).show();
                                            Intent i = new Intent(getApplicationContext(),user.class);
                                            startActivity(i);
                                        }
                                    }
                                });






                    }




















                }

        });

    }


}


