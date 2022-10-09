package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SeekBar seekBar;
    public void buttonClicked(View view){
        Log.i("Button Pressed!", "Nice!");

        CountDownTimer countDownTimer = new CountDownTimer(seekBar.getProgress()*1000, 1000) {
            @Override
            public void onTick(long l) {
                updateTimeFun((int)l/1000);
            }

            @Override
            public void onFinish() {
                Log.i("Finished", "Timer all Done");
            }
        };

    }

    public void updateTimeFun(int secondsleft){
        int minutes = secondsleft /60;
        int seconds = secondsleft - (minutes * 60);

        String secondString = Integer.toString(seconds);

        if(secondString.equals("0")){
            secondString = "00";
        }

        //textView.setText(Integer.toString(minutes) + ":" + Integer.toString(seconds));

        textView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.EggimageView);
        seekBar = findViewById(R.id.timerseekBar);
        textView = findViewById(R.id.CountDowntextView);

        int max = 600;
        int startingPos = 30;

        seekBar.setMax(max);
        seekBar.setProgress(startingPos);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimeFun(i);
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