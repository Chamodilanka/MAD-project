package com.example.flowerparadise;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CartFragment extends Fragment {
    private Button flower,cake,chocolate,card,mug,teddy;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_cart, container, false);
        flower=view.findViewById(R.id.btn_flowers);
        flower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),NewCart.class);
                startActivity(intent);

            }
        });
        cake=view.findViewById(R.id.btn_cake);
        cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),CakeCart.class);
                startActivity(intent);

            }
        });
        chocolate=view.findViewById(R.id.btn_chocolate);
        chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),ChocolateCart.class);
                startActivity(intent);

            }
        });
        card=view.findViewById(R.id.btn_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),CardCart.class);
                startActivity(intent);

            }
        });
        mug=view.findViewById(R.id.btn_mug);
        mug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),MugCart.class);
                startActivity(intent);

            }
        });
        teddy=view.findViewById(R.id.btn_bear);
        teddy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),TeddyCart.class);
                startActivity(intent);

            }
        });
        return view;

    }

}
