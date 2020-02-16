package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DiseaseResultss extends AppCompatActivity {

    private Button backButton;
    TextView a, b, c, d, e, f, g;
    Button button;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });


        a = (TextView) findViewById(R.id.name);
        b = (TextView) findViewById(R.id.selfcare);
        c = (TextView) findViewById(R.id.drug);
        d = (TextView) findViewById(R.id.meds);
        e = (TextView) findViewById(R.id.gels);
        f = (TextView) findViewById(R.id.dosage);
        // g = (TextView) findViewById(R.id.consult);
        button = findViewById(R.id.viewProfile);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("Response").child("User");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name = dataSnapshot.child("Disease Name").getValue().toString();
                        String drug = dataSnapshot.child("Drug").getValue().toString();
                        String gels = dataSnapshot.child("Ointments").getValue().toString();
                        String selfcare = dataSnapshot.child("Selfcare").getValue().toString();
                        String meds = dataSnapshot.child("Tablets").getValue().toString();
                        String dosage = dataSnapshot.child("Dosage").getValue().toString();
                        a.setText(name);
                        b.setText(selfcare);
                        c.setText(drug);
                        d.setText(meds);
                        e.setText(gels);
                        f.setText(dosage);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


