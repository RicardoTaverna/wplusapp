package com.example.wplusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainCard extends AppCompatActivity {

    RecyclerView recyclerViewCards;
    RecyclerViewCardAdapter recyclerViewCardAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincard);
        recyclerViewCards = findViewById(R.id.recyclerViewCards);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewCards.setLayoutManager(gridLayoutManager);
        recyclerViewCardAdapter = new RecyclerViewCardAdapter();
        recyclerViewCards.setAdapter(recyclerViewCardAdapter);

        recyclerViewCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainCard.this,Informacoes.class);
                startActivity(intent);

            }
        });



    }
}