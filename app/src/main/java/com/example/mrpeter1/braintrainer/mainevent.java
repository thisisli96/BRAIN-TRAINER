package com.example.mrpeter1.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class mainevent extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainevent);
        textView = findViewById(R.id.textView);

        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        textView.setText(Integer.toString(a) + " + " + Integer.toString(b));

    }
}
