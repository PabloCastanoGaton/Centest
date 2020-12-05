package com.proyecto.centest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth; //Conexion con el sistema de autorizacion de firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mAuth.getCurrentUser() != null) { //Si el usuario ya ha iniciado sesion te mandará a la actividad de sesion iniciada
            startActivity(new Intent(getApplicationContext(), SesionIniciadaEstudianteActivity.class));
            finish();
        }

        //Conexion entre el boton de la interfaz y el boton del código
        Button objetoBoton1 = findViewById(R.id.identificacion);
        Button objetoBoton2 = findViewById(R.id.localizacion);

        //Este boton te manda a la actividad de identificacion
        objetoBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencionIdentificacion = new Intent(view.getContext(), IdentificacionActivity.class);
                startActivity(intencionIdentificacion);
        } });

        //Este boton te manda a la actividad de localizacion de mapas
        objetoBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencionSelector = new Intent(view.getContext(), selectorLocalizacion.class);
                startActivity(intencionSelector);
            } });
    }
}