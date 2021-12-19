package com.example.registro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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

}
