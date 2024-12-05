package com.example.laura_snchez.modelo;

public class Producto {
    String nombre;
    double precio;
    int cantidad;


    // Constructores
    // ---------------------------------------------------------------------------------------------
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto() {
        this.nombre = "";
        this.precio = 0;
        this.cantidad = 0;
    }

    // Getters & Setters
    // ---------------------------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
