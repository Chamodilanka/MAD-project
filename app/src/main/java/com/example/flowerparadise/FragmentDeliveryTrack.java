package com.example.flowerparadise;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDeliveryTrack extends Fragment {
    private Button btndelivercharge;
    public FragmentDeliveryTrack(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delivery_track, container, false);


        btndelivercharge = (Button)view.findViewById(R.id.btndelivercharge);
        btndelivercharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),DeliverChargeActivity.class);
                startActivity(in);
            }
        });

        return view;
    }
}
