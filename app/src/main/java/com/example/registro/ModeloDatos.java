package com.example.registro;

public class ModeloDatos {
    private String codigo,nombre,apellido,numcell,direccion,nota;
    private int imgLogo;



    public ModeloDatos(String codigo, String nombre, String apellido, String numcell, String direccion, String nota, int imgLogo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numcell = numcell;
        this.direccion = direccion;
        this.nota = nota;
        this.imgLogo = imgLogo;
    }




    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumcell() {
        return numcell;
    }

    public void setNumcell(String numcell) {
        this.numcell = numcell;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(int imgLogo) {
        this.imgLogo = imgLogo;
    }
}
