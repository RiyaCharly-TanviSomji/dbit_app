package com.example.dbit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tomer.fadingtextview.FadingTextView;

import androidx.appcompat.app.AppCompatActivity;

public class loginactivity extends AppCompatActivity implements View.OnClickListener {
    private FadingTextView fadingTextView;
    private FirebaseAuth firebaseAuth;
    private Button buttonlogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        firebaseAuth= FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() ==null){

            finish();
            startActivity(new Intent(this,loginn.class));

        }
        FirebaseUser user =firebaseAuth.getCurrentUser();

        fadingTextView = findViewById(R.id.fading_text_view);
        buttonlogout= (Button) findViewById(R.id.logbutton);
        Button button3 =  findViewById(R.id.post);
        Button button4 =  findViewById(R.id.eve);

        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        buttonlogout.setOnClickListener(this);


    }




    @Override
    public void onClick(View v1) {
        if(v1==buttonlogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, loginn.class));
        }
        switch (v1.getId()){
            case R.id.post:
                Intent intent2 = new Intent (this, message.class);
                startActivity(intent2);
                break;
            case R.id.eve:
                Intent intent4 =new Intent(this,event.class );
                startActivity(intent4);
                break;
            case R.id.logbutton:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, loginn.class));

                break;
        }
    }
}