package com.proyecto.centest.centros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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

        maximo1 = (TextView) findViewById(R.id.maximoAviles1);
        maximo2 = (TextView) findViewById(R.id.maximoAviles2);

        actual1 = (TextView) findViewById(R.id.actualAviles1);
        actual2 = (TextView) findViewById(R.id.actualAviles2);

        calle1 = (TextView) findViewById(R.id.calleAviles1);
        calle2 = (TextView) findViewById(R.id.calleAviles2);

        horario1 = (TextView) findViewById(R.id.horarioAviles1);
        horario2 = (TextView) findViewById(R.id.horarioAviles2);
    }
}