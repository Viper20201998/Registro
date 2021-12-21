package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Mostrar extends AppCompatActivity {

    private RecyclerView recyclerViewRegistro;
    private RecyclerViewAdaptador adaptadorRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);





        recyclerViewRegistro=(RecyclerView) findViewById(R.id.recyclerDatos);
        recyclerViewRegistro.setLayoutManager(new LinearLayoutManager(this));

        RegistrosBD registrosBD = new RegistrosBD(getApplicationContext());

        adaptadorRegistro=new RecyclerViewAdaptador(registrosBD.mostrarDatos());
        recyclerViewRegistro.setAdapter(adaptadorRegistro);
    }

}