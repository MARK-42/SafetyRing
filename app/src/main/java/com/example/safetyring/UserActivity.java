package com.example.safetyring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class UserActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button logout;
    private Button details;
    private Button audio;
    private Button tracking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        auth = FirebaseAuth.getInstance();

        logout = (Button)findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
                startActivity(new Intent(UserActivity.this,LoginActivity.class));
                finish();
            }
        });


        details = (Button)findViewById(R.id.details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailsIntent = new Intent(UserActivity.this, DetailsActivity.class);
                startActivity(detailsIntent);
            }
        });

        tracking = (Button)findViewById(R.id.tracking);
        tracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(UserActivity.this, TrackingActivity.class);
            }
        });

        audio = (Button)findViewById(R.id.audio);
        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(UserActivity.this, AudioActivity.class);
            }
        });



    }

    public void signOut() {
        auth.signOut();
    }

}
