package com.example.wplusapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainCard extends AppCompatActivity {

    RecyclerView recyclerViewCards;
    RecyclerViewCardAdapter recyclerViewCardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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