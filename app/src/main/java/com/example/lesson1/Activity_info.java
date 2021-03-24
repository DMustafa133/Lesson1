package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.lesson1.firstRecyclerViewAdapter.DATA_INFO;

public class Activity_info extends AppCompatActivity  {

    TextView tv_fio_info, tv_date_info, tv_email_info;
    ImageView iv_big;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tv_fio_info = findViewById(R.id.tv_fio_info);
        tv_date_info = findViewById(R.id.tv_date_info);
        tv_email_info = findViewById(R.id.tv_email_info);
        iv_big = findViewById(R.id.iv_big);

        Intent rcv_intent = getIntent();
        if(rcv_intent != null) {
            DataClass dataClassIntent = rcv_intent.getParcelableExtra(DATA_INFO);
            tv_fio_info.setText(dataClassIntent.getFio());
            tv_date_info.setText(dataClassIntent.getDate());
            tv_email_info.setText(dataClassIntent.getEmail());
            iv_big.setImageResource(dataClassIntent.getImage());
        }
    }
}