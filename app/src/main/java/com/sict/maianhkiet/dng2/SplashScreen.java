package com.sict.maianhkiet.dng2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.sict.maianhkiet.dng2.User.UserDashboard;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    ImageView spalshimage;

    Animation sideAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        setContentView(R.layout.spalsh_screen);

        spalshimage = findViewById(R.id.splash_pic);

        sideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_anim);

        boolean b = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);

    }
}
