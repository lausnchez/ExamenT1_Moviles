package com.example.laura_snchez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.laura_snchez.modelo.ListadoProductos;
import com.example.laura_snchez.modelo.Producto;

public class AgregarProducto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_producto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn_agregar = findViewById(R.id.btn_agregar);
        EditText nombre = findViewById(R.id.et_nombre);
        EditText precio = findViewById(R.id.et_precio);
        EditText cantidad = findViewById(R.id.et_cantidad);


        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto nuevoProducto = comprobarCampos();
                if(nuevoProducto != null){
                    ListadoProductos.recogerInstancia().agregarProducto(nuevoProducto);
                    Adapter.actualizarListado(ListadoProductos.recogerInstancia().recogerTodosLosProductos());
                    MainActivity.miAdaptador.notifyDataSetChanged();
                    Toast.makeText(AgregarProducto.this, "Se agregó el producto con éxito", Toast.LENGTH_SHORT);
                    Intent i = new Intent(AgregarProducto.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }


    // Validar si una string en un valor int
    private boolean comprobarInt(String valor){
        try{
            Integer.parseInt(valor);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    // Validar si una string en un valor double
    private boolean comprobarDouble(String valor){
        try{
            Double.parseDouble(valor);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    private Producto comprobarCampos(){
        EditText nombre = findViewById(R.id.et_nombre);
        EditText precio = findViewById(R.id.et_precio);
        EditText cantidad = findViewById(R.id.et_cantidad);

        String nombreValor = nombre.getText().toString().trim();
        String precioValor = precio.getText().toString().trim();
        String cantidadValor = cantidad.getText().toString().trim();

        // En caso de que los valores no correspondan o estén vacíos no valida
        if(nombreValor.isEmpty() ||
                precioValor.isEmpty() ||
                cantidadValor.isEmpty() ||
                !comprobarInt(cantidadValor) ||
                !comprobarDouble(precioValor)
        ){
            Toast.makeText(this, "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();
            return null;
        }
        else{
            // Transforma los valores necesarios y crea un producto
            return new Producto(nombreValor, Double.parseDouble(precioValor), Integer.parseInt(cantidadValor));
        }
    }

}