package com.eudekagroup16.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.eudekagroup16.myapplication.R;

public class SplashScreenActivity extends AppCompatActivity {

    private LottieAnimationView lavLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        lavLogo = findViewById(R.id.lav_logo);

        lavLogo.setAnimation(R.raw.search_box);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    HomeActivity.start(SplashScreenActivity.this);
                }
            }
        };
        timerThread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
