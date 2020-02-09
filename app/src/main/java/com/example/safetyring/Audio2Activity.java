package com.example.safetyring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Audio2Activity extends AppCompatActivity {

    private FirebaseStorage storage;
    private StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio2);
        storage = FirebaseStorage.getInstance();
        storageRef =  storage.getReference();
        StorageReference islandRef = storageRef.child("audio/voice15.wav");

        islandRef.getDownloadUrl()
                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        try {

                            MediaPlayer player = new MediaPlayer();
                            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            player.setDataSource(Audio2Activity.this, uri);
                            player.prepare();
                            player.start();
                        } catch(Exception e) {
                            System.out.println(e.toString());
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(Audio2Activity.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
