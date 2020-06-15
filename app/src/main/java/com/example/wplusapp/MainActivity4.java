package com.example.wplusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView textViewTitulo, textViewAno;

    int i = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textViewTitulo = findViewById(R.id.textViewTitulo);
        textViewAno = findViewById(R.id.textViewAno);

        Intent intent = getIntent();

        i = intent.getIntExtra("id", -1);

    }
}