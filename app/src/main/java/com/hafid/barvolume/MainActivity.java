package com.hafid.barvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//implementasi onClick
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //membuat variabel untuk menampung view
    EditText edtPanjang, edtLebar, edtTinggi;
    Button btnHitung;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi variabel
        edtPanjang = findViewById(R.id.edtPanjang);
        edtLebar = findViewById(R.id.edtLebar);
        edtTinggi = findViewById(R.id.edtTinggi);
        btnHitung = findViewById(R.id.btnHitung);
        tvResult = findViewById(R.id.tvResult);

        //menambahkan fungsi btn saat di klik
        btnHitung.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHitung) {
            //membuat variabel baru
            String inputPanjang = edtPanjang.getText().toString().trim();
            String inputLebar = edtLebar.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();

            boolean isEmptyField = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputPanjang)) {
                isEmptyField = true;
                edtPanjang.setError("Field panjang tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputLebar)) {
                isEmptyField = true;
                edtPanjang.setError("Field panjang tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyField = true;
                edtPanjang.setError("Field panjang tidak boleh kosong");
            }

            Double panjang = toDouble(inputPanjang);
            Double lebar = toDouble(inputLebar);
            Double tinggi = toDouble(inputTinggi);

            if (panjang == null) {
                isInvalidDouble = true;
                edtPanjang.setError("Field panjang harus berupa format yg valid");
            }
            if (lebar == null) {
                isInvalidDouble = true;
                edtLebar.setError("Field lebar harus berupa format yg valid");
            }
            if (tinggi == null) {
                isInvalidDouble = true;
                edtLebar.setError("Field tinggi harus berupa format yg valid");
            }

            if (!isEmptyField && !isInvalidDouble) {
                Double luas = panjang * lebar * tinggi;
                tvResult.setText(String.valueOf(luas));
            }


        }
    }

    private Double toDouble(String s) {
        try {
            return Double.valueOf(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
