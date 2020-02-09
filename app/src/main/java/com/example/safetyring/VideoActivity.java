package com.example.safetyring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class VideoActivity extends AppCompatActivity {
    private StorageReference storageReference;
    private FirebaseStorage storage;
    ArrayList<String> s=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        final LinearLayout ll=(findViewById(R.id.ll1));

        storage = FirebaseStorage.getInstance();
        storageReference =  storage.getReference();
        int i=0;
        for(i=0;i<=25;i++) {
            String x = "images/image" + i + ".jpg";
            storageReference.child(x).getDownloadUrl()
                    .addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            s.add(uri.toString());
                            ImageView imageView = new ImageView(VideoActivity.this);
                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1000, 1000);
                            params.bottomMargin=12;
                            imageView.setLayoutParams(params);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            RequestOptions options = new RequestOptions()
                                    .centerCrop()
                                    .placeholder(R.mipmap.ic_launcher_round)
                                    .error(R.mipmap.ic_launcher_round);
                            Glide.with(VideoActivity.this).load(uri).apply(options).into(imageView);
                            ll.addView(imageView);


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Toast.makeText(VideoActivity.this, "failed", Toast.LENGTH_SHORT).show();

                }
            });
        }




    }
}
