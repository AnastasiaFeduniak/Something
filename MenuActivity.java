package com.example.suspisioustests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    Button winx, bread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);
        winx = (Button) findViewById(R.id.winx);
        bread = (Button) findViewById(R.id.bread);
    }
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.winx:  intent = new Intent(MenuActivity.this, WinxActivity.class);
                startActivity(intent); ;break;
            case R.id.bread: intent = new Intent(MenuActivity.this, BreadActivity.class);
                startActivity(intent);;break;
        }
    }
}
