package com.example.flowerparadise;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentToReview extends Fragment {
    private Button btn_feedback;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toreview, container, false);


        btn_feedback = (Button)view.findViewById(R.id.btn_feedback);
        btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),feedbackActivity.class);
                startActivity(in);
            }
        });

        return view;
    }
}
