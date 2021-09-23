package com.example.flowerparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class prepayments extends AppCompatActivity implements  View.OnClickListener {
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentsuccess);
        ok = (Button) findViewById(R.id.button2);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.paysuccess, new CartFragment()).commit();
        }

    }
}

