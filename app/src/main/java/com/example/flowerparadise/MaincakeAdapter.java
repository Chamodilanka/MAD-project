package com.example.flowerparadise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

public class MaincakeAdapter extends FirebaseRecyclerAdapter<MainGiftModel, MaincakeAdapter.myViewHolder> {
    public MaincakeAdapter(@NonNull @NotNull FirebaseRecyclerOptions<MainGiftModel> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder myViewHolder, int i, @NonNull @NotNull MainGiftModel mainGiftModel) {
        myViewHolder.name.setText(mainGiftModel.getName());
        myViewHolder.Price.setText(mainGiftModel.getPrice());


        Glide.with(myViewHolder.img.getContext())
                .load(mainGiftModel.getSurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(myViewHolder.img);

    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_cakes,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name,Price;

        public myViewHolder(@NonNull View itemView){
            super(itemView);
            img = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.giftnametxt1);
            Price = (TextView)itemView.findViewById(R.id.pricetxt);


        }
    }


}
