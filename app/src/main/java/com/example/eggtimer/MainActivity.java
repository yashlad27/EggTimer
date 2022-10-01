package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView2);
        SeekBar seekBar = findViewById(R.id.seekBar);

        int max = 200;
        int startingPos = 10;

        seekBar.setMax(max);
        seekBar.setProgress(startingPos);



    }
}