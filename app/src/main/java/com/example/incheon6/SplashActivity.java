package com.example.incheon6;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView image = (ImageView) findViewById(R.id.gif_image);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(image);
        Glide.with(this).load(R.drawable.splash).into(image);


        startLoading();
    }
    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },3000);
    }
    public void onBackPressed() {
    }

}
