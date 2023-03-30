package com.example.suspisioustests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BreadActivity  extends AppCompatActivity  {
    Button returnToMenu;
    ImageView img;
    TextView question, Res, ResT;
    Button bt1, bt2, bt3, bt4;
    int counter = 1;
    double bread = 0; double keks = 0; double lavash = 0; double suhar = 0;
    double mas[] = {bread, keks, lavash, suhar};
    String mas1[] = {"bread", "keks", "lavash", "suhar"};
    String result;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread);
        returnToMenu = (Button) findViewById(R.id.returnToMenu);
        img = (ImageView) findViewById(R.id.img);
        question = (TextView) findViewById(R.id.question);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        Res = (TextView) findViewById(R.id.Res);
        ResT = (TextView) findViewById(R.id.ResT);}

    public void ToMenu(View view) {
        Intent intent = new Intent(BreadActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    public void onClick(View view) {
        int checked = ((Button)view).getId();
        switch (checked){
            case R.id.bt1: keks = keks + 1; break;
            case R.id.bt2: suhar = suhar + 1; break;
            case R.id.bt3: bread = bread + 1; break;
            case R.id.bt4: lavash = lavash + 1; break;
        }
        counter++;
        String packageName = getPackageName();
        if(counter <= 8){
            String name = "Bq" + counter;
            int id = getResources().getIdentifier(name, "string", packageName);
            question.setText(id);
            for(int i = 1; i <= 4; i++){
                int idA = getResources().getIdentifier("Ban" + counter + "_" + i , "string", packageName);
                int bt = getResources().getIdentifier("bt" + i, "id", packageName);
                Button button = findViewById(bt);
                button.setText(idA);
            }
            int imgB = getResources().getIdentifier("imagesb" + counter, "drawable", packageName);
            img.setImageResource(imgB);
        } else {
            double score = 0;
            double mas[] = {bread, keks, lavash, suhar};
            String mas1[] = {"bread", "keks", "lavash", "suhar"};
            for (int i = 0; i < mas.length; i++) {
                if (mas[i] > score) {
                    score = mas[i];
                    result = mas1[i];
                }
            }
            question.setVisibility(View.GONE);
            for (int i = 1; i <= 4; i++) {
                int bt1 = getResources().getIdentifier("bt" + i, "id", packageName);
                Button button1 = findViewById(bt1);
                button1.setVisibility(View.GONE);
            }

            int winner = getResources().getIdentifier("R" + result, "string", packageName);
            Res.setVisibility(View.VISIBLE);
            Res.setText(winner);
            int winnerT = getResources().getIdentifier("T" + result, "string", packageName);
            ResT.setText(winnerT);
            ResT.setVisibility(View.VISIBLE);
            int winnerI = getResources().getIdentifier("imgbr" + result, "drawable", packageName);
            img.setImageResource(winnerI);


        }
    }
}
