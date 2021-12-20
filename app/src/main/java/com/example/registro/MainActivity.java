package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewRegistro;
    private RecyclerViewAdaptador adaptadorRegistro;

    EditText edtID, edtNombre, edtApellido, edtCell, edtDireccion, edtNota;
    Button btnAgregar, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtID=(EditText) findViewById(R.id.edtID);
        edtNombre=(EditText) findViewById(R.id.edtNombre);
        edtApellido=(EditText) findViewById(R.id.edtApellido);
        edtCell=(EditText) findViewById(R.id.edtCell);
        edtDireccion=(EditText) findViewById(R.id.edtDireccion);
        edtNota=(EditText) findViewById(R.id.edtNota);
        btnAgregar=(Button) findViewById(R.id.btnAgregar);
        btnMostrar=(Button) findViewById(R.id.btnMostrar);

        final RegistrosBD registrosBD=new RegistrosBD(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrosBD.agregar(edtID.getText().toString(),edtNombre.getText().toString(),edtApellido.getText().toString(),edtCell.getText().toString(),edtDireccion.getText().toString(),edtNota.getText().toString());
                Toast.makeText(getApplicationContext(),"Was added successfully",Toast.LENGTH_LONG).show();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



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