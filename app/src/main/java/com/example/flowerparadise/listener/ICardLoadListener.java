package com.example.flowerparadise.listener;

import com.example.flowerparadise.model.CardModel;


import java.util.List;

public interface ICardLoadListener {
    void onCardLoadSuccess(List < CardModel > cardModelList);
    void onCardLoadFailed(String message);
}