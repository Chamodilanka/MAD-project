package com.example.flowerparadise.listener;

import com.example.flowerparadise.model.FlowerModel;

import java.util.List;

public interface IFlowerLoadListener {
    void onFlowerLoadSuccess(List < FlowerModel > flowerModelList);
    void onFlowerLoadFailed(String message);
}
