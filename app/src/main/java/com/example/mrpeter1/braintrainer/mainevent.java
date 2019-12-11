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
    TextView textwaktu , information, resultTextView;
    Button btnmulai;
    int locationCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    Button button0, button1, button2, button3;


    public void chooseAnswer(View view){
       // Log.i("tag : ", view.getTag().toString()); // memdapatkan tag button jawaban yang dipilih
        //Pada bahasa pemrograman Java, didalam library String, terdapat sebuah method bernama equals(), method tersebut digunakan untuk membandingkan 2 buah variable,
        // yang bertipe data String, jika nilai dari kedua variable tersebut mempunyai karakter yang sama, baik dari segi huruf besar,
        // huruf kecil atau spasi, maka akan menghasilkan nilai boolean true dan jika tidak sesuai, maka akan menghasilkan nilai false.
        if  (Integer.toString(locationCorrectAnswer).equals(view.getTag().toString())){ // membandingkan jawaban yang di pilih dengan soalnya
            Log.i("correct!","you got it");
            information.setText("Correct!");
            score++;

        } else {
            Log.i("incorrect","try again");
            information.setText("Incorect");
        }
        numberOfQuestions++;
        resultTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQuestion();

    }

    public void mulaigame(View view){

    }

    public void newQuestion(){

        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        textView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationCorrectAnswer =rand.nextInt(4);
        answer.clear();
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

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainevent);
        textView = findViewById(R.id.textView);
        textwaktu = findViewById(R.id.textwaktu);
        information = findViewById(R.id.information);
        btnmulai = findViewById(R.id.btnmulai);
        resultTextView = findViewById(R.id.resultTextView);

         button0 = findViewById(R.id.button0);
         button1 = findViewById(R.id.button1);
         button2 = findViewById(R.id.button2);
         button3 = findViewById(R.id.button3);

        newQuestion();


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
