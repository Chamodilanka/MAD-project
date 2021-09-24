package com.example.flowerparadise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flowerparadise.R;
import com.example.flowerparadise.eventbus.MyUpdateCartEvent;
import com.example.flowerparadise.listener.ICartLoadListener;
import com.example.flowerparadise.listener.IRecyclerViewClickListener;
import com.example.flowerparadise.model.CardModel;
import com.example.flowerparadise.model.CartModel;
import com.example.flowerparadise.model.ChocolateModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyCardAdapter extends RecyclerView .Adapter<MyCardAdapter.MyCardViewHolder>{
    private Context context;
    private List < CardModel > cardModelList;
    private ICartLoadListener iCartLoadListener;

    public MyCardAdapter(Context context, List < CardModel > cardModelList, ICartLoadListener iCartLoadListener) {
        this.context = context;
        this.cardModelList= cardModelList;
        this.iCartLoadListener = iCartLoadListener;
    }

    @NonNull
    @NotNull
    @Override
    public MyCardViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MyCardViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.layout_flower_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyCardAdapter.MyCardViewHolder holder, int position) {
        Glide.with(context)
                .load(cardModelList.get(position).getUrl())
                .into(holder.imageView);
        holder.txtPrice.setText(new StringBuilder("LKR ").append(cardModelList.get(position).getPrice()));
        holder.txtName.setText(new StringBuilder().append(cardModelList.get(position).getName()));
        holder.setListener((view, adapterPosition) -> {
            addToCart(cardModelList.get(position));
        });
    }

    private void addToCart(CardModel cardModel) {
        DatabaseReference userCart= FirebaseDatabase
                .getInstance()
                .getReference("Cart")
                .child("UNIQUE_USER_ID");
        userCart.child(cardModel.getKey())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            CartModel cartModel=snapshot.getValue(CartModel.class);
                            cartModel.setQuantity(cartModel.getQuantity()+1);
                            Map <String,Object> updateData=new HashMap <>();
                            updateData.put("quantity",cartModel.getQuantity());
                            updateData.put("totalPrice",cartModel.getQuantity()*Float.parseFloat(cartModel.getPrice()));

                            userCart.child(cardModel.getKey())
                                    .updateChildren(updateData)
                                    .addOnSuccessListener(unused -> {
                                        iCartLoadListener.onCartLoadFailed("Add To Cart Success");
                                    })
                                    .addOnFailureListener(e -> iCartLoadListener.onCartLoadFailed(e.getMessage()));
                        }
                        else{
                            CartModel cartModel = new CartModel();
                            cartModel.setName(cardModel.getName());
                            cartModel.setUrl(cardModel.getUrl());
                            cartModel.setPrice(cardModel.getPrice());
                            cartModel.setKey(cardModel.getKey());
                            cartModel.setQuantity(1);
                            cartModel.setTotalPrice(Float.parseFloat(cardModel.getPrice()));
                            userCart.child(cardModel.getKey())
                                    .setValue(cartModel)
                                    .addOnSuccessListener(unused -> {
                                        iCartLoadListener.onCartLoadFailed("Add To Cart Success");
                                    })
                                    .addOnFailureListener(e -> iCartLoadListener.onCartLoadFailed(e.getMessage()));


                        }
                        EventBus.getDefault().postSticky(new MyUpdateCartEvent());
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {
                        iCartLoadListener.onCartLoadFailed(error.getMessage());
                    }
                });

    }

    @Override
    public int getItemCount() {

        return cardModelList.size();
    }

    public class MyCardViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtPrice)
        TextView txtPrice;

        IRecyclerViewClickListener listener;

        public void setListener(IRecyclerViewClickListener listener) {
            this.listener = listener;
        }

        private Unbinder unbinder;

        public MyCardViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            unbinder= ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onRecyclerClick(v,getAdapterPosition());
        }
    }
}
