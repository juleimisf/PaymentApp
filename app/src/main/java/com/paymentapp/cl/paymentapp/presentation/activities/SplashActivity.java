package com.paymentapp.cl.paymentapp.presentation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.paymentapp.cl.paymentapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setProgressValue();

    }

    private void setProgressValue() {
        // set the progress
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    lanzarMain();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void lanzarMain() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.left_out, R.anim.left_in);
        finish();
    }

}
