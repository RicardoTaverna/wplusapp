package com.example.wplusapp;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewCardAdapter extends
        RecyclerView.Adapter<RecyclerViewCardAdapter.CardsViewHolder> {

    public static class CardsViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageViewCard;
        TextView textViewCardTitle;
        TextView textViewCardDetail;

        CardsViewHolder(View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageViewCard = itemView.findViewById(R.id.imageViewCard);
            textViewCardTitle = itemView.findViewById(R.id.textViewCardTitle);
            textViewCardDetail = itemView.findViewById(R.id.textViewCardDetail);


        }

    }


    @Override
    public int getItemCount() {
        return Singleton.getInstance().cardDataList.size();
    }


    @Override
    public CardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new CardsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder holder, int position) {
        CardData card = Singleton.getInstance().cardDataList.get(position);
        holder.imageViewCard.setImageResource(card.drawableId);
        holder.textViewCardTitle.setText(card.title);
        holder.textViewCardDetail.setText(card.detail);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
