package com.example.mrpeter1.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button goevent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goevent = findViewById(R.id.goevent);

        goevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosuccesstiket = new Intent(MainActivity.this,mainevent.class); // kenapa biki variabel gotosign?
                startActivity(gotosuccesstiket); // saat klik dia akan keSignAct activity

            }
        });
    }
}
