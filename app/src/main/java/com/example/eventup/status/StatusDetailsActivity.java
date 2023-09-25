package com.example.eventup.status;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eventup.R;

import java.util.ArrayList;
import java.util.Map;

public class StatusDetailsActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvTime;
    private TextView tvDescription;
    private TextView tvDistrict;
    private TextView tvAddress;
    private TextView tvFee;
    private TextView tvQuota;
    private ListView lvParticipants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_details);

        tvTitle = findViewById(R.id.tvTitle);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        tvDescription = findViewById(R.id.tvDescription);
        tvDistrict = findViewById(R.id.tvDistrict);
        tvAddress = findViewById(R.id.tvAddress);
        tvFee = findViewById(R.id.tvFee);
        tvQuota = findViewById(R.id.tvQuota);
        lvParticipants = findViewById(R.id.lvParticipants);

        // Get the StatusEvent object from the intent
        StatusEvent event = getIntent().getParcelableExtra("event");

        // Set the text views to display the event details
        tvTitle.setText(event.getTitle());
        tvDate.setText(event.getDate());
        tvTime.setText(event.getTime());
        tvDescription.setText(event.getDescription());
        tvDistrict.setText(event.getDistrict());
        tvAddress.setText(event.getAddress());
        tvFee.setText(String.valueOf(event.getFee()));
        tvQuota.setText(String.valueOf(event.getQuota()));

        // Set up the list view to display the usernames of participants
        ArrayList<String> usernames = new ArrayList<>();
        Map<String, String> participants = event.getParticipants();
        for (String userID : participants.keySet()) {
            String username = participants.get(userID);
            Log.d("Debug",username);
            usernames.add(username);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usernames);
        lvParticipants.setAdapter(adapter);
    }
}