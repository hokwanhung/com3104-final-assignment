package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.eventup.calendar.CalendarActivity;
import com.example.eventup.event.EventListActivity;
import com.example.eventup.post.PostEventActivity;
import com.example.eventup.status.StatusListActivity;

public class HomeActivity extends AppCompatActivity {
    private static View relativelayout_clock;

    ImageButton logout_bt, post_bt, search_bt, event_bt, memo_bt, changeBackground_bt, calendar_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout_bt = findViewById(R.id.logout_icon);
        post_bt = findViewById(R.id.post_bt);
        search_bt = findViewById(R.id.search_bt);
        event_bt = findViewById(R.id.eventStatus_bt);
        memo_bt = findViewById(R.id.memo_bt);
        changeBackground_bt = findViewById(R.id.changeBackground_bt);
        relativelayout_clock = findViewById(R.id.relativelayout_clock);

        calendar_bt = findViewById(R.id.calendar_bt);


        logout_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });

        post_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, PostEventActivity.class));
            }
        });

        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, EventListActivity.class));
            }
        });

        event_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, StatusListActivity.class));
            }
        });

        memo_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MemoActivity.class));
            }
        });

        changeBackground_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, WallpaperActivity.class));
            }
        });

        calendar_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CalendarActivity.class));
            }
        });


    }

    public static void changeBG1() {
        relativelayout_clock.setBackgroundResource(R.drawable.bg1);
    }
    public static void changeBG2() { relativelayout_clock.setBackgroundResource(R.drawable.bg2); }
    public static void changeBG3() {
        relativelayout_clock.setBackgroundResource(R.drawable.bg3);
    }
    public static void changeBG4() {
        relativelayout_clock.setBackgroundResource(R.drawable.bg4);
    }
    public static void changeBG5() {
        relativelayout_clock.setBackgroundResource(R.drawable.bg5);
    }
    public static void changeBG6() {
        relativelayout_clock.setBackgroundResource(R.drawable.bg6);
    }
    public static void changeBG7() {
        relativelayout_clock.setBackgroundResource(R.drawable.bg7);
    }
    public static void changeBG8() {
        relativelayout_clock.setBackgroundResource(R.drawable.bg8);
    }
    public static void changeBG9() {
        relativelayout_clock.setBackgroundResource(R.drawable.bg9);
    }
    public static void changeBG10() { relativelayout_clock.setBackgroundResource(R.drawable.bg10); }
}