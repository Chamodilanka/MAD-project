package com.example.flowerparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedbackActivity extends AppCompatActivity {
    EditText etName;
    EditText etfeedback;
    Button btnsubmitfeedback;
    TextView tvFeedback;
    RatingBar rbStars;

    DatabaseReference feedbackDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        etName = findViewById(R.id.et_PersonName);
        etfeedback = findViewById(R.id.et_feedback);
        btnsubmitfeedback = findViewById(R.id.btnsubmitfeedback);
        tvFeedback = findViewById(R.id.txtfeedback);
        rbStars = findViewById(R.id.rb_stars);

        feedbackDB = FirebaseDatabase.getInstance().getReference().child("feedback");
        btnsubmitfeedback.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                insertFeedbackData();
            }
        });


        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating == 0)
                {
                    tvFeedback.setText("Very Dissatisfied");
                }
                else if(rating==1)
                {
                    tvFeedback.setText("Dissatisfied");
                }
                else if(rating == 2){
                    tvFeedback.setText("OK");
                }
                else if(rating == 3){
                    tvFeedback.setText("Good");
                }
                else if(rating == 4){
                    tvFeedback.setText("Very Good");
                }
                else if(rating == 5){
                    tvFeedback.setText("Excellent");
                }
                else{}
            }
        });
    }

    private void insertFeedbackData() {
        String name = etName.getText().toString();
        String feedback = etfeedback.getText().toString();

        FeedbackData feedbackData = new FeedbackData(name, feedback);

        feedbackDB.push().setValue(feedback);
        Toast.makeText(feedbackActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();

    }
}