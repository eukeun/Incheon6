package com.example.incheon6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
    //로그인 모듈 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 2000);
        thread_sleep sleep = new thread_sleep(this);
        sleep.start();

    }

    public class thread_sleep extends Thread {
        Activity thisAct;

        thread_sleep(Activity theAct) {
            thisAct = theAct;
        }

        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class splashhandler implements Runnable {
        public void run() {

            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish();


        }
    }

    public void onBackPressed() {
    }
}