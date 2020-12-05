package com.proyecto.centest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IdentificacionActivity extends AppCompatActivity {

    //Cajas de texto, boton y firebaseauth
    private EditText EditTextEmailIdentificacion;
    private EditText EditTextContraseñaIdentificacion;
    private Button botonInicio;
    FirebaseAuth mAuth;

    //Variables
    private String emailIdent = "";
    private String contraseñaIdent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacion);

        mAuth = FirebaseAuth.getInstance(); //Instancia de firebase

        Button objetoBoton1 = findViewById(R.id.botonRegistroTo); //Este botón te manda a la clase de registro
        objetoBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion1 = new Intent(view.getContext(), RegistrarseActivity.class);
                startActivity(intencion1);
            }
        });

        if (mAuth.getCurrentUser() != null) { //Si el usuario ya ha iniciado sesion te mandará a la sesion iniciada directamente
            startActivity(new Intent(getApplicationContext(), SesionIniciadaEstudianteActivity.class));
            finish();
        }

        //Enlace entre las cajas de texto y botones de la interfaz y el código
        EditTextEmailIdentificacion = findViewById(R.id.editTextEmailIdent);
        EditTextContraseñaIdentificacion = findViewById(R.id.editTextContraseñaIdent);
        botonInicio = findViewById(R.id.botonInicio);

        botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtiene el texto eliminando los espacios que haya por delante y por detrás
                emailIdent = EditTextEmailIdentificacion.getText().toString().trim();
                contraseñaIdent = EditTextContraseñaIdentificacion.getText().toString().trim();

                if(TextUtils.isEmpty(emailIdent)){ //Si el email está vacio dará un error
                    EditTextEmailIdentificacion.setError("El email está vacío");
                    return;
                }

                if(TextUtils.isEmpty(contraseñaIdent)){ //Si la contraseña está vacía dará un error
                    EditTextEmailIdentificacion.setError("La contraseña está vacía");
                    return;
                }

                mAuth.signInWithEmailAndPassword(emailIdent, contraseñaIdent).addOnCompleteListener(new OnCompleteListener<AuthResult>() { //Inicio de sesion mediante el usuario y la contraseña con firebase

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) { //If the task is successfully pass you to sesion iniciada
                            Toast.makeText(IdentificacionActivity.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), SesionIniciadaEstudianteActivity.class));
                        }

                        else{ //If the sign in gives an error
                            Toast.makeText(IdentificacionActivity.this, "Fallo al iniciar sesión", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
    }
}