package com.example.flowerparadise.listener;

import com.example.flowerparadise.model.CartModel;


import java.util.List;

public interface ICartLoadListener {
    void onCartLoadSuccess(List < CartModel> cartModelList);
    void onCartLoadFailed(String message);
}
