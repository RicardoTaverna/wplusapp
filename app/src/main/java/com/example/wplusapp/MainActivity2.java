package com.example.wplusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    Button buttonPaginaLogin, buttonCadastrar;
    EditText editTextTextEmailCadastro, editTextTextPasswordCadastro;
    String passwd, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonPaginaLogin = findViewById(R.id.buttonPaginaLogin);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        editTextTextEmailCadastro = findViewById(R.id.editTextTextEmailCadastro);
        editTextTextPasswordCadastro = findViewById(R.id.editTextTextPasswordCadastro);

        mAuth = FirebaseAuth.getInstance();


        //Mudar de tela
        buttonPaginaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Cadastro
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextTextEmailCadastro.getText().toString();
                passwd = editTextTextPasswordCadastro.getText().toString();

                mAuth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity2.this,"User Created",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                            startActivity(intent);

                        }else{
                            Log.w("MAIN", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity2.this,"Erro ao processar o cadastro", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

}