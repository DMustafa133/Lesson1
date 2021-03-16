package com.example.lesson1;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyFragment extends Fragment {

    public static final String PARAM_VALUE = "value";
    public static final String BROADCAST_ACTION = "servicebroadcast";

    Button btnStart;
    EditText edtQuery;
    TextView tvTask1;
    BroadcastReceiver br;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTask1 = (TextView) view.findViewById(R.id.txtResult);
        btnStart = (Button) view.findViewById(R.id.btnStart);
        edtQuery = (EditText) view.findViewById(R.id.edit_query);

        btnStart.setOnClickListener(v -> {
            onClickStart(v);
        });
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String value = intent.getStringExtra(PARAM_VALUE);
                tvTask1.setText(value);
            }
        };
        IntentFilter intFilt = new IntentFilter(BROADCAST_ACTION);
        getActivity().registerReceiver(br, intFilt);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(br);
    }

    private void onClickStart(View v) {
        Intent intent;
        intent = new Intent(getActivity(), MyService.class).putExtra(PARAM_VALUE, edtQuery.getText().toString());
        getActivity().startService(intent);
    }

}