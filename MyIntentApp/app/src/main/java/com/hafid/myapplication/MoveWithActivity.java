package com.hafid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithActivity extends AppCompatActivity {
    TextView tvDataObject;
    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with);
        tvDataObject = findViewById(R.id.tvDataObjectReceived);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+person.getName() + "\n Email : "
                +person.getEmail()+"\nAge : "+person.getAge()+"City : "+person.getCity();
        tvDataObject.setText(text);

    }
}