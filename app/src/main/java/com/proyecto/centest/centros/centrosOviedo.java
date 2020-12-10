package com.proyecto.centest.centros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
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

        mDataBase.child("Oviedo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String nombre = snapshot.child("El vasco").getValue().toString();
                    String calle = snapshot.child("El vasco").child("Calle").getValue().toString();
                    String disponible = snapshot.child("El vasco").getValue().toString();
                    String maximo = snapshot.child("El vasco").getValue().toString();
                    String horario = snapshot.child("El vasco").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}