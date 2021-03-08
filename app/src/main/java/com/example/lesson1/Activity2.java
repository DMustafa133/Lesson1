package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity  implements View.OnClickListener {

    EditText edtEmail;
    EditText edtDate;
    EditText edtFIO;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        edtEmail = (EditText) findViewById(R.id.editEmail);
        edtDate = (EditText) findViewById(R.id.editDate);
        edtFIO = (EditText) findViewById(R.id.editFIO);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("email", edtEmail.getText().toString());
        intent.putExtra("date", edtDate.getText().toString());
        intent.putExtra("Fio", edtFIO.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}