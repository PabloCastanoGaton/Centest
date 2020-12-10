package com.proyecto.centest.centros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.proyecto.centest.R;

public class centrosGijon extends AppCompatActivity {

    private EditText nombre1;
    private EditText maximo1;
    private EditText actual1;
    private EditText calle1;

    private EditText nombre2;
    private EditText maximo2;
    private EditText actual2;
    private EditText calle2;

    private EditText nombre3;
    private EditText maximo3;
    private EditText actual3;
    private EditText calle3;

    private EditText nombre4;
    private EditText maximo4;
    private EditText actual4;
    private EditText calle4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_gijon);
    }
}