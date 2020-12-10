package com.proyecto.centest.centros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.proyecto.centest.R;

public class centrosGijon extends AppCompatActivity {

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

    private TextView nombre3;
    private TextView maximo3;
    private TextView actual3;
    private TextView calle3;
    private TextView horario3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_gijon);

        mDataBase = FirebaseDatabase.getInstance().getReference();

        nombre1 = (TextView) findViewById(R.id.nombreGijon1);
        nombre2 = (TextView) findViewById(R.id.nombreGijon2);
        nombre3 = (TextView) findViewById(R.id.nombreGijon3);

        maximo1 = (TextView) findViewById(R.id.maximoGijon1);
        maximo2 = (TextView) findViewById(R.id.maximoGijon2);
        maximo3 = (TextView) findViewById(R.id.maximoGijon3);

        actual1 = (TextView) findViewById(R.id.actualGijon1);
        actual2 = (TextView) findViewById(R.id.actualGijon2);
        actual3 = (TextView) findViewById(R.id.actualGijon3);

        calle1 = (TextView) findViewById(R.id.calleGijon1);
        calle2 = (TextView) findViewById(R.id.calleGijon2);
        calle3 = (TextView) findViewById(R.id.calleGijon3);

        horario1 = (TextView) findViewById(R.id.horarioGijon1);
        horario2 = (TextView) findViewById(R.id.horarioGijon2);
        horario3 = (TextView) findViewById(R.id.horarioGijon3);

        mDataBase.child("Gijon").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String nombreGij1 = snapshot.child("El Llano").getValue().toString();
                String calleGij1 = snapshot.child("El Llano").child("Calle").getValue().toString();
                int disponibleGij1 = Integer.parseInt(snapshot.child("El Llano").child("Disponible").getValue().toString());
                int maximoGij1 = Integer.parseInt(snapshot.child("El Llano").child("Maximo").getValue().toString());
                String horarioGij1 = snapshot.child("El Llano").child("Horario").getValue().toString();

                String nombreGij2 = snapshot.child("Ceuias").getValue().toString();
                String calleGij2 = snapshot.child("Ceuias").child("Calle").getValue().toString();
                int disponibleGij2 = Integer.parseInt(snapshot.child("Ceuias").child("Disponible").getValue().toString());
                int maximoGij2 = Integer.parseInt(snapshot.child("Ceuias").child("Maximo").getValue().toString());
                String horarioGij2 = snapshot.child("Ceuias").child("Horario").getValue().toString();

                String nombreGij3 = snapshot.child("Praxis").getValue().toString();
                String calleGij3 = snapshot.child("Praxis").child("Calle").getValue().toString();
                int disponibleGij3 = Integer.parseInt(snapshot.child("Praxis").child("Disponible").getValue().toString());
                int maximoGij3 = Integer.parseInt(snapshot.child("Praxis").child("Maximo").getValue().toString());
                String horarioGij3 = snapshot.child("Praxis").child("Horario").getValue().toString();

                nombre1.setText("Nombre del centro: " + nombreGij1);
                calle1.setText("Calle: " + calleGij1);
                actual1.setText("Disponible: " + disponibleGij1);
                maximo1.setText("Sitios maximos: " + maximoGij1);
                horario1.setText("Horario: " + horarioGij1);

                nombre2.setText("Nombre del centro: " + nombreGij2);
                calle2.setText("Calle: " + calleGij2);
                actual2.setText("Disponible: " + disponibleGij2);
                maximo2.setText("Sitios maximos: " + maximoGij2);
                horario2.setText("Horario: " + horarioGij2);

                nombre3.setText("Nombre del centro: " + nombreGij3);
                calle3.setText("Calle: " + calleGij3);
                actual3.setText("Disponible: " + disponibleGij3);
                maximo3.setText("Sitios maximos: " + maximoGij3);
                horario3.setText("Horario: " + horarioGij3);
                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        
    }
}