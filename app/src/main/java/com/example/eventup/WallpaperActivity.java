package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Locale;

public class WallpaperActivity extends AppCompatActivity {


    RelativeLayout relativelayout_clock;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_wallpaper);
        relativelayout_clock = findViewById(R.id.relativelayout_clock);
    }
    int bg;

    public void c1(View view){
        HomeActivity.changeBG1();
        finish();
    }

    public void c2(View view){
        HomeActivity.changeBG2();
        finish();
    }
    public void c3(View view){
        HomeActivity.changeBG3();
        finish();
    }
    public void c4(View view){
        HomeActivity.changeBG4();
        finish();
    }
    public void c5(View view){
        HomeActivity.changeBG5();
        finish();
    }
    public void c6(View view){
        HomeActivity.changeBG6();
        finish();
    }

    public void c7(View view){
        HomeActivity.changeBG7();
        finish();
    }
    public void c8(View view){
        HomeActivity.changeBG8();
        finish();
    }

    public void c9(View view){
        HomeActivity.changeBG9();
        finish();
    }
    public void c10(View view){
        HomeActivity.changeBG10();
        finish();
    }
    int abc;
    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        Configuration config = getResources().getConfiguration();
        abc = prefs.getInt("a", 0);
        setLocale(abc);
    }
    public void setLocale(int abc) {
        Configuration config = new Configuration();
        switch (abc) {
            case 0:
                config.locale = Locale.ENGLISH;
                Locale.setDefault(Locale.ENGLISH);
                break;
            case 1:
                config.locale = Locale.TRADITIONAL_CHINESE;
                Locale.setDefault(Locale.TRADITIONAL_CHINESE);
                break;
            case 2:
                config.locale = Locale.JAPANESE;
                Locale.setDefault(Locale.JAPANESE);
                break;
            case 3:
                config.locale = Locale.KOREAN;
                Locale.setDefault(Locale.KOREAN);
                break;
        }
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        //save data to share preferences

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putInt("a", abc);
        editor.apply();
    }
}