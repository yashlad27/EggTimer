package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.EggimageView);
        SeekBar seekBar = findViewById(R.id.timerseekBar);
        TextView textView = findViewById(R.id.CountDowntextView);

        int max = 600;
        int startingPos = 30;

        seekBar.setMax(max);
        seekBar.setProgress(startingPos);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int minutes = i /60;
                int seconds = i - (minutes * 60);

                String secondString = Integer.toString(seconds);

                if(secondString == "0"){
                    secondString = "00";
                }

                //textView.setText(Integer.toString(minutes) + ":" + Integer.toString(seconds));

                textView.setText(Integer.toString(minutes) + ":" + secondString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}