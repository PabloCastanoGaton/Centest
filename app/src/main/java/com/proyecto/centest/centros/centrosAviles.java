package com.proyecto.centest.centros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.proyecto.centest.R;

public class centrosAviles extends AppCompatActivity {

    private EditText nombre1;
    private EditText maximo1;
    private EditText actual1;
    private EditText calle1;

    private EditText nombre2;
    private EditText maximo2;
    private EditText actual2;
    private EditText calle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_aviles);
    }
}