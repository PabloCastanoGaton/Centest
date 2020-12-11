package com.proyecto.centest.centros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.proyecto.centest.R;

public class centrosOviedo extends AppCompatActivity {

    private DatabaseReference mDataBase;

    private TextView nombre1;
    private TextView calle1;
    private TextView maximo1;
    private TextView actual1;
    private TextView horario1;

    private TextView nombre2;
    private TextView calle2;
    private TextView maximo2;
    private TextView actual2;
    private TextView horario2;

    private TextView nombre3;
    private TextView calle3;
    private TextView maximo3;
    private TextView actual3;
    private TextView horario3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_oviedo);

        mDataBase = FirebaseDatabase.getInstance().getReference();
        
        nombre1 = (TextView) findViewById(R.id.nombreOviedo1);
        nombre2 = (TextView) findViewById(R.id.nombreOviedo2);
        nombre3 = (TextView) findViewById(R.id.nombreOviedo3);

        maximo1 = (TextView) findViewById(R.id.maximoOviedo1);
        maximo2 = (TextView) findViewById(R.id.maximoOviedo2);
        maximo3 = (TextView) findViewById(R.id.maximoOviedo3);

        actual1 = (TextView) findViewById(R.id.actualOviedo1);
        actual2 = (TextView) findViewById(R.id.actualOviedo2);
        actual3 = (TextView) findViewById(R.id.actualOviedo3);

        calle1 = (TextView) findViewById(R.id.calleOviedo1);
        calle2 = (TextView) findViewById(R.id.calleOviedo2);
        calle3 = (TextView) findViewById(R.id.calleOviedo3);

        horario1 = (TextView) findViewById(R.id.horarioOviedo1);
        horario2 = (TextView) findViewById(R.id.horarioOviedo2);
        horario3 = (TextView) findViewById(R.id.horarioOviedo3);

        mDataBase.child("Oviedo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    String nombreOvi1 = snapshot.child("El vasco").child("Nombre").getValue().toString();
                    String calleOvi1 = snapshot.child("El vasco").child("Calle").getValue().toString();
                    int disponibleOvi1 = Integer.parseInt(snapshot.child("El vasco").child("Disponible").getValue().toString());
                    int maximoOvi1 = Integer.parseInt(snapshot.child("El vasco").child("Maximo").getValue().toString());
                    String horarioOvi1 = snapshot.child("El vasco").child("Horario").getValue().toString();

                    String nombreOvi2 = snapshot.child("La Florida").child("Nombre").getValue().toString();
                    String calleOvi2 = snapshot.child("La Florida").child("Calle").getValue().toString();
                    int disponibleOvi2 = Integer.parseInt(snapshot.child("La Florida").child("Disponible").getValue().toString());
                    int maximoOvi2 = Integer.parseInt(snapshot.child("La Florida").child("Maximo").getValue().toString());
                    String horarioOvi2 = snapshot.child("La Florida").child("Horario").getValue().toString();

                    String nombreOvi3 = snapshot.child("Santullano").child("Nombre").getValue().toString();
                    String calleOvi3 = snapshot.child("Santullano").child("Calle").getValue().toString();
                    int disponibleOvi3 = Integer.parseInt(snapshot.child("Santullano").child("Disponible").getValue().toString());
                    int maximoOvi3 =Integer.parseInt(snapshot.child("Santullano").child("Maximo").getValue().toString());
                    String horarioOvi3 = snapshot.child("Santullano").child("Horario").getValue().toString();

                    nombre1.setText(nombreOvi1);
                    calle1.setText("Calle: " + calleOvi1);
                    actual1.setText("Sitios disponible: " + disponibleOvi1);
                    maximo1.setText("Sitios maximos: " + maximoOvi1);
                    horario1.setText("Horario: " + horarioOvi1);

                    nombre2.setText(nombreOvi2);
                    calle2.setText("Calle: " + calleOvi2);
                    actual2.setText("Sitios disponible: " + disponibleOvi2);
                    maximo2.setText("Sitios maximos: " + maximoOvi2);
                    horario2.setText("Horario: " + horarioOvi2);

                    nombre3.setText(nombreOvi3);
                    calle3.setText("Calle: " + calleOvi3);
                    actual3.setText("Sitios disponible: " + disponibleOvi3);
                    maximo3.setText("Sitios maximos: " + maximoOvi3);
                    horario3.setText("Horario: " + horarioOvi3);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}