package com.example.dbit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class message extends AppCompatActivity implements View.OnClickListener {
    private EditText description;
    private Button post;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        databaseReference= FirebaseDatabase.getInstance().getReference();

        
        description=(EditText) findViewById(R.id.editText4);
        post= (Button) findViewById(R.id.button);
    post.setOnClickListener(this);
        }
        private void saveUserInformation()
        {
            String desc = description.getText().toString().trim();
          UserInformation userInformation= new UserInformation(desc);
          databaseReference.child(user.getUid())

        }


    @Override
    public void onClick(View view) {

    }
}




