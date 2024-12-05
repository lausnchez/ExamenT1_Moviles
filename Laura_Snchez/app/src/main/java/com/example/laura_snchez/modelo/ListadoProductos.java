package com.example.laura_snchez.modelo;

import java.util.ArrayList;

public class ListadoProductos {
    private ArrayList<Producto> productos;
    private static ListadoProductos instancia;


    public ListadoProductos() {
        this.productos = new ArrayList<>();
        productos.add(new Producto("producto1", 20.1, 50));
        productos.add(new Producto("producto2", 5.1, 513));
        productos.add(new Producto("producto3", 21, 220));
        productos.add(new Producto("producto4", 299.3, 5));
        productos.add(new Producto("producto5", 20000.1, 33));
        instancia = this;
    }

    // MÉTODO PARA AGREGAR UN PRODUCTO AL LISTADO
    public boolean agregarProducto(Producto producto){
        try{
            this.productos.add(producto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    // MÉTODO PARA RECOGER LA INSTANCIA
    // public static Tareas getInstance(){return (instance == null) ? new Tareas() : instance;}
    public static ListadoProductos recogerInstancia(){
        if(instancia == null){instancia = new ListadoProductos();
            return instancia;
        }
       else return instancia;
    }

    // Método que nos devuelve todos los productos del listado
    public ArrayList<Producto> recogerTodosLosProductos(){
        return this.productos;
    }

}
