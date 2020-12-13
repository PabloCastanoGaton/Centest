package com.proyecto.centest.sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.proyecto.centest.MainActivity;
import com.proyecto.centest.localizacionActivity;
import com.proyecto.centest.R;
import com.proyecto.centest.centros.centrosAviles;
import com.proyecto.centest.centros.centrosGijon;
import com.proyecto.centest.centros.centrosOviedo;

public class sesionIniciadaActivity extends AppCompatActivity {

    private DatabaseReference mDataBase;
    private FirebaseAuth mAuth;

    private Button botonOviedo;
    private Button botonGijon;
    private Button botonAviles;
    private Button botonLocalizacion;

    private TextView usarioIniciado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_iniciada);

        mAuth = FirebaseAuth.getInstance();

        //Obtener el nombre de usuario e imprimirlo en el texto
        String emailUsuario = mAuth.getCurrentUser().getEmail();

        usarioIniciado = (TextView) findViewById(R.id.textUsuarioIniciado);
        usarioIniciado.setText("Bienvenido a centest " + emailUsuario);

        //Acciones que deben realizar cada uno de los botones
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
                Intent intencionLocalizacion = new Intent(view.getContext(), localizacionActivity.class);
                startActivity(intencionLocalizacion);
            }
        });

    }

    //Cierre de sesion puesto en el boton con un onClick
    public void cierreSesion (View view){ //Este void lo que hace es cerrar la sesion de quien tenga la cuenta activada
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}
