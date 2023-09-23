package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatusListActivity extends AppCompatActivity {
    private ListView lvEvents;
    private ArrayList<StatusEvent> events;
    private Query query;
    private StatusEventAdapter adapter; // Declare the adapter as a member variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_list);

        lvEvents = findViewById(R.id.lvEvents);
        events = new ArrayList<StatusEvent>();

        // Populate the events list with data from Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventsRef = database.getReference("events");

        // Get current userID
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        String userKey = firebaseUser.getUid();

        query = eventsRef.orderByChild("postByID").equalTo(userKey);

        adapter = new StatusEventAdapter(this, events); // Initialize the adapter here

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                events.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String key = snapshot.getKey();
                    String postByID = snapshot.child("postByID").getValue(String.class);
                    String title = snapshot.child("title").getValue(String.class);
                    String date = snapshot.child("date").getValue(String.class);
                    String time = snapshot.child("time").getValue(String.class);
                    String description = snapshot.child("description").getValue(String.class);
                    String district = snapshot.child("district").getValue(String.class);
                    String address = snapshot.child("address").getValue(String.class);
                    int fee = snapshot.child("fee").getValue(Integer.class);
                    int quota = snapshot.child("quota").getValue(Integer.class);
                    // Get participants as Map<String, String>
                    Map<String, String> participants = new HashMap<>();
                    DataSnapshot participantsSnapshot = snapshot.child("participants");
                    for (DataSnapshot participantSnapshot : participantsSnapshot.getChildren()) {
                        String userID = participantSnapshot.getKey();
                        String username = participantSnapshot.getValue(String.class);
                        participants.put(userID, username);
                    }

                    // Create StatusEvent object with participants
                    StatusEvent event = new StatusEvent(key, postByID, title, date, time, description, district, address, quota, fee, participants);
                    events.add(event);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("TAG", "Failed to read events", databaseError.toException());
            }
        });


        lvEvents.setAdapter(adapter);

        lvEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StatusEvent event = events.get(position);
                Intent intent = new Intent(StatusListActivity.this, StatusDetailsActivity.class);
                intent.putExtra("event", (Parcelable) event);
                startActivity(intent);
            }
        });
    }
}