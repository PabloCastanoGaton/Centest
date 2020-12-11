package com.proyecto.centest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.proyecto.centest.sesion.identificacionActivity;
import com.proyecto.centest.sesion.sesionIniciadaActivity;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth; //Conexion con el sistema de autorizacion de firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance(); //Instancia de firebase

        if (mAuth.getCurrentUser() != null) { //Si el usuario ya ha iniciado sesion te mandará a la actividad de sesion iniciada
            startActivity(new Intent(getApplicationContext(), sesionIniciadaActivity.class));
            finish();
        }

        //Conexion entre el boton de la interfaz y el boton del código
        Button objetoBoton1 = findViewById(R.id.identificacion);
        Button objetoBoton2 = findViewById(R.id.localizacion);

        //Este boton te manda a la actividad de identificacion
        objetoBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencionIdentificacion = new Intent(view.getContext(), identificacionActivity.class);
                startActivity(intencionIdentificacion);
        } });

        //Este boton te manda a la actividad de localizacion de mapas
        objetoBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencionSelector = new Intent(view.getContext(), localizacionActivity.class);
                startActivity(intencionSelector);
            } });
    }
}
