package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity  implements View.OnClickListener {

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
        intent.putExtra("email", editEmail.getText().toString());
        intent.putExtra("date", editDate.getText().toString());
        intent.putExtra("Fio", editFIO.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}