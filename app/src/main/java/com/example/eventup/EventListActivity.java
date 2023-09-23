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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {
    private ListView lvEvents;
    private Button applyButton;
    private Spinner districtSpinner;
    private ArrayList<Event> events;
    private Query query;
    private EventAdapter adapter; // Declare the adapter as a member variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        lvEvents = findViewById(R.id.lvEvents);
        districtSpinner = findViewById(R.id.district_spinner);
        applyButton = findViewById(R.id.apply_button);
        events = new ArrayList<>();

        // Set up district spinner
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.search_districts_array, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtSpinner.setAdapter(arrayAdapter);

        // Populate the events list with data from Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventsRef = database.getReference("events");
        query = eventsRef.orderByChild("date");

        adapter = new EventAdapter(this, events); // Initialize the adapter here

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

                    Event event = new Event(key, postByID, title, date, time, description, district, address, quota, fee);
                    events.add(event);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("TAG", "Failed to read events", databaseError.toException());
            }
        });

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String district = districtSpinner.getSelectedItem().toString();
                if(!district.equals("All"))
                    query = eventsRef.orderByChild("district").equalTo(district);
                else
                    query = eventsRef.orderByChild("date");

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
                            Event event = new Event(key, postByID, title, date, time, description, district, address, quota, fee);
                            events.add(event);
                        }

                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("TAG", "Failed to read events", databaseError.toException());
                    }
                });
            }
        });

        lvEvents.setAdapter(adapter);

        lvEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event event = events.get(position);
                Intent intent = new Intent(EventListActivity.this, EventDetailsActivity.class);
                intent.putExtra("event", (Parcelable) event);
                startActivity(intent);
            }
        });
    }
}