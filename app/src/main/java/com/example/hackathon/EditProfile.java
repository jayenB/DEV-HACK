package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfile extends AppCompatActivity {

     Button backButton;


    TextView a,b;
    RadioGroup radioGroup1,radioGroup2;
    RadioButton radioButton1,radioButton2;
    Button button1,button2;
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
        b = (TextView) findViewById(R.id.age);

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);

        button1 = findViewById(R.id.viewProfile);
        button2 = findViewById(R.id.update);

        //reff = FirebaseDatabase.getInstance().getReference().child("PatInfo").child("User1");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("PatInfo").child("User1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name = dataSnapshot.child("name").getValue().toString();
                        String age = dataSnapshot.child("age").getValue().toString();
                        String sex = dataSnapshot.child("sex").getValue().toString();
                        String diabetes = dataSnapshot.child("diabetes").getValue().toString();
                        a.setText(name);
                        b.setText(age);
                        //find radioID
                        if(sex.equals("Male"))
                                radioGroup1.check(R.id.male);
                        else
                                radioGroup1.check(R.id.female);

                        if(diabetes.equals("NIL"))
                                radioGroup2.check(R.id.nil);
                        else if(diabetes.equals("Low"))
                                radioGroup2.check(R.id.low);
                        else if(diabetes.equals("Medium"))
                                radioGroup2.check(R.id.medium);
                        else
                                radioGroup2.check(R.id.high);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("PatInfo").child("User1");
                AddDate();


            }
        });
    }
    public void AddDate() {

        String w = a.getText().toString().trim();
        String x = b.getText().toString().trim();
        int id1 = radioGroup1.getCheckedRadioButtonId();
        int id2 = radioGroup2.getCheckedRadioButtonId();

        radioButton1 = findViewById(id1);
        radioButton2 = findViewById(id2);
        String y = radioButton1.getText().toString().trim();
        String z = radioButton2.getText().toString().trim();

        SaveData saveData = new SaveData(w,x,y,z);
        reff.setValue(saveData);

    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
