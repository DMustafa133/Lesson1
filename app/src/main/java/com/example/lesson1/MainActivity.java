package com.example.lesson1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static com.example.lesson1.firstRecyclerViewAdapter.DATA_INFO;

public class MainActivity extends AppCompatActivity implements firstRecyclerViewAdapter.OnItemCickListener {

    private RecyclerView recView;
    private firstRecyclerViewAdapter rvAdapter;
    List<DataClass> pref_data;
    Gson gson = new Gson();
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_NAME = "nickname";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref_data = getData();
        recView = findViewById(R.id.rec_view);
        rvAdapter = new firstRecyclerViewAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recView.setLayoutManager(gridLayoutManager);
        recView.setAdapter(rvAdapter);
        rvAdapter.setDataClassList(getData());
        String saved_data = gson.toJson(pref_data);
        savePrefData(saved_data);
    }

    private List<DataClass> getData() {
        List<DataClass> dataClass = new ArrayList<>();
        dataClass.add(new DataClass("Сидоров", "17.11.99", "sdfsdf@mail.ru", R.mipmap.ic_launcher));
        dataClass.add(new DataClass("Иванов", "4.03.87", "qwerty@mail.ru", R.mipmap.ic_launcher));
        dataClass.add(new DataClass("Петров", "27.10.68", "Petrov@mail.ru", R.mipmap.ic_launcher));
        dataClass.add(new DataClass("Терентьев", "6.04.99", "miha123@mail.ru", R.mipmap.ic_launcher));
        dataClass.add(new DataClass("Боров", "11.06.97", "ivan337@mail.ru", R.mipmap.ic_launcher));
        dataClass.add(new DataClass("Роналдо", "8.12.75", "fcjuve@mail.ru", R.mipmap.ic_launcher));


        return dataClass;
    }


    @Override
    public void itemClick(View v, int adapterPosition) {
        Intent intent = new Intent(this, Activity_info.class);
        intent.putExtra(DATA_INFO, getData().get(adapterPosition));
        startActivity(intent);
    }

    private void savePrefData(String saved_data) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(APP_PREFERENCES_NAME);
        editor.putString(APP_PREFERENCES_NAME, saved_data);
        editor.apply();
    }

    @Override
    public void itemDelete(int adapterPosition) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Settings").setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rvAdapter.removeData(adapterPosition);
                        savePrefData(gson.toJson(rvAdapter.getInfo()));
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}