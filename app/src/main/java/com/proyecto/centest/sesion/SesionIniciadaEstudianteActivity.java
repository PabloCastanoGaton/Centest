package com.proyecto.centest.sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.proyecto.centest.LocalizacionActivity;
import com.proyecto.centest.R;
import com.proyecto.centest.centros.centrosAviles;
import com.proyecto.centest.centros.centrosGijon;
import com.proyecto.centest.centros.centrosOviedo;
import com.proyecto.centest.sesion.IdentificacionActivity;

public class SesionIniciadaEstudianteActivity extends AppCompatActivity {

    private DatabaseReference mDataBase;

    private Button botonOviedo;
    private Button botonGijon;
    private Button botonAviles;
    private Button botonLocalizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_iniciada);

        botonOviedo = (Button) findViewById(R.id.botonOviedo);
        botonGijon = (Button) findViewById(R.id.botonGijon);
        botonAviles = (Button) findViewById(R.id.botonAviles);
        botonLocalizacion = (Button) findViewById(R.id.localizacionButton);

        botonOviedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencionOviedo = new Intent(view.getContext(), centrosOviedo.class);
                startActivity(intencionOviedo);
            }
        });

        botonGijon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencionGijon = new Intent(view.getContext(), centrosGijon.class);
                startActivity(intencionGijon);
            }
        });

        botonAviles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencionAviles = new Intent(view.getContext(), centrosAviles.class);
                startActivity(intencionAviles);
            }
        });

        botonLocalizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencionLocalizacion = new Intent(view.getContext(), LocalizacionActivity.class);
                startActivity(intencionLocalizacion);
            }
        });

    }

    public void cierreSesion (View view){ //Este void lo que hace es cerrar la sesion de quien tenga la cuenta activada
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), IdentificacionActivity.class));
        finish();
    }
}
