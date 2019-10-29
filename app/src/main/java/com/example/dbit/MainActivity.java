package com.example.dbit;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;


import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEmail;
    private EditText mPassword;
    private Button signup;
    private TextView login;

    private FirebaseAuth firebaseAuth;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth =FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){

            finish();
            startActivity(new Intent(getApplicationContext(),loginactivity.class));

        }


        mEmail= (EditText) findViewById(R.id.editText);
        mPassword = (EditText)  findViewById(R.id.editText2);
        signup = (Button) findViewById(R.id.meowww);
        login = (TextView) findViewById(R.id.cattt);

        signup.setOnClickListener(this);
        login.setOnClickListener(this);


    }
    private void registerUser() {

        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            return;

        }
    if(TextUtils.isEmpty(password)){
        Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
        return;


    }


    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){
                Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                if(firebaseAuth.getCurrentUser() !=null){

                    finish();
                    startActivity(new Intent(getApplicationContext(),loginactivity.class));

                }
            } else{
                Toast.makeText(MainActivity.this, "couldnot register", Toast.LENGTH_SHORT).show();
            }

        }
    });
    }

    @Override
    public void onClick(View v) {

        if (v == signup) {
            registerUser();
        }
        if(v==login){
            startActivity(new Intent(this, loginn.class));

        }
    }


    }