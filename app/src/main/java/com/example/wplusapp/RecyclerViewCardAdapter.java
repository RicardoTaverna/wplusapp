package com.example.wplusapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewCardAdapter extends
        RecyclerView.Adapter<RecyclerViewCardAdapter.CardsViewHolder> {
        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference;
        private List<Catalogo> listCatalogo = new ArrayList<Catalogo>();
        private ArrayAdapter<Catalogo> arrayAdapterCatalogo;


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
            inicializarFirebase(parent.getContext());
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
        private void inicializarFirebase(Context context){
            FirebaseApp.initializeApp(context);
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference();

        }
        private void eventoDatabase(final RecyclerView recyclerView){
            databaseReference.child("Catalogo").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    listCatalogo.clear();
                    for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                        Catalogo c = objSnapshot.getValue(Catalogo.class);
                        //recyclerView.setAdapter();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

}