package com.example.laura_snchez;

import android.content.Intent;
import android.graphics.text.TextRunShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalleProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_producto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView nombre = findViewById(R.id.lbl_nombre_detalle);
        TextView precio = findViewById(R.id.lbl_precio_detalle);
        TextView cantidad = findViewById(R.id.lbl_cantidad_detalle);
        Bundle bundle = getIntent().getExtras();

        nombre.setText(bundle.getString("nombre"));
        precio.setText(bundle.getString("precio"));
        cantidad.setText(bundle.getString("cantidad"));

        Button botonVolver = findViewById(R.id.btn_volver);
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetalleProducto.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}