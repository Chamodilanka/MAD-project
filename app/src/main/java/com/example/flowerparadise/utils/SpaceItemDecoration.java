package com.example.flowerparadiseapplication.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(@NonNull @org.jetbrains.annotations.NotNull Rect outRect, @NonNull @org.jetbrains.annotations.NotNull View view, @NonNull @org.jetbrains.annotations.NotNull RecyclerView parent, @NonNull @org.jetbrains.annotations.NotNull RecyclerView.State state) {
        if(parent.getChildLayoutPosition(view) %2 != 0){
            outRect.top=50;
            outRect.bottom=-50;
        }
    }
}
