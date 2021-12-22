package com.example.registro;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RegistrosBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="registro.bd";

    private static final int VERSION_BD=1;

    private static final String TABLA_DATOS="CREATE TABLE DATOS(CODIGO TEXT PRIMARY KEY, NOMBRE TEXT, APELLIDO TEXT, CELL TEXT , DIRECCION TEXT, NOTA TEXT)";

    public RegistrosBD(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_DATOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLA_DATOS);
        sqLiteDatabase.execSQL(TABLA_DATOS);
    }

    public void agregar(String codigo, String nombre, String apellido, String telefono, String direccion, String nota) {
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO DATOS VALUES('"+codigo+"','"+nombre+"','"+apellido+"', '"+telefono+"', '"+direccion+"', '"+nota+"')");
            bd.close();
        }
    }

    public List<ModeloDatos> mostrarDatos(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM DATOS",null);
        List<ModeloDatos> rdatos=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                rdatos.add(new ModeloDatos(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),R.drawable.logo));
            }while (cursor.moveToNext());
        }
        return rdatos;
    }


    public void buscar(ModeloDatos rdato, String codigo){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM DATOS WHERE CODIGO='"+codigo+"'",null);
        if (cursor.moveToFirst()){
            do {
                rdato.setNombre(cursor.getString(1));
                rdato.setApellido(cursor.getString(2));
                rdato.setNumcell(cursor.getString(3));
                rdato.setDireccion(cursor.getString(4));
                rdato.setNota(cursor.getString(5));
            }while (cursor.moveToNext());
        }
    }


    public void actualizar(String codigo, String nombre, String apellido, String telefono, String direccion, String nota) {
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("UPDATE DATOS SET NOMBRE='"+nombre+"',APELLIDO='"+apellido+"',CELL='"+telefono+"',DIRECCION='"+direccion+"',NOTA='"+nota+"' WHERE CODIGO='"+codigo+"'");
            bd.close();
        }
    }

    public void eliminar(String codigo) {
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("DELETE FROM DATOS WHERE CODIGO='"+codigo+"'");
            bd.close();
        }
    }

}



