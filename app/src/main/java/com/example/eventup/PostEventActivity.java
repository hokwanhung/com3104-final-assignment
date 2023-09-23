package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;
import java.util.Calendar;

public class PostEventActivity extends AppCompatActivity {

    private TextView dateTextView,  timeTextView;
    private Button dateButton, timeButton, postButton;
    private EditText titleEditText, descriptionEditText, addressEditText, quotaEditText, feeEditText;
    private Spinner districtSpinner;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_event);

        // Initialize views
        titleEditText = findViewById(R.id.title_edittext);
        dateTextView = findViewById(R.id.date_textview);
        dateButton = findViewById(R.id.date_button);
        timeTextView = findViewById(R.id.time_textview);
        timeButton = findViewById(R.id.time_button);
        descriptionEditText = findViewById(R.id.description_edittext);
        districtSpinner = findViewById(R.id.district_spinner);
        addressEditText = findViewById(R.id.address_edittext);
        quotaEditText = findViewById(R.id.quota_edittext);
        feeEditText = findViewById(R.id.fee_edittext);
        postButton = findViewById(R.id.post_button);

        // Initialize Firebase Realtime Database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Set up date picker dialog when date button is clicked
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(PostEventActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // Set the selected date
                                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                dateTextView.setText("Date: " + date);
                            }
                        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        // Set up time picker dialog when time button is clicked
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(PostEventActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // Set the selected time
                                String time = hourOfDay + ":" + minute;
                                timeTextView.setText("Time: " + time);
                            }
                        }, Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), false);
                timePickerDialog.show();
            }
        });

        // Set up district spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.districts_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtSpinner.setAdapter(adapter);

        // Set up post button click listener
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get current userID
                FirebaseAuth auth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = auth.getCurrentUser();
                String userId = firebaseUser.getUid();

                // Get the values from the input fields
                try {
                    String title = titleEditText.getText().toString().trim();
                    String date = dateTextView.getText().toString().substring(6);
                    String time = formatTime(timeTextView.getText().toString().substring(6));
                    String description = descriptionEditText.getText().toString().trim();
                    String district = districtSpinner.getSelectedItem().toString();
                    String address = addressEditText.getText().toString().trim();
                    int quota = Integer.parseInt(quotaEditText.getText().toString().trim());
                    int fee = Integer.parseInt(feeEditText.getText().toString().trim());

                    // Create a new event object
                    PostEvent postEvent = new PostEvent(userId, title, date, time, description, district, address, quota, fee);

                    // Save the event object to Firebase Realtime Database
                    String key = mDatabase.child("events").push().getKey();
                    mDatabase.child("events").child(key).setValue(postEvent);

                    // Show a success message
                    Toast.makeText(PostEventActivity.this, "Event created successfully!", Toast.LENGTH_SHORT).show();
                } catch (DateTimeParseException e) {
                    Toast.makeText(PostEventActivity.this, "Please enter the date/time!", Toast.LENGTH_SHORT).show();
                }

                startActivity(new Intent(PostEventActivity.this, HomeActivity.class));

                // Finish the activity
                finish();
            }

            String formatTime(String timeStr) {
                LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("H:m"));
                return time.format(DateTimeFormatter.ofPattern("HH:mm"));
            }

        });
    }
}