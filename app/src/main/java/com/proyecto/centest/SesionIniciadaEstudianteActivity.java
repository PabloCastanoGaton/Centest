package com.proyecto.centest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class SesionIniciadaEstudianteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_iniciada);
    }

    public void cierreSesion (View view){ //Este void lo que hace es cerrar la sesion de quien tenga la cuenta activada
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), IdentificacionActivity.class));
        finish();
    }
}
