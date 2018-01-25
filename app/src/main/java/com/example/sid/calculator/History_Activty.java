package com.example.sid.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class History_Activty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history__activty);

        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        if(intent == null || intent.getExtras()==null ) {
            finish();
        }

        assert intent != null;
        ArrayList<History> histories = intent.getParcelableArrayListExtra("History");
        StringBuilder historyBuilder = new StringBuilder();

        for(History h:histories)
            historyBuilder.append(h.toString()).append("\n");

        textView.setText(historyBuilder.toString());
    }
}
