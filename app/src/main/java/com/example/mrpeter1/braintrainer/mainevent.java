package com.example.mrpeter1.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class mainevent extends AppCompatActivity {
    TextView textView;
    ArrayList<Integer> answer = new ArrayList<>();
    TextView textwaktu , information ;
    Button btnmulai;
    int locationCorrectAnswer;

    public void chooseAnswer(View view){
       // Log.i("tag : ", view.getTag().toString()); // memdapatkan tag button jawaban yang dipilih
        if  (Integer.toString(locationCorrectAnswer).equals(view.getTag().toString())){ // membandingkan jawaban yang di pilih dengan soalnya
            Log.i("correct!","you got it");

        } else {
            Log.i("incorrect","try again");
        }

    }

    public void mulaigame(View view){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainevent);
        textView = findViewById(R.id.textView);
        textwaktu = findViewById(R.id.textwaktu);
        information = findViewById(R.id.information);
        btnmulai = findViewById(R.id.btnmulai);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);


        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        textView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationCorrectAnswer =rand.nextInt(4);
        for (int i= 0; i < 4; i++){

            if (i == locationCorrectAnswer){
                answer.add(a+b);
            }else {
                int wrongAnswer =rand.nextInt(41);

                while   (wrongAnswer == a+b)
                {
                    wrongAnswer = rand.nextInt(41);
                }

                answer.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));


        //---------------------------------- timer ------------------------------------

        CountDownTimer countDownTimer = new CountDownTimer(30000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("secong left", String.valueOf((millisUntilFinished / 1000)));
                textwaktu.setText(String.valueOf((millisUntilFinished / 1000)+"S"));
            }

            @Override
            public void onFinish() {
                Log.i("were done", "no more countdown");
                information.setText("DONE!");
                btnmulai.setText("PLAY AGAIN");

            }
        }.start();


    }
}
