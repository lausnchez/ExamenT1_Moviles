package com.example.laura_snchez;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laura_snchez.modelo.ListadoProductos;
import com.example.laura_snchez.modelo.Producto;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Item> {
    private static ArrayList<Producto> productos;


    public Adapter(){
        this.productos = ListadoProductos.recogerInstancia().recogerTodosLosProductos();
        this.notifyDataSetChanged();
    }

    // Para actualizar el listado (setData)
    public static void actualizarListado(ArrayList<Producto> comercios){
        Adapter.productos = comercios;
    }

    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Item(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Item holder, int position) {
        holder.nombre.setText(productos.get(position).getNombre());
        holder.precio.setText(String.valueOf(productos.get(position).getPrecio()));
        holder.cantidad.setText(String.valueOf(productos.get(position).getCantidad()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DetalleProducto.class);
                int posicionItem = holder.getAdapterPosition();
                String precioItem = String.valueOf(productos.get(posicionItem).getPrecio());
                String cantidadItem = String.valueOf(productos.get(posicionItem).getCantidad());

                i.putExtra("nombre", productos.get(posicionItem).getNombre());
                i.putExtra("precio", precioItem);
                i.putExtra("cantidad", cantidadItem);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }

    public static class Item extends RecyclerView.ViewHolder {
        public TextView nombre;
        public TextView precio;
        public TextView cantidad;
        public Item(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.lbl_nombre_item);
            precio = itemView.findViewById(R.id.lbl_precio_item);
            cantidad = itemView.findViewById(R.id.lbl_cantidad_item);

        }
    }

}
