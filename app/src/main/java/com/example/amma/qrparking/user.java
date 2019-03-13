package com.example.amma.qrparking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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





public class user extends AppCompatActivity {
    EditText email,password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.pswrdd);
        Button login=(Button) findViewById(R.id.lin);
        Button Signup=(Button) findViewById(R.id.sin) ;
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user.this, UserSignup.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().length()== 0) {
                    email.setError("Username Required");
                    email.requestFocus();
                }
                else if(password.getText().toString().length()== 0) {
                    password.setError("Password Required");
                    password.requestFocus();
                }
                else{
                    String txt=email.getText().toString();
                    String pass=password.getText().toString();
                    mAuth.signInWithEmailAndPassword(txt,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent i =new Intent(getApplicationContext(),user.class);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();

                            }

                        }
                    });





                }
            }
        });

    }

}
