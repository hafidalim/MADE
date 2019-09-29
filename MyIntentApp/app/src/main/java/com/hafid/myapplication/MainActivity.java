package com.hafid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPindah, btnMoveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah = findViewById(R.id.btnMoveActivity);
        btnPindah.setOnClickListener(this);

        btnMoveData = findViewById(R.id.btnmoveData);
        btnMoveData.setOnClickListener(this);

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
        }
    }
}
