package com.example.suspisioustests;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class WinxActivity extends AppCompatActivity {
    Button returnToMenu;
    ImageView img;
    TextView question, Res, ResT;
    Button bt1, bt2, bt3, bt4, bt5, bt6;
    int counter = 1;
    double bloom = 0;     double stella = 0;     double techna = 0;    double aisha = 0;    double flora = 0;double musa = 0;
    double mas[] = {flora, techna, bloom, stella, musa, aisha};
    String mas1[] = {"flora", "techna", "bloom", "stella", "musa", "aisha"};
    String result;
    String q = "Wq";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winx);
        returnToMenu = (Button) findViewById(R.id.returnToMenu);
        img = (ImageView) findViewById(R.id.img);
        question = (TextView) findViewById(R.id.question);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        Res = (TextView) findViewById(R.id.Res);
        ResT = (TextView) findViewById(R.id.ResT);


    }

    public void onClick(View view) {
        int checked = ((Button)view).getId();
        switch (checked){
            case R.id.bt1: flora = flora + 1; break;
            case R.id.bt2: techna = techna + 1; break;
            case R.id.bt3: bloom = bloom + 1; break;
            case R.id.bt4: stella = stella + 1; break;
            case R.id.bt5: musa = musa + 1; break;
            case R.id.bt6: aisha = aisha + 1; break;
        }
        counter++;
        String packageName = getPackageName();
        if(counter <= 8){
            String name = q + counter;
            int id = getResources().getIdentifier(name, "string", packageName);
            question.setText(id);
            for(int i = 1; i <= 6; i++){
                int idA = getResources().getIdentifier("Wan" + counter + "_" + i , "string", packageName);
                int bt = getResources().getIdentifier("bt" + i, "id", packageName);
                Button button = findViewById(bt);
                button.setText(idA);
            }
            int imgB = getResources().getIdentifier("image" + counter, "drawable", packageName);
            img.setImageResource(imgB);
        }
        else{
            double score = 0;
            double mas[] = {flora, techna, bloom, stella, musa, aisha};
            String mas1[] = {"flora", "techna", "bloom", "stella", "musa", "aisha"};
            for(int i = 0; i < mas.length; i++){
                if(mas[i]>score){ score = mas[i];
                    result = mas1[i];
                }
            }
            question.setVisibility(View.GONE);
            for(int i = 1; i <= 6; i++){
                int bt1 = getResources().getIdentifier("bt" + i, "id", packageName);
                Button button1 = findViewById(bt1);
                button1.setVisibility(View.GONE);
            }

            int winner = getResources().getIdentifier("R" + result, "string", packageName);
            Res.setText(winner);
            Res.setVisibility(View.VISIBLE);
            int winnerT = getResources().getIdentifier("T" + result, "string", packageName);
            ResT.setText(winnerT);
            ResT.setVisibility(View.VISIBLE);
            int winnerI = getResources().getIdentifier("images" + result, "drawable", packageName);
            img.setImageResource(winnerI);
           
        }
    }

    public void ToMenu(View view) {
        Intent intent = new Intent(WinxActivity.this, MenuActivity.class);
        startActivity(intent);
    }


}
