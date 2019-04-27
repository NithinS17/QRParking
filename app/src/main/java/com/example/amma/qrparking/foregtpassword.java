package com.example.amma.qrparking;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class foregtpassword extends AppCompatActivity {
    EditText email;
    FirebaseAuth mauth;
    String emailid;
    ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foregtpassword);
        mauth=FirebaseAuth.getInstance();
        email= findViewById(R.id.femail);
        // pb= findViewById(R.id.progress);
        if(getIntent().getStringExtra("email")!=null)
        {
            String em = getIntent().getStringExtra("email");
            email.setText(em);
        }

    }
    public void frgtpass(View v)
    {
        emailid=email.getText().toString().trim();
        if (TextUtils.isEmpty(emailid))
        {
            Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
            return;
        }
        pb.setVisibility(View.VISIBLE);
        mauth.sendPasswordResetEmail(emailid).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                pb.setVisibility(View.GONE);
                if (task.isSuccessful())
                    Toast.makeText(foregtpassword.this, "Reset code is sent to your mail! :)", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(foregtpassword.this, "Some  error occured!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
