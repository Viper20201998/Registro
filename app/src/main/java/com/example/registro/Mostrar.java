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



        RegistrosBD registrosBD = new RegistrosBD(getApplicationContext());

        recyclerViewRegistro=(RecyclerView) findViewById(R.id.recyclerDatos);
        recyclerViewRegistro.setLayoutManager(new LinearLayoutManager(this));



        adaptadorRegistro=new RecyclerViewAdaptador(Obtenerdatos());
        recyclerViewRegistro.setAdapter(adaptadorRegistro);
    }

    public List<ModeloDatos> Obtenerdatos(){
        List<ModeloDatos> rdatos=new ArrayList<>();
        rdatos.add(new ModeloDatos("codigo","nombre","apellido","cell","direccion","nota",R.drawable.logo));

        return rdatos;
    }
}