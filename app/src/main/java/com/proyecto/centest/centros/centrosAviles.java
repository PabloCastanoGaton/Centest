package com.proyecto.centest.centros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.proyecto.centest.R;

public class centrosAviles extends AppCompatActivity {

    private DatabaseReference mDataBase;

    private TextView nombre1;
    private TextView maximo1;
    private TextView actual1;
    private TextView calle1;
    private TextView horario1;

    private TextView nombre2;
    private TextView maximo2;
    private TextView actual2;
    private TextView calle2;
    private TextView horario2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_aviles);

        mDataBase = FirebaseDatabase.getInstance().getReference();

        nombre1 = (TextView) findViewById(R.id.nombreAviles1);
        nombre2 = (TextView) findViewById(R.id.nombreAviles2);

       /* maximo1 = (TextView) findViewById(R.id.maximoAviles1);
        maximo2 = (TextView) findViewById(R.id.maximoAviles2); */

        actual1 = (TextView) findViewById(R.id.actualAviles1);
        actual2 = (TextView) findViewById(R.id.actualAviles2);

        calle1 = (TextView) findViewById(R.id.calleAviles1);
        calle2 = (TextView) findViewById(R.id.calleAviles2);

        horario1 = (TextView) findViewById(R.id.horarioAviles1);
        horario2 = (TextView) findViewById(R.id.horarioAviles2);
        
        mDataBase.child("Aviles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String nombreAvi1 = snapshot.child("Conde del Real Agrado").child("Nombre").getValue().toString();
                String calleAvi1 = snapshot.child("Conde del Real Agrado").child("Calle").getValue().toString();
                int disponibleAvi1 = Integer.parseInt(snapshot.child("Conde del Real Agrado").child("Disponible").getValue().toString());
                int maximoAvi1 = Integer.parseInt(snapshot.child("Conde del Real Agrado").child("Maximo").getValue().toString());
                String horarioAvi1 = snapshot.child("Conde del Real Agrado").child("Horario").getValue().toString();

                String nombreAvi2 = snapshot.child("Biblioteca municipal de Aviles").child("Nombre").getValue().toString();
                String calleAvi2 = snapshot.child("Biblioteca municipal de Aviles").child("Calle").getValue().toString();
                int disponibleAvi2 = Integer.parseInt(snapshot.child("Biblioteca municipal de Aviles").child("Disponible").getValue().toString());
                int maximoAvi2 = Integer.parseInt(snapshot.child("Biblioteca municipal de Aviles").child("Maximo").getValue().toString());
                String horarioAvi2 = snapshot.child("Biblioteca municipal de Aviles").child("Horario").getValue().toString();

                nombre1.setText(nombreAvi1);
                calle1.setText("Calle: " + calleAvi1);
                actual1.setText("Disponibilidad: " + disponibleAvi1 + "/" + maximoAvi1);
                //maximo1.setText("Sitios maximos: " + maximoAvi1);
                horario1.setText("Horario: " + horarioAvi1);

                nombre2.setText(nombreAvi2);
                calle2.setText("Calle: " + calleAvi2);
                actual2.setText("Sitios disponible: " + disponibleAvi2 + "/" + maximoAvi2);
                //maximo2.setText("Sitios maximos: " + maximoAvi2);
                horario2.setText("Horario: " + horarioAvi2);
                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}