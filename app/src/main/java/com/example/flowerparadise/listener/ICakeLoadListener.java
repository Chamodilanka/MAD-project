package com.example.flowerparadise.listener;

import com.example.flowerparadise.model.CakeCartModel;
import com.example.flowerparadise.model.FlowerModel;

import java.util.List;

public interface ICakeLoadListener {
    void onCakeLoadSuccess(List < CakeCartModel > cakeCartModelList);
    void onCakeLoadFailed(String message);
}
