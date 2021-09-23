package com.example.flowerparadise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.flowerparadise.adapter.MyFlowerAdapter;
import com.example.flowerparadise.eventbus.MyUpdateCartEvent;
import com.example.flowerparadise.listener.ICartLoadListener;
import com.example.flowerparadise.listener.IFlowerLoadListener;
import com.example.flowerparadise.model.CartModel;
import com.example.flowerparadise.model.FlowerModel;
import com.example.flowerparadiseapplication.utils.SpaceItemDecoration;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nex3z.notificationbadge.NotificationBadge;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewCart extends AppCompatActivity implements IFlowerLoadListener, ICartLoadListener {
    @BindView(R.id.recycler_flower)
    RecyclerView recycler_flower;
    @BindView(R.id.newCart)
    RelativeLayout newCart;
    @BindView(R.id.badge)
    NotificationBadge badge;
    @BindView(R.id.btnCart)
    FrameLayout btnCart;
    @BindView(R.id.btnBack)
    ImageView btnBack;

    IFlowerLoadListener flowerLoadListener;
    ICartLoadListener cartLoadListener;

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        if(EventBus.getDefault().hasSubscriberForEvent(MyUpdateCartEvent.class))
            EventBus.getDefault().removeStickyEvent(MyUpdateCartEvent.class);
        EventBus.getDefault().unregister(this);

        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onUpdateCart(MyUpdateCartEvent event)
    {
        countCartItem();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cart);

        init();
        loadFlowerFromFirebase();
        countCartItem();
    }

    private void loadFlowerFromFirebase() {
        List<FlowerModel> flowerModels=new ArrayList <>();
        FirebaseDatabase.getInstance()
                .getReference("Flower")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {
                         if(dataSnapshot.exists()){
                             for(DataSnapshot flowerSnapshot:dataSnapshot.getChildren()){
                                 FlowerModel flowerModel=flowerSnapshot.getValue(FlowerModel.class);
                                 flowerModel.setKey(flowerSnapshot.getKey());
                                 flowerModels.add(flowerModel);

                             }
                             flowerLoadListener.onFlowerLoadSuccess(flowerModels);
                         }
                         else
                             flowerLoadListener.onFlowerLoadFailed("Can't find flower boquet");
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError databaseError) {
                        flowerLoadListener.onFlowerLoadFailed(databaseError.getMessage());
                    }
                });
    }

    private void init() {
        ButterKnife.bind(this);

        flowerLoadListener=this;
        cartLoadListener=this;


        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recycler_flower.setLayoutManager(gridLayoutManager);
        recycler_flower.addItemDecoration(new SpaceItemDecoration());

        btnCart.setOnClickListener(v -> startActivity(new Intent(this,shoppingCart.class)));
        btnBack.setOnClickListener(v -> finish());

    }

    @Override
    public void onFlowerLoadSuccess(List < FlowerModel > flowerModelList) {
       MyFlowerAdapter adapter = new  MyFlowerAdapter(this,flowerModelList,cartLoadListener);
       recycler_flower.setAdapter(adapter);
    }

    @Override
    public void onFlowerLoadFailed(String message) {
        Snackbar.make(newCart,message,Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void onCartLoadSuccess(List < CartModel > cartModelList) {
        int cartSum=0;
        for(CartModel cartModel:cartModelList)
            cartSum += cartModel.getQuantity();
        badge.setNumber(cartSum);


    }

    @Override
    public void onCartLoadFailed(String message) {
        Snackbar.make(newCart,message,Snackbar.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        countCartItem();
    }

    private void countCartItem() {
        List<CartModel> cartModels = new ArrayList <>();
        FirebaseDatabase
                .getInstance().getReference("Cart")
                .child("UNIQUE_USER_ID")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        for(DataSnapshot cartSnapshot:snapshot.getChildren()){
                            CartModel cartModel = cartSnapshot.getValue(CartModel.class);
                            cartModel.setKey(cartSnapshot.getKey());
                            cartModels.add(cartModel);

                        }
                        cartLoadListener.onCartLoadSuccess(cartModels);
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {
                      cartLoadListener.onCartLoadFailed(error.getMessage());
                    }
                });
    }
}