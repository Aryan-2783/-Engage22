package com.example.automobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginactivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    String emailpattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseAuth mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        TextView btn=findViewById(R.id.signuplog);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser mUser=mAuth.getCurrentUser();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginactivity.this,signup_sctivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginactivity.this,signup_sctivity.class));
            }
        });
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               performlogin();
           }
       });

    }

    private void performlogin() {
        String Email=email.getText().toString();
        String Password=password.getText().toString();

        if(!Email.matches(emailpattern))
        {
            email.setError("enter correct email");
        }
        else if(Password.isEmpty()||Password.length()<6)
        {
            password.setError("enter valid password");
        }
        else {
            progressDialog.setMessage("loging up");
            progressDialog.setTitle("login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                 if (task.isSuccessful())
                 {
                     progressDialog.dismiss();
                     sendusertonxxtactivity();
                     Toast.makeText(loginactivity.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     progressDialog.dismiss();
                     Toast.makeText(loginactivity.this, "Incorrect Password"+task.getException(), Toast.LENGTH_SHORT).show();
                 }


                }
            });
        }
    }
    private void sendusertonxxtactivity() {
        Intent intent=new Intent(loginactivity.this,MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}