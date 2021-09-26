package com.example.flowerparadise;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeliverChargeActivity extends AppCompatActivity {
    //Initialize variables

    private Button Multiply;
    private EditText Num1;
    private EditText Num2;
    private EditText Result;

    EditText etSource,etDestination;
    Button btTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deliver_charge);

        //Asign variable
        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        btTrack = findViewById(R.id.btn_track);

        Multiply = findViewById(R.id.btnMultiply);
        Num1 = findViewById(R.id.et_deliverchargepr1);
        Num2 = findViewById(R.id.et_distance);
        Result = findViewById(R.id.resultcharge);

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a,b,c;
                a = Double.parseDouble(Num1.getText().toString());
                b = Double.parseDouble(Num2.getText().toString());
                c = a * b;
                Result.setText(Double.toString(c));
            }
        });

        btTrack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Get value from edit text
                String sSource = etSource.getText().toString().trim();
                String sDestination = etDestination.getText().toString().trim();

                //Check condition
                if(sSource.equals("")&& sDestination.equals("")){
                    //When both value blank
                    Toast.makeText(getApplicationContext()
                    ,"Enter both location",Toast.LENGTH_SHORT).show();
                }else{
                    //When both values fill
                    //Display Track
                    DisplayTrack(sSource,sDestination);
                }
            }
        });
    }

    private void DisplayTrack(String sSource, String sDestination) {
        //If the device has not have a map installed, the redirect it to play store
        try {
            //When google map installed
            //Initialize uri
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/"
            + sDestination);
            //Initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //Set package
            intent.setPackage("com.google.android.apps.maps");
            //Set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //start activity
            startActivity(intent);

        }catch (ActivityNotFoundException e){
            //When google map is not installed
            //Initialize uri
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            //Initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //start activity
            startActivity(intent);
        }
        }
    }
