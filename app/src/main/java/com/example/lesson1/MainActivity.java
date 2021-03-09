package com.example.lesson1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_FIO = "Fio";
    public static final String KEY_DATE = "date";
    public static final String KEY_EMAIL = "email";

    Button btnEdit;
    TextView tvFIO;
    TextView tvEmail;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEdit = findViewById(R.id.btnEdit);
        tvFIO = findViewById(R.id.FIO);
        tvEmail = findViewById(R.id.Email);
        tvDate = findViewById(R.id.Date);

        btnEdit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) {
            return;
        }
        String fio = data.getStringExtra(KEY_FIO);
        tvFIO.setText(fio);
        String date = data.getStringExtra(KEY_DATE);
        tvDate.setText(date);
        String email = data.getStringExtra(KEY_EMAIL);
        tvEmail.setText(email);
    }
}