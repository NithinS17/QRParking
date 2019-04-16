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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class changeadminpass extends AppCompatActivity {
    Button btn;
    EditText newpass,cnewpass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeadminpass);
        btn=(Button)findViewById(R.id.apcbtn);
        newpass=(EditText)findViewById(R.id.newpass);
        cnewpass=(EditText)findViewById(R.id.cnewpass);
        auth=FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    user.updatePassword(newpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Password Changed",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(),admin.class);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Password Couldn't be changed,try again later!",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(),admin.class);
                            }
                        }
                    });
                }
            }
        });

    }

}
