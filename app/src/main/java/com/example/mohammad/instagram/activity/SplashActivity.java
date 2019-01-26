package com.example.mohammad.instagram.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.mohammad.instagram.R;

public class SplashActivity extends AppCompatActivity {
    public static final String USER_NAME = "username";
    private static SQLiteDatabase db;
    private Animation slideUp;
    private ImageView instagramLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        instagramLogo = findViewById(R.id.instagram_logo);
        slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        instagramLogo.startAnimation(slideUp);


        db = openOrCreateDatabase("project", MODE_PRIVATE, null);
        //comment parent is entered null because...
        db.execSQL("create table if not exists last_user(username text)");
        db.execSQL("create table if not exists comment (comment_id text, comment_text text, post_id text, user_id text, comment_parent text);");
        db.execSQL("create table if not exists post (post_id text, user_id text, post_date text, image blob, description text);");
        db.execSQL("create table if not exists follow(user_id text, follower_id text);");
        db.execSQL("create table if not exists save(post_id text, user_id text);");
        db.execSQL("create table if not exists likes(post_id text, user_id text);");
        db.execSQL("create table if not exists user(user_id text, user_password text);");


        CountDownTimer count = new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent;
                if (isLoggedIn()) {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    // Display the com.example.mohammad.instagram.fragment.HomeFragment for last logged in user
                    // else Display the LoginActivity
                } else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.start();


    }

    private boolean isLoggedIn() {
        Cursor c = db.rawQuery("select * from last_user", null);
        if (c.moveToFirst() && c.getColumnCount() != 0) {
            MainActivity.currentUserId = c.getString(0);
            return true;
        }
        return false;
    }
}
