package com.proyecto.centest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectorLocalizacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_localizacion);

        //Conexion entre el boton de la interfaz y el boton del codigo
        Button objetoBoton1 = findViewById(R.id.botonOviedo);
        Button objetoBoton2 = findViewById(R.id.botonAviles);
        Button objetoBoton3 = findViewById(R.id.botonGijon);

        //Que ocurre al pulsa cada uno de los botones
        objetoBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LocalizacionActivity.class);
                startActivity(intent);
            }
        });

        objetoBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        objetoBoton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}