package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference database;
    private EditText signupEmail, signupPassword, signupUsername, signupConfirmPassword;
    private Button signupButton;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();



        signupEmail = findViewById(R.id.email);
        signupPassword = findViewById(R.id.password);
        signupConfirmPassword = findViewById(R.id.confirm_password);
        signupUsername = findViewById(R.id.username);
        signupButton = findViewById(R.id.signup_button);
        loginLink = findViewById(R.id.login_link);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = signupEmail.getText().toString().trim();
                String password = signupPassword.getText().toString().trim();
                String confirm_password = signupConfirmPassword.getText().toString().trim();
                String username = signupUsername.getText().toString().trim();

                if (username.isEmpty()) {
                    signupUsername.setError("Username is required.");
                } else if (user.isEmpty()){
                    signupEmail.setError("Email is required.");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(user).matches()){
                    signupEmail.setError("Invalid email format.");
                } else if (password.isEmpty()){
                    signupPassword.setError("Password is required.");
                } else if (confirm_password.isEmpty()){
                    signupConfirmPassword.setError("Confirm password is required.");
                } else if (!password.equals(confirm_password)) {
                    signupConfirmPassword.setError("The password does not match.");
                } else {
                    auth.createUserWithEmailAndPassword(user, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser firebaseUser = auth.getCurrentUser();
                                String userId = firebaseUser.getUid();
                                UserProfile userProfile = new UserProfile(username);
                                database.child("users").child(userId).setValue(userProfile);
                                Toast.makeText(SignUpActivity.this,"SignUp Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                            } else {
                                Toast.makeText(SignUpActivity.this,"SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
    }
}