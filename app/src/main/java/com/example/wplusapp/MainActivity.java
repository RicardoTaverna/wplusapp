package com.example.wplusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView textViewInfo;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    Button buttonLogin, buttonPaginaCadastrar;
    EditText editTextTextEmail, editTextTextPassword;
    String passwd, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonPaginaCadastrar = findViewById(R.id.buttonPaginaCadastro);
        editTextTextEmail = findViewById(R.id.editTextTextEmail);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //Mudar de tela
        buttonPaginaCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        //Autenticacao
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextTextEmail.getText().toString();
                passwd = editTextTextPassword.getText().toString();

                mAuth.signInWithEmailAndPassword(email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            currentUser = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "User SIGNIN", Toast.LENGTH_LONG).show();
                            //Apos logar direciona para o catalogo de filmes
                            Intent intent = new Intent(MainActivity.this, MainCard.class);
                            startActivity(intent);

                        }else{
                            Log.w("MAIN", "SIGNINUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this,email + passwd, Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });

    }



}
