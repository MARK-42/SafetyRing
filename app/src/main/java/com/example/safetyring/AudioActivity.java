package com.example.safetyring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AudioActivity extends AppCompatActivity {

    private Button btnVideo, btnAudio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        btnVideo= (Button)findViewById(R.id.button_video);
        btnAudio= (Button)findViewById(R.id.button_audio);

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AudioActivity.this,VideoActivity.class));
            }
        });
        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AudioActivity.this,Audio2Activity.class));
            }
        });

    }
}
