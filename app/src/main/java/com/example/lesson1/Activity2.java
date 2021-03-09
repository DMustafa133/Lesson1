package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity  implements View.OnClickListener {

    public static final String KEY_EMAIL = "email";
    public static final String KEY_DATE = "date";
    public static final String KEY_FIO = "Fio";

    EditText editEmail;
    EditText editDate;
    EditText editFIO;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editDate = (EditText) findViewById(R.id.editDate);
        editFIO = (EditText) findViewById(R.id.editFIO);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra(KEY_EMAIL, editEmail.getText().toString());
        intent.putExtra(KEY_DATE, editDate.getText().toString());
        intent.putExtra(KEY_FIO, editFIO.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}