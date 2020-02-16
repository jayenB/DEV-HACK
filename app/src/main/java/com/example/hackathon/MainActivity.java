package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button uploadImage;
    private Button editProfile,viewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadImage = (Button) findViewById(R.id.uploadImage);
        editProfile = (Button) findViewById(R.id.editProfile);
        viewResults = (Button)  findViewById(R.id.viewResults);



        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUploadImage();

            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditProfile();
            }
        });
        viewResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewResults();
            }
        });
        }

    public void openUploadImage() {
    Intent intent = new Intent(this, UploadImage.class);
    startActivity(intent);
    }

    public void openEditProfile() {
        Intent intent2 = new Intent(this, EditProfile.class);
        startActivity(intent2);
    }

        public void openViewResults() {
            Intent abcd = new Intent(this,DiseaseResultss.class);
            startActivity(abcd);
        }
    }

