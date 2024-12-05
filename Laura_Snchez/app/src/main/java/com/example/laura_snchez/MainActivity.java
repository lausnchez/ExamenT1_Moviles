package com.example.laura_snchez;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarMenu;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    public static Adapter miAdaptador = new Adapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView menu = findViewById(R.id.bottomNav);
        RecyclerView rv = findViewById(R.id.rv);

        // CREAR MENÚ
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_agregarProducto){
                    Intent i = new Intent(MainActivity.this, AgregarProducto.class);
                    startActivity(i);
                }
                if (item.getItemId() == R.id.menu_ajustes) {
                    Intent i = new Intent(MainActivity.this, Ajustes.class);
                    startActivity(i);
                }
                return true;
            }
        });

        // RECYCLER VIEW
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        DividerItemDecoration deco = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(deco);
       // RecyclerView.Adapter miAdaptador = new Adapter();
        rv.setAdapter(miAdaptador);

       // rv.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener());
    }

    public void abrirDetalles(String nombre, String precio, String cantidad){
        Intent i = new Intent(MainActivity.this, DetalleProducto.class);
        i.putExtra("nombre", nombre);
        i.putExtra("precio", precio);
        i.putExtra("cantidad", cantidad);
        startActivity(i);
    }
}