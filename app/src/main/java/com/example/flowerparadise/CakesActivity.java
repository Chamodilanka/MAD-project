package com.example.flowerparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CakesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MaincakeAdapter maincakeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cakes);
    }
}