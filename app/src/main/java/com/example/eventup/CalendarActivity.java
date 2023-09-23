package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private RecyclerView eventsRecyclerView;
    private DatabaseReference eventsRef;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private String userKey;

    private List<CalendarEvent> calendarEventList;
    private CalendarEventAdapter calendarEventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = findViewById(R.id.calendarView);
        eventsRecyclerView = findViewById(R.id.eventsRecyclerView);

        eventsRecyclerView.setHasFixedSize(true);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        calendarEventList = new ArrayList<>();
        calendarEventAdapter = new CalendarEventAdapter(calendarEventList);
        eventsRecyclerView.setAdapter(calendarEventAdapter);

        eventsRef = FirebaseDatabase.getInstance().getReference("events");
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        // Get current userID
        userKey = firebaseUser.getUid();

        loadEventForAll();

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            loadEventsForDate(selectedDate);
        });
    }

    private void loadEventForAll(){

        eventsRef.orderByChild("date").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                calendarEventList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    CalendarEvent calendarEvent = snapshot.getValue(CalendarEvent.class);
                    if(calendarEvent.getParticipants() != null){
                        if (calendarEvent != null && calendarEvent.getParticipants().containsKey(userKey)) {
                            calendarEventList.add(calendarEvent);
                        }
                    }

                }
                calendarEventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void loadEventsForDate(String date) {

        eventsRef.orderByChild("date").equalTo(date).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                calendarEventList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    CalendarEvent calendarEvent = snapshot.getValue(CalendarEvent.class);
                    if(calendarEvent.getParticipants() != null){
                        if (calendarEvent != null && calendarEvent.getParticipants().containsKey(userKey)) {
                            calendarEventList.add(calendarEvent);
                        }
                    }
                }
                calendarEventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}