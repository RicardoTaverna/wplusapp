package com.example.wplusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView textViewTitulo, textViewAno;

    private String titulo;

    int i = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textViewTitulo = findViewById(R.id.textViewTitulo);
        textViewAno = findViewById(R.id.textViewAno);

        Intent intent = getIntent();

        i = intent.getIntExtra("id", -1);

        inicializarFirebase();
        eventoDatabase(i);

    }

    private void eventoDatabase(final int uid){
        databaseReference.child("Catalogo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Catalogo c = objSnapshot.getValue(Catalogo.class);
                    titulo = (dataSnapshot.child("0").getValue(String.class));
                    textViewTitulo.setText(titulo);
                    /*
                    int id_int = Integer.parseInt(id);
                    if (id_int == uid){
                        textViewTitulo.setText(dataSnapshot.child("Title").getValue(String.class));
                    }
                    */

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(MainActivity4.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }
}