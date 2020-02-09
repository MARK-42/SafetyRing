package com.example.safetyring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Locale;

public class TrackingActivity extends AppCompatActivity {
    FirebaseFirestore db;
    private FirebaseAuth auth;
    private Coordinates x;
    private TextView tv;
    private ProgressBar pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        tv = findViewById(R.id.showLatlong);
        pg = findViewById(R.id.pg);
        auth= FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection(auth.getCurrentUser().getEmail()).document("Location");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                x = documentSnapshot.toObject(Coordinates.class);
                tv.setText("Latitude : "+x.getLat()+"\nLongitude"+x.getLon());
                double a = Double.parseDouble(x.getLat().trim());
                double b = Double.parseDouble(x.getLon().trim());
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f",a,b);
//                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", x.getLat(), x.getLon());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                pg.setVisibility(View.GONE);
                startActivity(intent);
            }
        });

    }
}
