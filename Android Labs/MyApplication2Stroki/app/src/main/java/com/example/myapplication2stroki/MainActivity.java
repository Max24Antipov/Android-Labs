package com.example.myapplication2stroki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private TextView tv_result;
    private TextView textgen; //
    private Button button1;

    // Создание объекта Phaser:
    private Phaser phaser = new Phaser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textgen=findViewById(R.id.textgen);
        tv_result=findViewById(R.id.tv_result);
         button1= findViewById(R.id.button1);

         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s=  Phaser.PhaserGen();
                 textgen.setText(s);

                 String[] words = s.split(" ");
                 String tmp=(words[2] + "-это"+ " "+words[1]+" "+words[0]+".");
                 String capitalized = tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase(); //смена регистра
                 tv_result.setText(capitalized);

             }
         });

    }


}
