package com.example.flowerparadise.listener;

import com.example.flowerparadise.model.ChocolateModel;
import com.example.flowerparadise.model.TeddyModel;


import java.util.List;

public interface  ITeddyLoadListener {
    void onTeddyLoadSuccess(List < TeddyModel > teddyModelList);
    void onTeddyLoadFailed(String message);
}