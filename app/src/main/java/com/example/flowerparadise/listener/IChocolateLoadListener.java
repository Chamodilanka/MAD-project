package com.example.flowerparadise.listener;

import com.example.flowerparadise.model.ChocolateModel;


import java.util.List;

public interface IChocolateLoadListener {
    void onChocolateLoadSuccess(List < ChocolateModel > chocolateModelList);
    void onChocolateLoadFailed(String message);
}