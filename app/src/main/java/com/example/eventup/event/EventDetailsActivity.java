package com.example.eventup.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventup.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventDetailsActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvTime;
    private TextView tvDistrict;
    private TextView tvFee;
    private TextView tvAddress;
    private TextView tvDescription;
    private TextView tvQuota;
    private Button join_bt;
    public long count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        tvTitle = findViewById(R.id.tvTitle);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        tvDistrict = findViewById(R.id.tvDistrict);
        tvFee = findViewById(R.id.tvFee);
        tvQuota = findViewById(R.id.tvQuota);
        tvAddress = findViewById(R.id.tvAddress);
        tvDescription = findViewById(R.id.tvDescription);
        join_bt = findViewById(R.id.join_bt);

        Event event = getIntent().getParcelableExtra("event");
        Log.d("Debug", String.valueOf(event.getPostByID()));

        tvTitle.setText(event.getTitle());
        tvDate.setText(event.getDate());
        tvTime.setText(event.getTime());
        tvDistrict.setText(event.getDistrict());
        tvAddress.setText(event.getAddress());
        tvDescription.setText(event.getDescription());
        tvFee.setText(Integer.toString(event.getFee()));


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("users");
        DatabaseReference myRef = database.getReference("events");
        //Get event key
        String key =  event.getKey();

        myRef.child(key).child("participants").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get the number of children of the users node from the snapshot
                count = dataSnapshot.getChildrenCount();
                tvQuota.setText(Long.toString(count) + "/" + Integer.toString(event.getQuota()));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle errors
            }
        });



        join_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Long.toString(count).equals(Integer.toString(event.getQuota())))
                    Toast.makeText(EventDetailsActivity.this,"The event is full", Toast.LENGTH_SHORT).show();

                else{
                    // Get current userID
                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    String userId = firebaseUser.getUid();


                    // Retrieve the username for the user using a ValueEventListener
                    userRef.child(userId).child("username").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //username = dataSnapshot.getValue(String.class);
                            myRef.child(key).child("participants").child(userId).setValue(dataSnapshot.getValue(String.class));
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                        }
                    });
                    Toast.makeText(EventDetailsActivity.this,"Join Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EventDetailsActivity.this, EventListActivity.class);
                    finish();
                }
            }
        });

    }
}