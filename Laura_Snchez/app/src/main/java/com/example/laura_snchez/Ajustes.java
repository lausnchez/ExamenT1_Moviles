package com.example.laura_snchez;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ajustes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sp = getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorSP = sp.edit();

        EditText nombre = findViewById(R.id.et_pref_nombre);
        CheckBox impuestos = findViewById(R.id.check_impuestos);

        nombre.setText(sp.getString("usuario", ""));
        impuestos.setChecked(sp.getBoolean("impuestos", false));

        Button btn_volver = findViewById(R.id.btn_pref_volver);
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editorSP.putString("usuario", nombre.getText().toString());
                editorSP.putBoolean("impuestos" , impuestos.isChecked());
                editorSP.commit();
                Intent i = new Intent(Ajustes.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}