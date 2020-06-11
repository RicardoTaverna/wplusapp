package com.example.wplusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private List<Catalogo> listCatalogo = new ArrayList<Catalogo>();
    private ArrayAdapter<Catalogo> arrayAdapterCatalogo;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView = findViewById(R.id.listView);

        inicializarFirebase();
        eventoDatabase();

    }

    private void eventoDatabase(){
        databaseReference.child("catalogo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listCatalogo.clear();
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Catalogo c = objSnapshot.getValue(Catalogo.class);
                    //String titulo = objSnapshot.getValue(Catalogo.class).getTitle();
                    listCatalogo.add(c);

                }
                arrayAdapterCatalogo = new ArrayAdapter<Catalogo>(MainActivity3.this,
                        android.R.layout.simple_list_item_1,listCatalogo);
                listView.setAdapter(arrayAdapterCatalogo);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(MainActivity3.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();

    }
}