package com.example.safetyring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailsActivity extends AppCompatActivity {

    private Button submitbtn;
    private EditText name1,email1,phone1,name2,email2,phone2;
    private FirebaseFirestore db;

    FirebaseAuth auth;
    private DatabaseReference dbreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        auth=FirebaseAuth.getInstance();
        final String user_email = auth.getCurrentUser().getEmail();

        db = FirebaseFirestore.getInstance();

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
                UploadDetails();
            }
        });

    }
    public void UploadDetails(){
        String n1=name1.getText().toString().trim();
        if(TextUtils.isEmpty(n1)){
            name1.setError("This field cant be empty");
            return;
        }
        String n2=name2.getText().toString().trim();
        if(TextUtils.isEmpty(n2)){
            name2.setError("This field cant be empty");
            return;
        }
        String e1=email1.getText().toString().trim();
        if(TextUtils.isEmpty(e1)){
            email1.setError("This field cant be empty");
            return;
        }
        String e2=email2.getText().toString().trim();
        if(TextUtils.isEmpty(e2)){
            email2.setError("This field cant be empty");
            return;
        }
        String p1=phone1.getText().toString().trim();
        if(TextUtils.isEmpty(p1)){
            phone1.setError("This field cant be empty");
            return;
        }
        String p2=phone2.getText().toString().trim();
        if(TextUtils.isEmpty(p2)){
            phone2.setError("This field cant be empty");
            return;
        }

        EmergencyDetails var = new EmergencyDetails(n1,n2,e1,e2,p1,p2);

        db.collection(auth.getCurrentUser().getEmail()).document("Details").set(var)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
//                                pg.setVisibility(View.GONE);
                                Toast.makeText(DetailsActivity.this, "Details successfully uploaded", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
//                        pg.setVisibility(View.GONE);
                        Toast.makeText(DetailsActivity.this, "Some error occurred : "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



    }

}
