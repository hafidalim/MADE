package com.hafid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPindah, btnMoveData, btnMoveObject, btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah = findViewById(R.id.btnMoveActivity);
        btnPindah.setOnClickListener(this);

        btnMoveData = findViewById(R.id.btnmoveData);
        btnMoveData.setOnClickListener(this);

        btnMoveObject = findViewById(R.id.btnMoveObject);
        btnMoveObject.setOnClickListener(this);

        btnDial = findViewById(R.id.btnDialNumber);
        btnDial.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMoveActivity:
                Intent intent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(intent);
                break;
            case R.id.btnmoveData:

                //menggunakan put extra untuk mengirim object
                Intent moveData= new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Hafid Ali Mustaqim");
                moveData.putExtra(MoveWithDataActivity.EXTRA_AGE, 18);
                startActivity(moveData);
                break;
            case R.id.btnMoveObject:
                Person person = new Person();
                person.setName("Hafid Ali Mustaqim");
                person.setEmail("hafidd456@gmail.com");
                person.setAge(18);
                person.setCity("Banjarnegara");

                Intent moveObject = new Intent(MainActivity.this, MoveWithActivity.class);
                moveObject.putExtra(MoveWithActivity.EXTRA_PERSON, person);
                startActivity(moveObject);
                break;
            case R.id.btnDialNumber:
                String phoneNumber = "081234567890";
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(intentDial);
                break;
        }
    }
}
