package com.proyecto.centest.centros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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

    private TextView nombre4;
    private TextView maximo4;
    private TextView actual4;
    private TextView calle4;
    private TextView horario4;

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
        
    }
}