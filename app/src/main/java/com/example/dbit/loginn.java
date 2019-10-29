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

public class loginn extends AppCompatActivity implements View.OnClickListener {
    private EditText mEmail;
    private EditText mPassword;
    private Button login;
    private TextView signup;

    private FirebaseAuth firebaseAuth;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginn);
        firebaseAuth =FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){

            finish();
            startActivity(new Intent(getApplicationContext(),loginactivity.class));

        }


        mEmail= (EditText) findViewById(R.id.editText);
        mPassword = (EditText)  findViewById(R.id.editText2);
        signup = (TextView) findViewById(R.id.textView12);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);
        signup.setOnClickListener(this);


    }
    private void userlogin() {

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
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(loginn.this, "Login successful", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(getApplicationContext(),loginactivity.class));
                    }
                    else {
                        Toast.makeText(loginn.this, "couldnot login", Toast.LENGTH_SHORT).show();
                    }


                }


            });


    }

    @Override
    public void onClick(View v) {

        if (v == login) {
            userlogin();
        }
        if(v==signup){
            finish();
            startActivity(new Intent(this,MainActivity.class));

        }
    }


}