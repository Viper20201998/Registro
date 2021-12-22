package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText edtID, edtNombre, edtApellido, edtCell, edtDireccion, edtNota;
    Button btnAgregar, btnMostrar, btnbuscar;

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
        btnbuscar=(Button) findViewById(R.id.btnBuscar);

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
                Intent intent = new Intent(MainActivity.this,Mostrar.class);
                startActivity(intent);
            }
        });


        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloDatos rdato=new ModeloDatos();
                registrosBD.buscar(rdato,edtID.getText().toString());
                edtNombre.setText(rdato.getNombre());
                edtApellido.setText(rdato.getApellido());
                edtCell.setText(rdato.getNumcell());
                edtDireccion.setText(rdato.getDireccion());
                edtNota.setText(rdato.getNota());
            }
        });


    }

}