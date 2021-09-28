package com.example.flowerparadise;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//Updated the home fragment
public class HomeFragment extends Fragment {
    private Button btn_home;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        btn_home = (Button)view.findViewById(R.id.btnhome);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),HomeActivity.class);
                startActivity(in);
            }
        });

        return view;
    }
}
