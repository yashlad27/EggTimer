package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SeekBar seekBar;
    Boolean counterIsActive = false;
    Button goButton;
    CountDownTimer countDownTimer;

    public void resetTimer() {
        // if someone wants to stop the timer:
        textView.setText("0:30");
        seekBar.setProgress(30);
        seekBar.setEnabled(true);
        countDownTimer.cancel();
        goButton.setText("GO!");
        counterIsActive = false;
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked(View view) {
        Log.i("Button Pressed!", "Nice!");

        if(counterIsActive){

            resetTimer();

        }else{
            counterIsActive = true;
            seekBar.setEnabled(false);
            goButton.setText("Stop!");

            countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long l) {
                    updateTimeFun((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    Log.i("Finished", "Timer all Done");

                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(),  R.raw.air_horn);
                    mplayer.start();
                    resetTimer();
                }
            }.start();
        }
    }

    @SuppressLint("SetTextI18n")
    public void updateTimeFun(int secondsleft){
        int minutes = secondsleft /60;
        int seconds = secondsleft - (minutes * 60);

        String secondString = Integer.toString(seconds);

//        if(secondString.equals("0")){
//            secondString = "00";
//        }

        if (seconds <= 9){
            secondString = "0" + secondString;
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

        goButton = findViewById(R.id.buttonGO);

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