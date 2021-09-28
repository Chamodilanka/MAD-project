package com.example.flowerparadise;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GiftFragment extends Fragment {
    private Button btncakes;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gift, container, false);
        btncakes = (Button)view.findViewById(R.id.btncakes);
        btncakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),CakesActivity.class);
                startActivity(in);
            }
        });
        return view;
    }
}
