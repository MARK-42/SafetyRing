package com.example.safetyring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailsActivity extends AppCompatActivity {

    private Button submitbtn;
    private EditText name1,email1,phone1,name2,email2,phone2;


    FirebaseAuth auth;
    private DatabaseReference dbreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        auth=FirebaseAuth.getInstance();
        final String user_email = auth.getCurrentUser().getEmail();



        submitbtn = (Button)findViewById(R.id.submitbtn);
        name1=(EditText)findViewById(R.id.name1);
        name2=(EditText)findViewById(R.id.name2);
        email1=(EditText)findViewById(R.id.email1);
        email2=(EditText)findViewById(R.id.email2);
        phone1=(EditText)findViewById(R.id.phone1);
        phone2=(EditText)findViewById(R.id.phone2);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n1=name1.getText().toString().trim();
                String n2=name2.getText().toString().trim();
                String e1=email1.getText().toString().trim();
                String e2=email2.getText().toString().trim();
                String p1=phone1.getText().toString().trim();
                String p2=phone2.getText().toString().trim();

                EmergencyDetails var = new EmergencyDetails(n1,n2,e1,e2,p1,p2);

            }
        });

    }
}
