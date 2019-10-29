package com.example.dbit;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class event extends AppCompatActivity implements DatePickerDialog.OnDateSetListener   {

    private TextView datee;

    private EditText eventname, contactno, venue;
    private EditText description, time;
    private Button post;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
        databaseReference = FirebaseDatabase.getInstance().getReference();
       eventname= (EditText) findViewById(R.id.editText5);
      contactno= (EditText) findViewById(R.id.editText11);
        venue= (EditText) findViewById(R.id.abc);
       time= (EditText) findViewById(R.id.editText10);
       description= (EditText) findViewById(R.id.editText12);
        datee= (TextView) findViewById(R.id.date);
        post=(Button)findViewById(R.id.button2) ;




        Button button = (Button) findViewById(R.id.datep);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepicker = new datepicker_fragment();
                datepicker.show(getSupportFragmentManager(), "date picker" );
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayofMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayofMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.date);
        textView.setText(currentDateString);
    }
}