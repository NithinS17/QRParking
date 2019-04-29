package com.example.amma.qrparking;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class handler extends AppCompatActivity {
EditText user,pass,email;
    ProgressDialog pb;
    FirebaseAuth mauth;
    AlertDialog.Builder builder;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        user = (EditText)findViewById(R.id.usrusr);
        pass = (EditText)findViewById(R.id.pswrdd);
        sp=getApplicationContext().getSharedPreferences("user",MODE_PRIVATE);
        //email=(EditText)findViewById(R.id.hemail);
        Button login=(Button) findViewById(R.id.lin);
        Button Singup=(Button) findViewById(R.id.sin) ;
        pb = new ProgressDialog(handler.this);
        pb.setMessage("LOGGING IN..!!");






        Singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(handler.this, HandlerSignup.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pb.show();
                if(user.getText().toString().length()== 0) {
                    user.setError("Username Required");
                    user.requestFocus();
                }
                else if(pass.getText().toString().length()== 0) {
                    pass.setError("Password Required");
                    pass.requestFocus();
                }
                else{
                    final String uname = user.getText().toString().trim();
                    final String passw=pass.getText().toString().trim();

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    Query query =  reference.child("handler").orderByChild("username").equalTo(uname);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists())
                            { try {
                                for (DataSnapshot ca : dataSnapshot.getChildren()) {
                                    {

                                        addhandler r = ca.getValue(addhandler.class);
                                        String name=r.getUsername().toString().trim();
                                        String passwrd=r.getPassword().toString().trim();


                                        if(uname.equals(name) && passw.equals(passwrd))
                                        {
                                            sp.edit().putString("USER","HANDLER").apply();
                                            Toast.makeText(getApplicationContext(),"Welcome "+uname,Toast.LENGTH_LONG).show();
                                            Intent i = new Intent(getApplicationContext(),HandlerHome.class);
                                            startActivity(i);
                                            pb.hide();
                                        }
                                        else
                                        {
                                            Toast.makeText(getApplicationContext(),"Invalid User",Toast.LENGTH_LONG).show();
                                            Intent i = new Intent(getApplicationContext(),handler.class);
                                        }
                                    }
                                }
                            }catch(Exception e){}


                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

    }
  /*  public void frgtpass(View v){
        final EditText edittext= new EditText(handler.this);
        /*LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        edittext.setLayoutParams(lp);

        builder = new AlertDialog.Builder(this);
        builder.setTitle("Forgot Password ?");
        builder.setMessage("Please enter your registered email id.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String emailid = edittext.getText().toString();
                        if (TextUtils.isEmpty(emailid))
                        {
                            Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else
                        {
                            pb.show();
                            mauth.sendPasswordResetEmail(emailid).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    pb.hide();
                                    if (task.isSuccessful())
                                        Toast.makeText(handler.this, "Reset code is sent to your mail! :)", Toast.LENGTH_SHORT).show();
                                    else
                                        Toast.makeText(handler.this, "Some error occured!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }*/
}
