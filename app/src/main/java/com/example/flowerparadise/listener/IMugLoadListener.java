package com.example.flowerparadise.listener;


import com.example.flowerparadise.model.MugModel;


import java.util.List;

public interface IMugLoadListener {
    void onMugLoadSuccess(List < MugModel > mugModelList);
    void onMugLoadFailed(String message);
}