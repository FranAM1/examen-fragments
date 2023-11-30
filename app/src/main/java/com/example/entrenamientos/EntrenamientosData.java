package com.example.entrenamientos;

public class EntrenamientosData {
    private String nombre;
    private String descripcion;
    private int imagen;

    public EntrenamientosData(String nombre, String descripcion, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagen() {
        return imagen;
    }
}
